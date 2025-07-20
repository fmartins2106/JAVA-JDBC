
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos42;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase42;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento42;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora42;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest42 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos42 agendaDeEventos42 = new AgendaDeEventos42();
    private static final RelatorioEvento42 relatorioEvento42 = new RelatorioEvento42();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos42.validandoNomeEvento();
        String localEvento = AgendaDeEventos42.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora42.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            if (optionalLocalDateTime.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = optionalLocalDateTime.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase42 eventoBase42 = new EventoBase42(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos42.addEventoSistema(eventoBase42);
                return;
            }
            System.out.println("Erro. Data ou hora inválida.");
            return;
        }
        System.out.println("Erro. Data ou hora não encontrada.");
    }

    private static void excluirCadastro(){
        if (agendaDeEventos42.getEventoBase42s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos42.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos42.getEventoBase42s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        agendaDeEventos42.getEventoBase42s().remove(indice);
        System.out.println("Dados removidos com sucesso.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos42.getEventoBase42s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos42.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos42.getEventoBase42s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        int dias = letInt("Digite quantos dias deseja postergar o evento:");
        agendaDeEventos42.reagendarEvento(indice,dias);
        System.out.println("Evento reagendado com sucesso.");
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

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Relatório evento.");
        System.out.println("[6] Sair.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos42.listarEventosCadastrados();
                break;
            case 3:
                excluirCadastro();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento42.gerarRelatorio(agendaDeEventos42.getEventoBase42s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Digite um evento válido.");
        }
    }
}
