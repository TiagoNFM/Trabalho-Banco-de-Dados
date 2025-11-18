package DAO;

import Dados.VigilanciaSessao;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VigilanciaSessaoDAO {

    public void inserir(VigilanciaSessao vs) {
        String sql = "INSERT INTO VIGILANCIA_SESSAO(fk_id_sessao, fk_matricula_vigia) VALUES(?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, vs.getFkIdSessao());
            pstmt.setInt(2, vs.getFkMatriculaVigia());
            
            pstmt.executeUpdate();
            System.out.println("Vigilância de sessão inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir vigilância: " + e.getMessage());
        }
    }

    // A chave primária é composta [cite: 37]
    public void remover(int idSessao, int idVigia) {
        String sql = "DELETE FROM VIGILANCIA_SESSAO WHERE fk_id_sessao = ? AND fk_matricula_vigia = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idSessao);
            pstmt.setInt(2, idVigia);
            pstmt.executeUpdate();
            System.out.println("Vigilância de sessão removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover vigilância: " + e.getMessage());
        }
    }

    public List<VigilanciaSessao> listarTodos() {
        String sql = "SELECT * FROM VIGILANCIA_SESSAO";
        List<VigilanciaSessao> lista = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                VigilanciaSessao vs = new VigilanciaSessao();
                vs.setFkIdSessao(rs.getInt("fk_id_sessao"));
                vs.setFkMatriculaVigia(rs.getInt("fk_matricula_vigia"));
                lista.add(vs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar vigilâncias: " + e.getMessage());
        }
        return lista;
    }
}