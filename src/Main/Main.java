package Main;

import DAO.*;
import Dados.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SalaDAO salaDAO = new SalaDAO();
        SessaoDAO sessaoDAO = new SessaoDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        PoltronaDAO poltronaDAO = new PoltronaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        IngressoDAO ingressoDAO = new IngressoDAO();
        VigilanciaSessaoDAO vigilanciaDAO = new VigilanciaSessaoDAO();
        PertenceDAO pertenceDAO = new PertenceDAO();
        
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n====================== SISTEMA DE CINEMA ======================");
            System.out.println("1.  Inserir Sala           | 2.  Remover Sala           | 3.  Listar Salas");
            System.out.println("4.  Inserir Sessão         | 5.  Remover Sessão         | 6.  Listar Sessões");
            System.out.println("7.  Inserir Filme          | 8.  Remover Filme          | 9.  Listar Filmes");
            System.out.println("10. Inserir Poltrona       | 11. Remover Poltrona       | 12. Listar Poltronas");
            System.out.println("13. Inserir Funcionário    | 14. Remover Funcionário    | 15. Listar Funcionários");
            System.out.println("16. Inserir Ingresso       | 17. Remover Ingresso       | 18. Listar Ingressos");
            System.out.println("19. Inserir Vigilância     | 20. Remover Vigilância     | 21. Listar Vigilâncias");
            System.out.println("22. Inserir Venda          | 23. Remover Venda          | 24. Listar Vendas");
            System.out.println("---------------------------------------------------------------");
            System.out.println("50. Relatório: Sessões com Nomes (JOIN)");
            System.out.println("51. Relatório: Salas Acima da Média (SUBQUERY)");
            System.out.println("0.  Sair");
            System.out.println("===============================================================");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                case 1: // Inserir Sala
                    Sala sala = new Sala();
                    System.out.print("Digite a capacidade da nova sala: ");
                    sala.setCapacidade(scanner.nextInt());
                    scanner.nextLine();
                    salaDAO.inserir(sala);
                    break;
                case 2: // Remover Sala
                    System.out.print("Digite o ID da sala a remover: ");
                    salaDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3: // Listar Salas
                    System.out.println("\nListando Salas:");
                    for (Sala s : salaDAO.listarTodos()) {
                        System.out.println(s);
                    }
                    break;
                case 4: // Inserir Sessão
                    Sessao sessao = new Sessao();
                    System.out.print("Digite a data (AAAA-MM-DD): ");
                    sessao.setData(Date.valueOf(scanner.nextLine()));
                    System.out.print("Digite o horário (HH:MM:SS): ");
                    sessao.setHorario(Time.valueOf(scanner.nextLine()));
                    System.out.print("Digite o ID do Filme (FK): ");
                    sessao.setFkIdFilme(scanner.nextInt());
                    System.out.print("Digite o ID da Sala (FK): ");
                    sessao.setFkIdSala(scanner.nextInt());
                    scanner.nextLine();
                    sessaoDAO.inserir(sessao);
                    break;
                case 5: // Remover Sessão
                    System.out.print("Digite o ID da sessão a remover: ");
                    sessaoDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 6: // Listar Sessões
                    System.out.println("\nListando Sessões:");
                    for (Sessao s : sessaoDAO.listarTodos()) {
                        System.out.println(s);
                    }
                    break;
                
                case 7: // Inserir Filme
                    Filme filme = new Filme();
                    System.out.print("Digite o título: ");
                    filme.setTitulo(scanner.nextLine());
                    System.out.print("Digite o gênero: ");
                    filme.setGenero(scanner.nextLine());
                    System.out.print("Digite a classificação: ");
                    filme.setClassificacao(scanner.nextLine());
                    System.out.print("Digite a duração (em min): ");
                    filme.setDuracao(scanner.nextInt());
                    scanner.nextLine();
                    filmeDAO.inserir(filme);
                    break;
                case 8: // Remover Filme
                    System.out.print("Digite o ID do filme a remover: ");
                    filmeDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 9: // Listar Filmes
                    System.out.println("\nListando Filmes:");
                    for (Filme f : filmeDAO.listarTodos()) {
                        System.out.println(f);
                    }
                    break;
                
                case 10: // Inserir Poltrona
                    Poltrona poltrona = new Poltrona();
                    System.out.print("Digite a fila (ex: A): ");
                    poltrona.setFila(scanner.nextLine());
                    System.out.print("Digite o número (ex: 10): ");
                    poltrona.setNumero(scanner.nextInt());
                    System.out.print("Digite o ID da Sala (FK): ");
                    poltrona.setFkIdSala(scanner.nextInt());
                    scanner.nextLine();
                    poltronaDAO.inserir(poltrona);
                    break;
                case 11: // Remover Poltrona
                    System.out.print("Digite o ID da poltrona a remover: ");
                    poltronaDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 12: // Listar Poltronas
                    System.out.println("\nListando Poltronas:");
                    for (Poltrona p : poltronaDAO.listarTodos()) {
                        System.out.println(p);
                    }
                    break;
                
                case 13: // Inserir Funcionário
                    Funcionario func = new Funcionario();
                    System.out.print("Digite o nome: ");
                    func.setNome(scanner.nextLine());
                    System.out.print("Digite o telefone: ");
                    func.setTelefone(scanner.nextLine());
                    System.out.print("Digite o tipo (1=Vigia, 2=Bilheteiro): ");
                    func.setTipoFuncionario(scanner.nextInt());
                    scanner.nextLine();
                    funcionarioDAO.inserir(func);
                    break;
                case 14: // Remover Funcionário
                    System.out.print("Digite a matrícula do funcionário a remover: ");
                    funcionarioDAO.remover(scanner.nextInt());
                    scanner.nextLine(); // Limpa o buffer
                    break;
                case 15: // Listar Funcionários
                    System.out.println("\nListando Funcionários:");
                    for (Funcionario f : funcionarioDAO.listarTodos()) {
                        System.out.println(f);
                    }
                    break;
                
                case 16: // Inserir Ingresso
                    Ingresso ingresso = new Ingresso();
                    System.out.print("Digite a forma de pagamento: ");
                    ingresso.setFormaPagamento(scanner.nextLine());
                    System.out.print("Digite o tipo (1=Inteira, 2=Meia): ");
                    int tipo = scanner.nextInt();
                    ingresso.setTipoIngresso(tipo);
                    
                    if (tipo == 2) {
                        System.out.print("Digite a categoria da meia (1=Estudante, 2=Idoso, etc): ");
                        ingresso.setCategoriaMeia(scanner.nextInt());
                    } else {
                        ingresso.setCategoriaMeia(null); // Garante que é nulo
                    }
                    System.out.print("Digite a matrícula do Bilheteiro (FK): ");
                    ingresso.setFkMatriculaBilheteiro(scanner.nextInt());
                    scanner.nextLine();
                    ingressoDAO.inserir(ingresso);
                    break;
                case 17: // Remover Ingresso
                    System.out.print("Digite o ID do ingresso a remover: ");
                    ingressoDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 18: // Listar Ingressos
                    System.out.println("\nListando Ingressos:");
                    for (Ingresso i : ingressoDAO.listarTodos()) {
                        System.out.println(i);
                    }
                    break;
                
                case 19: // Inserir Vigilância
                    VigilanciaSessao vs = new VigilanciaSessao();
                    System.out.print("Digite o ID da Sessão (FK): ");
                    vs.setFkIdSessao(scanner.nextInt());
                    System.out.print("Digite a Matrícula do Vigia (FK): ");
                    vs.setFkMatriculaVigia(scanner.nextInt());
                    scanner.nextLine();
                    vigilanciaDAO.inserir(vs);
                    break;
                case 20: // Remover Vigilância
                    System.out.print("Digite o ID da Sessão a remover: ");
                    int vsSessaoId = scanner.nextInt();
                    System.out.print("Digite a Matrícula do Vigia a remover: ");
                    int vsVigiaId = scanner.nextInt();
                    scanner.nextLine();
                    vigilanciaDAO.remover(vsSessaoId, vsVigiaId);
                    break;
                case 21: // Listar Vigilâncias
                    System.out.println("\nListando Vigilâncias (Sessão x Vigia):");
                    for (VigilanciaSessao v : vigilanciaDAO.listarTodos()) {
                        System.out.println(v);
                    }
                    break;
                
                case 22: // Inserir Venda (Pertence)
                    Pertence pertence = new Pertence();
                    System.out.print("Digite o ID da Sessão (FK): ");
                    pertence.setFkIdSessao(scanner.nextInt());
                    System.out.print("Digite o ID do Ingresso (FK): ");
                    pertence.setFkIdIngresso(scanner.nextInt());
                    System.out.print("Digite o ID da Poltrona (FK): ");
                    pertence.setFkIdPoltrona(scanner.nextInt());
                    scanner.nextLine();
                    pertenceDAO.inserir(pertence);
                    break;
                case 23: // Remover Venda (Pertence)
                    System.out.print("Digite o ID da Sessão da venda a remover: ");
                    int pSessaoId = scanner.nextInt();
                    System.out.print("Digite o ID do Ingresso da venda a remover: ");
                    int pIngressoId = scanner.nextInt();
                    scanner.nextLine();
                    pertenceDAO.remover(pSessaoId, pIngressoId);
                    break;
                case 24: // Listar Vendas (Pertence)
                    System.out.println("\nListando Vendas (Sessao x Ingresso x Poltrona):");
                    for (Pertence p : pertenceDAO.listarTodos()) {
                        System.out.println(p);
                    }
                    break;

                case 50:
                    relatorioDAO.relatorioJoinSessaoFilme();
                    break;
                case 51:
                    relatorioDAO.relatorioSubqueryAggSala();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}