
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase41;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos41 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase41> eventoBase41s;

    public AgendaDeEventos41(){
        this.eventoBase41s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase41.validacaoNomeEvento(nomeEvento);
                return EventoBase41.formatoString(nomeEvento);
            }catch (NomeEventoBase41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String local = scanner.nextLine().trim();
                EventoBase41.validacaoLocalEvento(local);
                return EventoBase41.formatoString(local);
            }catch (LocalEventoBase41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase41 eventoBase41){
        eventoBase41s.add(eventoBase41);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase41s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase41s.size(); i++) {
            System.out.println("________________________________________________________________________________");
            System.out.println((1+i)+" - ");
            eventoBase41s.get(i).exibirInfo();
            System.out.println("________________________________________________________________________________");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase41 eventoBase41 = eventoBase41s.get(index);
        eventoBase41.reagendar(dias);
    }

    public List<EventoBase41> getEventoBase41s() {
        return eventoBase41s;
    }
}
