package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos24;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento24;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora24;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest24 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos24 agendaDeEventos24 = new AgendaDeEventos24();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro de evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Excluir evento sistema.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos24.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos24.excluirEventoSistema();
                    break;
                case 4:
                    agendaDeEventos24.reagendarEvento();
                    break;
                case 5:
                    System.out.println(">>>Finalizando sistema.");
                    return;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos24.validandoNomeEvento();
        String localEvento = AgendaDeEventos24.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora24.validandoDataValidade(ano,mes,dia,hora,minuto);
        if (dataHora !=null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento24 evento24 = new Evento24(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos24.addEventoSistema(evento24);
            System.out.println("Evento criado com sucesso.");
            return;
        }
        System.out.println("Data informada fora do padrão, tente novamente.");
    }
}
