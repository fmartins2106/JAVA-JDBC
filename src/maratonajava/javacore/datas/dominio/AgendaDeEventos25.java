package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase25;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos25 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase25> eventoBase25s;

    public AgendaDeEventos25(){
        this.eventoBase25s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase25.validacaoNomeEvento(nomeEvento);
                return EventoBase25.formatoString(nomeEvento);
            }catch (NomeEventoBase25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase25.validacaoLocalEvento(localEvento);
                return EventoBase25.formatoString(localEvento);
            }catch (LocalEventoBase25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase25 eventoBase25){
        eventoBase25s.add(eventoBase25);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase25s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase25s.size(); i++) {
            System.out.println("__________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase25s.get(i).exibirDetalhes();
            System.out.println("__________________________________________________________________________");
        }
    }

    public void excluirEvento(int index){
        if (index >= 0  && index < eventoBase25s.size()){
            eventoBase25s.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Nenhum evento foi encontrado.");
    }

    public void reagendar(int index, int dias){
        EventoBase25 eventoBase25 = eventoBase25s.get(index);
        eventoBase25.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase25> getEventoBase25s() {
        return eventoBase25s;
    }
}
