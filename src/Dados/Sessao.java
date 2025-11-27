package Dados;

import java.sql.Time;
import java.sql.Date;

public class Sessao {
    private int idSessao;
    private Date data;
    private Time horario;
    private int fkIdFilme;
    private int fkIdSala;
    private String nomeFilmeAux;
    private Time horarioFimAux;
    
    public int getIdSessao() { return idSessao; }
    public void setIdSessao(int idSessao) { this.idSessao = idSessao; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public Time getHorario() { return horario; }
    public void setHorario(Time horario) { this.horario = horario; }
    public int getFkIdFilme() { return fkIdFilme; }
    public void setFkIdFilme(int fkIdFilme) { this.fkIdFilme = fkIdFilme; }
    public int getFkIdSala() { return fkIdSala; }
    public void setFkIdSala(int fkIdSala) { this.fkIdSala = fkIdSala; }
    public String getNomeFilmeAux() { return nomeFilmeAux; }
    public void setNomeFilmeAux(String nomeFilmeAux) { this.nomeFilmeAux = nomeFilmeAux; }
    public Time getHorarioFimAux() { return horarioFimAux; }
    public void setHorarioFimAux(Time horarioFimAux) { this.horarioFimAux = horarioFimAux; }

    @Override
    public String toString() {
        return "ID: " + idSessao + 
               " | Filme: " + (nomeFilmeAux != null ? nomeFilmeAux : fkIdFilme) + 
               " | Data: " + data + 
               " | Horário: " + horario + " às " + (horarioFimAux != null ? horarioFimAux : "??:??") + 
               " | Sala: " + fkIdSala;
    }
}