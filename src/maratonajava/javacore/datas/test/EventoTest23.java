package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos23;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento23;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora23;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest23 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos23 agendaDeEventos23 = new AgendaDeEventos23();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao =  letInt("Digite uma das opções acima:");
            listaDeOpcoes(opcao);
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Remover evento cadastrado.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Tente novamente -> "+mensagem);
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento  = AgendaDeEventos23.validandoNomeEvento();
        String localEvento = AgendaDeEventos23.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        LocalDateTime dataHora = ValidadorDataHora23.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento23 evento23 = new Evento23(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos23.addEventoSistema(evento23);
            return;
        }
        System.out.println("Erro. Verifique data ou hora.");
    }

    private static void excluirDadosAgenda(){
        if (agendaDeEventos23.getEventoBase23s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos23.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento a ser excluido:")-1;
        agendaDeEventos23.excluirEvento(indice);
    }

    private static void reagendarEvento(){
        if (agendaDeEventos23.getEventoBase23s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos23.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento")-1;
        if (indice < 0 || indice >= agendaDeEventos23.getEventoBase23s().size()){
            System.out.println("Erro. Indice inválido.");
            return;
        }
        int dias = letInt("Digite quantos dias quer postergar o evento:");
        agendaDeEventos23.reagendarEvento(indice,dias);
    }

    private static void listaDeOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos23.listarEventosCadastrados();
                break;
            case 3:
                excluirDadosAgenda();
                break;
            case 4:
                reagendarEvento();
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
