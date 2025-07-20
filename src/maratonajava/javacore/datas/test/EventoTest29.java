package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos29;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento29;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora29;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest29 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos29 agendaDeEventos29 = new AgendaDeEventos29();

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
                    agendaDeEventos29.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos29.excluirEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nenhum evento foi cadastrado.");
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Listar eventos.");
        System.out.println("[3] Excluir evento.");
        System.out.println("[4] Reagendar evento.");
        System.out.println("[5] Sair.");
    }

    private static int letInt(String mensagens){
        while (true){
            try {
                System.out.print(mensagens);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos29.validandoNomeEvento();
        String localEvento = AgendaDeEventos29.validandoLocalEvento();
        int ano = letInt("Ano (ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora29.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento29 evento29 = new Evento29(nomeEvento,localEvento,zonedDateTime);

            agendaDeEventos29.addEventoSistema(evento29);
            return;
        }
        System.out.println("Data ou hora inválida. tente novamente.");
    }

    public static void reagendarEvento(){
        if (agendaDeEventos29.getEventoBase29s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaDeEventos29.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:")-1;
        if (index < 0 || index >= agendaDeEventos29.getEventoBase29s().size()){
            System.out.println("Indice inválido. Tente novamente.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a postergar o evento:");
        agendaDeEventos29.reagendarEvento(index,dias);
    }

}
