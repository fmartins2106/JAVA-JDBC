package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.DataHoraCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.MedicoCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.PacienteCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.ValorConsultaCadastro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ValidadoresConsulta02 {

    public static void validacaoPaciente(String paciente){
        if (paciente == null || paciente.isEmpty() || !paciente.matches("^\\p{L}+( \\p{L}+)+$")){
            throw new PacienteCadastroConsulta();
        }
    }

    public static void validacaoMedico(String medico){
        if (medico == null || medico.isEmpty() || !medico.matches("^\\p{L}+( \\p{L}+)+$")){
            throw new MedicoCadastroConsulta();
        }
    }

    public static void validacaoEspecialidade(String especialidade){
        if (especialidade == null || especialidade.isEmpty() || !especialidade.matches("^\\p{L}+( \\p{L}+)+$")){
            throw new MedicoCadastroConsulta();
        }
    }

    public static void validacaoValor(BigDecimal valorConsulta){
        if (valorConsulta.compareTo(ValorConsultaCadastro.MENOR_VALOR)< 0){
            throw new ValorConsultaCadastro();
        }
    }

    public static void validacaoDataHora(LocalDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(LocalDateTime.now())){
            throw new DataHoraCadastroConsulta();
        }
    }

}
