
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos41;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase41;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento41;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora41;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest41 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos41 agendaDeEventos41 = new AgendaDeEventos41();
    private static final RelatorioEvento41 relatorioEvento41 = new RelatorioEvento41();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos41.listarEventosCadastrados();
                break;
            case 3:
                excluirEvento();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento41.gerarRelatorio(agendaDeEventos41.getEventoBase41s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro, digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Exportar relatório.");
        System.out.println("[6] Sair.");
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos41.validandoNomeEvento();
        String localEvento = AgendaDeEventos41.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> dateTimeOptional = ValidadorDataHora41.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dateTimeOptional.isPresent()){
            if (dateTimeOptional.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dateTimeOptional.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase41 eventoBase41 = new EventoBase41(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos41.addEventoSistema(eventoBase41);
                return;
            }
            System.out.println("Erro. Data ou hora inválida.");
        }
        System.out.println("Erro. Data ou hora não foi cadastrada corretamente.");
    }

    private static void excluirEvento(){
        if (agendaDeEventos41.getEventoBase41s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos41.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos41.getEventoBase41s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        agendaDeEventos41.getEventoBase41s().remove(indice);
        System.out.println("Dados removidfos com sucesso.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos41.getEventoBase41s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos41.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos41.getEventoBase41s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar:");
        agendaDeEventos41.reagendar(indice,dias);
    }

}
