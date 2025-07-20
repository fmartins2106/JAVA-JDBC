package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos07 agendaDeEventos07 = new AgendaDeEventos07();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastrar evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Excluir evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair do sistema.");
            System.out.print("Digite uma da opções acima:");
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastroEvento(scanner,agendaDeEventos07);
                    break;
                case 2:
                    agendaDeEventos07.listarEventoSistema();
                    break;
                case 3:
                    agendaDeEventos07.excluirDadosAgenda(scanner);
                    break;
                case 4:
                    reagendar(scanner,agendaDeEventos07);
                    break;
            }
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos07 agendaDeEventos07){
        String nomeEvento = AgendaDeEventos07.validacaoNomeEvento(scanner);
        String localEvento = AgendaDeEventos06.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (1-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora07.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento07 evento07 = new Evento07(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos07.addEventoSistema(evento07);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendar(Scanner scanner, AgendaDeEventos07 agendaDeEventos07){
        if (agendaDeEventos07.getEventoBase07s().isEmpty()){
            System.out.println("Nenhuma agenda cadastrada.");
            return;
        }
        agendaDeEventos07.listarEventoSistema();
        int index = letInt("Digite o número do indice:",scanner)-1;
        int dias = letInt("Digite em quantos  dias quer postergar o evento:",scanner);
        agendaDeEventos07.reagendarEvento(index,dias);
    }

}
