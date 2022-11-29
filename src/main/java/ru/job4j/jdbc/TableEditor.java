package ru.job4j.jdbc;


import ru.job4j.io.Config;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private  Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }


    /*
    подключение к БД>:
    */
    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("hibernate.connection.driver"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createBaseConnection(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    /*
    создает пустую таблицу без столбцов с указанным именем:
    */
    public void createTable(String tableName) throws Exception {
        createBaseConnection(String.format(
                "create table if not exists %s(%s);",
                tableName,
                "id serial primary key"
        ));
    }

    /*
    удаляет таблицу по указанному имени:
     */
    public void dropTable(String tableName) throws Exception {
        createBaseConnection(String.format(
                "drop table %s;",
                tableName
        ));
    }

    /*
    добавляет столбец в таблицу:
     */
    public void addColumn(String tableName, String columnName, String type) throws Exception {
        createBaseConnection(String.format(
                "alter table %s add column %s %s;",
                tableName,
                columnName,
                type
        ));
    }

/*
удаляет столбец из таблицы:
 */
    public void dropColumn(String tableName, String columnName) throws Exception {
        createBaseConnection(String.format(
                "alter table %s drop column %s;",
                tableName,
                columnName
        ));
    }

/*
переименовывает столбец:
 */
    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        createBaseConnection(String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        ));
    }

    /*
метод выводит схему таблицы- столбцы и их типы:
 */
    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            TableEditor table = new TableEditor(config);
            table.createTable("worker");
            table.addColumn("worker", "name", "varchar(255)");
            table.addColumn("worker", "age", "int");
            table.renameColumn("worker", "name", "full_name");
            table.dropColumn("worker", "age");
            System.out.println(getTableScheme(table.connection, "worker"));
        }
    }
}
