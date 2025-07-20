package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos11;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento11;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos11 agendaDeEventos11 = new AgendaDeEventos11();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastrar evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Reagendar evento.");
            System.out.println("[4] Excluir evento.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastroEventoSistema(scanner,agendaDeEventos11);
                    break;
                case 2:
                    agendaDeEventos11.listarEventosCadastrados();
                    break;
                case 3:
                    reagendarEvento(scanner,agendaDeEventos11);
                    break;
                case 4:
                    agendaDeEventos11.excluirEventoSistema(scanner);
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

    public static void cadastroEventoSistema(Scanner scanner, AgendaDeEventos11 agendaDeEventos11){
        String nomeEvento = AgendaDeEventos11.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos11.validandoLocalEvento(scanner);
        int ano = letInt("Ano (ex,:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minutos = letInt("Minuto (0-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora11.validandoDataHora(ano,mes,dia,hora, minutos);
        if (dataHora !=null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento11 evento11 = new Evento11(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos11.addEventoSistema(evento11);
        }else {
            System.out.println("Data inválida.");
        }
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos11 agendaDeEventos11){
        if (agendaDeEventos11.getEventoBase11s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos11.listarEventosCadastrados();
        try {
            int index = letInt("Digite o indice do evento:",scanner)-1;
            if (index <  0 || index >= agendaDeEventos11.getEventoBase11s().size()){
                System.out.println("Indice não encontrado.");
                return;
            }
            int dias = letInt("Digite a quantidade de dias que gostaria de postergar:",scanner);
            agendaDeEventos11.reagendarEvento(index,dias);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

}
