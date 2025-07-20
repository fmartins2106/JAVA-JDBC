package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos08;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento08;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos08 agendaDeEventos08 = new AgendaDeEventos08();
        int opcao = 5;
        do {
            System.out.println("[1] Adicionar evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Excluir evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastrarEventoSistema(scanner,agendaDeEventos08);
                    break;
                case 2:
                    agendaDeEventos08.listarEventos();
                    break;
                case 3:
                    agendaDeEventos08.excluirDadosEvento(scanner);
                    break;
                case 4:
                    reagendarEvento(scanner,agendaDeEventos08);
                    break;
            }
        }while (opcao !=5);
            System.out.println(">>>Finalizando sistema.");
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static void cadastrarEventoSistema(Scanner scanner, AgendaDeEventos08 agendaDeEventos08){
        String nomeEvento = AgendaDeEventos08.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos08.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (1-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora08.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento08 evento08 = new Evento08(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos08.addEventoAgenda(evento08);
        }
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos08 agendaDeEventos08){
        if (agendaDeEventos08.getEventoBase08s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos08.listarEventos();
        int index = letInt("Digite o indice do produto:",scanner)-1;
        int dias = letInt("Digite a quantidade de dias a postergar o evento:",scanner);
        agendaDeEventos08.reagendarEvento(index,dias);
    }
}
