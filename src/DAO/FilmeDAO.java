package DAO;

import Dados.Filme;
import ConexaoDB.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public void inserir(Filme filme) {
        String sql = "INSERT INTO FILME(titulo, genero, classificacao, duracao) VALUES(?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, filme.getTitulo());
            pstmt.setString(2, filme.getGenero());
            pstmt.setString(3, filme.getClassificacao());
            pstmt.setInt(4, filme.getDuracao());
            
            pstmt.executeUpdate();
            System.out.println("Filme inserido com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM FILME WHERE id_filme = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Filme removido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover filme: " + e.getMessage());
        }
    }

    public List<Filme> listarTodos() {
        String sql = "SELECT * FROM FILME ORDER BY titulo";
        List<Filme> filmes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("id_filme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setClassificacao(rs.getString("classificacao"));
                filme.setDuracao(rs.getInt("duracao"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar filmes: " + e.getMessage());
        }
        return filmes;
    }
}