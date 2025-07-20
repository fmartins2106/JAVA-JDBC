package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase05;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos05 {
    private List<EventoBase05> eventoBase05s;

    public AgendaDeEventos05(){
        this.eventoBase05s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase05.validacaoNomeEvento(nomeEvento);
                return EventoBase05.formatoString(nomeEvento);
            }catch (NomeEventoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase05.validacaoLocalEvento(localEvento);
                return EventoBase05.formatoString(localEvento);
            }catch (LocalEventoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase05 eventoBase05){
        eventoBase05s.add(eventoBase05);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase05s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase05s.size(); i++) {
            System.out.println("______________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase05s.get(i).exibirInfo();
            System.out.println("______________________________________________________________________________________");
        }
    }

    public void excluirDadosEvento(Scanner scanner){
        if (eventoBase05s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventos();
        try {
            System.out.print("Digite o número do indice:");
            int numeroIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (numeroIndice >= 0 && numeroIndice < eventoBase05s.size()){
                eventoBase05s.remove(numeroIndice);
            }
            System.out.println("Indice não encontrado.");
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (index >= 0 && index < eventoBase05s.size()) {
            eventoBase05s.get(index).reagendar(dias);
            System.out.println("Data alterada com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase05> getEventoBase05s() {
        return eventoBase05s;
    }
}
