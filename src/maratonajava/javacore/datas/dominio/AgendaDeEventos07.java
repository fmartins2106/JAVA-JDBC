package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase07;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos07 {
    private List<EventoBase07> eventoBase07s;

    public AgendaDeEventos07(){
        this.eventoBase07s = new ArrayList<>();
    }

    public static String validacaoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase07.validacaoNomeEvento(nomeEvento);
                return EventoBase07.formatoString(nomeEvento);
            }catch (NomeEventoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validacaoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase07.validacaoLocalEvento(localEvento);
                return EventoBase07.formatoString(localEvento);
            }catch (LocalEventoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase07 eventoBase07){
        eventoBase07s.add(eventoBase07);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventoSistema(){
        if (eventoBase07s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase07s.size(); i++) {
            System.out.println("_____________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase07s.get(i).exibirInfo();
            System.out.println("_____________________________________________");
        }
    }

    public void excluirDadosAgenda(Scanner scanner){
        if (eventoBase07s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventoSistema();
        try {
            System.out.print("Digite o indice da agenda:");
            int indiceAgenda = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indiceAgenda < 0 || indiceAgenda >= eventoBase07s.size()){
                System.out.println("Digite um indice válido.");
                return;
            }
            eventoBase07s.remove(indiceAgenda);
        }catch (NumberFormatException e){
            System.out.println("Digite um número de indice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (index >= 0 && index < eventoBase07s.size()){
            eventoBase07s.get(index).reagendar(dias);
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase07> getEventoBase07s() {
        return eventoBase07s;
    }
}
