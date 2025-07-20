package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase13;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEvento13 {
    private List<EventoBase13> eventoBase13s;

    public AgendaDeEvento13(){
        this.eventoBase13s = new ArrayList<>();
    }

    public static String validandoNomeEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase13.validacaoNomeEvento(nomeEvento);
                return EventoBase13.formatoString(nomeEvento);
            }catch (NomeEventoBase13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validacaoLocalEvento(Scanner scanner){
        while (true){
            try {
                System.out.print("Local do envento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase13.validacaoLocalEvento(localEvento);
                return EventoBase13.formatoString(localEvento);
            }catch (LocalEventoBase13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase13 eventoBase13){
        eventoBase13s.add(eventoBase13);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase13s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase13s.size(); i++) {
            System.out.println("______________________________________________________");
            System.out.print((i+1)+" - ");
            eventoBase13s.get(i).exibirInfo();
            System.out.println("______________________________________________________");
        }
    }

    public void excluirEvento(Scanner scanner){
        if (eventoBase13s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indiceEvento = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indiceEvento >= 0 && indiceEvento < eventoBase13s.size()){
                eventoBase13s.remove(indiceEvento);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
            System.out.println("Indice inválido, Tente novamente.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase13 eventoBase13 = eventoBase13s.get(index);
        eventoBase13.reagendar(dias);
        System.out.println("Eventor reagendado com sucesso.");
    }

    public List<EventoBase13> getEventoBase13s() {
        return eventoBase13s;
    }
}
