package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno09;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Escola09;

import java.util.*;

public class AlunoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola09 escola09 = new Escola09();

        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Listar alunos.");
            System.out.println("[3] Alterar dados Aluno.");
            System.out.println("[4] Pesquisar por aluno.");
            System.out.println("[5] Excluir Aluno.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Escola09.validandoNome(scanner);
                    double nota1 = Escola09.validandoNota1(scanner);
                    double nota2 = Escola09.validandoNota2(scanner);
                    Aluno09 aluno = new Aluno09(nome,nota1,nota2);
                    escola09.addAluno(aluno);
                    break;

                case 2:
                    escola09.listarAlunos();
                    break;

                case 3:
                    escola09.alterarDadosAluno(scanner);
                    break;

                case 4:
                    escola09.buscarAluno(scanner);
                    break;

                case 5:
                    escola09.excluirDadosAluno(scanner);
                    break;

                case 6:
                    System.out.println("Finalizando o programa...");
                    return;

                default:
                    System.out.println("ERRO. Digit ema opção válida.");
            }
        }
    }
}
