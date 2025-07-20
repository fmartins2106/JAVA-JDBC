package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque15 {
    private List<Produto15> produto15s;

    public Estoque15(){
        this.produto15s = new ArrayList<>();
    }

    public void addProdutos(Produto15 produto15){
        produto15s.add(produto15);
    }

    public static int validandoCodigo(Scanner scanner,List<Produto15> produto15s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código precisa ser maior ou igual a 1.");
                }else {
                    boolean codigoExiste = produto15s.stream().anyMatch(p-> p.getCodigo()== codigo);
                    if (codigoExiste){
                        System.out.println("Código não existe.");
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
                System.out.println("Digite seu nome completo sem adição de caracteres.");
                continue;
            }
            return Produto15.formatoNome(nome);
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
            return Produto15.formatoNome(categoria);
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor::R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor precisa ser maior que zero e menor que R$10.000,00");
                    continue;
                }
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < 0){
                    System.out.println("Quantidade precisa ser maior que zero.");
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
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor que 50 unidades.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }
        }
    }
    public void listandoProdutos(){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto15s.forEach(System.out::println);
        }
    }
    public void atualizarDadosProduto(Scanner scanner){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto15 produto15 = produto15s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto15 != null){
                    produto15.setNome(validandoNome(scanner));
                    produto15.setCategoria(validandoCategoria(scanner));
                    produto15.setValor(validandoValor(scanner));
                    produto15.setQuantidade(validandoQuantidade(scanner));
                    produto15.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Código inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public void excluirProduto(Scanner scanner){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o número do código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto15 produto15 = produto15s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto15 !=null){
                    produto15s.remove(produto15);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listarProdutosEstoqueBaixo(){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean estoqueBaixo = false;
            for (Produto15 produto15 : produto15s){
                if (produto15.validandoEstoqueBaixo()){
                    System.out.println(produto15);
                    estoqueBaixo = true;
                }
            }
            if (!estoqueBaixo){
                System.out.println("Não tem estoque com estoque baixo.");
            }
        }
    }
    public void pesquisaProdutoCodigo(Scanner scanner){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto15 produto15 = produto15s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto15 != null){
                    System.out.println("Nome:"+produto15.getNome());
                    System.out.println("Categoria:"+produto15.getCategoria());
                    System.out.println("Valor:R$"+produto15.getValor());
                    System.out.println("Quantidade:"+produto15.getQuantidade());
                    System.out.println("Estoque mínimo:"+produto15.getEstoqueMinimo());
                }else {
                    System.out.println("Produto não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public List<Produto15> getProduto15s() {
        return produto15s;
    }

    public void setProduto15s(List<Produto15> produto15s) {
        this.produto15s = produto15s;
    }
}
