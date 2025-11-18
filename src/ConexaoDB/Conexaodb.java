package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaodb {
    private static final String URL = "jdbc:postgresql://localhost:5432/Cinema";
    private static final String USER = "postgres"; // Atualizar o nome do banco
    private static final String PASSWORD = "postgres"; // Atualizar para sua senha
    
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}