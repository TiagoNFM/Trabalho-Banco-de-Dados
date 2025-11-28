package DAO;

import Dados.Ingresso;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngressoDAO {

    public void inserir(Ingresso ingresso) {
        String sql = "INSERT INTO INGRESSO(forma_pagamento, tipo_ingresso, categoria_meia, fk_matricula_bilheteiro) VALUES(?, ?, ?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, ingresso.getFormaPagamento());
            pstmt.setInt(2, ingresso.getTipoIngresso());
            
            if (ingresso.getCategoriaMeia() == null) {
                pstmt.setNull(3, java.sql.Types.SMALLINT);
            } else {
                pstmt.setInt(3, ingresso.getCategoriaMeia());
            }
            
            pstmt.setInt(4, ingresso.getFkMatriculaBilheteiro());
            
            pstmt.executeUpdate();
            System.out.println("Ingresso inserido com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir ingresso: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM INGRESSO WHERE id_ingresso = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Ingresso removido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover ingresso: " + e.getMessage());
        }
    }

    public List<Ingresso> listarTodos() {
        String sql = "SELECT * FROM INGRESSO ORDER BY id_ingresso";
        List<Ingresso> ingressos = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setIdIngresso(rs.getInt("id_ingresso"));
                ingresso.setFormaPagamento(rs.getInt("forma_pagamento"));
                ingresso.setTipoIngresso(rs.getInt("tipo_ingresso"));
                
                int catMeia = rs.getInt("categoria_meia");
                if (!rs.wasNull()) {
                    ingresso.setCategoriaMeia(catMeia);
                }
                
                ingresso.setFkMatriculaBilheteiro(rs.getInt("fk_matricula_bilheteiro"));
                ingressos.add(ingresso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar ingressos: " + e.getMessage());
        }
        return ingressos;
    }
}