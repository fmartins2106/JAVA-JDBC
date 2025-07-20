
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase42;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase42;
import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos42 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase42> eventoBase42s;

    public AgendaDeEventos42(){
        this.eventoBase42s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase42.validacaoNomeEvento(nomeEvento);
                return EventoBase42.formatoString(nomeEvento);
            }catch (NomeEventoBase42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase42.validacaoLocalEvento(localEvento);
                return EventoBase42.formatoString(localEvento);
            }catch (LocalEventoBase42 e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void addEventoSistema(EventoBase42 eventoBase42){
        eventoBase42s.add(eventoBase42);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase42s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase42s.size(); i++) {
            System.out.println("_______________________________________________________________________________");
            System.out.println((1+i)+" -");
            eventoBase42s.get(i).exibirInfo();
            System.out.println("_______________________________________________________________________________");
        }
    }

    public void reagendarEvento(int indice, int dias){
        EventoBase42 eventoBase42 = eventoBase42s.get(indice);
        eventoBase42.reagendar(dias);
    }

    public List<EventoBase42> getEventoBase42s() {
        return eventoBase42s;
    }
}
