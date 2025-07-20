package academy.devdojo.maratonajava.javacore.navigableMap.dominio;

import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.DataHoraCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.EspecialidadeCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.MedicoCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.PacienteCadastroConsulta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CadastroConsulta01 implements Consultavel01{
    private String paciente;
    private String medico;
    private String especialidade;
    private LocalDateTime dataHora;

    public CadastroConsulta01(String paciente, String medico, String especialidade, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
        this.dataHora = dataHora;
    }

    public static void validacaoPaciente(String paciente){
        if (paciente ==  null || paciente.isEmpty() || !paciente.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new PacienteCadastroConsulta();
        }
    }

    public static void validacaoMedico(String medico){
        if (medico ==  null || medico.isEmpty() || !medico.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new MedicoCadastroConsulta();
        }
    }

    public static void validacaoEspecialidade(String especialidade){
        if (especialidade == null || especialidade.isEmpty() || !especialidade.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new EspecialidadeCadastroConsulta();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.toLowerCase().split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHora(LocalDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(LocalDateTime.now())){
            throw new DataHoraCadastroConsulta();
        }
    }

    @Override
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        validacaoPaciente(paciente);
        this.paciente = formatoString(paciente);
    }

    @Override
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        validacaoMedico(medico);
        this.medico = formatoString(medico);
    }

    @Override
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        validacaoEspecialidade(especialidade);
        this.especialidade = formatoString(especialidade);
    }

    @Override
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        validacaoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    private static final DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    @Override
    public String toString(){
        return String.format("Paciente:"+this.paciente+" |Médico:"+this.medico+" |Especialidade:"+this.especialidade+" |Data e Hora:"+
                this.dataHora.format(formatt));
    }
}
