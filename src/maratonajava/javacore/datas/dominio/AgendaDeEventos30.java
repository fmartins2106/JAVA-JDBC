package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase30;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos30 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase30> eventoBase30s;

    public AgendaDeEventos30(){
        this.eventoBase30s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase30.validacaoNomeEvento(nomeEvento);
                return EventoBase30.formatoString(nomeEvento);
            }catch (NomeEventoBase30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.err.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase30.validacaoLocalEvento(localEvento);
                return localEvento;
            }catch (LocalEventoBase30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoAgenda(EventoBase30 eventoBase30){
        eventoBase30s.add(eventoBase30);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase30s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase30s.size(); i++) {
            System.out.print((1+i)+" - ");
            eventoBase30s.get(i).exibirInfo();
        }
    }

    public void excluirDadosEvento(){
        if (eventoBase30s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase30s.size()){
                System.out.println("Índice inválido.");
                return;
            }
            eventoBase30s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Número inválido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase30 eventoBase30 = eventoBase30s.get(index);
        eventoBase30.reagendar(dias);
    }

    public List<EventoBase30> getEventoBase30s() {
        return eventoBase30s;
    }
}
