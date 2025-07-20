package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno06;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno07;

import java.util.*;

public class AlunoTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Aluno07> aluno07s = new ArrayList<>();

        while (true){
            int opcao = 0;
            System.out.println("[ 1 ] - Cadastrar aluno.");
            System.out.println("[ 2 ] - Relatório alunos cadastrados.");
            System.out.println("[ 3 ] - Ver notas aluno.");
            System.out.println("[ 4 ] - Alterar dados aluno.");
            System.out.println("[ 5 ] - Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao >= 6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    System.out.println("Cadastro de aluno.");
                    String nome = Aluno07.verificandoNome(scanner);
                    double nota1 = Aluno07.verificandoNota1(scanner);
                    double nota2 = Aluno07.verificandoNota2(scanner);
                    Aluno07 aluno07 = new Aluno07(nome,nota1,nota2);
                    aluno07s.add(aluno07);
                    break;

                case 2:
                    if (aluno07s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre alunos.");
                    }else {
                        for (int i = 0; i < aluno07s.size(); i++) {
                            Aluno07 aluno = aluno07s.get(i);
                            aluno.resultadoTabelaMedia(i, aluno07s.size());
                        }
                    }
                    break;

                case 3:
                    if (aluno07s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre um aluno.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula do aluno:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= aluno07s.size()){
                                    System.out.println("ERRO. Matricula não encontrada. Tente novamente.");
                                }else {
                                    Aluno07 matriculaAluno = aluno07s.get(matricula);
                                    matriculaAluno.mostrarNotasAluno(matricula);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Digite uma matricula válida, tente novamente.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alterar dados Aluno.");
                    if (aluno07s.isEmpty()){
                        System.out.println("ERRO. Digite um valor válido.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número da matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= aluno07s.size()){
                                    System.out.println("Erro. Número de matricuala inválido. Tente novamente.");
                                }else {
                                    Aluno07 alunos = aluno07s.get(matricula);
                                    String novoNome = Aluno07.verificandoNome(scanner);
                                    alunos.setNome(novoNome);
                                    double novaNota1 = Aluno07.verificandoNota1(scanner);
                                    alunos.setNota1(novaNota1);
                                    double novaNota2 = Aluno07.verificandoNota2(scanner);
                                    alunos.setNota2(novaNota2);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO. Digite uma matricula válida.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando programa.");
                    return;

                default:
                    System.out.println("ERRO. Digite um valor válido.");

            }
        }
    }
}
