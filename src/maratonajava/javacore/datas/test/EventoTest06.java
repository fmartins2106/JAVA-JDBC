package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos06;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento06;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora06;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaDeEventos06 agendaDeEventos06 = new AgendaDeEventos06();
        int opcao = 0;
        do {
            System.out.println("[1] Cadastrar agenda.");
            System.out.println("[2] Excluir agenda.");
            System.out.println("[3] Alterar dia da agenda.");
            System.out.println("[4] Listar compromissos.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroEventoSistema(scanner,agendaDeEventos06);
                        break;
                    case 2:
                        agendaDeEventos06.excluirDados(scanner);
                        break;
                    case 3:
                        reagendarEvento(scanner,agendaDeEventos06);
                        break;
                    case 4:
                        agendaDeEventos06.listarEventosCadastrados();
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
    
    public static int letInt(String mensagem, Scanner scanner){
        while (true){
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    public static void cadastroEventoSistema(Scanner scanner, AgendaDeEventos06 agendaDeEventos06){
        String nomeEvento = AgendaDeEventos06.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos06.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-60):",scanner);

        LocalDateTime dataHora = ValidadorDataHora06.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento06 evento06 = new Evento06(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos06.addEventoSistema(evento06);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendarEvento(Scanner scanner, AgendaDeEventos06 agendaDeEventos06){
        agendaDeEventos06.listarEventosCadastrados();
        int index = letInt("Digite o número do indice do envento:",scanner)-1;
        int dias = letInt("Digite quanto dias gostaria de postergar o evento:",scanner);
        agendaDeEventos06.reagendarEvento(index,dias);
    }
    
}
