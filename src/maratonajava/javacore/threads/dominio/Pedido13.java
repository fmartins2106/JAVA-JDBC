package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorDecimalPedido01;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pedido13 {
    public final int id;
    public final String cliente;
    public final BigDecimal valor;
    public static int contador = 1;

    public Pedido13(String cliente, BigDecimal valor) {
        synchronized (Pedido13.class){
            this.id = contador++;
            validacaoId(this.id);
            validacaoIdDuplicado(this.id);
            listaId.add(this.id);
        }
        this.cliente = cliente;
        this.valor = valor;
        validacaoCliente(this.cliente);
        valdiacaoValor(this.valor);

    }

    public static void validacaoId(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static Set<Integer> listaId = Collections.synchronizedSet(new HashSet<>());
    public static void validacaoIdDuplicado(int id){
        if (listaId.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L})*$")){
            throw new ValidacaoClientePedido01();
        }
    }

    public static void valdiacaoValor(BigDecimal valor){
        if (valor.compareTo(ValidacaoValorDecimalPedido01.MENOR_VALOR) < 0){
            throw new ValidacaoValorDecimalPedido01();
        }
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString(){
        return String.format("ID:#%d |Cliente:%s |Valor:R$%.2f",this.id,this.cliente,this.valor);
    }
}
