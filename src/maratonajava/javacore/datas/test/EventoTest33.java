package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos33;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento33;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora33;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Scanner;

public class EventoTest33 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos33 agendaDeEventos33 = new AgendaDeEventos33();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = letInt("Digite uma das opções acima:");
            switch (opcao){
                case 1:
                    cadastrarEventoSistema();
                    break;
                case 2:
                    agendaDeEventos33.listarEventosCadastrados();
                    break;
                case 3:
                    agendaDeEventos33.excluirEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Erro, digite uma opção válida.");
            }
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");

    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro evento.");
        System.out.println("[2] Lista de eventos cadastrados.");
        System.out.println("[3] Excluir evento.");
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


    private static void cadastrarEventoSistema(){
        String nomeEvento = AgendaDeEventos33.validandoNomeEvento();
        String localEvento = AgendaDeEventos33.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        Optional<LocalDateTime> optionalLocalDateTime = ValidadorDataHora33.validandoDataHora(ano,mes,dia,hora,minuto);
        if (optionalLocalDateTime.isPresent()){
            LocalDateTime dataHora = optionalLocalDateTime.get();
            if (dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
                ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
                Evento33 evento33 = new Evento33(nomeEvento,localEvento,zonedDateTime);
                agendaDeEventos33.addEventoSistema(evento33);
                return;
            }
            System.out.println("Data ou hora inválida.");
            return;
        }
        System.out.println("Data inválida.");
    }

    public static void reagendarEvento(){
        if (agendaDeEventos33.getEventoBase33s().isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        agendaDeEventos33.listarEventosCadastrados();
        int index = letInt("Digite o índice do evento:");
        if (index < 0 || index >= agendaDeEventos33.getEventoBase33s().size()){
            System.out.println("Erro. Digite um ano válido.");
            return;
        }
        int dias = letInt("Digite quantos dias gostaria de postergar o evento:");
        agendaDeEventos33.reagendarEvento(index,dias);
    }

}
