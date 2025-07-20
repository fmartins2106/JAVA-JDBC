package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;




import java.util.Scanner;

public class Produto05 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto05(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio ou conter caracteres. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<0 || valor >10000){
            throw new IllegalArgumentException("ERRO. Valor não pode ser menor que 0 ou maior que 10000. Tente novamente.");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}+( [\\p{L}])+]*$")){
            throw new IllegalArgumentException("Campo categoria não pode ser vazio ou conter caracteres. Tente novamente.");
        }
        this.categoria = formatoNome(categoria);
    }

    public static String validandoNomeProduto(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("ERRO. Campo nome não pode conter caracteres. Tente novamente.");
                }else {
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoValorProduto(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor>10000){
                    System.out.println("Valor deve ser maior que zero e menor que R$10.000,00");
                }else {
                    return valor;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:" +e.getMessage());
            }
        }
    }
    public static String validandoCategoriaProduto(Scanner scanner){
        while (true){
            System.out.print("Digite a categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty()){
                System.out.println("ERRO. Campo não pode ficar vazio. Tente novamente.");
            }else {
                if (!categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("Não utilize caracteres. Tente novamente.");
                }else {
                    return formatoNome(categoria);
                }
            }
        }
    }
    public void listarProdutos(int index, int produto05s){
        if (index==0){
            for (int n = 0; n < 50; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-20s %-8s %-15s\n","No","Nome","Valor","Categoria");
            for (int n = 0; n < 50; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-20s R$%-8.2f %-15s\n",index,getNome(),getValor(),getCategoria());
        if (index==produto05s-1){
            for (int n = 0; n < 50; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    @Override
    public Produto05 clone(){
        try {
            return (Produto05) super.clone();
        }catch (CloneNotSupportedException erro){
            throw new AssertionError("Clonagem não suportada.");
        }
    }


    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
