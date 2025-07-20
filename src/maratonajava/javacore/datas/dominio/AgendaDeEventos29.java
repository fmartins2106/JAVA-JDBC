package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase29;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos29 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase29> eventoBase29s;

    public AgendaDeEventos29(){
        this.eventoBase29s = new ArrayList<>();
    }

    public static String validandoNomeEvento(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase29.validacaoNomeEvento(nomeEvento);
                return EventoBase29.formatoString(nomeEvento);
            }catch (NomeEventoBase29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase29.validacaoLocalEvento(localEvento);
                return EventoBase29.formatoString(localEvento);
            }catch (LocalEventoBase29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase29 eventoBase29){
        eventoBase29s.add(eventoBase29);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase29s.isEmpty()){
            System.out.println("Nenhume evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase29s.size(); i++) {
            System.out.println("_____________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase29s.get(i).exibirInfo();
            System.out.println("_____________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase29s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o indice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase29s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            eventoBase29s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro, digite um valor válido.");
        }
    }

    public void reagendarEvento(int index, int dias){
        EventoBase29 eventoBase29 = eventoBase29s.get(index);
        eventoBase29.reagerdar(dias);
    }

    public List<EventoBase29> getEventoBase29s() {
        return eventoBase29s;
    }
}
