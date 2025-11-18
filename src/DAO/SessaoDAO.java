package DAO;

import Dados.Sessao;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {

    public void inserir(Sessao sessao) {
        String sql = "INSERT INTO SESSAO(data, horario, fk_id_filme, fk_id_sala) VALUES(?, ?, ?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, sessao.getData());
            pstmt.setTime(2, sessao.getHorario());
            pstmt.setInt(3, sessao.getFkIdFilme());
            pstmt.setInt(4, sessao.getFkIdSala());
            
            pstmt.executeUpdate();
            System.out.println("Sessão inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir sessão: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM SESSAO WHERE id_sessao = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Sessão removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover sessão: " + e.getMessage());
        }
    }

    public List<Sessao> listarTodos() {
        String sql = "SELECT * FROM SESSAO ORDER BY data, horario";
        List<Sessao> sessoes = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Sessao sessao = new Sessao();
                sessao.setIdSessao(rs.getInt("id_sessao"));
                sessao.setData(rs.getDate("data"));
                sessao.setHorario(rs.getTime("horario"));
                sessao.setFkIdFilme(rs.getInt("fk_id_filme"));
                sessao.setFkIdSala(rs.getInt("fk_id_sala"));
                sessoes.add(sessao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar sessões: " + e.getMessage());
        }
        return sessoes;
    }
}
    

