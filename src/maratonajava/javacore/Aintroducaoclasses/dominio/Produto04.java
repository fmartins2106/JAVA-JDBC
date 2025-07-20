package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Produto04 {
    private String nome;
    private double valor;
    private int quantidade;

    public Produto04(String nome, double valor, int quantidade){
        setNome(nome);
        setValor(valor);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome ==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Nome não pode ser nulo, vazio ou conter caracteres. Tente novamente.");
        }
        this.nome = verificandoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<=0 || valor>=10000.01){
            throw new IllegalArgumentException("ERRO. Valor deve ser maior que 0 e menor que 10.000");
        }
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade<=-1){
            throw new IllegalArgumentException("Quantidade não pode ser negativo. Tente novamente.");
        }
        this.quantidade = quantidade;
    }
    public void resultadoEtoqueProdutos(int index, int produto04s){
        if (index==0){
            for (int n=0;n<50;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-8s\n","No","Nome","Quantidade","Valor");
            for (int n=0;n<50;n++){
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4s %-25s %-8d %-8.2f\n",index,getNome(),getQuantidade(),getValor());
        if (index == produto04s -1){
            for (int n=0;n<50;n++){
                System.out.print("=");
            }
            System.out.println();
        }

    }


    private static String verificandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append("  ");
        }
        return nomeFormatado.toString().trim();
    }
}
