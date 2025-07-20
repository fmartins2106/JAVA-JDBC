package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase23;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos23 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase23> eventoBase23s;

    public AgendaDeEventos23(){
        this.eventoBase23s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase23.validacaoNomeEvento(nomeEvento);
                return EventoBase23.formatoString(nomeEvento);
            }catch (NomeEventoBase23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase23.validacaoLocalEvento(localEvento);
                return EventoBase23.formatoString(localEvento);
            }catch (LocalEventoBase23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase23 eventoBase23){
        eventoBase23s.add(eventoBase23);
        System.out.println("Evento registrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase23s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase23s.size(); i++) {
            System.out.print((1+i)+" - ");
            eventoBase23s.get(i).exibirInfo();
        }
    }

    public void excluirEvento(int index){
        if (index >= 0 && index < eventoBase23s.size()){
            eventoBase23s.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Indice inválido. Tente novamente.");
    }

    public void reagendarEvento(int index, int dias){
        EventoBase23 eventoBase23 = eventoBase23s.get(index);
        eventoBase23.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase23> getEventoBase23s() {
        return eventoBase23s;
    }
}
