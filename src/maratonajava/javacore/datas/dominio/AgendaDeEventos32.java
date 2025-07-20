package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos32 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<EventoBase32> eventoBase32s;

    public AgendaDeEventos32(){
        this.eventoBase32s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome do evento:");
                String nomeEvento = scanner.nextLine().trim();
                EventoBase32.validacaoNomeEvento(nomeEvento);
                return EventoBase32.formatoString(nomeEvento);
            }catch (NomeEventoBase32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocalEvento(){
        while (true){
            try {
                System.out.print("Local do evento:");
                String localEvento = scanner.nextLine().trim();
                EventoBase32.validacaoLocalEvento(localEvento);
                return EventoBase32.formatoString(localEvento);
            }catch (LocalEventoBase32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase32 eventoBase32){
        eventoBase32s.add(eventoBase32);
        System.out.println("Evento cadastrado com sucesso.");
    }

    public void listarEventosCadastrados(){
        if (eventoBase32s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        for (int i = 0; i < eventoBase32s.size(); i++) {
            System.out.println("__________________________________________________________________________________");
            System.out.print((1+i)+" - ");
            eventoBase32s.get(i).exibirInfo();
            System.out.println("__________________________________________________________________________________");
        }
    }

    public void excluirEvento(){
        if (eventoBase32s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        listarEventosCadastrados();
        try {
            System.out.print("Digite o índice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase32s.size()){
                System.out.println("Erro. Índice inválido.");
                return;
            }
            eventoBase32s.remove(indice);
            System.out.println("Evento excluir do sistema com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }


    public void reagendar(int index, int dias){
        EventoBase32 eventoBase32 = eventoBase32s.get(index);
        eventoBase32.reagendar(dias);
    }

    public List<EventoBase32> getEventoBase32s() {
        return eventoBase32s;
    }
}
