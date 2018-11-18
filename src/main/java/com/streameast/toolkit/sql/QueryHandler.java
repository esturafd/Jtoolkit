package com.streameast.toolkit.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * This class handles the types of queries that are made, through QueryRunner
 * 
 * @author streameast
 */
public class QueryHandler {
    
    private QueryRunner runner;
    
    public QueryHandler() {
        runner = new QueryRunner();
    }
    
    /**
     * This method returns an object of the query through QueryRunner
     * 
     * @return Object
     */
    public Object query(Connection conn, String sqlString, ResultSetHandler<? extends Object> handler, Object... params) {
        Object foo = null;
        try {
            foo = runner.query(conn, sqlString, handler, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foo;
    }
    
    /**
     * This method returns a simple query of a field
     * 
     * @return Object
     */
    public Object queryObject(Connection conn, String sqlString, Object... params) {
        ScalarHandler<Object> handler = new ScalarHandler<Object>();
        return query(conn, sqlString, handler, params);
    }
    
    /**
     * This method returns several fields
     * 
     * @return List<Object[]>
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> queryArray(Connection conn, String sqlString, Object... params) {
        ArrayListHandler handler = new ArrayListHandler();
        return (List<Object[]>) query(conn, sqlString, handler, params);
    }
    
    /**
     * This method returns several fields with its title
     * 
     * @return List<Map<String, Object>>
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> queryListMap(Connection conn, String sqlString, Object... params) {
        MapListHandler handler = new MapListHandler();
        return (List<Map<String, Object>>) query(conn, sqlString, handler, params);
    }
    
    /**
     * This method returns a query with custom objects
     * 
     * @return List<T>
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryListT(Connection conn, String sqlString, Class<T> classT, Object... params) {
        ResultSetHandler<List<T>> handler = new BeanListHandler<T>(classT);
        return (List<T>) query(conn, sqlString, handler, params);
    }
    
    /**
     * This method return an custom object of the query
     * 
     * @return T
     */
    @SuppressWarnings("unchecked")
    public <T> T queryObject(Connection conn, String sqlString, Class<T> classT, Object... params) {
        ResultSetHandler<T> handler = new BeanHandler<T>(classT);
        return (T) query(conn, sqlString, handler, params);
    }
    
    /**
     * This method executes insert and update statements
     */
    public int update(Connection conn, String sqlString, Object... params) {
        int foo = 0;
        try {
            foo = runner.update(conn, sqlString, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foo;
    }
}
