package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos17;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento17;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora17;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest17 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos17 AGENDA_DE_EVENTOS_17 = new AgendaDeEventos17();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Remover evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    AGENDA_DE_EVENTOS_17.listarEventoCadastrados();
                    break;
                case 3:
                    AGENDA_DE_EVENTOS_17.retirarEventoSistema();
                    break;
                case 4:
                    reagendarEvento();
                    break;
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
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos17.validandoNomeEvento();
        String localEvento = AgendaDeEventos17.validandoLocalEvento();
        int ano = letInt("Ano (Ex,:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora17.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento17 evento17 = new Evento17(nomeEvento,localEvento,zonedDateTime);
            AGENDA_DE_EVENTOS_17.addEventoSistema(evento17);
            return;
        }
        System.out.println("Data inválida. Tente novamente.");
    }

    public static void reagendarEvento(){
        AGENDA_DE_EVENTOS_17.listarEventoCadastrados();
        int index = letInt("Digite o indice do evento:")-1;
        if (index < 0 || index >= AGENDA_DE_EVENTOS_17.getEventoBase17s().size()){
            System.out.println("Indice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        AGENDA_DE_EVENTOS_17.reagendarEvento(index,dias);
    }
}
