package academy.devdojo.maratonajava.javacore.navigableMap.dominio;

import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.DataHoraCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.EspecialidadeCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.MedicoCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.PacienteCadastroConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendaConsulta01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ConsultaLogger01.getLogger(AgendaConsulta01.class);
    private NavigableMap<LocalDateTime,Consultavel01> registroConsultas = new TreeMap<>();

    public static String validandoPaciente(){
        while (true){
            try {
                System.out.print("Paciente:");
                String paciente = scanner.nextLine().trim();
                CadastroConsulta01.validacaoPaciente(paciente);
                return paciente;
            }catch (PacienteCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negocio"+e.getMessage());
            }
        }
    }

    public static String validandoMedico(){
        while (true){
            try {
                System.out.print("Médico:");
                String medico = scanner.nextLine().trim();
                CadastroConsulta01.validacaoMedico(medico);
                return medico;
            }catch (MedicoCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negocio:"+e.getMessage());
            }
        }
    }

    public static String validandoEspecialidade(){
        while (true){
            try {
                System.out.print("Especialidade:");
                String especialidade = scanner.nextLine().trim();
                CadastroConsulta01.validacaoEspecialidade(especialidade);
                return especialidade;
            }catch (EspecialidadeCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negócio:"+e.getMessage());
            }
        }
    }

    public static LocalDateTime validandoDataHora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true){
            try {
                System.out.print("Data e hora (DD/MM/AAAA HH:mm):");
                String entrada = scanner.nextLine().trim();
                LocalDateTime dataHora = LocalDateTime.parse(entrada,formatter);
                CadastroConsulta01.validacaoDataHora(dataHora);
                return dataHora;
            }catch (DateTimeParseException e){
                System.out.println("Erro, Digite data e hora no formato:DD/MM/AAAA HH:mm");
                logger.log(Level.WARNING,"Erro no formato data ou hora:DD/MM/AAAA HH:mm"+e.getMessage());
            }catch (DataHoraCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro na data ou hora conforme regra de negocio."+e.getMessage());
            }
        }
    }

    public void agendar(Consultavel01 consultavel01){
        registroConsultas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    public void cancelar(LocalDateTime horario){
        registroConsultas.remove(horario);
        System.out.println("Consulta removida com sucesso.");
    }

    public boolean jaExiste(LocalDateTime dateTime){
        return registroConsultas.containsKey(dateTime);
    }

    public Map.Entry<LocalDateTime,Consultavel01> proximasConsulta(){
        return registroConsultas.higherEntry(LocalDateTime.now());
    }

    public void listarTodos(){
        if (registroConsultas.isEmpty()){
            System.out.println("Nenhum registro.");
            return;
        }
        registroConsultas.forEach((dateTime, consultavel01) ->
                System.out.println("Data:"+dateTime+" |Consulta:"+consultavel01));
    }

    public void consultarAntes(LocalDateTime horario){
        registroConsultas.headMap(horario).forEach((k,v) ->
                System.out.println(v));
    }

    public void consultarDepois(LocalDateTime horario){
        registroConsultas.tailMap(horario,false).forEach((k,v) ->
                System.out.println(v));
    }

    public NavigableMap<LocalDateTime, Consultavel01> getRegistroConsultas() {
        return registroConsultas;
    }

    //iniciando treinamento parte 2

//    public void addConsultaSistema(Consultavel01 consultavel01){
//        registroConsultas.put(consultavel01.getDataHora(),consultavel01);
//        System.out.println("Consulta agendada com sucesso.");
//    }
//
//    public void removerConsulta(LocalDateTime horario){
//        registroConsultas.remove(horario);
//        System.out.println("Consulta cancelada com sucesso.");
//    }
//
//    public void listarConsultas(){
//        if (registroConsultas.isEmpty()){
//            System.out.println("Nenhuma consulta agendada.");
//            return;
//        }
//        registroConsultas.forEach((dateTime, consultavel01) -> System.out.println("Data:"+dateTime+"|Dados consulta:"+consultavel01));
//    }
//
//    public boolean jaExiste(LocalDateTime horario){
//        return registroConsultas.containsKey(horario);
//    }
//
//    public Map<LocalDateTime,Consultavel01> getRegistroConsulta(){
//        return registroConsultas;
//    }
//
//    public Map<LocalDateTime,Consultavel01> proximasConsultas(){
//        return registroConsultas.higherEntry(LocalDateTime.now());
//    }
//
//    public void ConsultarAntes(LocalDateTime horario){
//        registroConsultas.headMap(horario,true)
//                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
//    }
//
//    public void consultarDepois(LocalDateTime horario){
//        registroConsultas.tailMap(horario,true)
//                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
//    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       //finalizando terinamento parte 2
}
