package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos05 agendaDeEventos05 = new AgendaDeEventos05();
        int opcao = 0;
        do {
            System.out.println("Menu interativo");
            System.out.println("[1] Registrar compromisso.");
            System.out.println("[2] Remover compromisso.");
            System.out.println("[3] Listar compromisso.");
            System.out.println("[4] Reagendar comprimisso.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEventoAgenda(scanner,agendaDeEventos05);
                        break;
                    case 2:
                        agendaDeEventos05.excluirDadosEvento(scanner);
                        break;
                    case 3:
                        agendaDeEventos05.listarEventos();
                        break;
                    case 4:
                        reagendarEvento(scanner,agendaDeEventos05);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma número válida.");
            }
        }
    }

    public static void cadastroEventoAgenda(Scanner scanner, AgendaDeEventos05 agendaDeEventos05){
        String nome = AgendaDeEventos05.validandoNomeEvento(scanner);
        String local = AgendaDeEventos05.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (1-23):",scanner);
        int minutos = letInt("Minuto (1-59)",scanner);

        LocalDateTime dataHora = ValidadorDataHora05.validandoDataHora(ano,mes,dia,hora,minutos);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            EventoBase05 eventoBase05 = new Evento05(nome,local,zonedDateTime);
            agendaDeEventos05.addEventoSistema(eventoBase05);
            return;
        }
        System.out.println("Tente novamente, data Inválida.");
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos05 agendaDeEventos05){
        if (agendaDeEventos05.getEventoBase05s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos05.listarEventos();
        int index = letInt("Digite o número do indice do produto:",scanner)-1;
        int dias = letInt("Digite quantos dias deseja alterar:",scanner);
        agendaDeEventos05.reagendarEvento(index,dias);
    }
}
