package DAO;

import Dados.Sala;
import ConexaoDB.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {

    // Requisito: "Uma opção para inserir novas tuplas"
    public void inserir(Sala sala) {
        String sql = "INSERT INTO SALA(capacidade) VALUES(?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, sala.getCapacidade());
            pstmt.executeUpdate();
            System.out.println("Sala inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir sala: " + e.getMessage());
        }
    }

    // Requisito: "Uma opção para remover tuplas"
    public void remover(int id) {
        String sql = "DELETE FROM SALA WHERE id_sala = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Sala removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover sala: " + e.getMessage());
        }
    }

    // Requisito: "Uma opção para listar todas as tuplas"
    public List<Sala> listarTodos() {
        String sql = "SELECT * FROM SALA ORDER BY id_sala";
        List<Sala> salas = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("id_sala"));
                sala.setCapacidade(rs.getInt("capacidade"));
                salas.add(sala);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar salas: " + e.getMessage());
        }
        return salas;
    }
}