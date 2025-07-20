package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase19;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos19 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase19> eventoBase19s;

    public AgendaDeEventos19(){
        this.eventoBase19s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nome = scanner.nextLine().trim();
                EventoBase19.validacaoNome(nome);
                return EventoBase19.formatoString(nome);
            }catch (NomeEventoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocal(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase19.validacaoLocalEvento(localEvento);
                return EventoBase19.formatoString(localEvento);
            }catch (LocalEventoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase19 eventoBase19){
        eventoBase19s.add(eventoBase19);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase19s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase19s.size(); i++) {
            System.out.println("_________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase19s.get(i).exibirInfo();
            System.out.println("_________________________________________________________");
        }
    }

    public void excluirEventoAgenda(){
        if (eventoBase19s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase19s.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            eventoBase19s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase19 eventoBase19 = eventoBase19s.get(index);
        eventoBase19.reagendar(dias);
    }

    public List<EventoBase19> getEventoBase19s() {
        return eventoBase19s;
    }
}
