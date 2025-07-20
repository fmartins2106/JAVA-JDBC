package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase34;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos34 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase34> eventoBase34s;

    public AgendaDeEventos34(){
        this.eventoBase34s = new ArrayList<>();
    }

    public static String nomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase34.validacaoNomeEvento(nomeEvento);
                return nomeEvento;
            }catch (NomeEventoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String localEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase34.validacaoLocalEvento(localEvento);
                return localEvento;
            }catch (LocalEventoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase34 eventoBase34){
        eventoBase34s.add(eventoBase34);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase34s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrada.");
            return;
        }
        for (int i = 0; i < eventoBase34s.size(); i++) {
            System.out.println("____________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase34s.get(i).exibirInfo();
            System.out.println("____________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase34s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o número do índice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase34s.size()){
                System.out.println("Erro. Indice não encontrado.");
                return;
            }
            eventoBase34s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase34 eventoBase34 = eventoBase34s.get(index);
        eventoBase34.reagendar(dias);
    }

    public List<EventoBase34> getEventoBase34s() {
        return eventoBase34s;
    }
}
