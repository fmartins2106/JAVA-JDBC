package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase09;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos09 {
    private List<EventoBase09> eventoBase09s;

    public AgendaDeEventos09(){
        this.eventoBase09s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase09.validacaoNomeEvento(nomeEvento);
                return EventoBase09.formatoString(nomeEvento);
            }catch (NomeEventoBase09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do envento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase09.validacaoLocalEvento(localEvento);
                return EventoBase09.formatoString(localEvento);
            }catch (LocalEventoBase09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase09 eventoBase09){
        eventoBase09s.add(eventoBase09);
    }

    public void listarEventosCadastrados(){
        if (eventoBase09s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase09s.size(); i++) {
            System.out.println("_______________________________________");
            System.out.print((1+i)+" - ");
            eventoBase09s.get(i).exibirInfo();
            System.out.println("_______________________________________");
        }
    }

    public void excluirDadosEvento(Scanner scanner){
        if (eventoBase09s.isEmpty()){
            System.out.println("Nenhum evento foi criado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento a se retirado:");
            int index = Integer.parseInt(scanner.nextLine().trim())-1;
            if (index >=0 && index < eventoBase09s.size()){
                eventoBase09s.remove(index);
            }
            System.out.println("Indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        eventoBase09s.get(index).reagendar(dias);
    }

    public List<EventoBase09> getEventoBase09s() {
        return eventoBase09s;
    }
}
