package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase45;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase45;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos45 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase45> eventoBase45s;

    public AgendaDeEventos45(){
        this.eventoBase45s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase45.validacaoNomeEvento(nomeEvento);
                return EventoBase45.formatoString(nomeEvento);
            }catch (NomeEventoBase45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.println("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase45.validacaoLocalEvento(localEvento);
                return EventoBase45.formatoString(localEvento);
            }catch (LocalEventoBase45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase45 eventoBase45){
        eventoBase45s.add(eventoBase45);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase45s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase45s.size(); i++) {
            System.out.println("____________________________________________________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase45s.get(i).exibirInfo();
            System.out.println("____________________________________________________________________________________");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase45 eventoBase45 = eventoBase45s.get(index);
        eventoBase45.reagendar(dias);
    }

    public List<EventoBase45> getEventoBase45s() {
        return eventoBase45s;
    }
}
