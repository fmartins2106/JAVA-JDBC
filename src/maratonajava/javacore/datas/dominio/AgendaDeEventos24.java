package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase24;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos24 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase24> eventoBase24s;

    public AgendaDeEventos24(){
        this.eventoBase24s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase24.validacaoNomeEvento(nomeEvento);
                return EventoBase24.formatoString(nomeEvento);
            }catch (NomeEventoBase24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase24.validacaoLocalEvento(localEvento);
                return EventoBase24.formatoString(localEvento);
            }catch (LocalEventoBase24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase24 eventoBase24){
        eventoBase24s.add(eventoBase24);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase24s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase24s.size(); i++) {
            System.out.println("___________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase24s.get(i).exibirInfo();
            System.out.println("___________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase24s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase24s.size()){
                eventoBase24s.remove(indice);
                System.out.println("Evento excluido com sucesso.");
                return;
            }
            System.out.println("Erro. Número de indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número de indice válido.");
        }
    }

    public void reagendarEvento(){
        if (eventoBase24s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice > eventoBase24s.size()){
                System.out.println("Erro. Indice inválido.");
            }
            System.out.print("Digite a quantidade de dias que gostaria de postergar o evento:");
            int dias = Integer.parseInt(scanner.nextLine().trim());
            eventoBase24s.get(indice).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite digite um valor válido.");
        }
    }



}
