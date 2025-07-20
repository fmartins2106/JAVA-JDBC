package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio08 {
    private final NavigableMap<LocalDateTime, Consultavel01> consultasRegistradas = new TreeMap<>();

    private boolean addConsultaSistema(Consultavel01 consultavel01){
        return consultasRegistradas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
    }

    private void addConsulta(Consultavel01 consultavel01){
        boolean addConsulta = consultasRegistradas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
        if (!addConsulta){
            System.out.println("Horário indisponível. Verifique agenda.");
            return;
        }
        System.out.println("Consulta agendada com sucesso para:"+consultavel01.getDataHora());
    }

    private void addCOnsulta(Consultavel01 consultavel01){
        if (consultasRegistradas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível. Verifique agenda.");
            return;
        }
        consultasRegistradas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso:"+consultavel01);
    }

    private void listarAgendaConsultas(){
        if (consultasRegistradas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada.");
            return;
        }
        consultasRegistradas.forEach((dateTime, consultavel01) -> System.out.println("Data hora:"+dateTime+" |Dados consulta:"+consultavel01));
    }


    private void pesquisaPorData(LocalDateTime horario){
        consultasRegistradas
                .entrySet()
                .stream()
                .filter(horaData -> horaData.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Não há consulta para essa data."));
    }

    private void removerConsultaSistema(LocalDateTime horario){
        if (consultasRegistradas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada até o momento.");
            return;
        }
        boolean consultaRemovida = consultasRegistradas
                .entrySet().removeIf(dataHora -> dataHora.getKey().equals(horario));
        if (consultaRemovida){
            System.out.println("Consulta removida com sucesso.");
            return;
        }
        System.out.println("Consulta não encontrada. Verifique o horário.");
    }

    private void removerConsulta2(LocalDateTime horario){
        if (consultasRegistradas.isEmpty()){
            System.out.println("Nenhuma consulta foi agendada até o momento.");
            return;
        }
        consultasRegistradas
                .entrySet()
                .stream()
                .filter(consulta -> consulta.getKey().equals(horario))
                .findFirst()
                .ifPresentOrElse(consuta ->{
                    consultasRegistradas.remove(consuta.getKey(),consuta.getValue());
                    System.out.println("Consulta removida com sucesso.");
                        }, () -> System.out.println("Consulta não encontrada."));
    }

    public boolean consultaJaexiste(LocalDateTime horario){
        return consultasRegistradas.containsKey(horario);
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return consultasRegistradas.higherEntry(LocalDateTime.now());
    }

    public void proximasConsultas(LocalDateTime horario){
        consultasRegistradas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println("Horário:"+dateTime+" |Dados:"+consultavel01));
    }

    public void consultaAnteriores(LocalDateTime horario){
        consultasRegistradas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println());
    }
}
