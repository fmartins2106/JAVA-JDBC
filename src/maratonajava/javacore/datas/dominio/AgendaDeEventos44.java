package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase44;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase44;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos44 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase44> eventoBase44s;

    public AgendaDeEventos44(){
        this.eventoBase44s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase44.validacaoNomeEvento(nomeEvento);
                return EventoBase44.formatoString(nomeEvento);
            }catch (NomeEventoBase44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase44.validacaoLocalEvento(localEvento);
                return EventoBase44.formatoString(localEvento);
            }catch (LocalEventoBase44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase44 eventoBase44){
        eventoBase44s.add(eventoBase44);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEvento(){
        if (eventoBase44s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase44s.size(); i++) {
            System.out.print((1+i)+" - ");
            eventoBase44s.get(i).exibirInfo();
        }
    }

    public void reagendar(int index, int dias){
        EventoBase44 eventoBase44 = eventoBase44s.get(index);
        eventoBase44.reagendar(dias);
    }

    public List<EventoBase44> getEventoBase44s() {
        return eventoBase44s;
    }
}
