package Desafios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class ConversaoDeTempo {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\t\tMenu\t\t");
                System.out.println("1\t Converter segundos para data");
                System.out.println("2\t Obter data e hora atual deste ano");
                System.out.println("3\t Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        converterSegundosParaData();
                        break;
                    case 2:
                        obterDataHoraAtual();
                        break;
                    case 3:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 3);
        }

        public static void converterSegundosParaData() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a quantidade de segundos: ");
            long segundos = scanner.nextLong();

            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

            long millis = segundos * 1000;

            Date date = new Date(millis);

            SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            String dataFormatada = df.format(date);

            dataFormatada = dataFormatada.replaceFirst("yyyy", String.valueOf(anoAtual));

            System.out.println("Data e hora convertidas: " + dataFormatada);
        }

        public static void obterDataHoraAtual() {
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

            SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            String dataFormatada = df.format(new Date());

            dataFormatada = dataFormatada.replaceFirst("yyyy", String.valueOf(anoAtual));

            System.out.println("Data e hora atual deste ano: " + dataFormatada);
        }
    }
