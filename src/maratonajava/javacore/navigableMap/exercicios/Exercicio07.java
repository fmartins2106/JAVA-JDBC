package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio07 {

    private final NavigableMap<LocalDateTime, Consultavel01> registroDeConsultas = new TreeMap<>();

    private void addConsultaSistema(Consultavel01 consultavel01){
        if (registroDeConsultas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível. Tente novamente.");
            return;
        }
        registroDeConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta Agendada com sucesso para:"+consultavel01.getDataHora());
    }

    private void removerConsulta(LocalDateTime dataHora){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        registroDeConsultas.entrySet().stream()
                .filter(consulta -> consulta.getKey().equals(dataHora))
                .findFirst()
                .ifPresentOrElse(consulta -> System.out.println("Consulta removida do sistema:"+consulta.getValue()),
        () -> System.out.println("Consulta não encontrada."));
    }

    private void pesquisaPorData(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        registroDeConsultas.entrySet().stream().
                filter(dataHora -> dataHora.equals(horario))
                .findFirst()
                .ifPresentOrElse(consulta -> System.out.println("Consulta:"+consulta.getValue()),() -> System.out.println("Consulta não encontrada."));
    }

    private boolean jaExiste(LocalDateTime consulta){
        return registroDeConsultas.containsKey(consulta);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroDeConsultas.higherEntry(LocalDateTime.now());
    }

    private void proximasConsultas(LocalDateTime horario){
        registroDeConsultas.headMap(horario,false)
                .forEach((dateTime,consultavel01) -> System.out.println("Horário:"+horario+" Dados da consulta:"+consultavel01));
    }

    private void consultasAnteriores(LocalDateTime horario){
        registroDeConsultas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println("Horário:"+horario+" |Dados da consulta:"+consultavel01));
    }

}
