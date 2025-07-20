package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Loja12 {
    private ArrayList<Produto12> produto12s;

    public Loja12(){
        this.produto12s = new ArrayList<>();
    }

    public static String validarNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite nome completo sem caracteres.");
                continue;
            }
            return Produto12.formatoNome(nome);
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor <0 || valor >10000){
                    System.out.println("Valor precisa ser maior que zero e menor que R$10.000,00");
                    continue;
                }
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode vazio ou conter caracteres.");
                continue;
            }
            return Produto12.formatoNome(categoria);
        }
    }
    public void addProdutosLista(Produto12 produto12){
        produto12s.add(produto12);
    }
    public void tabelaProdutos(ArrayList<Produto12> produto12s){
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-15s %-20s\n","No","Nome","Valor","Categoria");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
        int index =0;
        for (Produto12 produto12 : produto12s){
            System.out.printf("%-4d %-25s R$%-15.2f %-20s\n",index++,produto12.getNome(),produto12.getValor(),produto12.getCategoria());
        }
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void pesquisaProdutoNome(Scanner scanner){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = Loja12.validarNome(scanner);
            boolean encontrado = false;
            for (Produto12 produto12 : produto12s){
                if (nome.equalsIgnoreCase(produto12.getNome())){
                    System.out.println("Nome:"+produto12.getNome());
                    System.out.println("Valor:R$"+produto12.getValor());
                    System.out.println("Categoria:"+produto12.getCategoria());
                    encontrado =true;
                }
            }
            if (!encontrado){
                System.out.println("Produto não encontrado.");
            }
        }
    }
    public void alterarDadosProduto(Scanner scanner){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo >= 0 && codigo <= produto12s.size()){
                    Produto12 produto12 = produto12s.get(codigo);
                    produto12.setNome(Loja12.validarNome(scanner));
                    produto12.setValor(Loja12.validandoValor(scanner));
                    produto12.setCategoria(Loja12.validandoCategoria(scanner));
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido, tente novamente.");
            }
        }
    }
    public void excluirProduto(Scanner scanner){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo >=0 && codigo <=produto12s.size()){
                    System.out.println("Produto excluido com sucesso.");
                    produto12s.remove(codigo);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public void listaProdutoValor(){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            ArrayList<Produto12> cloneList = new ArrayList<>();
            for (Produto12 produto12 : produto12s){
                cloneList.add(produto12.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Produto12::getValor).reversed());
            tabelaProdutos(cloneList);
        }
    }

    public ArrayList<Produto12> getProduto12s() {
        return produto12s;
    }

    public void setProduto12s(ArrayList<Produto12> produto12s) {
        this.produto12s = produto12s;
    }
}
