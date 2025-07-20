package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos27;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento27;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase27;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora27;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest27 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos27 agendaDeEventos27 = new AgendaDeEventos27();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos27.listarEventosCadastrados();
                    break;
                case 3:
                    excluirEventoSistema();
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
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos27.validacaoNomeEvento();
        String localEvento = AgendaDeEventos27.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        LocalDateTime dataHora = ValidadorDataHora27.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento27 evento27 = new Evento27(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos27.addEventoSistema(evento27);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    private static void excluirEventoSistema(){
        if (agendaDeEventos27.getEventoBase27s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos27.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        agendaDeEventos27.excluirEvento(indice);
    }

    private static void reagendarEvento(){
        if (agendaDeEventos27.getEventoBase27s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos27.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos27.getEventoBase27s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaDeEventos27.reagendarEvento(indice,dias);
    }


}
