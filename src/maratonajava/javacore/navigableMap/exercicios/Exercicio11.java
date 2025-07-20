package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio11 {

    public static NavigableMap<LocalDateTime, Consultavel01> registroConsultas = new TreeMap<>();

    public boolean registroConsultaSistema(Consultavel01 consultavel01){
        return registroConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
    }

    public boolean registroConsultaSistema2(Consultavel01 consultavel01){
        if (registroConsultas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível.");
            return false;
        }
        registroConsultas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
        return true;
    }

    public void registroConsultaSisteman3(Consultavel01 consultavel01){
        boolean registrarConsulta = registroConsultas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
        if (!registrarConsulta){
            System.out.println("Horário indisponível. Tente novamente.");
            return;
        }
        System.out.println("Consulta agendada com sucesso.");
    }

    public void listarConsultasAgendadas(){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.forEach((dateTime, consultavel01) -> System.out.println("Horário:"+dateTime+" |Dados:"+consultavel01));
    }

    public void listarConsultasAgendadas2(){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.entrySet().forEach(System.out::println);
    }


    public void pesquisaPorData(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.entrySet().stream()
                .filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Consulta não encontrada."));
    }

    public void removerConsulta(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        boolean consultaEncontrada = registroConsultas.entrySet()
                .removeIf(consulta -> consulta.getKey().equals(horario));
        if (!consultaEncontrada){
            System.out.println("Consulta não encontrada.");
            return;
        }
        System.out.println(consultaEncontrada);
        System.out.println("Produto removido com sucesso.");
    }

    public void removerConsulta2(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.entrySet().stream()
                .filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(horarioConsulta -> {
                    registroConsultas.remove(horario);
                    System.out.println("Consulta cancelada com sucesso.");
                }, () -> System.out.println("Consulta não encontrada."));
    }

    public void removerConsulta3(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        if (registroConsultas.containsKey(horario)){
            registroConsultas.remove(horario);
            System.out.println("Consulta removida com sucesso.");
            return;
        }
        System.out.println("Consulta não encontrada.");
    }


    public boolean consultaJaExiste(Consultavel01 consultavel01){
        return registroConsultas.containsKey(consultavel01.getDataHora());
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return registroConsultas.higherEntry(LocalDateTime.now());
    }

    public void proximasConsultas(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.headMap(horario,false)
                .entrySet().forEach(System.out::println);
    }

    public void consultasAnteriores(LocalDateTime horario){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        registroConsultas.tailMap(horario,false)
                .entrySet().forEach(System.out::println);
    }

}
