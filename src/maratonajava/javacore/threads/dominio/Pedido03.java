package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

import java.util.HashSet;
import java.util.Set;

public class Pedido03 {
    public static int contador;
    public final String cliente;
    public final double valor;
    public final int id;

    public Pedido03(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
        this.id = contador++;
        validacaoId(this.id);
        validacaoIdDuplicado(this.id);
        validacaoValor(this.valor);
        validacaoCliente(this.cliente);
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ValidacaoClientePedido01();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < ValidacaoValorPedido01.MENOR_VALOR_PRODUTO){
            throw new ValidacaoValorPedido01();
        }
    }

    public static void validacaoId(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static Set<Integer> cadastroID = new HashSet<>();

    public static void validacaoIdDuplicado(int id){
        if (cadastroID.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }


    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString(){
        return String.format("[Pedido: ID:%d |Cliente:%s |Valor:R$%.2f",this.id,this.cliente,this.valor);
    }

}
