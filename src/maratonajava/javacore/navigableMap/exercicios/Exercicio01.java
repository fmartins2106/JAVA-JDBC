package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.AgendaConsulta01;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.CadastroConsulta01;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.ConsultaLogger01;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.DataHoraCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.EspecialidadeCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.MedicoCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.PacienteCadastroConsulta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ConsultaLogger01.getLogger(AgendaConsulta01.class);
    private NavigableMap<LocalDateTime, Consultavel01> registroConsultas01 = new TreeMap<>();

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

    private void addConsulta(Consultavel01 consultavel01){
        registroConsultas01.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta Agendada com sucesso.");
    }

    private void cancelarConsulta(LocalDateTime horario){
        registroConsultas01.remove(horario);
        System.out.println("COnsulta cancelada.");
    }

    private boolean jaExiste(LocalDateTime dateTime){
        return registroConsultas01.containsKey(dateTime);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximasConsulta(){
        return registroConsultas01.higherEntry(LocalDateTime.now());
    }
    private void listarTodos(){
        if (registroConsultas01.isEmpty()){
            System.out.println("Nenhuma consulta foi registrada.");
            return;
        }
        registroConsultas01.forEach((horario,consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarAntes(LocalDateTime horario){
        registroConsultas01.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarDepois(LocalDateTime horario){
        registroConsultas01.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    public NavigableMap<LocalDateTime, Consultavel01> getRegistroConsultas01() {
        return registroConsultas01;
    }
}
