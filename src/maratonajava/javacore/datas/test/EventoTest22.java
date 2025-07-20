package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos22;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento22;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora22;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest22 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos22 agendaDeEventos22 = new AgendaDeEventos22();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Excluir evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaDeEventos22.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos22.excluirEventoSistema();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 5);
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
        String nomeEvento = AgendaDeEventos22.validandoNomeEvento();
        String localEvento = AgendaDeEventos22.validandoLocalEvento();
        int ano = letInt("Ano (ex.: 2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora: (0-23):");
        int minuto = letInt("Minuto (1-59):");

        LocalDateTime dataHora = ValidadorDataHora22.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento22 evento22 = new Evento22(nomeEvento,localEvento,zonedDateTime);
            agendaDeEventos22.addEventoSistema(evento22);
            return;
        }
        System.out.println("Erro. Verifique data ou hora.");
    }

    private static void reagendarEvento(){
        if (agendaDeEventos22.getEventoBase22s().isEmpty()){
            System.out.println("Erro. Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos22.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:")-1;
        if (index < 0 || index >= agendaDeEventos22.getEventoBase22s().size()){
            System.out.println("Erro. indice inválido.");
            return;
        }
        int dias = letInt("Quantidade de dias a postergar o evento:");
        agendaDeEventos22.reagendarEvento(index,dias);
    }


}
