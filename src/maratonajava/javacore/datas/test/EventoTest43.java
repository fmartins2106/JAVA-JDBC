package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest43 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos43 agendaDeEventos43 = new AgendaDeEventos43();
    private static final RelatorioEvento43 relatorioEvento43  = new RelatorioEvento43();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
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

    private static void excluirEvento(){
        if (agendaDeEventos43.getEventoBase43s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos43.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos43.getEventoBase43s().size()){
            System.out.println("Nenhum evento foi cadastrado com este índice.");
            return;
        }
        agendaDeEventos43.getEventoBase43s().remove(indice);
        System.out.println("Evento excluido com sucesso.");
    }
    //sdsdsd
    private static void reagendarEvento(){
        if (agendaDeEventos43.getEventoBase43s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos43.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos43.getEventoBase43s().size()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar o evento:");
        agendaDeEventos43.reagendarEvento(indice,dias);
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos43.validandoNomeEvento();
        String localEvento = AgendaDeEventos43.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora43.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            if (optionalLocalDateTime.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = optionalLocalDateTime.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase43 eventoBase43 = new EventoBase43(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos43.addEventoSistema(eventoBase43);
                return;
            }
            System.out.println("Erro. data ou hora inválida.");
            return;
        }
        System.out.println("Data ou hora não cadastrada corretamente.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro de evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Exportar relatório.");
        System.out.println("[6] Sair.");
    }
    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos43.listarEventosCadastrados();
                break;
            case 3:
                excluirEvento();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento43.gerarRelatorio(agendaDeEventos43.getEventoBase43s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
