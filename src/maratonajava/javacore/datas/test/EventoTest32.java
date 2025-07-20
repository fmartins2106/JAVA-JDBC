package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos32;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento32;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora32;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest32 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos32 agendaEventos32 = new AgendaDeEventos32();

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
                    agendaEventos32.listarEventosCadastrados();
                    break;
                case 3:
                    agendaEventos32.excluirEvento();
                    break;
                case 4:
                    reagendar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println();
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento sistema.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
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

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos32.validandoNome();
        String localEvento = AgendaDeEventos32.validandoLocalEvento();
        while (true){
            try {
                int ano = letInt("Ano (ex.:2025):");
                int mes = letInt("Mês (1-12):");
                int dia = letInt("Dia (1-31):");
                int hora = letInt("Hora (0-23):");
                int minuto = letInt("Minuto (0-59):");

                LocalDateTime dataHora = ValidadorDataHora32.validandoDataHora(ano,mes,dia,hora,minuto);
                if (dataHora != null){
                    if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                        ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
                        Evento32 evento32 = new Evento32(nomeEvento,localEvento,zonedDateTime);
                        agendaEventos32.addEventoSistema(evento32);
                        return;
                    }
                    System.out.println("Erro, data deve ser futura.");

                }
                System.out.println("\nErro. Data ou hora inválida.");
            }catch (DateTimeException e){
                System.out.println("\nErro. Data ou hora inválida.");
            }
        }
    }

    public static void reagendar(){
        if (agendaEventos32.getEventoBase32s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaEventos32.listarEventosCadastrados();
        int indice = letInt("Digite o índice do evento:")-1;
        if (indice < 0 || indice >= agendaEventos32.getEventoBase32s().size()){
            System.out.println("Erro. Índice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar o evento:");
        agendaEventos32.reagendar(indice,dias);
    }


}
