package Desafios;

import java.util.Scanner;

public class SequenciaFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\t\tMenu\t\t");
            System.out.println("1\t Calcular a Sequência de Fibonacci");
            System.out.println("2\t Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        calcularSequenciaFibonacci();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);
    }

    public static void calcularSequenciaFibonacci() {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Digite o valor de N: ");
        n = scanner.nextInt();

        if (n < 0) {
            throw new IllegalArgumentException("O valor de N deve ser não negativo.");
        } else {
            long resultado = calcularFibonacci(n);
            System.out.println("Fib = " + resultado);
        }
    }

    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursivo(n, 0, 1);
        }
    }

    private static long fibonacciRecursivo(int n, long a, long b) {
        if (n == 0) {
            return a;
        } else {
            return fibonacciRecursivo(n - 1, b, a + b);
        }
    }
}

