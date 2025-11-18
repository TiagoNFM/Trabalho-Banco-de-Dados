package DAO;

import Dados.Funcionario;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario func) {
        String sql = "INSERT INTO FUNCIONARIO(nome, telefone, tipo_funcionario) VALUES(?, ?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, func.getNome());
            pstmt.setString(2, func.getTelefone());
            pstmt.setInt(3, func.getTipoFuncionario());
            
            pstmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public void remover(int matricula) {
        String sql = "DELETE FROM FUNCIONARIO WHERE matricula = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, matricula);
            pstmt.executeUpdate();
            System.out.println("Funcionário removido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listarTodos() {
        String sql = "SELECT * FROM FUNCIONARIO ORDER BY nome";
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setMatricula(rs.getInt("matricula"));
                func.setNome(rs.getString("nome"));
                func.setTelefone(rs.getString("telefone"));
                func.setTipoFuncionario(rs.getInt("tipo_funcionario"));
                funcionarios.add(func);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
        }
        return funcionarios;
    }
}