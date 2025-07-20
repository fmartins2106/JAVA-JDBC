package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque20 {
    private List<Produto20> produto20s;

    public Estoque20(){
        this.produto20s = new ArrayList<>();
    }

    public void addProdutoLista(Produto20 produto20){
        produto20s.add(produto20);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto20> produto20s){
        while (true){
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código precisa ser maior que 0.");
                    continue;
                }
                if (produto20s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código já existente, tente novamente.");
                }else {
                    return codigo;
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
            return Produto20.formatoNome(nome);
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
            return Produto20.formatoNome(categoria);
        }
    }

    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Valor precisa ser maior que zero  e menor que R$10.000,00");
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
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaProdutos(){
        if (produto20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto20s.forEach(System.out::println);
        }
    }

    public void alterarDadosProduto(Scanner scanner){
        if (produto20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto20 produto20 = produto20s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto20 != null){
                    produto20.setNome(validandoNome(scanner));
                    produto20.setCategoria(validandoCategoria(scanner));
                    produto20.setValor(validandoValor(scanner));
                    produto20.setQuantidade(validandoQuantidade(scanner));
                    produto20.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Código inexistente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProdutoLista(Scanner scanner){
        if (produto20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto20 produto20 = produto20s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto20 !=null){
                    produto20s.remove(produto20);
                }else {
                    System.out.println("Código inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void produtosEstoqueAbaixoMinimo(){
        if (produto20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean encontrado = false;
            for (Produto20 produto20 : produto20s){
                if (produto20.validandoEstoqueMinimo()){
                    System.out.println(produto20);
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Não tem produtos com estoque abaixo do mínimo.");
            }
        }
    }

    public void pesquisaPorNome(Scanner scanner){
        if (produto20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            Produto20 produto20 = produto20s.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
            if (produto20 != null){
                System.out.println("_______________________________");
                System.out.println("Código:"+produto20.getCodigo());
                System.out.println("Nome:"+produto20.getNome());
                System.out.println("Categoria:"+produto20.getCategoria());
                System.out.println("Valor:"+produto20.getValor());
                System.out.println("Quantidade:" +produto20.getQuantidade());
                System.out.println("Estoque mínimo:"+produto20.getEstoqueMinimo());
            }else {
                System.out.println("Nome não cadastrado. Tente novamente.");
            }
        }
    }

    public List<Produto20> getProduto20s() {
        return produto20s;
    }

    public void setProduto20s(List<Produto20> produto20s) {
        this.produto20s = produto20s;
    }
}
