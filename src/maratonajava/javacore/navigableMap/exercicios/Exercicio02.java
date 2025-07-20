package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio02 {

    private final NavigableMap<LocalDateTime, Consultavel01> agendaConsultas = new TreeMap<>();

    private void addConsulta(Consultavel01 consultavel01){
        agendaConsultas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    private void cancelarConsulta(LocalDateTime horario){
        if (agendaConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
        }
        agendaConsultas.remove(horario);
        System.out.println("Consulta cancelada com sucesso.");
    }

    private boolean jaExiste(LocalDateTime horario){
        return agendaConsultas.containsKey(horario);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximasConsultas(){
        return agendaConsultas.higherEntry(LocalDateTime.now());
    }

    private void listarConsultas(){
        if (agendaConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
        }
        agendaConsultas.forEach((horario, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarAntes(LocalDateTime horario){
        agendaConsultas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarDepois(LocalDateTime horario){
        agendaConsultas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    public Map<LocalDateTime, Consultavel01> getAgendaConsultas() {
        return agendaConsultas;
    }
}
