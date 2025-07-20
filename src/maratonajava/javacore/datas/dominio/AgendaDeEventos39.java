
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase39;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase39;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos39 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase39> eventoBase39s;

    public AgendaDeEventos39(){
        this.eventoBase39s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase39.validacaoNomeEvento(nomeEvento);
                return EventoBase39.formatoString(nomeEvento);
            }catch (NomeEventoBase39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase39.validacaoLocalEvento(localEvento);
                return EventoBase39.formatoString(localEvento);
            }catch (LocalEventoBase39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoLista(EventoBase39 eventoBase39){
        eventoBase39s.add(eventoBase39);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase39s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado até o momento.");
            return;
        }
        for (int i = 0; i < eventoBase39s.size(); i++) {
            System.out.println("__________________________________________________________________________________");
            System.out.print((1+i)+" -");
            eventoBase39s.get(i).exibirInfo();
            System.out.println("__________________________________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase39s.isEmpty()){
            System.out.println("Nenhum evento cadastrado no sistema.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase39s.size()){
                System.out.println("Índice inválido.");
                return;
            }
            eventoBase39s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um índice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase39 eventoBase39 = eventoBase39s.get(index);
        eventoBase39.reagendar(dias);
    }

    public List<EventoBase39> getEventoBase39s() {
        return eventoBase39s;
    }
}
