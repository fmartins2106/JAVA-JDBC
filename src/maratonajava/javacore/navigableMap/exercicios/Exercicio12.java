package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio12 {
    public final NavigableMap<LocalDateTime, Consultavel01> consultasCadastradas = new TreeMap<>();

    public boolean registrarConsultaSistema(LocalDateTime horario, Consultavel01 consultavel01){
        return consultasCadastradas.putIfAbsent(horario,consultavel01) == null;
    }

    public void regitrarConsulta2(Consultavel01 consultavel01){
        boolean consulta = consultasCadastradas.putIfAbsent(consultavel01.getDataHora(),consultavel01) == null;
        if (!consulta){
            System.out.println("Consulta registrada com sucesso.");
            return;
        }
        System.out.println("Horário indisponível. Tente novaente.");
    }

    public void registroConsutal3(Consultavel01 consultavel01){
        if (consultasCadastradas.containsKey(consultavel01.getDataHora())){
            System.out.println("Horário indisponível. Tente novamente.");
            return;
        }
        consultasCadastradas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta registrada com sucesso.");
    }

    public void listarConsultasAgendadas(Consultavel01 consultavel01){
        if (consultasCadastradas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        consultasCadastradas.forEach((dataHora,dadosConsulta) -> System.out.println("Data e hora:"+dataHora+" |Dados consulta:"+
                dadosConsulta));
    }

    public void listarConsultasAgendadas(){
        if (consultasCadastradas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        consultasCadastradas.entrySet().forEach(System.out::println);
    }

    public void pesquisaPorData(LocalDateTime dataHora){
        if (consultasCadastradas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        consultasCadastradas.entrySet().stream()
                .filter(consulta -> consulta.getKey().equals(dataHora))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Consulta não encontrada."));
    }

    public void removerConsulta(LocalDateTime dataHora){
        if (consultasCadastradas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        boolean consultaEncontrada = consultasCadastradas.entrySet().removeIf(consulta -> consulta.getKey().equals(dataHora));
        if (!consultaEncontrada){
            System.out.println("Consulta não encontrada.");
            return;
        }
        System.out.println("Consulta removida com sucesso.");
    }

    public void consultaJaExiste(LocalDateTime horario){
        if (consultasCadastradas.isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        if (consultasCadastradas.containsKey(horario)){
            System.out.println("Consulta já cadastrada.");
            return;
        }
        System.out.println("Horário disponível:"+horario);
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return consultasCadastradas.higherEntry(LocalDateTime.now());
    }

    public void proximasConsultas(LocalDateTime horario){
        consultasCadastradas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println("Data e Hora:"+dateTime+" |Dados:"+consultavel01));
    }

    public void consultasAnteriores(LocalDateTime horario){
        consultasCadastradas.tailMap(horario,false)
                .forEach(((dateTime, consultavel01) -> System.out.println("Data e hora:"+dateTime+" |Dados:"+consultavel01)));
    }

    public void proximasConsultas2(LocalDateTime horario){
        consultasCadastradas.headMap(horario,false)
                .entrySet().forEach(System.out::println);
    }

    public void consultasAnteriores2(LocalDateTime horario){
        consultasCadastradas.tailMap(horario,false)
                .entrySet().forEach(System.out::println);
    }



}
