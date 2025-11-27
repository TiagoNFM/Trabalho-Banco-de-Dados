package Dados;

public class Ingresso {
    private int idIngresso;
    private String formaPagamento;
    private int tipoIngresso; // 1 = Inteira, 2 = Meia
    private Integer categoriaMeia;
    private int fkMatriculaBilheteiro;

    // Getters e Setters
    public int getIdIngresso() { return idIngresso; }
    public void setIdIngresso(int idIngresso) { this.idIngresso = idIngresso; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public int getTipoIngresso() { return tipoIngresso; }
    public void setTipoIngresso(int tipoIngresso) { this.tipoIngresso = tipoIngresso; }
    public Integer getCategoriaMeia() { return categoriaMeia; }
    public void setCategoriaMeia(Integer categoriaMeia) { this.categoriaMeia = categoriaMeia; }
    public int getFkMatriculaBilheteiro() { return fkMatriculaBilheteiro; }
    public void setFkMatriculaBilheteiro(int fkMatriculaBilheteiro) { this.fkMatriculaBilheteiro = fkMatriculaBilheteiro; }

    @Override
    public String toString() {
        return "Ingresso [ID=" + idIngresso + ", Tipo=" + tipoIngresso + ", Pagamento=" + formaPagamento + "]";
    }
}