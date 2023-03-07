package br.com.cruzvita.entities;

import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho(List<Carta> cartas) {
        this.cartas = cartas;
        
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros"};
        String[] nomes = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        
        for (String naipe : naipes) {
            for (String nome : nomes) {
                cartas.add(new Carta(nome, naipe));
            }
        }

        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta("Coringa", "Coringa"));
        }

        embaralharBaralho();
    }

    

    public void embaralharBaralho() {
        for (int i = 0; i < cartas.size(); i++) {
            int posicaoAleatoria1 = (int) (Math.random() * cartas.size());
            int posicaoAleatoria2 = (int) (Math.random() * cartas.size());
            Collections.swap(cartas, posicaoAleatoria1, posicaoAleatoria2);
        }
    }

    public String darCarta(Pessoa pessoa){
        if(cartas.size() > 0 || cartas != null){
            pessoa.getCartas().add(cartas.get(0));
            return "" + cartas.remove(0);
        }else{
            return "Sem cartas no baralho!";
        }
    }

    public Boolean temCarta(){
        return !cartas.isEmpty();
    }

    public void imprimeBaralho(){
        int i = 1;
        for (Carta carta : cartas) {
            System.out.println("Posição "+ i + "\n" + carta + "\n");
            i++;
        }
    }


    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
