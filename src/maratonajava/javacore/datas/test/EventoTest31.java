package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos31;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento31;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase31;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora31;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest31 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos31 agendaDeEventos31 = new AgendaDeEventos31();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma opção válida:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos31.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos31.excluirEventoSistema();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    public static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos31.validandoNomeEvento();
        String localEvento = AgendaDeEventos31.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora31.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            EventoBase31 eventoBase31 = new Evento31(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos31.addEventoSistema(eventoBase31);
            return;
        }
        System.out.println("Erro, data cadastrada inválida.");
    }


    public static void reagendarEvento(){
        if (agendaDeEventos31.getEventoBase31s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos31.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:")-1;
        if (index < 0 || index >= agendaDeEventos31.getEventoBase31s().size()){
            System.out.println("Erro. Indice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a ser adiado o evento:");
        agendaDeEventos31.reagendarEvento(index,dias);
    }
}
