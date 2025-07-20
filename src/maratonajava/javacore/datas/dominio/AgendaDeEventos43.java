package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase43;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase43;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos43 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase43> eventoBase43s;

    public AgendaDeEventos43(){
        this.eventoBase43s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase43.validacaoNomeEvento(nomeEvento);
                return EventoBase43.formatoString(nomeEvento);
            }catch (NomeEventoBase43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase43.validacaoLocalEvento(localEvento);
                return EventoBase43.formatoString(localEvento);
            }catch (LocalEventoBase43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase43 eventoBase43){
        eventoBase43s.add(eventoBase43);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase43s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase43s.size(); i++) {
            System.out.println("_________________________________________________________________________________");
            System.out.println((1+i)+" -");
            eventoBase43s.get(i).exibirInfo();
            System.out.println("_________________________________________________________________________________");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase43 eventoBase43 = eventoBase43s.get(index);
        eventoBase43.reagendar(dias);
    }
    //sdsdsd
    public List<EventoBase43> getEventoBase43s() {
        return eventoBase43s;
    }
}
