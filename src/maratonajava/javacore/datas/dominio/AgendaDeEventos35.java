package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos35 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase35> eventoBase35s;

    public AgendaDeEventos35(){
        this.eventoBase35s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase35.validacaoNomeEvento(nomeEvento);
                return EventoBase35.formatoString(nomeEvento);
            }catch (NomeEventoBase35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase35.validacaoLocalEvento(localEvento);
                return EventoBase35.formatoString(localEvento);
            }catch (LocalEventoBase35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase35 eventoBase35){
        eventoBase35s.add(eventoBase35);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase35s.isEmpty()){
            System.out.println("Erro. Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase35s.size(); i++) {
            System.out.println("________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase35s.get(i).exibirInfo();
            System.out.println("________________________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase35s.isEmpty()){
            System.out.println("Erro. Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase35s.size()){
                System.out.println("Erro. Índice inválido.");
                return;
            }
            eventoBase35s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Número inválido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase35 eventoBase35 = eventoBase35s.get(index);
        eventoBase35.reagendar(dias);
    }

    public List<EventoBase35> getEventoBase35s() {
        return eventoBase35s;
    }
}
