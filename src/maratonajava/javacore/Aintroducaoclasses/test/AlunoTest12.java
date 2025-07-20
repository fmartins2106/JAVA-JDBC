package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno12;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Escola12;

import java.util.Scanner;

public class AlunoTest12 {
    public static void main(String[] args) {
        Escola12 escola12 = new Escola12();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar aluno.");
            System.out.println("[2] Listar alunos.");
            System.out.println("[3] Alterar dados aluno.");
            System.out.println("[4] Pesquisa aluno por nome.");
            System.out.println("[5] Excluir aluno.");
            System.out.println("[6] Lista ordenada maior nota.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Escola12.validandoNomeAluno(scanner);
                    double nota1 = Escola12.validandoNota1(scanner);
                    double nota2 = Escola12.validandoNota2(scanner);
                    Aluno12 aluno12 = new Aluno12(nome,nota1,nota2);
                    escola12.addNotasAluno(aluno12);
                    break;

                case 2:
                    escola12.listaAlunos(escola12.getAluno12s());
                    break;

                case 3:
                    escola12.alterarDadosAluno(scanner);
                    break;

                case 4:
                    escola12.pesquisaAlunoNome(scanner);
                    break;

                case 5:
                    escola12.excluirAluno(scanner);
                    break;

                case 6:
                    escola12.listaMaiorMedia(scanner,escola12.getAluno12s());
                    break;

                case 7:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
