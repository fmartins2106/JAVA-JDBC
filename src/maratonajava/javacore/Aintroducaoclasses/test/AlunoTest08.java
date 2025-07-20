package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno08;

import java.util.*;

public class AlunoTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Aluno08> aluno08s = new ArrayList<>();

        while (true){
            int opcao=0;
            System.out.println("[1] Cadastrar um aluno.");
            System.out.println("[2] Relatório de alunos cadastrados.");
            System.out.println("[3] Nota aluno.");
            System.out.println("[4] Alterar dados aluno.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao <=0 || opcao>=6){
                    System.out.println("Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    String nome = Aluno08.validandoNome(scanner);
                    double nota1 = Aluno08.validandoNota1(scanner);
                    double nota2 = Aluno08.validandoNota2(scanner);
                    Aluno08 aluno08 = new Aluno08(nome,nota1,nota2);
                    aluno08s.add(aluno08);
                    break;

                case 2:
                    if (aluno08s.isEmpty()){
                        System.out.println("Lista vazia, adicione livros.");
                    }else {
                        for (int i = 0; i < aluno08s.size(); i++) {
                            Aluno08 alunos = aluno08s.get(i);
                            alunos.exbindoRelatorioAlunos(i,aluno08s.size());
                        }
                    }
                    break;

                case 3:
                    if (aluno08s.isEmpty()){
                        System.out.println("Lista vazia, adicione livros.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número de matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= aluno08s.size()){
                                    System.out.println("Número de matricula inválido. Tente novamente.");
                                }else {
                                    Aluno08 alunoNotas = aluno08s.get(matricula);
                                    alunoNotas.exibindoNotasAluno(matricula);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Digite um número de matricula válido. Tente novamente.");
                            }
                        }
                    }
                    break;

                case 4:
                    if (aluno08s.isEmpty()){
                        System.out.println("Lista vazia. Primeiro cadastre alunos.");
                    }else {
                        while (true){
                            System.out.print("Digite a matricula do aluno:");
                            int matricula = Integer.parseInt(scanner.nextLine());
                            if (matricula<0 || matricula >= aluno08s.size()){
                                System.out.println("Matricula inválida, tente novamente.");
                            }else {
                                Aluno08 alunos = aluno08s.get(matricula);
                                alunos.setNome(Aluno08.validandoNome(scanner));
                                alunos.setNota1(Aluno08.validandoNota1(scanner));
                                alunos.setNota2(Aluno08.validandoNota2(scanner));
                                break;
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("ERRO. Digite uma opção válida.");
            }
        }
    }
}
