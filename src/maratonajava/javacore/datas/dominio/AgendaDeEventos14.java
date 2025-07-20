package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase14;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos14 {
    private List<EventoBase14> eventoBase14s;

    public AgendaDeEventos14(){
        this.eventoBase14s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase14.validacaoNome(nomeEvento);
                return EventoBase14.formatoString(nomeEvento);
            }catch (NomeEventoBase14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase14.validacaoLocalEvento(localEvento);
                return EventoBase14.formatoString(localEvento);
            }catch (LocalEventoBase14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEvento(EventoBase14 eventoBase14){
        eventoBase14s.add(eventoBase14);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase14s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase14s.size(); i++) {
            System.out.println("______________________________________________________________________");
            System.out.print((i+1));
            eventoBase14s.get(i).exibirInfo();
            System.out.println("______________________________________________________________________");
        }
    }

    public void excluirEvento(Scanner scanner){
        if (eventoBase14s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o número do indice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < getEventoBase14s().size()){
                eventoBase14s.remove(indice);
                System.out.println("Evento excluido com sucesso.");
                return;
            }
            System.out.println("Indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase14 eventoBase14 = eventoBase14s.get(index);
        eventoBase14.reagendar(dias);
    }

    public List<EventoBase14> getEventoBase14s() {
        return eventoBase14s;
    }
}
