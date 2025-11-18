package DAO;

import ConexaoDB.ConnectionFactory;
import java.sql.*;

public class RelatorioDAO {

    /**
     * Requisito: "Uma opção para listar o resultado de uma consulta que envolva uma junção entre duas tabelas"
     * Consulta: Listar todas as sessões, mostrando o título do filme (Junta SESSAO e FILME).
     */
    public void relatorioJoinSessaoFilme() {
        String sql = "SELECT s.id_sessao, s.data, s.horario, f.titulo " +
                     "FROM SESSAO s " +
                     "JOIN FILME f ON s.fk_id_filme = f.id_filme " +
                     "ORDER BY s.data, s.horario";
        
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- Relatório de Sessões (JOIN) ---");
            while (rs.next()) {
                System.out.printf("ID Sessão: %d | Data: %s | Horário: %s | Filme: %s\n",
                        rs.getInt("id_sessao"),
                        rs.getDate("data").toString(),
                        rs.getTime("horario").toString(),
                        rs.getString("titulo"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de sessões: " + e.getMessage());
        }
    }

    /**
     * Requisito: "Uma opção para listar o resultado de uma consulta que envolva subconsulta(s) e uma ou mais funções de agregação."
     * Consulta: Listar todas as salas cuja capacidade é maior que a capacidade média de todas as salas.
     * (Agregação: AVG(), Subconsulta: (SELECT AVG(capacidade) FROM SALA))
     */
    public void relatorioSubqueryAggSala() {
        String sql = "SELECT id_sala, capacidade FROM SALA " +
                     "WHERE capacidade > (SELECT AVG(capacidade) FROM SALA)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- Relatório: Salas com Capacidade Acima da Média ---");
            while (rs.next()) {
                System.out.printf("ID Sala: %d | Capacidade: %d\n",
                        rs.getInt("id_sala"),
                        rs.getInt("capacidade"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de salas: " + e.getMessage());
        }
    }
}