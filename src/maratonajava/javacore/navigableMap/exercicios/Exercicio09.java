package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio09 {
    private final NavigableMap<LocalDateTime, Consultavel01> registroDeConsultas = new TreeMap<>();

    public boolean addConsultaSistema(Consultavel01 consultavel01){
        return registroDeConsultas.put(consultavel01.getDataHora(),consultavel01) == null;
    }

    public void addConsultaSistema2(Consultavel01 consultavel01){
        boolean consulta = registroDeConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
        if (!consulta){
            System.out.println("Consutal já cadastrada. Verifique agenda.");
            return;
        }
        System.out.println("Consulta agendada com sucesso.");
    }

    private void addConsulta3(Consultavel01 consultavel01){
        if (registroDeConsultas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível, verifique agenda.");
            return;
        }
        registroDeConsultas.put(consultavel01.getDataHora(),consultavel01);
    }


    public void listarConsultasAgendadas(){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada.");
            return;
        }
        registroDeConsultas.forEach((dateTime, consultavel01) -> System.out.println("Horário:"+dateTime+" |Dados:"+consultavel01));
    }

    public void pesquisaPorData(LocalDateTime horario){
        registroDeConsultas.entrySet()
                .stream().filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Consulta não encontradao."));
    }

    public void removerConsulta(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi encontrada.");
            return;
        }
        boolean produtoEncontrado = registroDeConsultas
                .entrySet()
                .removeIf(consulta -> consulta.getKey().equals(horario));
        if (!produtoEncontrado){
            System.out.println("Consulta não encontrada.");
            return;
        }
        System.out.println("Consulta removida do sistema com sucesso.");
    }

    public void removerConsulta2(Consultavel01 consultavel01){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi encontrada.");
            return;
        }
        if (registroDeConsultas.containsKey(consultavel01.getDataHora())){
            registroDeConsultas.remove(consultavel01.getDataHora(),consultavel01);
            System.out.println("Consulta removida com sucesso.");
            return;
        }
        System.out.println("Nenhum consulta foi encontrada.");
    }

    public void removerConsulta3(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi encontrada.");
            return;
        }
        registroDeConsultas.entrySet()
                .stream()
                .filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(consulta -> {
                    registroDeConsultas.remove(consulta.getKey(),consulta.getValue());
                    System.out.println("Consulta removida com sucesso");
                        },() -> System.out.println("Consulta não encontrada."));
    }

    public boolean consultaJaExiste(Consultavel01 consultavel01){
        return registroDeConsultas.containsKey(consultavel01.getDataHora());
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroDeConsultas.higherEntry(LocalDateTime.now());
    }

    public void proximasConsultas(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi encontrada.");
            return;
        }
        registroDeConsultas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println("Horário:"+dateTime+" |Dados:"+consultavel01));

    }

    public void consultasAnteriores(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi encontrada.");
            return;
        }
        registroDeConsultas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println("Horário:"+dateTime+" |Dados:"+consultavel01));
    }
    



}
