package academy.devdojo.maratonajava.javacore.navigableMap.excessoes;

import academy.devdojo.maratonajava.javacore.designPatterns.dominio.FormatadorMonetario02;

import java.math.BigDecimal;

public class ValorConsultaCadastro extends IllegalArgumentException {
    public static final BigDecimal MENOR_VALOR = BigDecimal.ZERO;
    public ValorConsultaCadastro() {
        super(String.format("Valor da consulta não pode ser menor que R$"+ FormatadorMonetario02.formatar(MENOR_VALOR)));
    }
}
