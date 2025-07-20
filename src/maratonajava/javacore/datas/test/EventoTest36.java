package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos36;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento36;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora36;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest36 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos36 agendaDeEventos36 = new AgendaDeEventos36();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            codigoOpcoesMenu(opcao);
        }while (opcao != 5);
        System.out.println(">>>Finalizando Sistema.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válida.");
            }
        }
    }
    private static void codigoOpcoesMenu(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos36.listarEventosCadastrados();
                break;
            case 3:
                agendaDeEventos36.excluirEventoSistema();
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
    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Remover evento sistema.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos36.validandoNomeEvento();
        String localEvento = AgendaDeEventos36.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora36.validandoDataEvento(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            LocalDateTime dateTime = optionalLocalDateTime.get();
            if (dateTime.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("America/Sao_Paulo"));
                Evento36 evento36 = new Evento36(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos36.addEventoSistema(evento36);
            }else {
                System.out.println("Data ou hora deve estár no futuro..");
                optionalLocalDateTime = Optional.empty();
            }
        }else {
            System.out.println("Data ou hora inválida.");
        }

    }

    private static void reagendarEvento(){
        if (agendaDeEventos36.getEventoBase36s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos36.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos36.getEventoBase36s().size()){
            System.out.println("Indice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar o evento:");
        agendaDeEventos36.reagendarEvento(indice,dias);
    }


}


