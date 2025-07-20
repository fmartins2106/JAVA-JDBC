package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque18 {
    private List<Produto18> produto18s;

    public Estoque18(){
        this.produto18s = new ArrayList<>();
    }
    public void addProduto(Produto18 produto18){
        produto18s.add(produto18);
    }
    public static int validandoCodigo(Scanner scanner, List<Produto18> produto18s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Digite um código maior que 1.");
                }else {
                    if (produto18s.stream().anyMatch(p-> p.getCodigo() == codigo)){
                        System.out.println("Código já cadastrado. Tente outro.");
                    }else{
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite o nome completo sem uso de caracateres.");
            }else {
                return Produto18.formatoNome(nome);
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ser vazio ou conter caracteres.");
            }else {
                return Produto18.formatoNome(categoria);
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor não pode ser menor que zero e maior que R$10.000,00");
                    continue;
                }
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < 0){
                    System.out.println("Quantidade não pode ser menor que zero.");
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoquMinimo = Integer.parseInt(scanner.nextLine());
                if (estoquMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menro que 50.");
                    continue;
                }
                return estoquMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listarProdutos(){
        if (produto18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto18s.forEach(System.out::println);
        }
    }
    public void alterarDadosProduto(Scanner scanner){
        if (produto18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto18 produto18 = produto18s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto18 != null){
                    produto18.setNome(validandoNome(scanner));
                    produto18.setCategoria(validandoCategoria(scanner));
                    produto18.setValor(validandoValor(scanner));
                    produto18.setQuantidade(validandoQuantidade(scanner));
                    produto18.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Códido inexistente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirProdutos(Scanner scanner){
        if (produto18s.isEmpty()){
            System.out.println("Digite um valor válido.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto18 produto18 = produto18s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if ( produto18 != null){
                    produto18s.remove(produto18);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listaEstoqueAbaixoMinimo(){
        if (produto18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean estoqueBaixo = false;
            for (Produto18 produto18 : produto18s){
                if (produto18.validandoEstoqueMinimo()){
                    System.out.println(produto18);
                    estoqueBaixo = true;
                }
            }
            if (!estoqueBaixo){
                System.out.println("Não tem produtos com estoque abaixo do mínimo.");
            }
        }
    }
    public void pesquisaPorNome(Scanner scanner){
        if (produto18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            Produto18 produto18 = produto18s.stream().filter(p-> p.getNome().equals(nome)).findFirst().orElse(null);
            if (produto18 != null){
                System.out.println("Código:"+produto18.getCodigo());
                System.out.println("Nome:"+produto18.getNome());
                System.out.println("Categoria:"+produto18.getCategoria());
                System.out.println("Valor:R$"+produto18.getValor());
                System.out.println("Quantidade:"+produto18.getQuantidade());
                System.out.println("Estoque mínimo:"+produto18.getEstoqueMinimo());
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Produto18> getProduto18s() {
        return produto18s;
    }

    public void setProduto18s(List<Produto18> produto18s) {
        this.produto18s = produto18s;
    }
}
