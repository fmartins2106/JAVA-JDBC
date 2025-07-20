package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase11;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos11 {
    private List<EventoBase11> eventoBase11s;

    public AgendaDeEventos11(){
        this.eventoBase11s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase11.validacaoNomeEvento(nomeEvento);
                return EventoBase11.formatoString(nomeEvento);
            }catch (NomeEventoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase11.validacaoLocalEvento(localEvento);
                return EventoBase11.formatoString(localEvento);
            }catch (LocalEventoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void addEventoSistema(EventoBase11 eventoBase11){
        eventoBase11s.add(eventoBase11);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase11s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase11s.size(); i++) {
            System.out.println("__________________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase11s.get(i).exibirInfo();
            System.out.println("__________________________________________________");
        }
    }

    public void excluirEventoSistema(Scanner scanner){
        if (eventoBase11s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase11s.size()){
                EventoBase11 eventoBase11 = eventoBase11s.get(indice);
                eventoBase11s.remove(eventoBase11);
                System.out.println("Evento removido com sucesso.");
                return;
            }
            System.out.println("Indice inválido. Tente novamente.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase11 eventoBase11 = eventoBase11s.get(index);
        eventoBase11.reagendar(dias);
    }

    public List<EventoBase11> getEventoBase11s() {
        return eventoBase11s;
    }
}
