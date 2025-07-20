package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase03;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeEventos03 {
    private List<EventoBase03> eventoBase03s;

    public AgendaDeEventos03(){
        this.eventoBase03s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                EventoBase03.validacaoNome(nome);
                return EventoBase03.formatoString(nome);
            }catch (NomeEventoBase03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoLocal(Scanner scanner){
        while (true){
            try {
                System.out.print("Local:");
                String local = scanner.nextLine().trim();
                EventoBase03.validacaoLocal(local);
                return EventoBase03.formatoString(local);
            }catch (LocalEventoBase03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addEventoSistema(EventoBase03 eventoBase03){
        eventoBase03s.add(eventoBase03);
        System.out.println("Evento adicionado com sucesso.");
    }

    public void listarEventos(){
        if (eventoBase03s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (EventoBase03 base03 : eventoBase03s) {
            System.out.println("________________________________________");
            base03.exibirInfo();
            System.out.println("________________________________________");
        }
    }

    public void reagendarEvento(int index, int dias){
        if (eventoBase03s.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        if (index >=0 && index < eventoBase03s.size()){
            eventoBase03s.get(index).reagendar(dias);
            System.out.println("Evento reagendado com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public List<EventoBase03> getEventoBase03s() {
        return eventoBase03s;
    }

    public void excluirDados(Scanner scanner){
        if (eventoBase03s.isEmpty()){
            System.out.println("Nenhum evento foi cadastrado.");
            return;
        }
        try {
            System.out.print("Digite o indice do agendamento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= eventoBase03s.size()){
                System.out.println("Indice inválido.");
                return;
            }
            eventoBase03s.remove(indice);
            System.out.println("Dados removidos com sucesso.");
        }catch (NumberFormatException e){
            System.out.println("ERRO: Digite um indice válido.");
        }
    }

}
