package Dados;

public class Poltrona {
    private int idPoltrona;
    private int numero;
    private String fila;
    private int fkIdSala;

    // Getters e Setters
    public int getIdPoltrona() { return idPoltrona; }
    public void setIdPoltrona(int idPoltrona) { this.idPoltrona = idPoltrona; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }
    public int getFkIdSala() { return fkIdSala; }
    public void setFkIdSala(int fkIdSala) { this.fkIdSala = fkIdSala; }

    @Override
    public String toString() {
        return "Poltrona [ID=" + idPoltrona + ", Fila=" + fila + ", Numero=" + numero + ", ID_Sala=" + fkIdSala + "]";
    }
}