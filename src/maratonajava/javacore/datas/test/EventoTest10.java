package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos10;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento10;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos10 agendaDeEventos10 = new AgendaDeEventos10();
        int opcao = 0;
        do {
            System.out.println("[1] Adicionar comprimisso.");
            System.out.println("[2] Listar agenda.");
            System.out.println("[3] Remover agenda.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    adicionarAgenda(scanner,agendaDeEventos10);
                    break;
                case 2:
                    agendaDeEventos10.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos10.excluirEvento(scanner);
                    break;
                case 4:
                    reagendarEvento(scanner,agendaDeEventos10);
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida. Tente novamente.");
            }
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Número inválido. Tente novamente.");
            }
        }
    }

    public static void adicionarAgenda(Scanner scanner, AgendaDeEventos10 agendaDeEventos10){
        String nomeEvento = AgendaDeEventos10.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos10.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora10.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento10 evento10 = new Evento10(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos10.addEventoSistema(evento10);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos10 agendaDeEventos10){
        if (agendaDeEventos10.getEventoBase10s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos10.listarEventosCadastrados();
        int index = letInt("Digite o indice da agenda:",scanner)-1;
        if (index < 0 || index >= agendaDeEventos10.getEventoBase10s().size()){
            System.out.println("Erro.Indice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidades de dias que gostaria de postergar o evento:",scanner);
        agendaDeEventos10.reagendarEvento(index,dias);
    }




}
