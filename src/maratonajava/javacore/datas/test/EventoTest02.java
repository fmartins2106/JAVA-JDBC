package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos02;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento02;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora02;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest02 {
    public static void main(String[] args) {
        AgendaDeEventos02 agendaDeEventos02 = new AgendaDeEventos02();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Menu de eventos.");
            System.out.println("[1] Criar um evento.");
            System.out.println("[2] Exibir informações do evento.");
            System.out.println("[3] Alterar data do evento.");
            System.out.println("[4] Excluir dados do evento.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEvento(scanner,agendaDeEventos02);
                        break;
                    case 2:
                        agendaDeEventos02.listarEventos();
                        break;
                    case 3:
                        reagendarEvento2(scanner,agendaDeEventos02);
                        break;
                    case 4:
                        agendaDeEventos02.excluirAgenda(scanner);
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos02 agendaDeEventos02){
        String nome = AgendaDeEventos02.validandoNome(scanner);
        String local = AgendaDeEventos02.validandoLocal(scanner);
        int ano = letInt("Ano (ex:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia:(1-31):",scanner);
        int horas = letInt("Horas (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);
        LocalDateTime dataHora = ValidadorDataHora02.validarHora(ano,mes,dia,horas,minuto);
        if (dataHora != null){
            ZonedDateTime zonedDateTime  = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento02 eventos02 = new Evento02(nome,local,zonedDateTime);
            eventos02 = new Evento02(nome,local,zonedDateTime);
            agendaDeEventos02.addEvento(eventos02);
        }else {
            System.out.println("Tente novamente com a data válida.");
        }
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void reagendarEvento2(Scanner scanner, AgendaDeEventos02 agendaDeEventos02){
        if (agendaDeEventos02.getEventosBase02s().isEmpty()){
            System.out.println("Nenhum evento está agendado.");
            return;
        }
        agendaDeEventos02.listarEventos();
        int index = letInt("Digite o número de eventos que deseja alterar:",scanner)-1;
        int dias = letInt("Digite quantos dais deseja alterar:",scanner);
        agendaDeEventos02.reagendarEvento(index,dias);
    }

}
