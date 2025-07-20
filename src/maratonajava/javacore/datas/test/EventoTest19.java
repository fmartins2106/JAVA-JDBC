package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos19;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento19;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora19;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest19 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos19 agendaEventos19 = new AgendaDeEventos19();
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
                    agendaEventos19.listarEventosCadastrados();
                    break;
                case 3:
                    agendaEventos19.excluirEventoAgenda();
                    break;
                case 4:
                    reagendarEvento();
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
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
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void cadastroEvento(){
        String nomeEvento = AgendaDeEventos19.validandoNome();
        String localEvento = AgendaDeEventos19.validandoLocal();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuito = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora19.validandoDataHora(ano,mes,dia,hora,minuito);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento19 evento19 = new Evento19(nomeEvento,localEvento,zonedDateTime);

            agendaEventos19.addEventoSistema(evento19);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    private static void reagendarEvento(){
        if (agendaEventos19.getEventoBase19s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaEventos19.listarEventosCadastrados();
        int indice = letInt("Digite o número do indice:")-1;
        if (indice < 0 || indice >= agendaEventos19.getEventoBase19s().size()){
            System.out.println("Indice inválido. Tente novamente.");
            return;
        }
        int dias = letInt("Quantidade de dias que deseja postergar o evento:");
        agendaEventos19.reagendarEvento(indice,dias);
    }

}
