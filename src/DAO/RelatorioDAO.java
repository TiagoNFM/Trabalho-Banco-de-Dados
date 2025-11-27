package DAO;

import ConexaoDB.Conexaodb;
import java.sql.*;

public class RelatorioDAO {
    public void relatorioJoinSessaoFilme() {
        String sql = "SELECT s.id_sessao, s.data, s.horario, f.titulo " +
                     "FROM SESSAO s " +
                     "JOIN FILME f ON s.fk_id_filme = f.id_filme " +
                     "ORDER BY s.data, s.horario";
        
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- Relatório de Sessões ---");
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
    
    public void relatorioSubqueryAggSala() {
    String sqlMedia = "SELECT AVG(capacidade) AS media FROM SALA";
    
    String sqlLista = "SELECT id_sala, capacidade FROM SALA " +
                      "WHERE capacidade > (SELECT AVG(capacidade) FROM SALA)";
    
        try (Connection conn = Conexaodb.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rsMedia = stmt.executeQuery(sqlMedia);
            double media = 0;
            if (rsMedia.next()) {
                media = rsMedia.getDouble("media");
            }
            rsMedia.close();

            System.out.println("\n--- Relatório: Salas com Capacidade Acima da Média ---");
            System.out.printf(">>> Média Geral Calculada: %.2f assentos <<<\n", media);
            System.out.println("------------------------------------------------------");

            ResultSet rsLista = stmt.executeQuery(sqlLista);

            while (rsLista.next()) {
                System.out.printf("ID Sala: %d | Capacidade: %d\n",
                        rsLista.getInt("id_sala"),
                        rsLista.getInt("capacidade"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de salas: " + e.getMessage());
        }
    }
}