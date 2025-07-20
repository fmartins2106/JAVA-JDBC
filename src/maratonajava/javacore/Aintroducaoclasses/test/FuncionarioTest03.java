package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario03;

import java.util.*;


public class FuncionarioTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario03> funcionario03s = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quer cadastrar quanto funcionários?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior ou igual a 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Opção inválida, tente novamente.");
            }
        }
        for (int total=0;total<quant;total++){
            String nome="";
            while (true){
                System.out.print("Digite o nome do "+(total+1)+"º funcionário:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ficar vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("ERRO. Digite o nome completo do funcionário.");
                    }else {
                        break;
                    }
                }
            }
            String cargo="";
            while (true){
                System.out.print("Digite o cargo do(a) "+nome+":");
                cargo = scanner.nextLine().trim();
                if (cargo.isEmpty()){
                    System.out.println("Campo não pode ficar vazio, tente novamente.");
                }else {
                    if (!cargo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("ERRO. Cargo inválido, tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double salario =0;
            while (true){
                System.out.print("Digite o seu salário:R$");
                if (scanner.hasNextDouble()){
                    salario = scanner.nextDouble();
                    if (salario<=1499.99){
                        System.out.println("ERRO. Salário não pode ser menor que salário mínimo.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um valor válido.");
                }
            }
            Funcionario03 funcionario03 = new Funcionario03(nome,cargo,salario);
            funcionario03s.add(funcionario03);
            String addNovoFuncionarios;
            do {
                System.out.print("Quer adicionar outro funcionário?(sim/não):");
                addNovoFuncionarios = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoFuncionarios.equals("não") && !addNovoFuncionarios.equals("sim"));
            if (addNovoFuncionarios.equals("não")){
                for (Funcionario03 funcionario : funcionario03s){
                    funcionario.mostrandosDadosFuncionarios();
                }
                break;
            }
        }
    }
}
