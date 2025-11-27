package Dados;

public class Funcionario {
    private int matricula;
    private String nome;
    private String telefone;
    private int tipoFuncionario; // 1 = Vigia, 2 = Bilheteiro

    // Getters e Setters
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public int getTipoFuncionario() { return tipoFuncionario; }
    public void setTipoFuncionario(int tipoFuncionario) { this.tipoFuncionario = tipoFuncionario; }

    @Override
    public String toString() {
        String tipo = (tipoFuncionario == 1) ? "Vigia" : "Bilheteiro";
        return "Funcionario [Matricula=" + matricula + ", Nome=" + nome + ", Tipo=" + tipo + "]";
    }
}