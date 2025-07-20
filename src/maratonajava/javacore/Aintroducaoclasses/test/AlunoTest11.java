package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno11;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Escola11;

import java.util.Scanner;

public class AlunoTest11 {
    public static void main(String[] args) {
        Escola11 escola11 = new Escola11();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Lista de alunos.");
            System.out.println("[3] Alterar dados Aluno.");
            System.out.println("[4] Pesquisa aluno por nome.");
            System.out.println("[5] Excluir aluno.");
            System.out.println("[6] Lista ordenada por maior nota.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    String nome = Escola11.validandoNome(scanner);
                    double nota1 = Escola11.validandoNota1(scanner);
                    double nota2 = Escola11.validandoNota2(scanner);
                    Aluno11 aluno11 = new Aluno11(nome,nota1,nota2);
                    escola11.addAluno(aluno11);
                    break;

                case 2:
                    escola11.exibindoResultados(escola11.getAluno11s());
                    break;

                case 3:
                    escola11.alterarDadosAlunos(scanner);
                    break;

                case 4:
                    escola11.pesquisaNome(scanner);
                    break;

                case 5:
                    escola11.excluirDadosAluno(scanner);
                    break;

                case 6:
                    escola11.listaAlunosPorMaiorMedia();
                    break;

                case 7:
                    System.out.println(">>>Finalizando o programa<<<");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
