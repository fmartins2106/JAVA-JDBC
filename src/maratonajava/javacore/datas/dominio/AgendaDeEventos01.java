package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase01;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase01;

import java.util.*;

public class AgendaDeEventos01 {
    private List<EventoBase01> eventoBase01s;

    public AgendaDeEventos01(){
        this.eventoBase01s = new ArrayList<>();
    }

    public void adicionarEvento(EventoBase01 eventoBase01){
        eventoBase01s.add(eventoBase01);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase01s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase01s.size(); i++) {
            System.out.println("____________________________________");
            System.out.print((i+1)+" - ");
            eventoBase01s.get(i).exibirInfo();
            System.out.println("____________________________________");
        }
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase01.validacaoNome(nomeEvento);
                return EventoBase01.formatoString(nomeEvento);
            }catch (NomeProdutoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o local:");
                String local = scanner.nextLine().trim();
                EventoBase01.validacaoLocal(local);
                return EventoBase01.formatoString(local);
            }catch (LocalEventoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void reagendarEvento(int index, int dias){
        if (index >= 0 && index < eventoBase01s.size()){
            eventoBase01s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase01> getEventoBase01s() {
        return eventoBase01s;
    }

    public void excluirEvento(Scanner scanner){
        try {
            System.out.print("Digite o indice do agendamento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase01s.size()){
                System.out.println("Nenhum evento foi cadastrado.");
                return;
            }
            eventoBase01s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }
}
