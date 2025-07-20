package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase21;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos21 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase21> eventoBase21s;

    public AgendaDeEventos21(){
        this.eventoBase21s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase21.validacaoNomeEvento(nomeEvento);
                return EventoBase21.formatoString(nomeEvento);
            }catch (NomeEventoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase21.validacaoLocalEvento(localEvento);
                return EventoBase21.formatoString(localEvento);
            }catch (LocalEventoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase21 eventoBase21){
        eventoBase21s.add(eventoBase21);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase21s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase21s.size(); i++) {
            System.out.println("______________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase21s.get(i).exibirInfo();
            System.out.println("______________________________________________________________________");
        }
    }

    public void excluirDadosEvento(){
        if (eventoBase21s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase21s.size()){
                EventoBase21 eventoRemover = eventoBase21s.get(indice);
                Iterator<EventoBase21> iterator = eventoBase21s.iterator();
                while (iterator.hasNext()){
                    EventoBase21 eventoBase21 = iterator.next();
                    if (eventoBase21.equals(eventoRemover)){
                        iterator.remove();
                        System.out.println("Dados removidos com sucesso.");
                        return;
                    }
                }
            }else {
                System.out.println("Indice não encontado.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase21 eventoBase21 = eventoBase21s.get(index);
        eventoBase21.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase21> getEventoBase21s() {
        return eventoBase21s;
    }
}
