package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase36;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos36 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase36> eventoBase36s;

    public AgendaDeEventos36(){
        this.eventoBase36s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase36.validacaoNomeEvento(nomeEvento);
                return EventoBase36.formatoString(nomeEvento);
            }catch (NomeEventoBase36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase36.validacaoLocalEvento(localEvento);
                return EventoBase36.formatoString(localEvento);
            }catch (LocalEventoBase36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase36 eventoBase36){
        eventoBase36s.add(eventoBase36);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase36s.isEmpty()){
            System.out.println("Erro. Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase36s.size(); i++) {
            System.out.println("_________________________________________________________________________________");
            System.out.println((1+i)+" - ");
            eventoBase36s.get(i).exibirInfo();
            System.out.println("_________________________________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase36s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o número do índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim());
            if (indice < 0 || indice >= eventoBase36s.size()){
                System.out.println("Índice inválido.");
                return;
            }
            eventoBase36s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase36 eventoBase36 = eventoBase36s.get(index);
        eventoBase36.reagendar(dias);
    }

    public List<EventoBase36> getEventoBase36s() {
        return eventoBase36s;
    }
}
