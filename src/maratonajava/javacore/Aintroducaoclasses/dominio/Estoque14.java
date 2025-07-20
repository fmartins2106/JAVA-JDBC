package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque14 {
    private List<Produto14> produto14s;

    public Estoque14(){
        this.produto14s = new ArrayList<>();
    }
    public void addProdutosEstoque(Produto14 produto14){
        produto14s.add(produto14);
    }

    public void listarProdutos(){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto14s.forEach(System.out::println);
        }
    }
    public void buscaPorCodigoProduto(Scanner scanner){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            int codigo = 0;
            try {
                System.out.print("Digite o código do produto.");
                codigo = Integer.parseInt(scanner.nextLine());
                boolean codigoEncontrado = false;
                for (Produto14 produto14 : produto14s){
                    if (produto14.getCodigo()==codigo){
                        for (int i = 0; i < 60; i++) {
                            System.out.print("=");
                        }
                        System.out.println();
                        System.out.println("Código:"+produto14.getCodigo());
                        System.out.println("Nome:"+produto14.getNome());
                        System.out.println("Categoria:"+produto14.getCategoria());
                        System.out.println("Quantidade:"+produto14.getQuantidade());
                        System.out.println("Estoque mínimo:"+produto14.getEstoqueMinimo());
                        codigoEncontrado = true;
                        for (int i = 0; i < 60; i++) {
                            System.out.print("=");
                        }
                        System.out.println();
                    }
                }
                if (!codigoEncontrado){
                    System.out.println("Produto não encontrado.");
                }

            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }
    public static int validandoCodigo(Scanner scanner, List<Produto14> produto14s){
        while (true){
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 0 ){
                    System.out.println("Código precisa ser maior que zero.");
                    continue;
                }
                boolean codigoExiste = produto14s.stream().anyMatch(p-> p.getCodigo() == codigo);
                if (codigoExiste){
                    System.out.println("Código já existe, tente outro.");
                }else {
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valo válido.");
            }
        }
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite seu nome completo sem caracteres.");
                continue;
            }
            return Produto14.formatoNome(nome);
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Produto14.formatoNome(categoria);
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor não pode ser menor que zero ou maior que R$10.000,00");
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
                if (quantidade < 0 ){
                    System.out.println("Quantidade não pode ser menor que zero.");
                    continue;
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
                int estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50 ){
                    System.out.println("Estoque mínimo precisa ser maior que 50.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void atualizarValores(Scanner scanner){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto14 produto14 = produto14s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto14 != null){
                    produto14.setNome(validandoNome(scanner));
                    produto14.setCategoria(validandoCategoria(scanner));
                    produto14.setValor(validandoValor(scanner));
                    produto14.setQuantidade(validandoQuantidade(scanner));
                    produto14.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Código inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirProduto(Scanner scanner){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto14 produto14 = produto14s.stream().filter(p-> p.getCodigo()== codigo).findFirst().orElse(null);
                if (produto14 != null){
                    produto14s.remove(produto14);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listarProdutosBaixoEstoque(){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean encontro = false;
            for (Produto14 produto14 : produto14s){
                if (produto14.estoqueBaixo()){
                    System.out.println(produto14);
                    encontro = true;
                }
            }
            if (!encontro){
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public List<Produto14> getProduto14s() {
        return produto14s;
    }

    public void setProduto14s(List<Produto14> produto14s) {
        this.produto14s = produto14s;
    }
}
