package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos28;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento28;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora28;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest28 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos28 agendaDeEventos28 = new AgendaDeEventos28();

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
                    agendaDeEventos28.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos28.excluirEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando o sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar.");
        System.out.println("[5] Sair.");
    }

    public static int letInt(String mensagem){
        while (true){
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos28.validandoNomeEvento();
        String localEvento = AgendaDeEventos28.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");
        LocalDateTime dataHora = ValidadorDataHora28.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento28 evento28 = new Evento28(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos28.addEventoSistema(evento28);
            return;
        }
        System.out.println("Data inválida. Evento não cadastrado.");
    }


    public static void reagendarEvento(){
        if (agendaDeEventos28.getEventoBase28s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos28.listarEventosCadastrados();
        int indice = letInt("Digite o indice do evento:")-1;
        if (indice < 0 || indice >= agendaDeEventos28.getEventoBase28s().size()){
            System.out.println("Indice inválido.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias que deseja postergar o evento:");
        agendaDeEventos28.reagendar(indice,dias);
    }

}
