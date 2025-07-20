
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase40;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos40 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase40> eventoBase40s;

    public AgendaDeEventos40(){
        this.eventoBase40s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase40.validacaoNomeEvento(nomeEvento);
                return EventoBase40.formatoString(nomeEvento);
            }catch (NomeEventoBase40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase40.validacaoLocalEvento(localEvento);
                return EventoBase40.formatoString(localEvento);
            }catch (LocalEventoBase40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase40 eventoBase40){
        eventoBase40s.add(eventoBase40);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase40s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase40s.size(); i++) {
            System.out.println("________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase40s.get(i).exibirInfo();
            System.out.println("________________________________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase40s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase40s.size()){
                System.out.println("Índice inválido.");
                return;
            }
            eventoBase40s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido.");
        }
    }

    public void reagendarEvento(int indice, int dias){
        EventoBase40 eventoBase40 = eventoBase40s.get(indice);
        eventoBase40.reagendar(dias);
    }

    public List<EventoBase40> getEventoBase40s() {
        return eventoBase40s;
    }
}

