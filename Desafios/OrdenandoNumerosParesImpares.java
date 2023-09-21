package Desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenandoNumerosParesImpares {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcao;

            do {
                System.out.println("\t\tMenu\t\t");
                System.out.println("1\t Inserir números");
                System.out.println("2\t Ordenar e exibir números");
                System.out.println("3\t Sair");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(br.readLine());

                switch (opcao) {
                    case 1:
                        inserirNumeros(br);
                        break;
                    case 2:
                        ordenarEExibirNumeros();
                        break;
                    case 3:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 3);
        }

        private static List<Integer> listaNumeros = new ArrayList<>();

        private static void inserirNumeros(BufferedReader br) throws IOException {
            System.out.print("Quantos números deseja inserir? ");
            int quantidade = Integer.parseInt(br.readLine());

            for (int i = 0; i < quantidade; i++) {
                System.out.print("Digite um número não negativo: ");
                int numero = Integer.parseInt(br.readLine());
                if (numero >= 0) {
                    listaNumeros.add(numero);
                } else {
                    System.out.println("Número negativo não é válido. Tente novamente.");
                }
            }
        }

        private static void ordenarEExibirNumeros() {
            List<Integer> pares = listaNumeros.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toList());
            List<Integer> impares = listaNumeros.stream().filter(num -> num % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            List<Integer> total = new ArrayList<>();
            total.addAll(pares);
            total.addAll(impares);

            System.out.println("Números ordenados:");
            for (Integer numero : total) {
                System.out.println(numero);
            }
        }
    }
