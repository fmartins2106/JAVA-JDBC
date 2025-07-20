package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.AgendaDeEventos18;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento17;
import academy.devdojo.maratonajava.javacore.datas.dominio.Evento18;
import academy.devdojo.maratonajava.javacore.datas.dominio.ValidadorDataHora18;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EventoTest18 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaDeEventos18 agenda = new AgendaDeEventos18();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("[1] Cadastro evento.");
            System.out.println("[2] Listar eventos cadastrados.");
            System.out.println("[3] Remover evento.");
            System.out.println("[4] Reagendar evento.");
            System.out.println("[5] Sair.");
            opcao = letInt("Digite uma das opções no menu acima:");
            switch (opcao){
                case 1:
                    cadastroEvento();
                    break;
                case 2:
                    agenda.listarEventos();
                    break;
                case 3:
                    agenda.excluirEvento();
                    break;
                case 4:
                    reagendarEvento();
                    break;
            }
        }while (opcao != 5);
        System.out.println(">>>Finalizando pedido.");
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
        String nomeEvento = AgendaDeEventos18.validandoNomeEvento();
        String localEvento = AgendaDeEventos18.validandoLocalEvento();
        int ano = letInt("Ano (Ex.:2025):");
        int mes = letInt("Mês (1-12):");
        int dia = letInt("Dia (1-31):");
        int hora = letInt("Hora (0-23):");
        int minuto = letInt("Minuto (0-59):");

        LocalDateTime dataHora = ValidadorDataHora18.validandoDataHora(ano,mes,dia,hora,minuto);
        if (dataHora != null && dataHora.isAfter(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            ZonedDateTime zonedDateTime = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
            Evento18 evento18 = new Evento18(nomeEvento,localEvento,zonedDateTime);
            agenda.addEventoSistema(evento18);
            return;
        }
        System.out.println("Data ou hora inválida.");
    }

    public static void reagendarEvento(){
        agenda.listarEventos();
        try {
            int indice = letInt("Digite o número do indice:")-1;
            if (indice < 0 || indice >= agenda.getEventoBase18s().size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            int dias = letInt("Digite quantos dias deseja postergar o evento:");
            agenda.reagendar(indice,dias);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido para o indice.");
        }
    }
}
