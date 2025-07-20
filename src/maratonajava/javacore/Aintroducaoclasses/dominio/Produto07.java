package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;



import java.util.Scanner;

public class Produto07 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto07(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite um valor válido. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<0 || valor >10000){
            throw new IllegalArgumentException("Valor não pode ser menor que zero ou maior que R$10.000,00");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Digite um valor válido, tente novamente.");
        }
        this.categoria = formatoNome(categoria);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formantandoNome = new StringBuilder();
        for (String palavra : palavras){
            formantandoNome.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return formantandoNome.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo nome não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("Digite uma opção válida. Tente novamente.");
                }else {
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor > 10000){
                    System.out.println("ERRO. Digite um valor válido. Tente novamente.");
                }else {
                    return valor;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
        }
    }
    public static String verificandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty()){
                System.out.println("ERRO. Campo não pode ficar vazio. Tente novamente.");
            }else {
                if (!categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("ERRO. Digite um valor válido. Tente novamente.");
                }else {
                    return categoria;
                }
            }
        }
    }

    public void exibindoResultados(int index, int produto07s){
        if (index ==0){
            for (int n = 0; n < 58; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-15s\n","No","Nome","Valor","Categoria");
            for (int n = 0; n < 58; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-8.2f %-15s\n",index,getNome(),getValor(),getCategoria());
        if (index==produto07s-1){
            for (int n = 0; n < 58; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    @Override
    public Produto07 clone(){
        try {
            return (Produto07) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("ERRO na clonagem.");
        }
    }


}
