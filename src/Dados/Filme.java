package Dados;

public class Filme {
    private int idFilme;
    private String titulo;
    private String genero;
    private String classificacao;
    private int duracao;

    // Getters e Setters
    public int getIdFilme() { return idFilme; }
    public void setIdFilme(int idFilme) { this.idFilme = idFilme; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getClassificacao() { return classificacao; }
    public void setClassificacao(String classificacao) { this.classificacao = classificacao; }
    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    @Override
    public String toString() {
        return "Filme [ID=" + idFilme + ", Titulo=" + titulo + ", Genero=" + genero + "]";
    }
}