package academy.devdojo.maratonajava.javacore.threads.dominio;

import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoClientePedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdDuplicado01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoIdPedido01;
import academy.devdojo.maratonajava.javacore.threads.validacao.ValidacaoValorPedido01;

import java.util.HashSet;
import java.util.Set;

public class Pedido02 {
    private  static int contador;
    private final  int id;
    private final String cliente;
    private final double valor;


    public Pedido02(String cliente, double valor) {
        this.id = contador++;
        this.cliente = cliente;
        this.valor = valor;
        validacaoID(this.id);
        validacaoCliente(this.cliente);
        validacaoValor(this.valor);
        listaID.add(this.id);
    }

    public static Set<Integer> listaID = new HashSet<>();

    public static void validacaoIdDuplicado(int id){
        if (listaID.contains(id)){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public static void validacaoID(int id){
        if (id < ValidacaoIdPedido01.ID_MINIMO){
            throw new ValidacaoIdPedido01();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < ValidacaoValorPedido01.MENOR_VALOR_PRODUTO){
            throw new ValidacaoIdDuplicado01();
        }
    }

    public static void validacaoCliente(String cliente){
        if (cliente == null || cliente.isEmpty() || !cliente.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ValidacaoClientePedido01();
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
        return String.format("Pedido:#[ID: %d |Cliente:%s |Valor:R$%.2f]",id,cliente,valor);
    }

}
