package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca09 extends Conta09{
    public ContaPoupanca09(Cliente09 cliente09, int numeroConta, double saldo, Cliente09.TipoContas tipoContas, Cliente09.StatusContas statusContas) {
        super(cliente09, numeroConta, saldo, tipoContas, statusContas);
    }

    @Override
    public void saque(double valor){
        if (statusContas == Cliente09.StatusContas.ATIVA){
            if (valor <= saldo){
                saldo-= valor;
                System.out.println("Saque no valor de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println(Cliente09.ErroMensagens.ERRO_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente09.ErroMensagens.ERRO_DEPOSITO.getDescricao());
        }
    }
}
