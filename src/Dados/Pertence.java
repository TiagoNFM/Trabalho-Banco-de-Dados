package Dados;

public class Pertence {
    private int fkIdSessao;
    private int fkIdIngresso;
    private int fkIdPoltrona;

    // Getters e Setters
    public int getFkIdSessao() { return fkIdSessao; }
    public void setFkIdSessao(int fkIdSessao) { this.fkIdSessao = fkIdSessao; }
    public int getFkIdIngresso() { return fkIdIngresso; }
    public void setFkIdIngresso(int fkIdIngresso) { this.fkIdIngresso = fkIdIngresso; }
    public int getFkIdPoltrona() { return fkIdPoltrona; }
    public void setFkIdPoltrona(int fkIdPoltrona) { this.fkIdPoltrona = fkIdPoltrona; }

    @Override
    public String toString() {
        return "Pertence [ID_Sessao=" + fkIdSessao + ", ID_Ingresso=" + fkIdIngresso + ", ID_Poltrona=" + fkIdPoltrona + "]";
    }
}