package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante03;

import java.util.*;

public class EstudanteTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Estudante03> estudante03s = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Quantos estudantes quer cadastar?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("ERRO. Digite um valor válido.");
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
                System.out.print("Digite o nome do "+(total+1)+"º aluno:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("Digite seu nome completo. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            int idade=0;
            while (true){
                try {
                    System.out.print("Digite a idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=18){
                        System.out.println("Digite uma idade maior que 18 anos.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            String curso;
            while (true){
                System.out.print("Curso:");
                curso = scanner.nextLine().trim().toLowerCase();
                if (curso.isEmpty()){
                    System.out.println("Tente novamente. Campo não pode ficar vazio.");
                }else {
                    break;
                }
            }
            Estudante03 estudante03 = new Estudante03(nome,idade,curso);
            estudante03s.add(estudante03);
        }
        for (Estudante03 estudante : estudante03s){
            estudante.cadastroEstudantes();
        }
    }
}
