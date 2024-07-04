package ir.maktabsharif105.jdbc.util;

public class QueryUtil {

    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE = "select count(*) from %s";

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    public static final String DELETE_ALL_QUERY_TEMPLATE = "delete from %s where id > 0";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";

    //    public static final String INSERT_QUERY_TEMPLATE = "insert into city(name) values('تهران')";
//    public static final String INSERT_QUERY_TEMPLATE = "insert into wallet(amount, user_id) values(0, 5)";
//    public static final String INSERT_QUERY_TEMPLATE = "insert into user(first_name,last_name,username,password) values(0, 5)";
    public static final String INSERT_QUERY_TEMPLATE = "insert into %s(%s) values(%s)";
}
