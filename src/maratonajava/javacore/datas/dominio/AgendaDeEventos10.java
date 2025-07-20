package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase10;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos10 {
    private List<EventoBase10> eventoBase10s;

    public AgendaDeEventos10(){
        this.eventoBase10s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase10.validacaoNomeEvento(nomeEvento);
                return EventoBase10.formatoString(nomeEvento);
            }catch (NomeEventoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase10.validacaoLocalEvento(localEvento);
                return EventoBase10.formatoString(localEvento);
            }catch (LocalEventoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase10 eventoBase10){
        eventoBase10s.add(eventoBase10);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase10s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase10s.size(); i++) {
            System.out.println("_______________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase10s.get(i).exibirInfo();
            System.out.println("_______________________________________________");
        }
    }

    public void excluirEvento(Scanner scanner){
        if (eventoBase10s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int removerEvento = Integer.parseInt(scanner.nextLine().trim())-1;
            EventoBase10 eventoBase10 = eventoBase10s.get(removerEvento);
            eventoBase10s.remove(eventoBase10);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido de indice.");
        }
    }

    public void reagendarEvento(int index, int dias){
       eventoBase10s.get(index).reagendar(dias);
    }

    public List<EventoBase10> getEventoBase10s() {
        return eventoBase10s;
    }
}
