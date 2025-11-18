package Dados;

public class Sala {
    private int idSala;
    private int capacidade;

    // Getters e Setters
    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    @Override
    public String toString() {
        return "Sala [ID=" + idSala + ", Capacidade=" + capacidade + "]";
    }
}