package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.repository.BaseEntityGenericRepository;
import ir.maktabsharif105.jdbc.util.InsertKey;
import ir.maktabsharif105.jdbc.util.QueryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static ir.maktabsharif105.jdbc.util.QueryUtil.FIND_ALL_QUERY_TEMPLATE;
import static ir.maktabsharif105.jdbc.util.QueryUtil.FIND_BY_ID_QUERY_TEMPLATE;


public abstract class BaseEntityGenericRepositoryImpl<T extends BaseEntity<ID>, ID>
        implements BaseEntityGenericRepository<T, ID> {

    protected final Connection connection;

    public BaseEntityGenericRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T save(T entity) {
        try {
            PreparedStatement preparedStatement = getPreparedStatementForInsert(entity);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                setIdInNewEntity(resultSet, entity);
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement getPreparedStatementForInsert(T entity) throws SQLException {
        /*PreparedStatement preparedStatement = connection.prepareStatement(
                getInsertQuery(),
                PreparedStatement.RETURN_GENERATED_KEYS
        );
        setInsertParamsInQuery(preparedStatement, entity);
        return preparedStatement;*/

        AtomicInteger atomicInteger = new AtomicInteger(1);
        AtomicReference<String> columnName = new AtomicReference<>("");
        AtomicReference<String> questionMarks = new AtomicReference<>("");
        Map<InsertKey, Object> insertMap = getInsertMap(entity);
        insertMap.forEach((key, value) -> {
            columnName.set(columnName.get().concat(key.getColumnName() + ","));
            questionMarks.set(questionMarks.get().concat("?" + ","));
            key.setParamIndex(atomicInteger.getAndIncrement());
        });

        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        QueryUtil.INSERT_QUERY_TEMPLATE,
                        getTableName(),
                        columnName.get().substring(0, columnName.get().length() - 1),
                        questionMarks.get().substring(0, questionMarks.get().length() - 1)
                ),
                PreparedStatement.RETURN_GENERATED_KEYS
        );
        insertMap.forEach((insertKey, o) -> {
            try {
                preparedStatement.setObject(insertKey.getParamIndex(), o);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return preparedStatement;
    }

    protected abstract Map<InsertKey, Object> getInsertMap(T entity);

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T[] findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    getFindAllQuery()
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            T[] entities = getEntityArrayForFindAll();
            int arrayIndex = 0;
            while (resultSet.next()) {
                entities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
            }
            return entities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(ID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    getFindByIdQuery()
            );
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public long count() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(
                            QueryUtil.COUNT_ALL_QUERY_TEMPLATE,
                            getTableName()
                    )
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(
                            QueryUtil.DELETE_ALL_QUERY_TEMPLATE,
                            getTableName()
                    )
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(ID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(
                            QueryUtil.DELETE_BY_ID_QUERY_TEMPLATE,
                            getTableName()
                    )
            );
            preparedStatement.setObject(1, id);
//            fillIdParameter(preparedStatement, 1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(ID id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    String.format(
                            QueryUtil.EXISTS_BY_ID_QUERY_TEMPLATE,
                            getTableName()
                    )
            );
            preparedStatement.setObject(1, id);
//            fillIdParameter(preparedStatement, 1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getFindByIdQuery() {
        return String.format(
                FIND_BY_ID_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected String getFindAllQuery() {
        return String.format(
                FIND_ALL_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected String getInsertQuery() {
//        insert into %s(%s) values(%s)
//        insert into city(name) values(?)
//        insert into user(first_name, username, password) values(?)
        return String.format(
                QueryUtil.INSERT_QUERY_TEMPLATE,
                getTableName(),
                getInsertColumnNames(),
                getQuestionMarksForInsert()
        );
    }

    protected String getInsertColumnNames() {
        String[] insertColumns = getInsertColumnNamesArray();
        if (insertColumns == null || insertColumns.length == 0) {
            throw new RuntimeException("wrong implementation");
        }
        return String.join(
                ",",
                insertColumns
        );
    }

    protected String getQuestionMarksForInsert() {
        String[] insertColumns = getInsertColumnNamesArray();
        if (insertColumns == null || insertColumns.length == 0) {
            throw new RuntimeException("wrong implementation");
        }
        Arrays.fill(insertColumns, "?");
        return String.join(
                ",",
                insertColumns
        );
    }

    protected abstract String getTableName();

    protected abstract T mapResultSetToBaseEntity(ResultSet resultSet);

    protected abstract T[] getEntityArrayForFindAll();

    protected abstract void fillIdParameter(PreparedStatement statement, int paramIndex, ID id);

    protected abstract String[] getInsertColumnNamesArray();

    protected abstract void setInsertParamsInQuery(PreparedStatement preparedStatement, T entity);

    protected abstract void setIdInNewEntity(ResultSet resultSet, T entity);
}
