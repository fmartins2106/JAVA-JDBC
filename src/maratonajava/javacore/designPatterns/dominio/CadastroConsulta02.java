package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastroConsulta02 implements Consultavel02{
    private String paciente;
    private String medico;
    private String especialidade;
    private BigDecimal valorConsulta;
    private LocalDateTime dataHora;

    public CadastroConsulta02(String paciente, String medico, String especialidade, BigDecimal valorConsulta, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
        this.valorConsulta = valorConsulta;
        this.dataHora = dataHora;
    }

    @Override
    public String getPaciente() {
        return paciente;
    }

    @Override
    public String getMedico() {
        return medico;
    }

    @Override
    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    @Override
    public LocalDateTime getDataHora() {
        return dataHora;
    }


//    comentario somente para teste do git hub
    @Override
    public String toString(){
        DateTimeFormatter dataHoraFormatada = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        return String.format("Paciente:%s |Médico:%s |Especialidade:%s |Valor da consulta:%s |Data da consulta:%s",
                this.paciente,this.medico,this.especialidade,FormatadorMonetario02.formatar(this.valorConsulta)
                ,this.dataHora.format(dataHoraFormatada));
    }


}
