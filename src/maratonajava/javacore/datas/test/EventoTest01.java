package academy.devdojo.maratonajava.javacore.datas.test;


import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos01;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento01;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora01;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest01 {
    public static void main(String[] args) {
        AgendaDeEventos01 agendaDeEventos01 = new AgendaDeEventos01();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("MENU DE EVENTOS");
            System.out.println("[1] Criar evento.");
            System.out.println("[2] Exibir informações de evento.");
            System.out.println("[3] Reagendar evento.");
            System.out.println("[4] Excluir agenda.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEvento(scanner,agendaDeEventos01);
                        break;
                    case 2:
                        agendaDeEventos01.listarEventosCadastrados();
                        break;
                    case 3:
                        reagendarEvento(scanner,agendaDeEventos01);
                        break;
                    case 4:
                        agendaDeEventos01.excluirEvento(scanner);
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida");
                opcao = -1;
            }
        }while (opcao != 5);
    }

    public static void cadastroEvento(Scanner scanner,AgendaDeEventos01 agendaDeEventos01){
        String nomeEvento = AgendaDeEventos01.validandoNome(scanner);
        String localEvento = AgendaDeEventos01.validandoLocalEvento(scanner);
        int ano = letInt("Ano (ex: 2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dias = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);
        LocalDateTime dataHora = ValidadorDataHora01.validarDataHora(ano,mes,dias,hora,minuto);
        if (dataHora != null){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento01 evento01 = new Evento01(nomeEvento,localEvento,zonedDateTime);
            evento01 = new Evento01(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos01.adicionarEvento(evento01);
        }else {
            System.out.println("Tente novamente com uma data válida.");
        }
    }

    private static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos01 agendaDeEventos01){
        if (agendaDeEventos01.getEventoBase01s().isEmpty()){
            System.out.println("Nenhum evento para reagendar.");
            return;
        }
        agendaDeEventos01.listarEventosCadastrados();
        int index = letInt("Digite o número do evento que deseja alterar:",scanner)-1;
        int dias = letInt("Digite quantos dias deseja alterar:",scanner);

        agendaDeEventos01.reagendarEvento(index,dias);
    }

}
