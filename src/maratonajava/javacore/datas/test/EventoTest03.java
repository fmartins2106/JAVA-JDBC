package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos03;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento03;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora02;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest03 {
    public static void main(String[] args) {
        AgendaDeEventos03 agendaDeEventos03 = new AgendaDeEventos03();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Menu de eventos");
            System.out.println("[1] Criar evento.");
            System.out.println("[2] Exbir informações do evento.");
            System.out.println("[3] Alterar dados evento.");
            System.out.println("[4] Excluir dados do evento.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opçõe acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEvento(scanner,agendaDeEventos03);
                        break;
                    case 2:
                        agendaDeEventos03.listarEventos();
                        break;
                    case 3:
                        reagendarEvento(scanner,agendaDeEventos03);
                        break;
                    case 4:
                        agendaDeEventos03.excluirDados(scanner);
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos03 agendaDeEventos03){
        String nomeEvento = AgendaDeEventos03.validandoNome(scanner);
        String localEvento = AgendaDeEventos03.validandoLocal(scanner);
        int ano = letInt("Ano (ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int horas = letInt("Horas (0-23):",scanner);
        int minutos = letInt("Minutos (0-59)",scanner);
        LocalDateTime dataHora = ValidadorDataHora02.validarHora(ano,mes,dia,horas,minutos);
        if (dataHora != null){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento03 evento03 = new Evento03(nomeEvento,localEvento,zonedDateTime);
//            evento03 = new Evento03(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos03.addEventoSistema(evento03);
        }else {
            System.out.println("Tente novamente, data inválida.");
        }
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static void reagendarEvento(Scanner scanner, AgendaDeEventos03 agendaDeEventos03){
        if (agendaDeEventos03.getEventoBase03s().isEmpty()){
            System.out.println("Nenhum evento está agendado.");
            return;
        }
        agendaDeEventos03.listarEventos();
        int index = letInt("Digite o número do evento que deseja alterar:",scanner)-1;
        int dias = letInt("Digite quantos dias deseja alterar:",scanner);
        agendaDeEventos03.reagendarEvento(index,dias);
    }
}
