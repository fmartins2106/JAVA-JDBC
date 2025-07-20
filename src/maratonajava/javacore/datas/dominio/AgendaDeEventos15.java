package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase15;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos15 {
    private List<EventoBase15> eventoBase15s;

    public AgendaDeEventos15(){
        this.eventoBase15s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase15.validacaoNomeEvento(nomeEvento);
                return EventoBase15.formatoString(nomeEvento);
            }catch (NomeEventoBase15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase15.validacaoLocalEvento(localEvento);
                return EventoBase15.formatoString(localEvento);
            }catch (LocalEventoBase15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase15 eventoBase15){
        eventoBase15s.add(eventoBase15);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase15s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase15s.size(); i++) {
            System.out.println("________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase15s.get(i).exibirInfo();
            System.out.println("________________________________________________________________");
        }
    }

    public void excluirEventoSistema(Scanner scanner){
        if (eventoBase15s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase15s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            EventoBase15 eventoBase15 = eventoBase15s.get(indice);
            eventoBase15s.remove(eventoBase15);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase15 eventoBase15 = eventoBase15s.get(index);
        eventoBase15.reagendar(dias);
    }

    public List<EventoBase15> getEventoBase15s() {
        return eventoBase15s;
    }
}
