package DAO;

import Dados.Sala;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {

    public void inserir(Sala sala) {
        String sql = "INSERT INTO SALA(capacidade) VALUES(?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, sala.getCapacidade());
            pstmt.executeUpdate();
            System.out.println("Sala inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir sala: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM SALA WHERE id_sala = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Sala removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover sala: " + e.getMessage());
        }
    }

    public List<Sala> listarTodos() {
        String sql = "SELECT * FROM SALA ORDER BY id_sala";
        List<Sala> salas = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
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