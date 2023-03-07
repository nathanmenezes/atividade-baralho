package br.com.cruzvita.entities;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private List<Carta> cartas = new ArrayList<>();
    private String status = "jogando";

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }

    

    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Integer totalPontuacao(){
        Integer pontuacao = 0;
        for (Carta carta : cartas) {
            if(carta.getNome() == "J" || carta.getNome() == "Q" || carta.getNome() == "K" || carta.getNome() == "A"|| carta.getNome() == "Coringa"){
                switch (carta.getNome()) {
                    case "J":
                        pontuacao += 11;
                    break;
                    case "Q":
                        pontuacao += 12;
                    break;
                    case "K":
                        pontuacao += 13;
                    break;
                    case "A":
                    pontuacao += 1;
                    break;
                    case "Coringa":
                        pontuacao += 21;
                    break;
                }
            }else{
                pontuacao += Integer.parseInt(carta.getNome());
            }
        }
        return pontuacao;
    }
}
