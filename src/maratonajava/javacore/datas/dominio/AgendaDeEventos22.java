package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase22;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos22 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<EventoBase22> eventoBase22s;

    public AgendaDeEventos22(){
        this.eventoBase22s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase22.validacaoNomeEvento(nomeEvento);
                return EventoBase22.formatoString(nomeEvento);
            }catch (NomeEventoBase22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase22.validacaoLocalEvento(localEvento);
                return EventoBase22.formatoString(localEvento);
            }catch (LocalEventoBase22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase22 eventoBase22){
        eventoBase22s.add(eventoBase22);
        System.out.println("Evento criado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase22s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase22s.size(); i++) {
            System.out.println("__________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase22s.get(i).exibirInfo();
            System.out.println("__________________________________________________________");
        }
    }

    public void excluirEventoSistema(){
        if (eventoBase22s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        try {
            System.out.print("Digite o indice do evento.");
            int indiceEvento = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indiceEvento < 0 || indiceEvento >= eventoBase22s.size()){
                System.out.println("Erro. Indice inválido.");
                return;
            }
            eventoBase22s.remove(indiceEvento);
            System.out.println("Evento removido com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Indice inválido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase22 eventoBase22 = eventoBase22s.get(index);
        eventoBase22.reagendar(dias);
        System.out.println("Evento reagendado com sucesso.");
    }

    public List<EventoBase22> getEventoBase22s() {
        return eventoBase22s;
    }
}
