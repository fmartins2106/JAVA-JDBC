package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase28;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos28 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase28> eventoBase28s;

    public AgendaDeEventos28(){
        this.eventoBase28s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase28.validacaoNomeEvento(nomeEvento);
                return EventoBase28.formatoString(nomeEvento);
            }catch (NomeEventoBase28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase28.validacaoLocalEvento(localEvento);
                return EventoBase28.formatoString(localEvento);
            }catch (LocalEventoBase28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase28 eventoBase28){
        eventoBase28s.add(eventoBase28);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase28s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase28s.size(); i++) {
            System.out.println("____________________________________________________________________________");
            System.out.println((1+i)+" - ");
            eventoBase28s.get(i).exibirInfo();
            System.out.println("____________________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase28s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice > eventoBase28s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            eventoBase28s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
        }
    }

    public void reagendar(int index, int dias){
        EventoBase28 eventoBase28 = eventoBase28s.get(index);
        eventoBase28.reagendar(dias);
    }

    public List<EventoBase28> getEventoBase28s() {
        return eventoBase28s;
    }
}
