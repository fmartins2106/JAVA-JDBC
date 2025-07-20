package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos25;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento25;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora25;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest25 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos25 agendaDeEventos25 = new AgendaDeEventos25();

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
                    agendaDeEventos25.listarEventosCadastrados();
                    break;
                case 3:
                    excluindoEvento();
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
                System.out.println("Erro. Digite uma opção/valor válida.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos25.validandoNomeEvento();
        String localEvento = AgendaDeEventos25.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora25.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento25 evento25 = new Evento25(nomeEvento,localEvento,zonedDateTime);

            agendaDeEventos25.addEventoSistema(evento25);
            return;
        }
        System.out.println("Erro. Verifique data ou hora informada.");
    }

    private static void excluindoEvento(){
        if (agendaDeEventos25.getEventoBase25s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos25.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento:")-1;
        agendaDeEventos25.excluirEvento(indice);
    }

    private static void reagendarEvento(){
        if (agendaDeEventos25.getEventoBase25s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos25.listarEventosCadastrados();
        int indiceEvento = letInt("Digite o indice do evento:")-1;
        if (indiceEvento < 0 || indiceEvento >= agendaDeEventos25.getEventoBase25s().size()){
            System.out.println("Indicve não encontrado.");
            return;
        }
        int dias = letInt("Gostaria de postergar em quantos dias ?:");
        agendaDeEventos25.reagendar(indiceEvento,dias);
    }




}
