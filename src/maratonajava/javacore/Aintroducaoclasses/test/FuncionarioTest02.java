package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario02;

import java.util.*;

public class FuncionarioTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario02> funcionario02 = new ArrayList<>();

        int quant=0;
        while (true){
            try {
                System.out.print("Quantos funcionários quer cadastrar?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um valor maior que 0.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            }
        }
        for (int total=0;total<quant;total++){
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("Digite seu nome completo.");
                    }else {
                        break;
                    }
                }
            }
            String cargo;
            while (true){
                System.out.print("Cargo:");
                cargo = scanner.nextLine().trim();
                if (cargo.isEmpty()){
                    System.out.println("Cargo não pode ficar vazio.");
                }else {
                    break;
                }
            }
            double salario=0;
            while (true){
                try {
                    System.out.print("Digite o salário:R$");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario<=1449.99){
                        System.out.println("ERRO. Salário precisa ser maior que salaário minimo. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("DIigte um valor válido. Tente novamente.");
                }
            }
            Funcionario02 funcionario2 = new Funcionario02(nome,cargo,salario);
            funcionario02.add(funcionario2);
        }
        for (Funcionario02 funcionario : funcionario02){
            funcionario.ExibirDadosFuncionarios02();
        }

    }

}
