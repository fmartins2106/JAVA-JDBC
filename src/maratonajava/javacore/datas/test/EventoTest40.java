
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos40;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase40;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento40;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora40;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest40 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos40 agendaDeEventos40 = new AgendaDeEventos40();
    private static final RelatorioEvento40 relatorioEvento40 = new RelatorioEvento40();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirInfo();
            opcao = letInt("Digite uma das opções acima:");
            metodoOpcoes(opcao);
        }while(opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos40.listarEventosCadastrados();
                break;
            case 3:
                reagendarEvento();
                break;
            case 4:
                agendaDeEventos40.excluirEventoSistema();
                break;
            case 5:
                relatorioEvento40.relatorioEvento(agendaDeEventos40.getEventoBase40s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void exibirInfo(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos.");
        System.out.println("[3] Reagendar evento.");
        System.out.println("[4] Excluir evento.");
        System.out.println("[5] Exportar relatório.");
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
        String nomeEvento = AgendaDeEventos40.validandoNomeEvento();
        String localEvento = AgendaDeEventos40.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> dateTimeOptional = ValidadorDataHora40.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dateTimeOptional.isPresent()){
            if (dateTimeOptional.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dateTimeOptional.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase40 eventoBase40 = new EventoBase40(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos40.addEventoSistema(eventoBase40);
                return;
            }
            System.out.println("Erro. Data ou hora inválida.");
        }
        System.out.println("Erro, data ou hora.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos40.getEventoBase40s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos40.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos40.getEventoBase40s().size()){
            System.out.println("Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar o evento:");
        agendaDeEventos40.reagendarEvento(indice,dias);
    }
}
