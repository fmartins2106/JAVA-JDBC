package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase20;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos20 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase20> eventoBase20s;

    public AgendaDeEventos20(){
        this.eventoBase20s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase20.validacaoNomeEvento(nomeEvento);
                return EventoBase20.formatoString(nomeEvento);
            }catch (NomeEventoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase20.validacaoLocalEvento(localEvento);
                return EventoBase20.formatoString(localEvento);
            }catch (LocalEventoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase20 eventoBase20){
        eventoBase20s.add(eventoBase20);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase20s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase20s.size(); i++) {
            System.out.println("__________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase20s.get(i).exibirInfo();
            System.out.println("__________________________________________________");
        }
    }

    public void retirarEventoSistema(){
        if (eventoBase20s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase20s.size()){
                eventoBase20s.remove(indice);
                return;
            }
            System.out.println("Erro. Indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Indice inválido. Tente novamente.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase20 eventoBase20 = eventoBase20s.get(index);
        eventoBase20.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase20> getEventoBase20s() {
        return eventoBase20s;
    }
}
