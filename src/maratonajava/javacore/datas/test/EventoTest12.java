package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos12;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento12;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest12 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AgendaDeEventos12 agendaDeEventos12 = new AgendaDeEventos12();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Reagendar evento.");
            System.out.println("[4] Excluir evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:",scanner);
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaDeEventos12);
                    break;
                case 2:
                    agendaDeEventos12.listarEventosCadastrados();
                    break;
                case 3:
                    reagendarEvento(agendaDeEventos12);
                    break;
                case 4:
                    agendaDeEventos12.excluirEvento(scanner);
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
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
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos12 agendaDeEventos12){
        String nomeEvento = AgendaDeEventos12.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos12.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto: (0-59):",scanner);

        LocalDateTime datahora = ValidadorDataHora12.validandoDataHora(ano,mes,dia,hora,minuto);
        if (datahora != null && datahora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = datahora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento12 evento12 = new Evento12(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos12.addEventoSistema(evento12);
            return;
        }
        System.out.println("Data inválida. Verifique.");
    }

    public static void reagendarEvento(AgendaDeEventos12 agendaDeEventos12){
        if (agendaDeEventos12.getEventoBase12s().isEmpty()){
            System.out.println("Nenhum compromisso foi cadastrado.");
            return;
        }
        agendaDeEventos12.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento a ser retirado:",scanner)-1;
        if (index < 0 || index >= agendaDeEventos12.getEventoBase12s().size()){
            System.out.println("Indice inválido. Tente novamente.");
            return;
        }
        int dias = letInt("Digite quantos dias gostaria de postergar o evento:",scanner);
        agendaDeEventos12.reagendar(index,dias);
    }

}
