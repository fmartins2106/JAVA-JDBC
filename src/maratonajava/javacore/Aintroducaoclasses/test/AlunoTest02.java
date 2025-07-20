package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno02;

import java.util.*;

public class AlunoTest02 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        ArrayList<Aluno02> aluno02s = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Digite o nome completo do aluno:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ficar vazio. Tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+( \\p{L}+)+$")){
                        System.out.println("Digite o nome completo e não use caracteres. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double nota1 = Aluno02.validandoNota1(scanner);
            double nota2 = Aluno02.validandoNota2(scanner);
            Aluno02 aluno02 = new Aluno02(nome,nota1,nota2);
            aluno02s.add(aluno02);
            String addNovAluno="";
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovAluno.equals("sim")  && !addNovAluno.equals("não"));
            if (addNovAluno.equals("não")){
                for (int i = 0; i < aluno02s.size(); i++) {
                    Aluno02 aluno = aluno02s.get(i);
                    aluno.exibirTabelaAlunos(i, aluno02s.size());
                }
                break;
            }

        }
        int notas = 0;
        while (true){
            try {
                System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar):");
                notas = Integer.parseInt(scanner.nextLine());
                if (notas==999){
                    System.out.println(">>>Finalizando programa....");
                    break;
                }else {
                    if (notas<= aluno02s.size()){
                        Aluno02 aluno02 = aluno02s.get(notas);
                        aluno02.verificandoNotasAlunos();
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            } 
        }
    }
}
