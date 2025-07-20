package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase46;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase46;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos46 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase46> eventoBase46s;

    public AgendaDeEventos46(){
        this.eventoBase46s = new ArrayList<>();
    }

    public static final Comparator<EventoBase46> COMPARATOR_POR_DATA =
            Comparator.comparing(EventoBase46::getDataHora);

    public static final Comparator<EventoBase46> COMPARATOR_NOME_EVENTO =
            Comparator.comparing(EventoBase46::getNomeEvento);


    public void listarEventoPorData(){
        if (eventoBase46s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        eventoBase46s.stream().sorted(COMPARATOR_POR_DATA).forEach(eventoBase46 -> {
            System.out.println("_____________________________________________________________________________________");
            eventoBase46.exibirInfo();
            System.out.println("_____________________________________________________________________________________");
        });
    }

    public void listarEventosPorNome(){
        if (eventoBase46s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        eventoBase46s.stream().sorted(COMPARATOR_NOME_EVENTO).forEach(eventoBase46 -> {
            System.out.println("_____________________________________________________________________________________");
            eventoBase46.exibirInfo();
            System.out.println("_____________________________________________________________________________________");
        });
    }

    public static final Comparator<EventoBase46> COMPARATOR_LOCAL_EVENTO =
            Comparator.comparing(EventoBase46::getLocalEvento);

    public void listarEventosLocal(){
        if (eventoBase46s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        eventoBase46s.stream().sorted(COMPARATOR_LOCAL_EVENTO).forEach(eventoBase46 -> {
            System.out.println("_____________________________________________________________________________________");
            eventoBase46.exibirInfo();
            System.out.println("_____________________________________________________________________________________");
        });
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.println("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase46.validacaoNomeEvento(nomeEvento);
                return EventoBase46.formatoString(nomeEvento);
            }catch (NomeEventoBase46 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.println("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase46.validacaoLocalEvento(localEvento);
                return EventoBase46.formatoString(localEvento);
            }catch (LocalEventoBase46 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase46 eventoBase46){
        eventoBase46s.add(eventoBase46);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosSistema(){
        if (eventoBase46s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase46s.size(); i++) {
            System.out.println("__________________________________________________________________________________");
            System.out.print((1+i)+" -");
            eventoBase46s.get(i).exibirInfo();
            System.out.println("__________________________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase46s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosSistema();
        try {
            System.out.println("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase46s.size()){
                System.out.println("Índice inválido. Tente novamente.");
                return;
            }
            eventoBase46s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Índice inválido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase46 eventoBase46 = eventoBase46s.get(index);
        eventoBase46.reagendar(dias);
    }

    public List<EventoBase46> getEventoBase46s() {
        return eventoBase46s;
    }
}
