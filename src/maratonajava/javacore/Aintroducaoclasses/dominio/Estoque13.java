package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque13 {
    private List<Produto13> produto13s;

    public Estoque13(){
        this.produto13s = new ArrayList<>();
    }
    public void addEstoque(Produto13 produto13){
        produto13s.add(produto13);
    }
    public void listarProtudos(){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.println("\nLista de produtos:");
            produto13s.forEach(System.out::println);
        }
    }
    public void buscarProdutoPorCodigo(Scanner scanner){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código");
                int codigo = Integer.parseInt(scanner.nextLine());
                boolean encontrado = false;
                for (Produto13 produto13 : produto13s){
                    if (produto13.getCodigo()==codigo){
                        for (int i = 0; i < 60; i++) {
                            System.out.print("=");
                        }
                        System.out.println();
                        System.out.println("Nome:"+produto13.getNome());
                        System.out.println("Categoria:"+produto13.getCategoria());
                        System.out.println("Valor:R$"+produto13.getValor());
                        System.out.println("Quantidade:"+produto13.getQuantidadeEstoque());
                        encontrado = true;
                        for (int i = 0; i < 60; i++) {
                            System.out.print("=");
                        }
                        System.out.println();
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Diigte um valor válido.");
            }
            boolean encontrado = false;

            if (!encontrado){
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public static int validandoCodigo(Scanner scanner,List<Produto13>produto13s){
        while (true){
            try {
                System.out.print("Digite o codigo");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 0 ){
                    System.out.println("Código precisa ser maior que zero.");
                    continue;
                }
                boolean codigoExiste = produto13s.stream().anyMatch(p-> p.getCodigo() == codigo);
                if (codigoExiste){
                    System.out.println("Código já existente, tente outro.");
                }else {
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite seu nome completo sem uso de caracteres.");
                continue;
            }
            return Produto13.formatoNome(nome);
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
            return Produto13.formatoNome(categoria);
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor >10000){
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
                System.out.print("Quantidade mínima:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Número inválido.");
            }
        }
    }
    public void atualizarProduto(Scanner scanner){
        System.out.println("Atualizar dados produto.");
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o codigo do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto13 produto13 = produto13s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto13 != null){
                    produto13.setNome(validandoNome(scanner));
                    produto13.setCategoria(validandoCategoria(scanner));
                    produto13.setValor(validandoValor(scanner));
                    produto13.setQuantidadeEstoque(validandoQuantidade(scanner));
                }else {
                    System.out.println("Cóodigo inválido.");
                }

            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirProduto(Scanner scanner){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto13 produto13 = produto13s.stream().filter(p-> p.getCodigo() == codigo ).findFirst().orElse(null);
                if (produto13 !=null){
                    produto13s.remove(produto13);
                }else {
                    System.out.println("Código inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listaprodutosEstoqueBaixo(){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            boolean encontrou = false;
            for (Produto13 produto13 : produto13s){
                if (produto13.isEstoqueBaixo()){
                    System.out.println(produto13);
                    encontrou = true;
                }
            }
            if (!encontrou){
                System.out.println("Nenhum produto com estoque baixo.");
            }
        }

    }

    public List<Produto13> getProduto13s() {
        return produto13s;
    }

    public void setProduto13s(List<Produto13> produto13s) {
        this.produto13s = produto13s;
    }
}
