package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos44;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase44;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento44;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora44;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest44 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos44 agendaDeEventos44 = new AgendaDeEventos44();
    private static final RelatorioEvento44 relatorioEvento44 = new RelatorioEvento44();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos44.getEventoBase44s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos44.listarEvento();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos44.getEventoBase44s().size()){
            System.out.println("Índice inválido. Tente novamente.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaDeEventos44.reagendar(indice,dias);
    }

    private static void excluirEvento(){
        if (agendaDeEventos44.getEventoBase44s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos44.listarEvento();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos44.getEventoBase44s().size()){
            System.out.println("Índice não encontrado.");
            return;
        }
        agendaDeEventos44.getEventoBase44s().remove(indice);
        System.out.println("Evento removido com sucesso.");
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos44.validandoNomeEvento();
        String localEvento  = AgendaDeEventos44.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> localDateTimeOptional = ValidadorDataHora44.validandoDataHora(ano,mes,dia,hora,minuto);
        if (localDateTimeOptional.isPresent()){
            if (localDateTimeOptional.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = localDateTimeOptional.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase44 eventoBase44 = new EventoBase44(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos44.addEventoSistema(eventoBase44);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data ou hora não registrada.");
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

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos44.listarEvento();
                break;
            case 3:
                excluirEvento();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento44.gerarRelatorio(agendaDeEventos44.getEventoBase44s());
                break;
            case 6:
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Exportar relatório.");
        System.out.println("[6] Sair.");
    }


}

