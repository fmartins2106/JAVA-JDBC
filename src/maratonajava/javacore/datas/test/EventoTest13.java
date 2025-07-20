package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEvento13;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento13;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora13;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest13 {
    private static final Scanner  scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AgendaDeEvento13 agendaDeEvento13 = new AgendaDeEvento13();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro de evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Excluir evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:",scanner);
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaDeEvento13);
                    break;
                case 2:
                    agendaDeEvento13.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEvento13.excluirEvento(scanner);
                    break;
                case 4:
                    reagendarEvento(scanner,agendaDeEvento13);
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int letInt(String mensagem,Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEvento13 agendaDeEvento13){
        String nomeEvento = AgendaDeEvento13.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEvento13.validacaoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);
        LocalDateTime dataHora = ValidadorDataHora13.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento13 evento13 = new Evento13(nomeEvento,localEvento,zonedDateTime);
            agendaDeEvento13.addEventoSistema(evento13);
            return;
        }
        System.out.println("Nenhum evento foi cadastrado.");
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEvento13 agendaDeEvento13) {
        if (agendaDeEvento13.getEventoBase13s().isEmpty()) {
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEvento13.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:", scanner)-1;
        if (index < 0 || index >= agendaDeEvento13.getEventoBase13s().size()) {
            System.out.println("Indice não encontrado. Tente novamente.");
            return;
        }
        int dias = letInt("Digite em quantos dias gostaria de postergar o evento:", scanner);
        agendaDeEvento13.reagendar(index, dias);
    }
}
