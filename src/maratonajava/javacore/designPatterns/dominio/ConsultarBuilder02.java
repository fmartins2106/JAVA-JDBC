package academy.devdojo.maratonajava.javacore.designPatterns.dominio;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultarBuilder02 {
    private String paciente;
    private String medico;
    private String especialidade;
    private BigDecimal valorConsulta;
    private LocalDateTime dataHora;

    private ConsultarBuilder02() {
    }

    public static ConsultarBuilder02 aCadastroConsulta02() {
        return new ConsultarBuilder02();
    }

    public ConsultarBuilder02 paciente(String paciente) {
        this.paciente = paciente;
        return this;
    }

    public ConsultarBuilder02 medico(String medico) {
        this.medico = medico;
        return this;
    }

    public ConsultarBuilder02 especialidade(String especialidade) {
        this.especialidade = especialidade;
        return this;
    }

    public ConsultarBuilder02 valorConsulta(BigDecimal valorConsulta) {
        this.valorConsulta = valorConsulta;
        return this;
    }

    public ConsultarBuilder02 dataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
        return this;
    }

    public CadastroConsulta02 build() {
        ValidadoresConsulta02.validacaoPaciente(paciente);
        ValidadoresConsulta02.validacaoMedico(medico);
        ValidadoresConsulta02.validacaoEspecialidade(especialidade);
        ValidadoresConsulta02.validacaoValor(valorConsulta);
        ValidadoresConsulta02.validacaoDataHora(dataHora);

        return new CadastroConsulta02(paciente, medico, especialidade, valorConsulta, dataHora);
    }
}