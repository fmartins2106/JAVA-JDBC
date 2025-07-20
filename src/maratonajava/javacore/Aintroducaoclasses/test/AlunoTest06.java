package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno06;

import java.util.*;

public class AlunoTest06 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<Aluno06> aluno06s = new ArrayList<>();

        while (true){
            int opcao = 0;
            System.out.println("[ 1 ] Cadastrar notas aluno.");
            System.out.println("[ 2 ] Relatório alunos.");
            System.out.println("[ 3 ] Ver notas aluno.");
            System.out.println("[ 4 ] Alterar dados aluno.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite uma opção válida, tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Aluno06.validandoNome(scanner);
                    double nota1 = Aluno06.validandoNota1(scanner);
                    double nota2 = Aluno06.validandoNota2(scanner);
                    Aluno06 aluno06 = new Aluno06(nome,nota1,nota2);
                    aluno06s.add(aluno06);
                    break;

                case 2:
                    if (aluno06s.isEmpty()){
                        System.out.println("Lista vazia, cadastre alunos para gerar a lista.");
                    }else {
                        for (int i = 0; i < aluno06s.size(); i++) {
                            Aluno06 alunos = aluno06s.get(i);
                            alunos.exibindoResultados(i, aluno06s.size());
                        }
                    }
                    break;

                case 3:
                    if (aluno06s.isEmpty()){
                        System.out.println("Lista vazia, cadastre um aluno para verificar as notas.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número da matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= aluno06s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válido. Tente novamente.");
                                }else {
                                    Aluno06 aluno = aluno06s.get(matricula);
                                    aluno.monstrandoNotasAluno();
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("ERRO. Digite um valor válido, tente novamente.");
                            }
                        }
                    }
                    break;

                case 4:
                    if (aluno06s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre alunos.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número da matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= aluno06s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válido. Tente novamente.");
                                }else {
                                    Aluno06 matriculaAluno = aluno06s.get(matricula);
                                    String novoNome = Aluno06.validandoNome(scanner);
                                    matriculaAluno.setNome(novoNome);
                                    double novaNota1 = Aluno06.validandoNota1(scanner);
                                    matriculaAluno.setNota1(novaNota1);
                                    double novaNota2 = Aluno06.validandoNota2(scanner);
                                    matriculaAluno.setNota2(novaNota2);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("ERRO. Digite uma matricula válida.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>>Finalizando o programa....");
                    return;

                default:
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
            }
        }
    }
}
