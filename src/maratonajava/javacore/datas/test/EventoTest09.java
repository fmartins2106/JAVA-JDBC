package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos09;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento09;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos09 agendaDeEventos09 = new AgendaDeEventos09();

        int opcao = 0;
        do {
            System.out.println("[1] Cadastrado evento.");
            System.out.println("[2] Listar eventos.");
            System.out.println("[3] Reagendar evento.");
            System.out.println("[4] Excluir evento.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaDeEventos09);
                    break;
                case 2:
                    agendaDeEventos09.listarEventosCadastrados();
                    break;
                case 3:
                    reagendarEvento(scanner,agendaDeEventos09);
                    break;
                case 4:
                    agendaDeEventos09.excluirDadosEvento(scanner);
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    public static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos09 agendaDeEventos09){
        String nomeEvento = AgendaDeEventos09.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos09.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);

        LocalDateTime validadorDataHora09 = ValidadorDataHora09.validandoDataHora(ano,mes,dia,hora,minuto);
        if (validadorDataHora09 != null && validadorDataHora09.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = validadorDataHora09.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento09 evento09 = new Evento09(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos09.addEventoSistema(evento09);
            System.out.println("Evento criado com sucesso.");
        }
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos09 agendaDeEventos09){
        if (agendaDeEventos09.getEventoBase09s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos09.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento:",scanner)-1;
        if (indice < 0 || indice  >= agendaDeEventos09.getEventoBase09s().size()){
            System.out.println("Indice invalido.");
        }
        int dias = letInt("Digite em quantos dias quer postergar o evento:",scanner);
        agendaDeEventos09.reagendarEvento(indice,dias);
        System.out.println("Evento reagendado com sucesso.");

    }

}
