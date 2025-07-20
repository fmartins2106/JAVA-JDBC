package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos14;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento14;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora14;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest14 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AgendaDeEventos14 agendaDeEventos14 = new AgendaDeEventos14();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Excluir eventos.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:",scanner);
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaDeEventos14);
                    break;
                case 2:
                    agendaDeEventos14.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos14.excluirEvento(scanner);
                    break;
                case 4:
                  reagendar(scanner,agendaDeEventos14);
                  break;
            }
        }while (opcao != 5);
        System.out.println(">>>>Finalizado sistema.");
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos14 agendaDeEventos14){
        String nomeEvento = AgendaDeEventos14.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos14.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora14.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento14 evento14 = new Evento14(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos14.addEvento(evento14);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendar(Scanner scanner, AgendaDeEventos14 agendaDeEventos14){
        if (agendaDeEventos14.getEventoBase14s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos14.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:",scanner)-1;
        if (index < 0 || index >= agendaDeEventos14.getEventoBase14s().size()){
            System.out.println("Indice inválido.");
            return;
        }
        int dias = letInt("Quantos dias gostaria de postergar o  evento?:",scanner);
        agendaDeEventos14.reagendarEvento(index,dias);
    }

}
