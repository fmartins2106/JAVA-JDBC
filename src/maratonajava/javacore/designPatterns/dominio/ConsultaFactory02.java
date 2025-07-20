package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaFactory02 {
    public static CadastroConsulta02 criarConsulta(String paciente, String medico, String especialidade,
                                                   BigDecimal valorConsulta, LocalDateTime dataHora){
        return ConsultarBuilder02
                .aCadastroConsulta02()
                .paciente(paciente)
                .medico(medico)
                .especialidade(especialidade)
                .valorConsulta(valorConsulta)
                .dataHora(dataHora)
                .build();
    }
}
