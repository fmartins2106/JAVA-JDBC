package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

public class Pedido01 {
    private static int contador = 0;
    private final int id;
    private final String cliente;
    private final double valor;

    public Pedido01(String cliente, double valor) {
        this.id = ++contador;
        this.cliente = cliente;
        this.valor = valor;
    }

    public static void validacaoId(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L}+)+$")){
            throw new ValidacaoClientePedido01();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < ValidacaoValorPedido01.MENOR_VALOR_PRODUTO){
            throw new ValidacaoValorPedido01();
        }
    }


    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido01.contador = contador;
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
        return "Pedido #" + id + "[Cliente: "+cliente + ", Valor:R$"+valor+" ]";
    }
}
