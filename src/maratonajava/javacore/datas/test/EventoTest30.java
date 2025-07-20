package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos30;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento30;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora30;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest30 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos30 agendaEvento30 = new AgendaDeEventos30();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaEvento30.listarEventosCadastrados();
                    break;
                case 3:
                    agendaEvento30.excluirDadosEvento();
                    break;
                case 4:
                  reagendarEvento();
                  break;
                case 5:
                    return;
                default:
                    System.out.println("Erro. opção inválida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    public static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }
        }
    }

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos30.validandoNomeEvento();
        String localEvento = AgendaDeEventos30.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora30.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento30 evento30 = new Evento30(nomeEvento,localEvento,zonedDateTime);
            agendaEvento30.addEventoAgenda(evento30);
            return;
        }
        System.out.println("Erro. Data ou hora inválida.");
    }

    public static void reagendarEvento(){
        if (agendaEvento30.getEventoBase30s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaEvento30.listarEventosCadastrados();
        int index = letInt("Digite o número do índice:")-1;
        if (index < 0 || index >= agendaEvento30.getEventoBase30s().size()){
            System.out.println("Erro, índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaEvento30.reagendarEvento(index,dias);
    }



}
