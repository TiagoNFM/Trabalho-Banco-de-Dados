package Dados;

public class Ingresso {
    private int idIngresso;
    private int formaPagamento; // 1 = crédito, 2 = débito, 3 = pix, 4 = dinheiro
    private int tipoIngresso; // 1 = Inteira, 2 = Meia
    private Integer categoriaMeia;
    private int fkMatriculaBilheteiro;

    // Getters e Setters
    public int getIdIngresso() { return idIngresso; }
    public void setIdIngresso(int idIngresso) { this.idIngresso = idIngresso; }
    public int getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(int formaPagamento) { this.formaPagamento = formaPagamento; }
    public int getTipoIngresso() { return tipoIngresso; }
    public void setTipoIngresso(int tipoIngresso) { this.tipoIngresso = tipoIngresso; }
    public Integer getCategoriaMeia() { return categoriaMeia; }
    public void setCategoriaMeia(Integer categoriaMeia) { this.categoriaMeia = categoriaMeia; }
    public int getFkMatriculaBilheteiro() { return fkMatriculaBilheteiro; }
    public void setFkMatriculaBilheteiro(int fkMatriculaBilheteiro) { this.fkMatriculaBilheteiro = fkMatriculaBilheteiro; }

    @Override
    public String toString() {
        String forma;
        switch(tipoIngresso) {
            case 1:
                forma = "Credito";
                break;
            case 2:
                forma = "Debito";
                break;
            case 3:
                forma = "Pix";
                break;
            case 4:
                forma = "Dinheiro";
                break;
            default:
                forma = "tipo invalido";
        }        
        return "Ingresso [ID=" + idIngresso + ", Tipo=" + tipoIngresso + ", Pagamento=" + forma + "]";
        
    }
}