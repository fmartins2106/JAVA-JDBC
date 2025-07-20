package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno01;

import java.util.*;

public class AlunoTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno01> aluno01s =new ArrayList<>();
        while (true){
            String nome ="";
            while (true){
                System.out.print("Digite o nome completo do aluno(a):");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                        System.out.println("Digite seu nome completo sem adição de caracteres. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double nota1=0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Double.parseDouble(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("ERRO. Nota precisa ser entre 0 e 10. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma nota válida. Tente novamente.");
                }
            }
            double nota2 = 0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Double.parseDouble(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("ERRO. Nota precisa ser entre 0 e 10. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma nota válida. Tente novamente.");
                }
            }
            Aluno01 aluno01 = new Aluno01(nome,nota1,nota2);
            aluno01s.add(aluno01);
            String addNovAluno="";
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovAluno.equals("sim") && !addNovAluno.equals("não"));
            if (addNovAluno.equals("não")){
                for (int i=0;i<aluno01s.size();i++){
                    Aluno01 aluno = aluno01s.get(i);
                    aluno.exibindoMediaAlunos(i);
                }
                break;
            }
        }
        int opc = 0;
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.):");
            opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa.");
                break;
            }else {
                if (opc<aluno01s.size()){
                    Aluno01 aluno = aluno01s.get(opc);
                    aluno.exibindoNotasAluno(opc);
                }
            }
        }
    }
}
