package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio04 {

    private final NavigableMap<LocalDateTime, Consultavel01> registroConsultas = new TreeMap<>();

    private void addConsultaSistema(Consultavel01 consultavel01){
        registroConsultas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    private void cancelarConsulta(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        registroConsultas.remove(horario);
        System.out.println("Consulta cancelada.");
    }

    private boolean jaExiste(LocalDateTime horairo){
        return registroConsultas.containsKey(horairo);
    }

    private void listarConsultasAgendadas(){
        if (registroConsultas.isEmpty()){
            System.out.println("Consulta agendada com sucesso.");
            return;
        }
        registroConsultas.forEach((horario,consultavel01) -> System.out.println(consultavel01));
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroConsultas.higherEntry(LocalDateTime.now());
    }

    private void proximasCOnsultas(LocalDateTime horario){
        registroConsultas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultasAnteriores(LocalDateTime horario){
        registroConsultas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    public NavigableMap<LocalDateTime, Consultavel01> getRegistroConsultas() {
        return registroConsultas;
    }
}
