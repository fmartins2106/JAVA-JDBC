package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario02;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario03;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario04;

import java.sql.SQLOutput;
import java.util.*;

public class FuncionarioTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario04> funcionario04s = new ArrayList<>();

        while (true){
            String nome="";
            while (true){
                System.out.print("Nome completo:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vazio. Tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("Digite o seu nome completo. Não use caracteres. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            String cargo="";
            while (true){
                System.out.print("Digite o cargo de "+nome+":");
                cargo = scanner.nextLine().trim();
                if (cargo.isEmpty()){
                    System.out.println("Cargo não pode ficar vazio, Tente novamente.");
                }else {
                    if (!cargo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("Não utilize caracteres. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double salario=0;
            while (true){
                try {
                    System.out.print("Digite o salário:");
                    salario =Double.parseDouble(scanner.nextLine());
                    if (salario<=1499.99){
                        System.out.println("Salário não pode ser menor que salário mìnimo. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            double percentual=0;
            while (true){
                try {
                    System.out.print("Quer adicionar quantos % de aumento no salário?:");
                    percentual = Double.parseDouble(scanner.nextLine());
                    if (percentual<=0 || percentual>=11){
                        System.out.println("Erro. Digite um percentual entre 0 e 100.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            Funcionario04 funcionario04 = new Funcionario04(nome,cargo,salario);
            funcionario04s.add(funcionario04);
            for (Funcionario04 funcionario : funcionario04s){
                funcionario.aumentoSalarial(percentual);
            }
            String addNovoFuncionario="";
            do {
                System.out.print("Quer adicionar outro funcionpario?(sim/não):");
                addNovoFuncionario = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoFuncionario.equals("não") && !addNovoFuncionario.equals("sim"));
            if (addNovoFuncionario.equals("não")){
                for (Funcionario04 funcionario : funcionario04s){
                    funcionario.monstrandoResultadosFuncionarios();
                }
                break;
            }
        }

    }
}
