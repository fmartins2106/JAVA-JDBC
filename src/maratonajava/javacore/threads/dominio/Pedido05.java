package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

import java.util.HashSet;
import java.util.Set;

public class Pedido05 {
    public static int contador = 1;
    public final String cliente;
    public final double valor;
    public final int id;

    public Pedido05(String cliente, double valor) {
        synchronized (Pedido05.class){
            this.id = contador ++;
            validacaoId(this.id);
            listaID.add(this.id);
        }
        this.valor = valor;
        this.cliente = cliente;
        validacaoValor(this.valor);
        validacaoCliente(this.getCliente());
    }

    public static void validacaoId(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static Set<Integer> listaID = new HashSet<>();

    public static void validacaoIdDuplicado(int id){
        if (listaID.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < ValidacaoValorPedido01.MENOR_VALOR_PRODUTO){
            throw new ValidacaoValorPedido01();
        }
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ValidacaoClientePedido01();
        }
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("ID:"+this.id+" |Cliente:"+this.cliente+" |Valor:R$"+this.valor);
    }

}
