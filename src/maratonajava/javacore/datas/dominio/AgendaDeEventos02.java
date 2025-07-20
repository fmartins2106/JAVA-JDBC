package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase02;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos02 {
    private List<EventoBase02> eventoBase02s;

    public AgendaDeEventos02(){
        this.eventoBase02s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                EventoBase02.validacaoNome(nome);
                return EventoBase02.formatoString(nome);
            }catch (NomeEventoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocal(Scanner scanner){
        while (true){
            try {
                System.out.print("Local:");
                String local = scanner.nextLine().trim();
                EventoBase02.validacaoLocal(local);
                return EventoBase02.formatoString(local);
            }catch (LocalEventoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEvento(EventoBase02 eventoBase02){
        eventoBase02s.add(eventoBase02);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase02s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (EventoBase02 eventoBase02 : eventoBase02s) {
            System.out.println("____________________________________________");
            eventoBase02.exibirInfo();
            System.out.println("____________________________________________");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (eventoBase02s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        if (index >= 0 && index < eventoBase02s.size()){
            eventoBase02s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase02> getEventosBase02s() {
        return eventoBase02s;
    }

    public void excluirAgenda(Scanner scanner){
        try {
            System.out.print("Digite o número do indice.");
            int numeroIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (numeroIndice < 0 || numeroIndice >= eventoBase02s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            eventoBase02s.remove(numeroIndice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

}
