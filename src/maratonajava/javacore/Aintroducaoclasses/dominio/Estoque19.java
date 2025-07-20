package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque19 {
    List<Produto19> produto19s;

    public Estoque19 (){
        this.produto19s = new ArrayList<>();
    }

    public void addProdutos(Produto19 produto19){
        produto19s.add(produto19);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto19> produto19s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código precisa ser maior que 1.");
                }else {
                    if (produto19s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                        System.out.println("Código já cadastrado, tente novamente.");
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
                System.out.println("Digite nome completo sem adição de caracteres.");
            }else {
                return Produto19.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria  = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Produto19.formatoNome(categoria);
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
                if (estoqueMinimo <50 ){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaDeProdutos(){
        if (produto19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto19s.forEach(System.out::println);
        }
    }

    public void alterarDadosProduto(Scanner scanner){
        if (produto19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                Produto19 produto19 = produto19s.stream().filter(p -> p.getCodigo() == matricula).findFirst().orElse(null);
                if (produto19 != null){
                    produto19.setNome(validandoNome(scanner));
                    produto19.setCategoria(validandoCategoria(scanner));
                    produto19.setValor(validandoValor(scanner));
                    produto19.setQuantidade(validandoQuantidade(scanner));
                    produto19.setEstoqueMinimo(validandoEstoqueMinimo(scanner));
                }else {
                    System.out.println("Matricula não encontrada.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirDadosProduto(Scanner scanner){
        if (produto19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                Produto19 produto19 = produto19s.stream().filter(p-> p.getCodigo() == matricula).findFirst().orElse(null);
                if (produto19 != null){
                    produto19s.remove(produto19);
                }else {
                    System.out.println("Matricula não encontrada.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaProdutosAbaixoMinimo(){
        if (produto19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean estoquebaixo = false;
            for (Produto19 produto19 : produto19s) {
                if (produto19.validandoEstoqueMinimo()) {
                    System.out.println(produto19);
                } else {
                    System.out.println("Não tem produtos com estoque abaixo do mínimo.");
                }
            }
        }
    }

    public void pesquisaPorCodigo(Scanner scanner){
        if (produto19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto19 produto19 = produto19s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if ( produto19 != null){
                    System.out.println("___________________________");
                    System.out.println("Nome:"+produto19.getNome());
                    System.out.println("Categoria:"+produto19.getCategoria());
                    System.out.println("Valor:R$"+produto19.getValor());
                    System.out.println("Quantidade:"+produto19.getQuantidade());
                    System.out.println("Estoque mínimo:"+produto19.getEstoqueMinimo());
                    System.out.println("________________________________________________");
                }else {
                    System.out.println("Matricula não encontrada.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public List<Produto19> getProduto19s() {
        return produto19s;
    }

    public void setProduto19s(List<Produto19> produto19s) {
        this.produto19s = produto19s;
    }
}
