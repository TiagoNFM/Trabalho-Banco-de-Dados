package DAO;

import Dados.Pertence;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PertenceDAO {

    public void inserir(Pertence pertence) {
        String sql = "INSERT INTO PERTENCE(fk_id_sessao, fk_id_ingresso, fk_id_poltrona) VALUES(?, ?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, pertence.getFkIdSessao());
            pstmt.setInt(2, pertence.getFkIdIngresso());
            pstmt.setInt(3, pertence.getFkIdPoltrona());
            
            pstmt.executeUpdate();
            System.out.println("Venda de ingresso inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir 'pertence': " + e.getMessage());
        }
    }

    public void remover(int idSessao, int idIngresso) {
        String sql = "DELETE FROM PERTENCE WHERE fk_id_sessao = ? AND fk_id_ingresso = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idSessao);
            pstmt.setInt(2, idIngresso);
            pstmt.executeUpdate();
            System.out.println("Venda de ingresso removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover 'pertence': " + e.getMessage());
        }
    }

    public List<Pertence> listarTodos() {
        String sql = "SELECT * FROM PERTENCE";
        List<Pertence> lista = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pertence pertence = new Pertence();
                pertence.setFkIdSessao(rs.getInt("fk_id_sessao"));
                pertence.setFkIdIngresso(rs.getInt("fk_id_ingresso"));
                pertence.setFkIdPoltrona(rs.getInt("fk_id_poltrona"));
                lista.add(pertence);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar 'pertence': " + e.getMessage());
        }
        return lista;
    }
}