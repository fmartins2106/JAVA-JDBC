package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase18;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos18 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase18> eventoBase18s;

    public AgendaDeEventos18(){
        this.eventoBase18s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase18.validacaoNomeEvento(nomeEvento);
                return EventoBase18.formatoString(nomeEvento);
            }catch (NomeEventoBase18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase18.validacaoLocalEvento(localEvento);
                return EventoBase18.formatoString(localEvento);
            }catch (LocalEventoBase18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase18 eventoBase18){
        eventoBase18s.add(eventoBase18);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase18s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase18s.size(); i++) {
            System.out.println("_____________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase18s.get(i).exibirInfo();
            System.out.println("_____________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase18s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventos();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim());
            if (indice < 0 || indice >= eventoBase18s.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            EventoBase18 eventoBase18 = eventoBase18s.get(indice);
            eventoBase18s.remove(eventoBase18);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida. Tente novamente.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase18 eventoBase18 = eventoBase18s.get(index);
        eventoBase18.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase18> getEventoBase18s() {
        return eventoBase18s;
    }
}
