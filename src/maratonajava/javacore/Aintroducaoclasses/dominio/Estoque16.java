package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque16 {
    private List<Produto16>produto16s;

    public Estoque16(){
        this.produto16s = new ArrayList<>();
    }

    public void addProduto(Produto16 produto16){
        produto16s.add(produto16);
    }
    public static int validandoCodigo(Scanner scanner, List<Produto16> produto16s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Codigo precisa ser maior que zero.");
                }else {
                    boolean codigoExiste = produto16s.stream().anyMatch(p-> p.getCodigo() == codigo);
                    if (codigoExiste){
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
                System.out.println("Digite seu nome completo sem uso de caracateres.");
                continue;
            }
            return Produto16.formatoNome(nome);
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo não pode ser vazio ou conter caracteres");
                continue;
            }
            return Produto16.formatoNome(categoria);
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor não pode ser menor que zero ou maior que R$10.000,00.");
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
                if (quantidade < 0 ){
                    System.out.println("Valor precisa ser maior que zero.");
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
                if (estoqueMinimo <50){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listarProdutos(){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto16s.forEach(System.out::println);
        }
    }
    public void autualizarDadosProduto(Scanner scanner){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto16 produto16 = produto16s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto16 !=null){
                    produto16.setNome(validandoNome(scanner));
                    produto16.setCategoria(validandoCategoria(scanner));
                    produto16.setValor(validandoValor(scanner));
                    produto16.setQuantidade(validandoQuantidade(scanner));
                    produto16.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirDadosProduto(Scanner scanner){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto16 produto16 = produto16s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto16 !=null){
                    produto16s.remove(produto16);
                }else {
                    System.out.println("Produto não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listaProdutoEstoqueBaixo(){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Produto16 produto16 : produto16s){
                if (produto16.validandoEstoqueMinimo()){
                    System.out.println(produto16);
                }else {
                    System.out.println("Não temo produtos com estoque abaixo do mínimo.");
                }
            }
        }
    }
    public void pesquisaProdutoCodigo(Scanner scanner){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto16 produto16 = produto16s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto16 != null){
                    System.out.println("Nome:"+produto16.getNome());
                    System.out.println("Categoria:"+produto16.getCategoria());
                    System.out.println("Valor:R$"+produto16.getValor());
                    System.out.println("Quantidade:"+produto16.getQuantidade());
                    System.out.println("Estoque mínimo:"+produto16.getEstoqueMinimo());
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public List<Produto16> getProduto16s() {
        return produto16s;
    }

    public void setProduto16s(List<Produto16> produto16s) {
        this.produto16s = produto16s;
    }
}
