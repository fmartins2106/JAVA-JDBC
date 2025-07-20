//package academy.devdojo.maratonajava.introducao;
//
//import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro05;
//
//
//import java.util.Scanner;
//
//public class Livro06 {
//    private String titulo;
////    private String autor;
//    private double valor;
//    private int quantidade;
//
//    public Livro06(String titulo, String autor, double valor, int quantidade){
//        setTitulo(titulo);
//        setAutor(autor);
//        setValor(valor);
//        setQuantidade(quantidade);
//    }
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public void setTitulo(String titulo) {
//       if (titulo==null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
//           throw new IllegalArgumentException("ERRO. Campo título não pode ser vazio ou conter caracteres. Tente novamente.");
//       }
//        this.titulo = formatandoNomes(titulo);
//    }
//
//    public String getAutor() {
//        return autor;
//    }
//
//    public void setAutor(String autor) {
//        if (autor==null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
//            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio, não aceita caracteres. Digite nome completo;");
//        }
//        this.autor = formatandoNomes(autor);
//    }
//
//    public double getValor() {
//        return valor;
//    }
//
//    public void setValor(double valor) {
//        if (valor<0 || valor> 10000){
//            throw new IllegalArgumentException("ERRO. Valor precisa ser maior que zero e menor que R$10.000");
//        }
//        this.valor = valor;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(int quantidade) {
//        if (valor<0){
//            throw new IllegalArgumentException("ERRO. Valor não pode ser menor que zero. Tente novamente.");
//        }
//        this.quantidade = quantidade;
//    }
//
//    private static String formatandoNomes(String nome){
//        String[] palavras = nome.toLowerCase().split("\\+s");
//        StringBuilder nomeFormatado = new StringBuilder();
//        for (String palavra :palavras){
//            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
//        }
//        return nomeFormatado.toString().trim();
//    }
//    public static String verificandoTitulo(Scanner scanner){
//        while (true){
//            System.out.print("Título:");
//            String titulo = scanner.nextLine();
//            if (titulo.isEmpty()){
//                System.out.println("Campo não pode ser vazio. Tente novamente.");
//            }else {
//                if (!titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
//                    System.out.println("Campo titulo não aceita caracteres. Tente novamente.");
//                }else {
//                    return formatandoNomes(titulo);
//                }
//            }
//        }
//    }
//    public static String verificandoAutor(Scanner scanner){
//        while (true){
//            System.out.print("Autor:");
//            String autor = scanner.nextLine().trim();
//            if (autor.isEmpty()){
//                System.out.println("Campo não pode ser vazio. Tente novamente.");
//            }else {
//                if (!autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
//                    System.out.println("Digite o nome completo. Tente novamente.");
//                }else {
//                    return formatandoNomes(autor);
//                }
//            }
//        }
//    }
//    public static double verificandoValor(Scanner scanner){
//        while (true){
//            try {
//                System.out.print("Digite o valor:R$");
//                double valor = Double.parseDouble(scanner.nextLine());
//                if (valor<0 || valor >10000){
//                    System.out.println("Valor não pode ser menor que zero ou maior que R$10.000,00");
//                }else {
//                    return valor;
//                }
//            }catch (NumberFormatException erro){
//                System.out.println("ERRO:"+erro.getMessage());
//            }
//        }
//    }
//    public static int verificandoQuantidade(Scanner scanner){
//        while (true){
//            try {
//                System.out.print("Digite a quantidade:");
//                int quantidade = Integer.parseInt(scanner.nextLine());
//                if (quantidade<0){
//                    System.out.println("Quantidade não pode ser menor que zero. Tente novamente.");
//                }else {
//                    return quantidade;
//                }
//            }catch (NumberFormatException erro){
//                System.out.println("ERRO:"+erro.getMessage());
//            }
//        }
//    }
//    public void monstrandoTabelaLivros(int index, int libro06s){
//        if (index==0){
//            for (int n = 0; n < 80; n++) {
//                System.out.print("=");
//            }
//            System.out.println();
//            System.out.printf("%-4s %-25s %-25s %-8s %-8s%n","No","Título","Autor","Valor","Quantidade");
//            for (int n = 0; n < 80; n++) {
//                System.out.print("=");
//            }
//            System.out.println();
//        }
//        System.out.printf("%-4d %-25s %-25s R$%-8.2f %-8d%n",index,getTitulo(),getAutor(),getValor(),getQuantidade());
//        if (index == libro06s-1){
//            for (int n = 0; n < 80; n++) {
//                System.out.print("=");
//            }
//            System.out.println();
//        }
//    }
//
//
//
//
//}
