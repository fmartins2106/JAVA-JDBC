package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Optional;

public interface ConsultaRepository02 {
    void salvar(Consultavel02 consultavel02);
    void remover(LocalDateTime horario);
    boolean existe(LocalDateTime horario);
    Optional<Map.Entry<LocalDateTime,Consultavel02>> proxima();
    NavigableMap<LocalDateTime,Consultavel02> listarTodas();
    Optional<Consultavel02> buscarPorHorario(LocalDateTime horario);
    void atualizar(LocalDateTime horario,Consultavel02 novaConsulta);
}
