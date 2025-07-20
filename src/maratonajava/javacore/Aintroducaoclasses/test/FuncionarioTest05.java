package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario05;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario05> funcionario05s = new ArrayList<>();

        while (true){
            String nome="";
            while (true){
                System.out.print("Digite o nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vázio. Tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                        System.out.println("ERRO. Digite o nome completo para finalizar o cadastro.");
                    }else {
                        break;
                    }
                }
            }
            String cargo="";
            while (true){
                System.out.print("Digite o cargo:");
                cargo = scanner.nextLine().trim();
                if (cargo.isEmpty()){
                    System.out.println("Cargo não pode ficar vazio. Tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                        System.out.println("ERRO. Digite apenas o cargo sem uso de caracteres inválidos. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double salario = Funcionario05.validandoSalario(scanner);
            Funcionario05  funcionario05 = new Funcionario05(nome,cargo,salario);
            double aumento=0;
            while (true){
                try {
                    System.out.print("Aumento no salário de quantos %?:");
                    aumento = Double.parseDouble(scanner.nextLine());
                    if (aumento>=0 && aumento<=100){
                        break;
                    }else {
                        System.out.println("Aumento precisa ser maior que 0 e menor que 100.");
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido. Tente novamente.");
                }
            }

            funcionario05.aumentoSalario(aumento);

            funcionario05s.add(funcionario05);
            String addNovoFuncionario="";
            do {
                System.out.print("Quer adicionar outro funcionário?(sim/não):");
                addNovoFuncionario = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoFuncionario.equals("sim") && !addNovoFuncionario.equals("não"));
            if (addNovoFuncionario.equals("não")){
                for (Funcionario05 funcionario : funcionario05s){
                    funcionario.exibindoResultados();
                }
                break;
            }
        }
    }
}
