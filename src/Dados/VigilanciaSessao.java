package Dados;

public class VigilanciaSessao {
    private int fkIdSessao;
    private int fkMatriculaVigia;

    // Getters e Setters
    public int getFkIdSessao() { return fkIdSessao; }
    public void setFkIdSessao(int fkIdSessao) { this.fkIdSessao = fkIdSessao; }
    public int getFkMatriculaVigia() { return fkMatriculaVigia; }
    public void setFkMatriculaVigia(int fkMatriculaVigia) { this.fkMatriculaVigia = fkMatriculaVigia; }

    @Override
    public String toString() {
        return "VigilanciaSessao [ID_Sessao=" + fkIdSessao + ", ID_Vigia=" + fkMatriculaVigia + "]";
    }
}