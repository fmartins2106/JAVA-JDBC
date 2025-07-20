
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos39;
import academy.devdojo.maratonajava.javacore.datas.dominio.EventoBase39;
import academy.devdojo.maratonajava.javacore.datas.dominio.RelatorioEvento39;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora39;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest39 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos39 agendaDeEventos39 = new AgendaDeEventos39();
    private static final RelatorioEvento39 relatorioEvento39  = new RelatorioEvento39();
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
        String nomeEvento = AgendaDeEventos39.validandoNomeEvento();
        String localEvento = AgendaDeEventos39.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        Optional<LocalDateTime> dateTimeOptional = ValidadorDataHora39.validacaoDataHora(ano,mes,dia,hora,minuto);
        if (dateTimeOptional.isPresent()){
            if (dateTimeOptional.get().isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dateTimeOptional.get().atZone(ZoneId.of("America/Sao_Paulo"));
                EventoBase39 eventoBase39 = new EventoBase39(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos39.addEventoLista(eventoBase39);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Data ou hora não cadastrada.");
    }

    public static void reagendarEvento(){
        if (agendaDeEventos39.getEventoBase39s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos39.listarEventosCadastrados();
        int indice = letInt("Digit o índice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos39.getEventoBase39s().size()){
            System.out.println("Índice não encontrado.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a adiatar o evento:");
        agendaDeEventos39.reagendarEvento(indice,dias);
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

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroEvento();
                break;
            case 2:
                agendaDeEventos39.listarEventosCadastrados();
                break;
            case 3:
                agendaDeEventos39.excluirEventoSistema();
                break;
            case 4:
                reagendarEvento();
                break;
            case 5:
                relatorioEvento39.gerarRelatorio(agendaDeEventos39.getEventoBase39s());
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Alterar evento.");
        System.out.println("[5] Gerar relatório.");
        System.out.println("[6] Sair.");
    }

}
