package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos15;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento15;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora15;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest15 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AgendaDeEventos15 agendaEventos = new AgendaDeEventos15();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Reagendar evento.");
            System.out.println("[4] Remover evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opçõe acima:",scanner);
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaEventos);
                    break;
                case 2:
                    agendaEventos.listarEventosCadastrados();
                    break;
                case 3:
                    reagendarEvento(scanner,agendaEventos);
                    break;
                case 4:
                    agendaEventos.excluirEventoSistema(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando pedido.");
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void cadastroEvento(Scanner scanner,AgendaDeEventos15 agendaDeEventos15){
        String nomeEvento = AgendaDeEventos15.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos15.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minutos = letInt("Minuto (0-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora15.validandoDataHora(ano,mes,dia,hora,minutos);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime =  dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento15 evento15 = new Evento15(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos15.addEventoSistema(evento15);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendarEvento(Scanner scanner,AgendaDeEventos15 agendaDeEventos15){
        if (agendaDeEventos15.getEventoBase15s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos15.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:",scanner)-1;
        if (index < 0 || index >= agendaDeEventos15.getEventoBase15s().size()){
            System.out.println("Indice inválido, tente novamente.");
            return;
        }
        int dias = letInt("Digite quantos dias quer postergar o evento:",scanner);
        agendaDeEventos15.reagendar(index,dias);
    }


}
