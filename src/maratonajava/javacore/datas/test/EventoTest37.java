package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest37 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos37 agendaEventos37 = new AgendaDeEventos37();
    private static RelatorioEvento37 relatorioEvento37 = new RelatorioEvento37();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaEventos37.listarEventosSistema();
                break;
            case 3:
                agendaEventos37.excluirDadosSistema();
            case 4:
                reagendar();
                break;
            case 5:
                relatorioEvento37.gerarRelatorio(agendaEventos37.getEventoBase37s());
                break;
            case 6:
                break;
            default:
                System.out.println("Nenhum evento cadastrado.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Retirar evento sistema.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Relatório eventos..");
        System.out.println("[6] Sair.");
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
        String nomeEvento = AgendaDeEventos37.validandoNomeEvento();
        String localEvento = AgendaDeEventos37.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-59):");
        int minuto = letInt("Minuto (0-59):");

        Optional<LocalDateTime> dataHora = ValidadorDataHora37.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora.isPresent()){
            if (dataHora.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dataHora.get().atZone(ZoneId.of("America/Sao_Paulo"));
                Evento37 evento37 = new Evento37(nomeEvento,localEvento,zonedDateTime);
                agendaEventos37.addProdutoSistema(evento37);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data não informada.");
    }

    public static void reagendar(){
        if (agendaEventos37.getEventoBase37s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        int indice = letInt("Digite o número do índice:")-1;
        if (indice < 0 || indice >= agendaEventos37.getEventoBase37s().size()){
            System.out.println("Erro. Número de índice inválida.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a ser adiado:");
        agendaEventos37.reagendarEvento(indice,dias);
    }


}
