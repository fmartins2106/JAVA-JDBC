package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercicio05 {
    private static final Scanner scanner = new Scanner(System.in);
    private final NavigableMap<LocalDateTime, Consultavel01> registroDeConsultas = new TreeMap<>();

    private void addConsultaSistema(Consultavel01 consultavel01){
        registroDeConsultas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    private void excluirConsulta(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroDeConsultas.remove(horario);
        System.out.println("Produto removido com sucesso.");
    }

    private boolean jaExiste(LocalDateTime horario){
        return registroDeConsultas.containsKey(horario);
    }

    private void listarConsultasAgendadas(){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroDeConsultas.forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroDeConsultas.higherEntry(LocalDateTime.now());
    }

    private void ProximasConsultas(LocalDateTime horario){
        registroDeConsultas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultaAnteriores(LocalDateTime horario){
        registroDeConsultas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }



}
