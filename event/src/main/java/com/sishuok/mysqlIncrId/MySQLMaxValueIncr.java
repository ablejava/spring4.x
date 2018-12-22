package com.sishuok.mysqlIncrId;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.incrementer.AbstractColumnMaxValueIncrementer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLMaxValueIncr extends AbstractColumnMaxValueIncrementer {

    private static final  String VALUE_SQL = "select last_insert_id()";
    private long nextId =0L;
    private long maxId =0L;

    public MySQLMaxValueIncr(){}

    public MySQLMaxValueIncr(DataSource dataSource, String incrNum, String columnNum){
        super(dataSource, incrNum, columnNum);
    }

    protected synchronized long getNextKey() throws DataAccessException {
        if (this.maxId == this.nextId) {
            Connection connection = DataSourceUtils.getConnection(this.getDataSource());
            Statement stmt = null;

            try {
                stmt = connection.createStatement();
                DataSourceUtils.applyTransactionTimeout(stmt, this.getDataSource());
                String ex = this.getColumnName();
                stmt.executeUpdate("update "+this.getIncrementerName()+" set "+ex+"=last_insert_id("+ex+"+"+this.getCacheSize()+")");
                ResultSet resultSet = stmt.executeQuery(VALUE_SQL);
                try {
                    if (!resultSet.next()){
                        throw new DataAccessResourceFailureException("last_insert_id() failed after executeing an update");

                    }
                    this.maxId = resultSet.getLong(1);
                }finally {
                    JdbcUtils.closeResultSet(resultSet);
                }

                this.nextId = this.maxId - (long) this.getCacheSize()+1L;
            } catch (SQLException e){
                throw new DataAccessResourceFailureException(" could not obtain last_insert_id()", e);
            } finally {
                JdbcUtils.closeStatement(stmt);
                DataSourceUtils.releaseConnection(connection, this.getDataSource());
            }
        } else {
            ++ this.nextId;
        }
        return this.nextId;
    }
}
