package com.mycompany.lojainformatica.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String url = "jdbc:mysql://localhost:3306/lojainformatica";
    private static final String login = "root";
    private static final String senha = "";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, senha);
                System.out.println("Conectou");
            }


            return connection;

        } catch (Exception e) {
            System.out.println("Falha de conexão com o banco de dados -> " + e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public static void close() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            System.out.println("Erro para fechar conexão");
        }
    }

}
