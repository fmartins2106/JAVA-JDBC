package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase06;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos06 {
    private List<EventoBase06> eventoBase06s;

    public AgendaDeEventos06(){
        this.eventoBase06s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase06.validacaoNomeEvento(nomeEvento);
                return EventoBase06.formatoString(nomeEvento);
            }catch (NomeEventoBase06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase06.validacaoLocalEvento(localEvento);
                return EventoBase06.formatoString(localEvento);
            }catch (LocalEventoBase06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase06 eventoBase06){
        eventoBase06s.add(eventoBase06);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase06s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase06s.size(); i++) {
            System.out.println("__________________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase06s.get(i).exibirInfo();
            System.out.println("__________________________________________________");
        }
    }

    public void excluirDados(Scanner scanner){
        if (eventoBase06s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice da agenda:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice >= 0 && indice < eventoBase06s.size()){
                eventoBase06s.remove(indice);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
            System.out.println("Indice inválido.");
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (eventoBase06s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        if (index >= 0 && index < eventoBase06s.size()){
            eventoBase06s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso");
            return;
        }
        System.out.println("Indice inválido.");
    }
}
