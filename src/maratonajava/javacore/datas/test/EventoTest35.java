package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos35;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento35;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora35;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest35 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos35 agendaDeEventos35 = new AgendaDeEventos35();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            codigoOpcoes(opcao);
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro de evento.");
        System.out.println("[2] Lista de eventos.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    private static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos35.listarEventosCadastrados();
                break;
            case 3:
                agendaDeEventos35.excluirEvento();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos35.validandoNomeEvento();
        String localEvento = AgendaDeEventos35.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora35.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            LocalDateTime dataHora = optionalLocalDateTime.get();
            if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
                Evento35 evento35 = new Evento35(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos35.addEventoSistema(evento35);
                return;
            }
            System.out.println("Erro. Data inválida.");
            return;
        }
        System.out.println("Erro. Data inválida.");
    }

    public static void reagendarEvento(){
        if (agendaDeEventos35.getEventoBase35s().isEmpty()){
            System.out.println("Erro. Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos35.listarEventosCadastrados();
        int index =  letInt("Digite o índice do evento:")-1;
        if (index < 0 || index >= agendaDeEventos35.getEventoBase35s().size()){
            System.out.println("Índice inválido, tente novamente.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que gostaria de adiar o evento:");
        agendaDeEventos35.reagendarEvento(index,dias);
    }

}
