package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase38;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase38;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos38 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase38> eventoBase38s;

    public AgendaDeEventos38(){
        this.eventoBase38s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nome = scanner.nextLine().trim();
                EventoBase38.validacaoNomeEvento(nome);
                return EventoBase38.formatoString(nome);
            }catch (NomeEventoBase38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase38.validacaoLocalEvento(localEvento);
                return EventoBase38.formatoString(localEvento);
            }catch (LocalEventoBase38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(EventoBase38 eventoBase38){
        eventoBase38s.add(eventoBase38);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase38s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase38s.size(); i++) {
            System.out.println("________________________________________________");
            System.out.print((1+i)+" -");
            eventoBase38s.get(i).exibirInfo();
            System.out.println("________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase38s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase38s.size()){
                System.out.println("Erro. Índice inválido.");
                return;
            }
            eventoBase38s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Número inválido. Tente novamente.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase38 eventoBase38 = eventoBase38s.get(index);
        eventoBase38.reagendar(dias);
    }

    public List<EventoBase38> getEventoBase38s() {
        return eventoBase38s;
    }
}
