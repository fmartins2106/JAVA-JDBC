package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno13;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Escola13;

import java.util.Scanner;

public class AlunoTest13 {
    public static void main(String[] args) {
        Escola13 escola13 = new Escola13();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar aluno.");
            System.out.println("[2] Lista de alunos.");
            System.out.println("[3] Alterar dados aluno.");
            System.out.println("[4] Excluir dados aluno.");
            System.out.println("[5] Lista maior nota.");
            System.out.println("[6] Pesquisa aluno.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Escola13.validandoNome(scanner);
                    double nota1 = Escola13.validandoNota1(scanner);
                    double nota2 = Escola13.validandoNota2(scanner);
                    Aluno13 aluno13 = new Aluno13(nome,nota1,nota2);
                    escola13.addAlunosLista(aluno13);
                    break;
                case 2:
                    escola13.listaAlunos(scanner,escola13.getAluno13s());
                    break;

                case 3:
                    escola13.alterarDadosAluno(scanner);
                    break;

                case 4:
                    escola13.excluindoDadosAluno(scanner);
                    break;

                case 5:
                    escola13.listaMaiorMedia(scanner);
                    break;

                case 6:
                    escola13.pesquisarPorNome(scanner);
                    break;

                case 7:
                    System.out.println(">>>Finalizando programa.");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
