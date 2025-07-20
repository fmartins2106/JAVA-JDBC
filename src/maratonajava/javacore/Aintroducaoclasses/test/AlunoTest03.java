package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno03;

import java.util.*;

public class AlunoTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Aluno03> aluno03s = new ArrayList<>();

        while (true){
            String nome = Aluno03.validandoNomeAluno(scanner);
            double nota1 = Aluno03.validandoNota1(scanner);
            double nota2 = Aluno03.validandoNota2(scanner);
            Aluno03 aluno03 =new Aluno03(nome,nota1,nota2);
            aluno03s.add(aluno03);
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("não") && !addNovoAluno.equals("sim"));
            if (addNovoAluno.equals("não")){
                for (int i = 0; i < aluno03s.size(); i++) {
                    Aluno03 aluno = aluno03s.get(i);
                    aluno.resultadoAlunos03(i, aluno03s.size());
                }
                break;
            }
        }
        while (true){
            try {
                System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar):");
                int index = Integer.parseInt(scanner.nextLine());
                if (index==999){
                    System.out.println(">>>Finalizando sistema.");
                    break;
                }
                if (index <0 || index >= aluno03s.size()){
                    System.out.println("ERRO. Digite um número de matricula válido.");
                }else {
                    Aluno03 aluno = aluno03s.get(index);
                    aluno.verNotasAluno(index);

                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO:"+erro.getMessage());
            }
        }
    }
}
