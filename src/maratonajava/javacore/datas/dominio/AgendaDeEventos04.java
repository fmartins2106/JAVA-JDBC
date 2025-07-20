package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase04;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase04;
import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos04 {
    private List<EventoBase04> eventoBase04s;

    public AgendaDeEventos04(){
        this.eventoBase04s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase04.validacaoNome(nomeEvento);
                return EventoBase04.formatoString(nomeEvento);
            }catch (NomeEventoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocal(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase04.validacaoLocal(localEvento);
                return EventoBase04.formatoString(localEvento);
            }catch (LocalEventoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEvento(EventoBase04 eventoBase04){
        eventoBase04s.add(eventoBase04);
    }

    public void listarDadosEvento(){
        if (eventoBase04s.isEmpty()){
            System.out.println("Nenhum evento foi encontrado.");
            return;
        }
        for (int i = 0; i < eventoBase04s.size(); i++) {
            System.out.println("_______________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase04s.get(i).exibirInfo();
            System.out.println("_______________________________________________");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (eventoBase04s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        if (index >= 0 && index < eventoBase04s.size()){
            eventoBase04s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase04> getEventoBase04s() {
        return eventoBase04s;
    }

    public void excluirDadosEvento(Scanner scanner){
        if (eventoBase04s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarDadosEvento();
        try {
            System.out.print("Digite o número do indice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase04s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            eventoBase04s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }
}
