package DAO;

import Dados.Poltrona;
import ConexaoDB.Conexaodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PoltronaDAO {

    public void inserir(Poltrona poltrona) {
        String sql = "INSERT INTO POLTRONA(numero, fila, fk_id_sala) VALUES(?, ?, ?)";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, poltrona.getNumero());
            pstmt.setString(2, poltrona.getFila());
            pstmt.setInt(3, poltrona.getFkIdSala());
            
            pstmt.executeUpdate();
            System.out.println("Poltrona inserida com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir poltrona: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM POLTRONA WHERE id_poltrona = ?";
        try (Connection conn = Conexaodb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Poltrona removida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao remover poltrona: " + e.getMessage());
        }
    }

    public List<Poltrona> listarTodos() {
        String sql = "SELECT * FROM POLTRONA ORDER BY fk_id_sala, fila, numero";
        List<Poltrona> poltronas = new ArrayList<>();
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Poltrona poltrona = new Poltrona();
                poltrona.setIdPoltrona(rs.getInt("id_poltrona"));
                poltrona.setNumero(rs.getInt("numero"));
                poltrona.setFila(rs.getString("fila"));
                poltrona.setFkIdSala(rs.getInt("fk_id_sala"));
                poltronas.add(poltrona);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar poltronas: " + e.getMessage());
        }
        return poltronas;
    }
}