package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase33;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase33;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos33 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase33> eventoBase33s;

    public AgendaDeEventos33(){
        this.eventoBase33s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase33.validacaoNomeEvento(nomeEvento);
                return nomeEvento;
            }catch (NomeEventoBase33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase33.validacaoLocalEvento(localEvento);
                return localEvento;
            }catch (LocalEventoBase33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase33 eventoBase33){
        eventoBase33s.add(eventoBase33);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase33s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase33s.size(); i++) {
            System.out.println("_______________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase33s.get(i).exibirInfo();
            System.out.println("_______________________________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase33s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase33s.size()){
                System.out.println("Índice não encontrado.");
                return;
            }
            eventoBase33s.remove(indice);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase33 eventoBase33 = eventoBase33s.get(index);
        eventoBase33.reagendar(dias);
    }

    public List<EventoBase33> getEventoBase33s() {
        return eventoBase33s;
    }
}
