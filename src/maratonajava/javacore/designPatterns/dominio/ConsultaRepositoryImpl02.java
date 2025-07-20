package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.time.LocalDateTime;
import java.util.*;

public class ConsultaRepositoryImpl02 implements ConsultaRepository02 {
    private final NavigableMap<LocalDateTime,Consultavel02> consultas = new TreeMap<>();

    @Override
    public void salvar(Consultavel02 consultavel02) {
        Objects.requireNonNull(consultavel02,"Consulta não pode ser nula");
        Objects.requireNonNull(consultavel02.getDataHora(),"Data e hora da consulta não podem ser nulas.");
        Consultavel02 consultaExistente = consultas.putIfAbsent(consultavel02.getDataHora(),consultavel02);
        if (consultaExistente != null){
            throw new IllegalArgumentException("Já existe uma consulta para este horário:"+consultavel02.getDataHora());
        }

    }

    @Override
    public void remover(LocalDateTime horario) {
        Objects.requireNonNull(horario,"Horário para remoção não pode ser nulo.");
        Consultavel02 removed = consultas.remove(horario);
        if (removed == null){
            throw new NoSuchElementException("Consulta não encontrada para o horário."+horario);
        }
    }

    @Override
    public boolean existe(LocalDateTime horario) {
        Objects.requireNonNull(horario,"Horário não pode ser nulo.");
        return consultas.containsKey(horario);
    }

    @Override
    public Optional<Map.Entry<LocalDateTime, Consultavel02>> proxima() {
        return Optional.ofNullable(consultas.higherEntry(LocalDateTime.now()));
    }

    @Override
    public NavigableMap<LocalDateTime, Consultavel02> listarTodas() {
        return Collections.unmodifiableNavigableMap(new TreeMap<>(consultas));
    }

    @Override
    public Optional<Consultavel02> buscarPorHorario(LocalDateTime horario) {
        Objects.requireNonNull(horario,"Horário não pode ser nulo");
        return Optional.ofNullable(consultas.get(horario));
    }

    @Override
    public void atualizar(LocalDateTime horario, Consultavel02 novaConsulta) {
        Objects.requireNonNull(horario,"Horário não pode ser nulo.");
        Objects.requireNonNull(novaConsulta,"Consulta nova não pode ser nula.");
        if (!consultas.containsKey(horario)) {
            throw new NoSuchElementException("Consulta não encontrada para o horário: " + horario);
        }
        consultas.put(horario, novaConsulta);
    }
}
