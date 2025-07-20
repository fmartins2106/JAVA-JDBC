package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase12;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos12 {
    private List<EventoBase12> eventoBase12s;

    public AgendaDeEventos12(){
        this.eventoBase12s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase12.validacaoNome(nomeEvento);
                return EventoBase12.formatoString(nomeEvento);
            }catch (NomeEventoBase12 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase12.validacaoLocalEvento(localEvento);
                return EventoBase12.formatoString(localEvento);
            }catch (LocalEventoBase12 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase12 eventoBase12){
        eventoBase12s.add(eventoBase12);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase12s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase12s.size(); i++) {
            System.out.println("______________________________________");
            System.out.print((1+i)+" - ");
            eventoBase12s.get(i).exibirInfo();
            System.out.println("______________________________________");
        }
    }

    public void excluirEvento(Scanner scanner){
        if (eventoBase12s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase12s.size()){
                EventoBase12 eventoBase12 = eventoBase12s.get(indice);
                eventoBase12s.remove(eventoBase12);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
            System.out.println("Indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase12 eventoBase12 = eventoBase12s.get(index);
        eventoBase12.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase12> getEventoBase12s() {
        return eventoBase12s;
    }
}
