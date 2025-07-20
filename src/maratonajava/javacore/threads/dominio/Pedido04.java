package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

import java.util.HashSet;
import java.util.Set;

public class Pedido04 {
    public static int contador = 1;
    public final String cliente;
    public final double valor;
    public final int id;

    public Pedido04(String cliente, double valor) {
        synchronized (Pedido04.class){
            this.id = contador ++;
            validacaoIdDuplicado(this.id);
            listaID.add(this.id);
        }
        this.cliente = cliente;
        this.valor = valor;
        validacaoId(this.id);
        validacaoCliente(this.cliente);
        validacaoValor(this.valor);
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

    public int getContador() {
        return contador;
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
        return String.format("Pedido:# ID:[%d] |Cliente:%s |Valor:R$%.2f",
                this.id,this.cliente,this.valor);
    }

}
