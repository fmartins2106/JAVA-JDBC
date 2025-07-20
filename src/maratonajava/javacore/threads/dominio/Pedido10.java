package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Pedido10 {
    public final String cliente;
    public final BigDecimal valor;
    public final int id;
    public static int contador = 1;

    public Pedido10(String cliente,BigDecimal valor) {
        synchronized (Pedido10.class){
            this.id = contador++;
            validacaoId(this.id);
            validacaoIdDuplicado(this.id);
        }
        this.valor = valor;
        this.cliente = cliente;
        validacaoCliente(this.cliente);
        validacaoValor(this.valor);
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ValidacaoClientePedido01();
        }
    }

    public static void validacaoValor(BigDecimal valor){
        if (valor.compareTo(ValidacaoValorDecimalPedido01.MENOR_VALOR) < 0){
            throw new ValidacaoValorDecimalPedido01();
        }
    }

    public static void validacaoId(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static Set<Integer> listaId = new HashSet<>();

    public static void validacaoIdDuplicado(int id){
        if (listaId.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("ID:%d |Cliente:%s |Valor:R$%.2f",this.id,this.cliente,this.valor);
    }

}
