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
            System.out.println("4.  Inserir Sessao         | 5.  Remover Sessao         | 6.  Listar Sessoes");
            System.out.println("7.  Inserir Filme          | 8.  Remover Filme          | 9.  Listar Filmes");
            System.out.println("10. Inserir Poltrona       | 11. Remover Poltrona       | 12. Listar Poltronas");
            System.out.println("13. Inserir Funcionario    | 14. Remover Funcionario    | 15. Listar Funcionarios");
            System.out.println("16. Inserir Ingresso       | 17. Remover Ingresso       | 18. Listar Ingressos");
            System.out.println("19. Inserir Vigilancia     | 20. Remover Vigilancia     | 21. Listar Vigilancias");
            System.out.println("22. Inserir Venda          | 23. Remover Venda          | 24. Listar Vendas");
            System.out.println("---------------------------------------------------------------");
            System.out.println("50. Relatorio: Sessões com Nomes (JOIN)");
            System.out.println("51. Relatorio: Salas Acima da Media (SUBQUERY)");
            System.out.println("0.  Sair");
            System.out.println("===============================================================");
            System.out.print("Escolha uma opçao: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                // --- SALAS ---
                case 1: 
                    Sala sala = new Sala();
                    System.out.print("Digite a capacidade da nova sala: ");
                    sala.setCapacidade(scanner.nextInt());
                    scanner.nextLine();
                    salaDAO.inserir(sala);
                    break;
                case 2: 
                    System.out.println("--- Salas Disponíveis ---");
                    for(Sala s : salaDAO.listarTodos()) System.out.println(s);
                    
                    System.out.print("Digite o ID da sala a remover: ");
                    salaDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3: 
                    System.out.println("\nListando Salas:");
                    for (Sala s : salaDAO.listarTodos()) System.out.println(s);
                    break;

                // --- SESSÕES ---
                case 4: 
                    Sessao sessao = new Sessao();
                    System.out.print("Digite a data (AAAA-MM-DD): ");
                    sessao.setData(Date.valueOf(scanner.nextLine()));
                    System.out.print("Digite o horário (HH:MM:SS): ");
                    sessao.setHorario(Time.valueOf(scanner.nextLine()));
                    
                    System.out.println("--- Filmes Disponíveis ---");
                    for(Filme f : filmeDAO.listarTodos()) System.out.println(f);
                    System.out.print("Digite o ID do Filme: ");
                    sessao.setFkIdFilme(scanner.nextInt());
                    
                    System.out.println("--- Salas Disponíveis ---");
                    for(Sala s : salaDAO.listarTodos()) System.out.println(s);
                    System.out.print("Digite o ID da Sala: ");
                    sessao.setFkIdSala(scanner.nextInt());
                    
                    scanner.nextLine();
                    sessaoDAO.inserir(sessao);
                    break;
                case 5: 
                    System.out.println("--- Sessões Disponíveis ---");
                    for(Sessao s : sessaoDAO.listarTodos()) System.out.println(s);
                    
                    System.out.print("Digite o ID da sessão a remover: ");
                    sessaoDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 6: 
                    System.out.println("\nListando Sessões:");
                    for (Sessao s : sessaoDAO.listarTodos()) System.out.println(s);
                    break;
                
                // --- FILMES ---
                case 7: 
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
                case 8: 
                    System.out.println("--- Filmes Disponíveis ---");
                    for(Filme f : filmeDAO.listarTodos()) System.out.println(f);
                    
                    System.out.print("Digite o ID do filme a remover: ");
                    filmeDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 9: 
                    System.out.println("\nListando Filmes:");
                    for (Filme f : filmeDAO.listarTodos()) System.out.println(f);
                    break;
                
                // --- POLTRONAS ---
                case 10: 
                    Poltrona poltrona = new Poltrona();
                    System.out.print("Digite a fila (ex: A): ");
                    poltrona.setFila(scanner.nextLine());
                    System.out.print("Digite o número (ex: 10): ");
                    poltrona.setNumero(scanner.nextInt());
                    
                    System.out.println("--- Salas Disponíveis ---");
                    for(Sala s : salaDAO.listarTodos()) System.out.println(s);
                    System.out.print("Digite o ID da Sala: ");
                    
                    poltrona.setFkIdSala(scanner.nextInt());
                    scanner.nextLine();
                    poltronaDAO.inserir(poltrona);
                    break;
                case 11: 
                    System.out.println("--- Poltronas Cadastradas ---");
                    for(Poltrona p : poltronaDAO.listarTodos()) System.out.println(p);
                    
                    System.out.print("Digite o ID da poltrona a remover: ");
                    poltronaDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 12: 
                    System.out.println("\nListando Poltronas:");
                    for (Poltrona p : poltronaDAO.listarTodos()) System.out.println(p);
                    break;
                
                // --- FUNCIONARIOS ---
                case 13: 
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
                case 14: 
                    System.out.println("--- Funcionários Cadastrados ---");
                    for(Funcionario f : funcionarioDAO.listarTodos()) System.out.println(f);
                    
                    System.out.print("Digite a matrícula do funcionário a remover: ");
                    funcionarioDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 15: 
                    System.out.println("\nListando Funcionários:");
                    for (Funcionario f : funcionarioDAO.listarTodos()) System.out.println(f);
                    break;
                
                // --- INGRESSOS ---
                case 16: 
                    Ingresso ingresso = new Ingresso();
                    System.out.println("Forma de Pagamento: 1-Crédito, 2-Débito, 3-Pix, 4-Dinheiro");
                    System.out.print("Digite o código: ");
                    ingresso.setFormaPagamento(scanner.nextInt());
                    
                    System.out.print("Digite o tipo (1=Inteira, 2=Meia): ");
                    int tipo = scanner.nextInt();
                    ingresso.setTipoIngresso(tipo);
                    
                    if (tipo == 2) {
                        System.out.print("Digite a categoria da meia (1=Estudante, 2=Idoso, etc): ");
                        ingresso.setCategoriaMeia(scanner.nextInt());
                    } else {
                        ingresso.setCategoriaMeia(null);
                    }
                    
                    System.out.println("--- Funcionários (Escolha um Bilheteiro) ---");
                    for(Funcionario f : funcionarioDAO.listarTodos()) System.out.println(f);
                    System.out.print("Digite a matrícula do Bilheteiro: ");
                    
                    ingresso.setFkMatriculaBilheteiro(scanner.nextInt());
                    scanner.nextLine();
                    ingressoDAO.inserir(ingresso);
                    break;
                case 17: 
                    System.out.println("--- Ingressos Cadastrados ---");
                    for(Ingresso i : ingressoDAO.listarTodos()) System.out.println(i);
                    
                    System.out.print("Digite o ID do ingresso a remover: ");
                    ingressoDAO.remover(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 18: 
                    System.out.println("\nListando Ingressos:");
                    for (Ingresso i : ingressoDAO.listarTodos()) System.out.println(i);
                    break;
                
                // --- VIGILANCIA ---
                case 19: 
                    VigilanciaSessao vs = new VigilanciaSessao();
                    
                    System.out.println("--- Sessões Disponíveis ---");
                    for(Sessao s : sessaoDAO.listarTodos()) System.out.println(s);
                    System.out.print("Digite o ID da Sessão: ");
                    vs.setFkIdSessao(scanner.nextInt());
                    
                    System.out.println("--- Funcionários (Escolha um Vigia) ---");
                    for(Funcionario f : funcionarioDAO.listarTodos()) System.out.println(f);
                    System.out.print("Digite a Matrícula do Vigia: ");
                    vs.setFkMatriculaVigia(scanner.nextInt());
                    
                    scanner.nextLine();
                    vigilanciaDAO.inserir(vs);
                    break;
                case 20: 
                    System.out.println("--- Vigilâncias Cadastradas ---");
                    for(VigilanciaSessao v : vigilanciaDAO.listarTodos()) System.out.println(v);
                    
                    System.out.print("Digite o ID da Sessão a remover: ");
                    int vsSessaoId = scanner.nextInt();
                    System.out.print("Digite a Matrícula do Vigia a remover: ");
                    int vsVigiaId = scanner.nextInt();
                    scanner.nextLine();
                    vigilanciaDAO.remover(vsSessaoId, vsVigiaId);
                    break;
                case 21: 
                    System.out.println("\nListando Vigilâncias:");
                    for (VigilanciaSessao v : vigilanciaDAO.listarTodos()) System.out.println(v);
                    break;
                
                    // VENDAS
                case 22: 
                    Pertence pertence = new Pertence();
                    
                    System.out.println("--- Sessões Disponíveis ---");
                    for(Sessao s : sessaoDAO.listarTodos()) System.out.println(s);
                    System.out.print("Digite o ID da Sessão: ");
                    pertence.setFkIdSessao(scanner.nextInt());
                    
                    System.out.println("--- Ingressos Disponíveis ---");
                    for(Ingresso i : ingressoDAO.listarTodos()) System.out.println(i);
                    System.out.print("Digite o ID do Ingresso: ");
                    pertence.setFkIdIngresso(scanner.nextInt());
                    
                    System.out.println("--- Poltronas Disponíveis ---");
                    for(Poltrona p : poltronaDAO.listarTodos()) System.out.println(p);
                    System.out.print("Digite o ID da Poltrona: ");
                    pertence.setFkIdPoltrona(scanner.nextInt());
                    
                    scanner.nextLine();
                    pertenceDAO.inserir(pertence);
                    break;
                    
                case 23: 
                    System.out.println("--- Vendas (Pertence) Cadastradas ---");
                    for(Pertence p : pertenceDAO.listarTodos()) System.out.println(p);
                    
                    System.out.print("Digite o ID da Sessão da venda a remover: ");
                    int pSessaoId = scanner.nextInt();
                    System.out.print("Digite o ID do Ingresso da venda a remover: ");
                    int pIngressoId = scanner.nextInt();
                    scanner.nextLine();
                    pertenceDAO.remover(pSessaoId, pIngressoId);
                    break;
                    
                case 24: 
                    System.out.println("\nListando Vendas:");
                    for (Pertence p : pertenceDAO.listarTodos()) System.out.println(p);
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