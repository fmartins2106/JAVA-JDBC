package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest04 {
    public static void main(String[] args) {
        AgendaDeEventos04 agendaDeEventos04 = new AgendaDeEventos04();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("[1] Criar eventos.");
            System.out.println("[2] Listar eventos.");
            System.out.println("[3] Aterar data.");
            System.out.println("[4] Excluir dados evento.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEvento(scanner,agendaDeEventos04);
                        break;
                    case 2:
                        agendaDeEventos04.listarDadosEvento();
                        break;
                    case 3:
                        reagendarEvento(scanner,agendaDeEventos04);
                        break;
                    case 4:
                        agendaDeEventos04.excluirDadosEvento(scanner);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando sistema.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
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

    public static void cadastroEvento(Scanner scanner, AgendaDeEventos04 agendaDeEventos04){
        String nome = AgendaDeEventos04.validandoNome(scanner);
        String local = AgendaDeEventos04.validandoLocal(scanner);
        int ano = letInt("Ano (ex.: 2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minutos = letInt("Minuto (0,59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora04.validandoDataHora(ano,mes,dia,hora,minutos);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            EventoBase04 eventoBase04 = new Evento04(nome,local,zonedDateTime);
            agendaDeEventos04.addEvento(eventoBase04);
        }else {
            System.out.println("Tente novamente, data inválida.");
        }
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos04 agendaDeEventos04){
        if (agendaDeEventos04.getEventoBase04s().isEmpty()){
            System.out.println("Nenhum evento foi agendado.");
            return;
        }
        agendaDeEventos04.listarDadosEvento();
        int index = letInt("Digite o número do evento que deseja alterar:",scanner)-1;
        int dias = letInt("Digite quantos dias deseja alterar:",scanner);
        agendaDeEventos04.reagendarEvento(index,dias);
    }

}
