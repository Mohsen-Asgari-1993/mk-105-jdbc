package ir.maktabsharif105.jdbc.util;

public class QueryUtil {

    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE = "select count(*) from %s";

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    public static final String DELETE_ALL_QUERY_TEMPLATE = "delete from %s where id > 0";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";
}
