package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase37;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos37 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase37>eventoBase37s;

    public AgendaDeEventos37(){
        this.eventoBase37s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase37.validacaoNomeEvento(nomeEvento);
                return EventoBase37.formatoString(nomeEvento);
            }catch (NomeEventoBase37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase37.validacaoLocalEvento(localEvento);
                return EventoBase37.formatoString(localEvento);
            }catch (LocalEventoBase37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(EventoBase37 eventoBase37){
        eventoBase37s.add(eventoBase37);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosSistema(){
        if (eventoBase37s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase37s.size(); i++) {
            System.out.println("_________________________________________________________________________________");
            System.out.print((1+i)+" -");
            eventoBase37s.get(i).exibirInfo();
            System.out.println("_________________________________________________________________________________");
        }
    }

    public void excluirDadosSistema(){
        if (eventoBase37s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosSistema();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase37s.size()){
                System.out.println("Índice inválido. Tente novamente.");
                return;
            }
            eventoBase37s.remove(indice);
            System.out.println("Evento removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Número inválido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase37 eventoBase37 = eventoBase37s.get(index);
        eventoBase37.reagendar(dias);
    }

    public List<EventoBase37> getEventoBase37s() {
        return eventoBase37s;
    }
}
