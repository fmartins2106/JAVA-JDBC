package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase31;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos31 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase31> eventoBase31s;

    public AgendaDeEventos31(){
        this.eventoBase31s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase31.validacaoNomeEvento(nomeEvento);
                return nomeEvento;
            }catch (NomeEventoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase31.validacaoLocalEvento(localEvento);
                return localEvento;
            }catch (LocalEventoBase31 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase31 eventoBase31){
        eventoBase31s.add(eventoBase31);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase31s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase31s.size(); i++) {
            System.out.println("________________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase31s.get(i).exibirInfo();
            System.out.println("________________________________________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase31s.isEmpty()){
            System.out.println("Lista vazio. Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase31s.size()){
                System.out.println("Erro. Indice inválido.");
                return;
            }
            eventoBase31s.remove(indice);
            System.out.println("Evento excluido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase31 eventoBase31 = eventoBase31s.get(index);
        eventoBase31.reagendar(dias);
    }

    public List<EventoBase31> getEventoBase31s() {
        return eventoBase31s;
    }
}
