package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.*;

public class Empresa10 {
    private List<Funcionario10> funcionario10s;

    public Empresa10 (){
        this.funcionario10s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite o nome completo sem caracteres.");
                continue;
            }
            return Funcionario10.formatoNome(nome);
        }
    }
    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < 1510){
                    System.out.println("Salário não pode ser menor que salário mínimo.");
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digit um valor válido.");
            }
        }
    }
    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo não pode ficar vazio ou conter caracteres. Tente novamente.");
                continue;
            }
            return Funcionario10.formatoNome(cargo);
        }
    }
    public void tabelaFuncionario(List<Funcionario10> funcionario10s){
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-12s %-25s\n","No","Nome","Salário","Cargo");
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
        int index = 0;
        for (Funcionario10 funcionario10 : funcionario10s){
            System.out.printf("%-4d %-25s R$%-12.2f %-25s\n",index++,funcionario10.getNome(),funcionario10.getSalario(),funcionario10.getCargo());
        }
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    public void pesquisaFuncionarioNome(Scanner scanner){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = Empresa10.validandoNome(scanner);
            boolean encontrado = false;
            for (Funcionario10 funcionario10 : funcionario10s) {
                if (nome.equalsIgnoreCase(funcionario10.getNome())) {
                    for (int i = 0; i < 60; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                    System.out.println("Nome:" + funcionario10.getNome());
                    System.out.println("Salário:R$" + funcionario10.getSalario());
                    System.out.println("Cargo:" + funcionario10.getCargo());
                    encontrado = true;
                    for (int i = 0; i < 60; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                }
            }
            if (!encontrado) {
                System.out.println("Funcionário inexistente.");
            }
        }
    }
    public void alterarDadosFuncionario(Scanner scanner){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            int matricula = 0;
            try {
                System.out.print("Digite o número da matricula:");
                matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <=funcionario10s.size()){
                    Funcionario10 funcionario10 = funcionario10s.get(matricula);
                    funcionario10.setNome(Empresa10.validandoNome(scanner));
                    funcionario10.setSalario(Empresa10.validandoSalario(scanner));
                    funcionario10.setCargo(Empresa10.validandoCargo(scanner));
                }else {
                    System.out.println("Número de matricula inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Número inválido.");
            }
        }
    }

    public void addFuncionario(Funcionario10 funcionario10){
        funcionario10s.add(funcionario10);
    }
    public void excluirAluno(Scanner scanner){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            int matricula= 0;
            try {
                System.out.print("Digite o número da matricula:");
                matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <= funcionario10s.size()){
                    funcionario10s.remove(matricula);
                    System.out.println("Funcionário removido com sucesso.");
                }else {
                    System.out.println("Número de matricula inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public void listaMaiorSalario(){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            List<Funcionario10> cloneList = new ArrayList<>();
            for (Funcionario10 funcionario10 : funcionario10s){
                cloneList.add(funcionario10.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Funcionario10::getSalario).reversed());
            tabelaFuncionario(cloneList);
        }
    }

    public List<Funcionario10> getFuncionario10s() {
        return funcionario10s;
    }

    public void setFuncionario10s(List<Funcionario10> funcionario10s) {
        this.funcionario10s = funcionario10s;
    }
}
