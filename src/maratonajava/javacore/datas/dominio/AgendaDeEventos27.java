package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase27;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase27;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos27 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase27> eventoBase27s;

    public AgendaDeEventos27(){
        this.eventoBase27s = new ArrayList<>();
    }

    public static String validacaoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase27.validacaoNomeEvento(nomeEvento);
                return EventoBase27.formatoString(nomeEvento);
            }catch (NomeEventoBase27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase27.validacaoLocalEvento(localEvento);
                return EventoBase27.formatoString(localEvento);
            }catch (LocalEventoBase27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase27 eventoBase27){
        eventoBase27s.add(eventoBase27);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase27s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase27s.size(); i++) {
            System.out.println("___________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase27s.get(i).exibiInfo();
            System.out.println("___________________________________________________________________________");
        }
    }

    public void excluirEvento(int index){
        if (index >= 0 && index < eventoBase27s.size()){
            eventoBase27s.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Indice não encontrado.");
    }

    public void reagendarEvento(int index, int dias){
        EventoBase27 eventoBase27 = eventoBase27s.get(index);
        eventoBase27.reagendar(dias);
    }

    public List<EventoBase27> getEventoBase27s() {
        return eventoBase27s;
    }
}
