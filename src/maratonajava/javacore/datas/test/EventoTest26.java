package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos26;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento26;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora26;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest26 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos26 agendaDeEventos26 = new AgendaDeEventos26();

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
                    agendaDeEventos26.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos26.excluirEvento();
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
        System.out.println("[4] Reagendar.");
        System.out.println("[5] Sair.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor digitado inválido.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos26.validandoNomeEvento();
        String localEvento = AgendaDeEventos26.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora26.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento26 evento26 = new Evento26(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos26.addEventosSistema(evento26);
            return;
        }
        System.out.println("Data ou hora inválida..");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos26.getEventoBase26s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos26.listarEventosCadastrados();
        try {
            int indice = letInt("Digite o índice do produto:")-1;
            if (indice < 0 || indice >= agendaDeEventos26.getEventoBase26s().size()){
                System.out.println("Índice inválido.");
                return;
            }
            int dias = letInt("Digite a quantidade de dias a postergar o evento:");
            agendaDeEventos26.reagendarEvento(indice,dias);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

}
