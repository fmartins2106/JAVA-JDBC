package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos21;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento21;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora21;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest21 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos21 agendaDeEventos21 = new AgendaDeEventos21();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Remover evento cadastrado.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos21.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos21.excluirDadosEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos21.validandoNomeEvento();
        String localEvento = AgendaDeEventos21.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-59):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora21.validandoDataHora(ano,mes,dia,hora,minuto);

        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento21 evento21 = new Evento21(nomeEvento,localEvento,zonedDateTime);

            agendaDeEventos21.addEventoSistema(evento21);
        }else {
            System.out.println("Data ou hora inválida.");
        }
    }

    public static void reagendarEvento(){
        if (agendaDeEventos21.getEventoBase21s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos21.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos21.getEventoBase21s().size()){
            System.out.println("Erro. Indice inválido.");
            return;
        }
        int dias = letInt("Digite quantos dias gostaria de postergar o evento:");
        agendaDeEventos21.reagendar(indice,dias);
    }


}
