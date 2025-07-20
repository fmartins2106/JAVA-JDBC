package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest38 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos38 agendaDeEventos38 = new AgendaDeEventos38();
    private static final RelatorioEvento38 relatorioEvento38 = new RelatorioEvento38();

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

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos38.validandoNomeEvento();
        String localEvento = AgendaDeEventos38.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> eventoBase37Optional = ValidadorDataHora38.validandoDataHora(ano,mes,dia,hora,minuto);
        if (eventoBase37Optional.isPresent()){
            if (eventoBase37Optional.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = eventoBase37Optional.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase38 eventoBase38 = new EventoBase38(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos38.addProdutoSistema(eventoBase38);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data ou hora não encontrada.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos38.getEventoBase38s().isEmpty()){
            System.out.println("Erro. Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos38.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos38.getEventoBase38s().size()){
            System.out.println("Erro. Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a ser postergado:");
        agendaDeEventos38.reagendarEvento(indice,dias);
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Exportar relatório");
        System.out.println("[6] Sair.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos38.listarEventosCadastrados();
                break;
            case 3:
                agendaDeEventos38.excluirEventoSistema();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento38.gerarRelorios(agendaDeEventos38.getEventoBase38s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Opção inválida.");
        }
    }



}
