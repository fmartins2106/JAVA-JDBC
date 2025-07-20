package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase26;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase26;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos26 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase26> eventoBase26s;

    public AgendaDeEventos26(){
        this.eventoBase26s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase26.validacaoNomeEvento(nomeEvento);
                return EventoBase26.formatoString(nomeEvento);
            }catch (NomeEventoBase26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase26.validacaoLocalEvento(localEvento);
                return EventoBase26.formatoString(localEvento);
            }catch (LocalEventoBase26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventosSistema(EventoBase26 eventoBase26){
        eventoBase26s.add(eventoBase26);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase26s.isEmpty()){
            System.out.println("Erro. Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase26s.size(); i++) {
            System.out.println("___________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase26s.get(i).exibirDados();
            System.out.println("___________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase26s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase26s.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            eventoBase26s.remove(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendarEvento(int indice, int dias){
        EventoBase26 eventoBase26 = eventoBase26s.get(indice);
        eventoBase26.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase26> getEventoBase26s() {
        return eventoBase26s;
    }
}
