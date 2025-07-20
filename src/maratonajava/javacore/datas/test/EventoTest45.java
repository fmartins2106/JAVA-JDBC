package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos45;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase45;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento45;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora45;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest45 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos45 agendaDeEventos45 = new AgendaDeEventos45();
    private static final RelatorioEvento45 relatorioEvento45 = new RelatorioEvento45();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void excluirEvento(){
        if (agendaDeEventos45.getEventoBase45s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos45.listarEventos();
        int index = letInt("Digite o índice do evento:")-1;
        if (index < 0 || index >= agendaDeEventos45.getEventoBase45s().size()){
            System.out.println("Erro. índice inválido.");
            return;
        }
        agendaDeEventos45.getEventoBase45s().remove(index);
        System.out.println("Dados removidos com sucesso.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos45.getEventoBase45s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos45.listarEventos();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos45.getEventoBase45s().size()){
            System.out.println("Índice inválido. tente novamente.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaDeEventos45.reagendar(indice,dias);
    }


    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos45.validandoNomeEvento();
        String localEvento = AgendaDeEventos45.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora45.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            if (optionalLocalDateTime.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = optionalLocalDateTime.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase45 eventoBase45 = new EventoBase45(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos45.addEventoSistema(eventoBase45);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data ou hora incorreta.");
    }

    private static int letInt(String mensagem){
        while (true){
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Listar eventos cadastrados.");
        System.out.println("[3] Reagendar evento.");
        System.out.println("[4] Excluir evento.");
        System.out.println("[5] Exportar relatório.");
        System.out.println("[6] Sair.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos45.listarEventos();
                break;
            case 3:
                reagendarEvento();
                break;
            case 4:
                excluirEvento();
                break;
            case 5:
                relatorioEvento45.gerarEvento(agendaDeEventos45.getEventoBase45s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro, digite uma opção válida.");
        }
    }



}
