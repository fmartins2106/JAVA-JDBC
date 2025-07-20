package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

import java.util.HashSet;
import java.util.Set;

public class Pedido06 {
    public final int id;
    public final String cliente;
    public final double valor;
    public static int contador;

    public Pedido06(String cliente, double valor) {
        synchronized (Pedido06.class){
            this.id = contador ++;
            validacaoId(this.id);
            listaId.add(this.id);
        }
        this.cliente = cliente;
        this.valor = valor;
        validacaoCliente(this.cliente);
        validacaoValor(this.valor);
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
            throw new ValidacaoIdDuplicado01();
        }
    }

    public static Set<Integer> listaId = new HashSet<>();
    public static void validacaoIdDuplicado(int id){
        if (listaId.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString(){
        return String.format("ID:%d |Cliente:%s |Valor:R$%.2f",this.id,this.cliente,this.valor);
    }
}
