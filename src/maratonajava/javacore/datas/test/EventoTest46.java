package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos46;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase46;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento46;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora46;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest46 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos46 agendaDeEventos46 = new AgendaDeEventos46();
    private static final RelatorioEvento46 relatorioEvento46 = new RelatorioEvento46();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            escolhaOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }


    private static void reagendar(){
        if (agendaDeEventos46.getEventoBase46s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos46.listarEventosSistema();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos46.getEventoBase46s().size()){
            System.out.println("Erro. Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaDeEventos46.reagendar(indice,dias);
    }

    private static void cadastrarEvento(){
        String nomeEvento = AgendaDeEventos46.validandoNomeEvento();
        String localEvento  = AgendaDeEventos46.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora46.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            if (optionalLocalDateTime.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = optionalLocalDateTime.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase46 eventoBase46 = new EventoBase46(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos46.addEventoSistema(eventoBase46);
                return;
            }
            System.out.println("Erro. Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data ou hora inválida. Verifique.");
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

    private static void escolhaOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastrarEvento();
                break;
            case 2:
                agendaDeEventos46.listarEventosSistema();
                break;
            case 3:
                reagendar();
                break;
            case 4:
                relatorioEvento46.gerarRelatorio(agendaDeEventos46.getEventoBase46s());
                break;
            case 5:
                agendaDeEventos46.excluirEvento();
                break;
            case 6:
                agendaDeEventos46.listarEventoPorData();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos.");
        System.out.println("[3] Reagendar evento.");
        System.out.println("[4] Exportar relatório.");
        System.out.println("[5] Excluir evento.");
        System.out.println("[6] Lista ordenada por nada.");
        System.out.println("[7] Sair.");
    }

}
