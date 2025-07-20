package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Consultavel02 {
    String getPaciente();
    String getMedico();
    String getEspecialidade();
    BigDecimal getValorConsulta();
    LocalDateTime getDataHora();
}
