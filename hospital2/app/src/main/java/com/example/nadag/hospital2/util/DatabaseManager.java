package com.example.nadag.hospital2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {

    final String connectionURL = "jdbc:mysql://db4free.net:3306/hnahospital";
    final String userName = "hnahospitalusr";
    final String userPassword = "123456789";

    private Connection connection = null;

    private String queryString;
    private List<Object> parameters = new ArrayList<Object>();



    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setParameter(int index, Object parameter) {
        parameters.add(index, parameter);
    }

    /**
     * Integer executeUpdate() this method execute non-query
     *
     * @return an integer this integer is the generated key in case of INSERT or
     * the number of affected rows in case of DELETE or UPDATE
     */
    public Integer executeUpdate() throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer returnedKey = 0;


        openConnection();
        preparedStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < parameters.size(); i++) {

            preparedStatement.setObject(i + 1, parameters.get(i));// preparedStatment
            // is 1
            // indexed
        }

        returnedKey = preparedStatement.executeUpdate();// returnedKey now
        // has number of
        // affected rows
        resultSet = preparedStatement.getGeneratedKeys();
        // a ResultSet object that contains the data produced by the given
        // query; never null
        if (resultSet.next()) {
            returnedKey = resultSet.getInt(1);// overwirte affected rows
            // with the generatedId only
            // in case of insert

            // nothing if it wasn't opened
            parameters.clear();
            resultSet.close();
            preparedStatement.close();
        }

        return returnedKey;

    }

    /**
     * List<object[]> executeQuery() this method execute query as described in
     * the queryString
     *
     * @return a list of object arrays each object array represent a row each
     * object represent a column in that row it can return empty list if
     * there is no subjects
     */

    public List<Object[]> executeQuery() throws SQLException {

        List<Object[]> results = new ArrayList<Object[]>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        openConnection();
        preparedStatement = connection.prepareStatement(queryString);
        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));// preparedStatment
            // is 1
            // indexed
        }

        preparedStatement.executeQuery();
        resultSet = preparedStatement.getResultSet();
        // a ResultSet object that contains the data produced by the given
        // query; never null
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            Object[] result = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                result[i] = resultSet.getObject(i + 1);// resultSet is 1
                // indexed
            }
            results.add(result);
        }

        // DbUtils.clloseQuietly(X) try to close X if it is opened or do
        // nothing if it wasn't opened
        parameters.clear();
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return results;
    }

    public List<Object[]> callStoredProcedure(String query) throws SQLException {

        List<Object[]> results = new ArrayList<Object[]>();
        java.sql.CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        openConnection();
        callableStatement = connection.prepareCall(query);
        for (int i = 0; i < parameters.size(); i++) {
            callableStatement.setObject(i + 1, parameters.get(i));// preparedStatment
            // is 1
            // indexed
        }

        callableStatement.executeQuery();
        resultSet = callableStatement.getResultSet();
        if (resultSet != null) {
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Object[] result = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    result[i] = resultSet.getObject(i + 1);// resultSet is 1
                    // indexed
                }
                results.add(result);
            }
        }
        // DbUtils.clloseQuietly(X) try to close X if it is opened or do
        // nothing if it wasn't opened
        parameters.clear();
        resultSet.close();
        callableStatement.close();


        return results;
    }

    public List<Map<String, Object>> runQuery() throws SQLException {
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        openConnection();
        preparedStatement = connection.prepareStatement(queryString);
        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));
        }

        preparedStatement.executeQuery();
        resultSet = preparedStatement.getResultSet();
        ResultSetMetaData resultsetMetaData = resultSet.getMetaData();

        int columnCount = resultsetMetaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> result = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                String key = resultsetMetaData.getColumnName(i);
                Object value = resultSet.getObject(i);
                result.put(key, value);
            }
            results.add(result);
        }

        parameters.clear();
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return results;
    }

    public Connection openConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(connectionURL, userName, userPassword);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;

    }

}