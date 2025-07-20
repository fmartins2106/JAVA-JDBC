package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos16;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento16;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora16;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest16 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos16 agendaEventos16 = new AgendaDeEventos16();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Lista de eventos cadastrados.");
            System.out.println("[3] Remover evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções acima:",scanner);
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agendaEventos16.listarEventosCadastrados();
                    break;
                case 3:
                    removerEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int letInt(String mensagem,Scanner scanner){
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
        String nomeEvento = AgendaDeEventos16.validandoNomeEvento(scanner);
        String localEvento = AgendaDeEventos16.validandoLocalEvento(scanner);
        int ano = letInt("Ano (Ex.:2025):",scanner);
        int mes = letInt("Mês (1-12):",scanner);
        int dia = letInt("Dia (1-31):",scanner);
        int hora = letInt("Hora (0-23):",scanner);
        int minuto = letInt("Minuto (0-59):",scanner);

        LocalDateTime dataHora = ValidadorDataHora16.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento16 evento16 = new Evento16(nomeEvento,localEvento,zonedDateTime);
            agendaEventos16.addEventoSistema(evento16);
            return;
        }
        System.out.println("Data ou hora inválido. Verifique.");
    }

    private static void reagendarEvento(){
        if (agendaEventos16.getEventoBase16s().isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        agendaEventos16.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:",scanner)-1;
        if (index < 0 || index >= agendaEventos16.getEventoBase16s().size()){
            System.out.println("Indice inválido. Tente novamente.");
            return;
        }
        int dias = letInt("Digite a quantidade de dias a portergar o evento:",scanner);
        agendaEventos16.reagendarEvento(index,dias);
    }

    public static void removerEvento(){
        agendaEventos16.listarEventosCadastrados();
        int index = letInt("Digite o indice do evento:",scanner)-1;
        agendaEventos16.removerEvento(index);
    }




}
