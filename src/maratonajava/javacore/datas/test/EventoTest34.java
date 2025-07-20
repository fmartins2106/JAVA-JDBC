package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos34;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento34;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora34;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest34 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos34 agendaDeEventos34 = new AgendaDeEventos34();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcoes){
        switch (opcoes){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos34.listarEventosCadastrados();
                break;
            case 3:
                agendaDeEventos34.excluirEventoSistema();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                break;
            default:
                System.out.println("Erro. Digite um valor válido.");
        }
    }
    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro, digite uma número válida.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos34.nomeEvento().trim();
        String localEvento = AgendaDeEventos34.localEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora34.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            LocalDateTime dataHora = optionalLocalDateTime.get();
            if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
                Evento34 evento34 = new Evento34(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos34.addEventoSistema(evento34);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendarEvento(){
        if (agendaDeEventos34.getEventoBase34s().isEmpty()){
            System.out.println("Nenhum evento foi agendado.");
            return;
        }
        agendaDeEventos34.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos34.getEventoBase34s().size()){
            System.out.println("Erro. Digite um número de índice válido.");
            return;
        }
        int dias = letInt("Digite quantidade de dias a ser adiado o evento:");
        agendaDeEventos34.reagendar(indice,dias);
    }

}
