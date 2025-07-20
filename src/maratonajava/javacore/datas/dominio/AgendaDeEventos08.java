package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase08;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos08 {
    private List<EventoBase08> eventoBase08s;

    public AgendaDeEventos08(){
        this.eventoBase08s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase08.validacaoNomeEvento(nomeEvento);
                return EventoBase08.formatoString(nomeEvento);
            }catch (NomeEventoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase08.validacaoLocalEvento(localEvento);
                return EventoBase08.formatoString(localEvento);
            }catch (LocalEventoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoAgenda(EventoBase08 eventoBase08){
        eventoBase08s.add(eventoBase08);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase08s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase08s.size(); i++) {
            System.out.println("_______________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase08s.get(i).exibirInfo();
            System.out.println("_______________________________________________________________");
        }
    }

    public void excluirDadosEvento(Scanner scanner){
        if (eventoBase08s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventos();
        try {
            System.out.print("Digite o indice da agenda:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            EventoBase08 eventoBase08 = eventoBase08s.get(indice);
            eventoBase08s.remove(eventoBase08);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (index >= 0 && index < eventoBase08s.size()){
            eventoBase08s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
            return;
        }
        System.out.println("Indice inválido. Tente novamente.");
    }

    public List<EventoBase08> getEventoBase08s() {
        return eventoBase08s;
    }
}
