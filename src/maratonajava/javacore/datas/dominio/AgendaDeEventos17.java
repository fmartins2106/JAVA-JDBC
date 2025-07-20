package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase17;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos17 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase17> eventoBase17s;

    public AgendaDeEventos17(){
        this.eventoBase17s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase17.validacaoNomeEvento(nomeEvento);
                return EventoBase17.formatoString(nomeEvento);
            }catch (NomeProdutoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase17.validacaoLocalEvento(localEvento);
                return EventoBase17.formatoString(localEvento);
            }catch (LocalEventoBase17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase17 eventoBase17){
        eventoBase17s.add(eventoBase17);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventoCadastrados(){
        if (eventoBase17s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase17s.size(); i++) {
            System.out.println("_________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase17s.get(i).exibirInfo();
            System.out.println("_________________________________________");
        }
    }

    public void retirarEventoSistema(){
        if (eventoBase17s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventoCadastrados();
        try {
            System.out.print("Digite o indice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase17s.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            eventoBase17s.remove(indice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase17 eventoBase17 = eventoBase17s.get(index);
        eventoBase17.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase17> getEventoBase17s() {
        return eventoBase17s;
    }
}
