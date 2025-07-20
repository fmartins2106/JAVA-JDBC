package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio10 {
    private NavigableMap<LocalDateTime, Consultavel01> registroConsultas = new TreeMap<>();

    public boolean registroConsultaSistema(Consultavel01 consultavel01){
        return registroConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
    }

    public void registroConsultaSistema2(Consultavel01 consultavel01){
        boolean consulta = registroConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01)== null;
        if (!consulta){
            System.out.println("Consulta cadastrada com sucesso.");
            return;
        }
        System.out.println("Horário indisponível.");
    }

    private void regitroConsultaSistema(Consultavel01 consultavel01){
        if (registroConsultas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível.");
            return;
        }
        registroConsultas.put(consultavel01.getDataHora(),consultavel01);
    }

    public void listarConsultasAgendados(){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhum consulta foi agendada.");
            return;
        }
        registroConsultas.entrySet().forEach(System.out::println);
    }

    public void pesquisaPorData(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada.");
            return;
        }
        registroConsultas.entrySet().stream()
                .filter(consulta -> consulta.getKey().isEqual(horario))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Nenhum produto foi agendado."));
    }

    public void removerConsulta(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada.");
            return;
        }
        boolean consultas = registroConsultas.entrySet().removeIf(consulta -> consulta.getKey().equals(horario));
        if (!consultas){
            System.out.println("Consulta não encontrada.");
            return;
        }
        System.out.println("Consulta excluida com sucesso.");
    }

    public void removerConsulta2(Consultavel01 consultavel01){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada.");
            return;
        }
        if (registroConsultas.containsKey(consultavel01.getDataHora())){
            registroConsultas.remove(consultavel01.getDataHora(),consultavel01);
            System.out.println("Consulta removida com sucesso.");
            return;
        }
        System.out.println("Nenhuma consulta foi registrada neste horário.");
    }

    public void removerConsulta3(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi cadastrada.");
            return;
        }
        registroConsultas.entrySet()
                .stream().filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(registros -> {
                    registroConsultas.remove(registros.getKey(),registros.getValue());
                }, () -> System.out.println("Consulta não encontrada."));
    }

    public boolean consultaJaExiste(LocalDateTime horario){
        return registroConsultas.containsKey(horario);
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroConsultas.higherEntry(LocalDateTime.now());
    }

    public void proximasConsultas(LocalDateTime horario){
        registroConsultas.headMap(horario,false)
                .entrySet().forEach(System.out::println);
    }

    public void consultasAnteriores(LocalDateTime horario){
        registroConsultas.tailMap(horario,false)
                .entrySet().forEach(System.out::println);
    }
}
