package br.com.cruzvita;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.cruzvita.entities.Baralho;
import br.com.cruzvita.entities.Carta;
import br.com.cruzvita.entities.Pessoa;

public class TesteMetodos{
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int option = 99;
        Baralho baralho = new Baralho(new ArrayList<Carta>());
        Pessoa pessoa = new Pessoa("Nathan");

        while (option != 0) {
            System.out.println("BARALHO");
            System.out.println("[1] EMBARALHAR");
            System.out.println("[2] DAR CARTA");
            System.out.println("[3] TEM CARTA");
            System.out.println("[4] IMPRIMIR BARALHO");
            System.out.println("[0] SAIR");
            System.out.print("DIGITE A OPÇÃO DESEJADA: ");
            option = sc.nextInt();

            if(option != 1 && option != 2 && option != 3 && option != 4 && option != 0){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Opção invalida, digite uma opção valida!! \n");
            }

            switch (option) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    baralho.embaralharBaralho();
                    System.out.println("BARALHO EMBARALHADO! \n");
                    break;
            
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("CARTA DADA");
                    System.out.println(baralho.darCarta(pessoa) + "\n");
                    break;
                
                case 3:
                    if(baralho.temCarta()){
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("O baralho ainda tem cartas");
                        System.out.println("Quantidade de cartas: " + baralho.getCartas().size() + "\n");
                    }else{
                        System.out.println("Não há cartas!");
                    }
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    baralho.imprimeBaralho();
                    break;
            }
        }
        sc.close();
    }
}