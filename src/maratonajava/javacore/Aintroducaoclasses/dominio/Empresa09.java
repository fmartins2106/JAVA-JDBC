package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Empresa09 {
    private ArrayList<Funcionario09> funcionario09s;

    public Empresa09 (){
        this.funcionario09s = new ArrayList<>();
    }

    public void  addLista(Funcionario09 funcionarios){
        funcionario09s.add(funcionarios);
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome precisa ter nome completo e sem caracateres.");
                continue;
            }
            return Funcionario09.formatoNome(nome);
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario<1510){
                    System.out.println("Salário precisa ser maior que salário mínimo");
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Digite o cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campor cargo não pode ficar vazio ou conter caracteres.");
                continue;
            }
            return Funcionario09.formatoNome(cargo);
        }
    }
    public void tabelaFuncionariosCadastrados(ArrayList<Funcionario09> funcionario09s){
        for (int i = 0; i < 65; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-15s %-25s\n","No","Nome","Salário","Cargo");
        for (int i = 0; i < 65; i++) {
            System.out.print("=");
        }
        System.out.println();
        int index=0;
        for (Funcionario09 funcionario09 : funcionario09s){
            System.out.printf("%-4d %-25s R$%-8.2f %-25s\n",index++, funcionario09.getNome(), funcionario09.getSalario(), funcionario09.getCargo());
        }
        for (int i = 0; i < 65; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void alterarDadosFuncionarios(Scanner scanner){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista esta vazia. Cadastre funcionarios.");
        }else {
            try {
                System.out.print("Digite a matricula do funcionário:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula < funcionario09s.size()){
                    Funcionario09 funcionario09 = funcionario09s.get(matricula);
                    funcionario09.setNome(validandoNome(scanner));
                    funcionario09.setSalario(validandoSalario(scanner));
                    funcionario09.setCargo(validandoCargo(scanner));
                }else {
                    System.out.println("Número de matricula inválido. Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }
        }
    }

    public void pesquisaPorNome(Scanner scanner){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = Empresa09.validandoNome(scanner);
            boolean encontrado = false;
            for (Funcionario09 funcionario09 : funcionario09s){
                if (nome.equalsIgnoreCase(funcionario09.getNome())){
                    System.out.println("Nome:"+ funcionario09.getNome());
                    System.out.println("Salário:R$"+ funcionario09.getSalario());
                    System.out.println("Cargo:"+ funcionario09.getCargo());
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Funcionário não encontrado.");
            }
        }
    }

    public void excluirFuncionario(Scanner scanner){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <= funcionario09s.size()){
                    funcionario09s.remove(matricula);
                    System.out.println("Funcionário excluido com sucesso.");
                }else {
                    System.out.println("Matricula inválida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida. Tente novamente.");
            }
        }
    }

    public void listaFuncionariosMaiorSalario(){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            ArrayList<Funcionario09> cloneList = new ArrayList<>();
            for (Funcionario09 funcionario09 : funcionario09s){
                cloneList.add(funcionario09.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Funcionario09::getSalario).reversed());
            tabelaFuncionariosCadastrados(cloneList);
        }
    }

    public ArrayList<Funcionario09> getFuncionarios09s() {
        return funcionario09s;
    }

    public void setFuncionarios09s(ArrayList<Funcionario09> funcionario09s) {
        this.funcionario09s = funcionario09s;
    }
}
