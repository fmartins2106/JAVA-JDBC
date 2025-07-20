package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.Scanner;

public class Estoque17 {
    private List<Produto17> produto17s;

    public Estoque17(){
        this.produto17s = new ArrayList<>();
    }

    public void addProduto(Produto17 produto17){
        produto17s.add(produto17);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto17>produto17s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código não pode ser menor que 1.");
                }else {
                    if (produto17s.stream().anyMatch(p-> p.getCodigo() == codigo)){
                        System.out.println("Código já existe.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio, conter caracteres ou ter somente o primeiro nome.");
            }else {
                return Produto17.formatoNome(nome);
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ficar vazio ou conter caracteres.");
            }else {
                return Produto17.formatoNome(categoria);
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor precisa ser maior que zero e menor que R$10.000,00");
                }else {
                    return valor;
                }
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
                }else {
                    return quantidade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                }else {
                    return estoqueMinimo;
                }
            }catch (NumberFormatException e){
                System.out.println("Estoque mínimo não pode ser menor que 50.");
            }
        }
    }
    public void listarProdutos(){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto17s.forEach(System.out::println);
        }
    }
    public void alterandoProdutos(Scanner scanner){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto17 produto17 = produto17s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto17 != null){
                    produto17.setNome(validandoNome(scanner));
                    produto17.setCategoria(validandoCategoria(scanner));
                    produto17.setValor(validandoValor(scanner));
                    produto17.setQuantidade(validandoQuantidade(scanner));
                    produto17.setEstoquMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public void excluirProduto(Scanner scanner){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto17 produto17 = produto17s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto17 != null){
                    produto17s.remove(produto17);
                }else {
                    System.out.println("Produto não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listarProdutosEstoqueBaixo(Scanner scanner){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean estoqueBaixou = false;
            for (Produto17 produto17 : produto17s){
                if (produto17.validandoEstoqueMinimo()){
                    System.out.println(produto17);
                    estoqueBaixou = true;
                }
            }
            System.out.println("Não temos produtos com estoque abaixo do mínimo.");
        }
    }
    public void pesquisaProdutoPorNome(Scanner scanner){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            Produto17 produto17 = produto17s.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
            if (produto17 != null){
                System.out.println("______________________________________________________");
                System.out.println("Código:"+produto17.getCodigo());
                System.out.println("Nome:"+produto17.getNome());
                System.out.println("Categoria:"+produto17.getCategoria());
                System.out.println("Valor:R$"+produto17.getValor());
                System.out.println("Quantidade:"+produto17.getQuantidade());
                System.out.println("Estoque mínimo:"+produto17.getEstoquMinimo());
                System.out.println("______________________________________________________");
            }else {
                System.out.println("Produto não encontrado.");
            }

        }
    }

    public List<Produto17> getProduto17s() {
        return produto17s;
    }

    public void setProduto17s(List<Produto17> produto17s) {
        this.produto17s = produto17s;
    }
}
