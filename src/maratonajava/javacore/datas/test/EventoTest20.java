package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos20;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento20;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora20;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest20 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos20 agendaDeEventos20 = new AgendaDeEventos20();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Excluir evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opçõe acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos20.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos20.retirarEventoSistema();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao !=5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos20.validandoNomeEvento();
        String localEvento = AgendaDeEventos20.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora20.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento20 evento20 = new Evento20(nomeEvento,localEvento,zonedDateTime);

            agendaDeEventos20.addEventoSistema(evento20);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos20.getEventoBase20s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos20.listarEventosCadastrados();
        try {
            int indice = letInt("Digite o indice do evento:")-1;
            if (indice < 0 || indice >= agendaDeEventos20.getEventoBase20s().size()){
                System.out.println("Erro. indice inválido.");
                return;
            }
            int dias = letInt("Digite em quantos dias quer postergar o evento:");
            agendaDeEventos20.reagendar(indice,dias);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

}
