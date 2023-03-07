package br.com.cruzvita;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.io.Console;
import br.com.cruzvita.entities.Baralho;
import br.com.cruzvita.entities.Carta;
import br.com.cruzvita.entities.Pessoa;


public class Cruz21 {
    public static void main(String [] args) {

        Console console = System.console();
        Scanner sc = new Scanner(System.in); 

        System.out.println("BEM VINDO AO CRUZ-21");

        int n = 0;
        boolean tipoValido = false;
        while (!tipoValido) {
            try {
                System.out.print("DIGITE QUANTAS PESSOA IRÁ JOGAR: ");
                n = sc.nextInt();
                tipoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.nextLine();
            }
        }
        

        List<Pessoa> pessoas = new ArrayList<>();
        List<Pessoa> pessoasJogando = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome da pessoa " + (i+1) + ": ");
            String nome = sc.next();
            Pessoa novaPessoa = new Pessoa(nome);
            pessoas.add(novaPessoa);
            pessoasJogando.add(novaPessoa);
        }
        System.out.print("\033[H\033[2J");
                    System.out.flush();
        Baralho baralho = new Baralho(new ArrayList<Carta>());

        boolean continuar = true;
        for (int i = 0; i < 3 && continuar; i++) {
            for (Pessoa pessoa : new ArrayList<>(pessoasJogando)) {
                if (pessoa.getStatus().equals("parou")) {
                    pessoasJogando.remove(pessoa);
                    continue;
                }
                if (console != null && !console.equals(System.out)) {
                    // Limpe o console
                    console.flush();
                }
                System.out.println("Jogador: " + pessoa.getNome());
                System.out.println("Pontuação Total: " + pessoa.totalPontuacao());
                System.out.println("[1] Pegar mais uma carta");
                System.out.println("[2] Parar de pegar cartas");
                System.out.print("Digite a opção: ");
                int opcao = sc.nextInt();
        
                while (opcao != 1 && opcao != 2) {
                    System.out.println("Opção inválida, tente novamente!");
                    System.out.print("Digite a opção: ");
                    opcao = sc.nextInt();
                }
        
                if (opcao == 1) {
                    baralho.darCarta(pessoa);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(pessoa.getNome() + " ficou com: " + pessoa.totalPontuacao());
                    System.out.println();
                    if(pessoa.totalPontuacao() >= 21){
                        continuar = false;
                        break;
                    }
                } else {
                    pessoa.setStatus("parou");
                }
            }
        
            System.out.println("FIM DE RODADA");
            for (Pessoa pessoa : pessoas) {
                System.out.println("Jogador: " + pessoa.getNome());
                System.out.println("Pontuação Total: " + pessoa.totalPontuacao());
            }
            System.out.println("\n\n");
        }

        Pessoa vencedor = new Pessoa("Ninguém");
        for (Pessoa pessoa : pessoas) {
            if (pessoa.totalPontuacao() > vencedor.totalPontuacao() && pessoa.totalPontuacao() <= 21) {
                vencedor = pessoa;
            }
        }

        System.out.println("Vencedor: " + vencedor.getNome());
        System.out.println("Pontuação Total: " + vencedor.totalPontuacao());

        sc.close();
    }
}