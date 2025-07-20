package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase16;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos16 {
    private List<EventoBase16> eventoBase16s;

    public AgendaDeEventos16(){
        this.eventoBase16s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase16.validacaoNomeEvento(nomeEvento);
                return EventoBase16.formatoString(nomeEvento);
            }catch (NomeEventoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase16.validacaoLocalEvento(localEvento);
                return EventoBase16.formatoString(localEvento);
            }catch (LocalEventoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase16 eventoBase16){
        eventoBase16s.add(eventoBase16);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase16s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase16s.size(); i++) {
            System.out.println("___________________________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase16s.get(i).exibirInfo();
            System.out.println("___________________________________________________________");
        }
    }

    public void removerEvento(int index){
        if (eventoBase16s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        if (index < 0 || index >= eventoBase16s.size()){
            System.out.println("Indice inválido.");
        }
        EventoBase16 eventoBase16 = eventoBase16s.get(index);
        eventoBase16s.remove(eventoBase16);
        System.out.println("Dados removidos com sucesso.");
    }

    public void reagendarEvento(int index, int dias){
        EventoBase16 eventoBase16 = eventoBase16s.get(index);
        eventoBase16.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase16> getEventoBase16s() {
        return eventoBase16s;
    }
}

