package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.*;

public class Exercicio06 {

    private final NavigableMap<LocalDateTime, Consultavel01> registroDeConsultas = new TreeMap<>();

    private boolean addProduto(Consultavel01 consultavel01){
        Consultavel01 consultas = registroDeConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01);
        if (consultas != null){
            System.out.println("Já tem consuta agendada para este horário:"+consultas.getDataHora());
            return false;
        }
        System.out.println("Consulta agendada com sucesso horário:"+consultas.getDataHora());
        return true;
    }

    private void excluirDados(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi cadastrada.");
            return;
        }
        if (registroDeConsultas.containsKey(horario)){
            registroDeConsultas.remove(horario);
            return;
        }
        System.out.println("Consulta não encontrada.");
    }

    private void listarProdutos(){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi cadastrada.");
            return;
        }
        registroDeConsultas.forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void pesquisaPorData(LocalDateTime horario){
        if (registroDeConsultas.isEmpty()){
            System.out.println("Nenhuma consulta foi cadastrada.");
            return;
        }
      registroDeConsultas.entrySet().stream()
                .filter(dataHora -> dataHora.getKey().equals(horario)).findFirst().
                ifPresentOrElse(consulta -> System.out.println("Consulta:"+consulta.getValue()), () ->
                        System.out.println("Consulta não encontradao."));
    }

    private boolean jaexiste(LocalDateTime horario){
        return registroDeConsultas.containsKey(horario);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroDeConsultas.higherEntry(LocalDateTime.now());
    }

    private void proximasConsultas(LocalDateTime consulta){
        registroDeConsultas.headMap(consulta,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultasAnteriores(LocalDateTime consulta){
       registroDeConsultas.tailMap(consulta,false)
               .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }






}
