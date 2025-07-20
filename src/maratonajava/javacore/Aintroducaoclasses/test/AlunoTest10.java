package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno10;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Escola10;

import java.util.*;

public class AlunoTest10 {
    public static void main(String[] args) {
        Escola10 escola10 = new Escola10();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar aluno.");
            System.out.println("[2] Lista de alunos.");
            System.out.println("[3] Pesquisa notas por nome.");
            System.out.println("[4] Alterar dados aluno.");
            System.out.println("[5] Excluir aluno.");
            System.out.println("[6] Lista alunos maior média.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um válor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Escola10.validandoNome(scanner);
                    double nota1 = Escola10.validandoNota1(scanner);
                    double nota2 = Escola10.validandoNota2(scanner);
                    Aluno10 aluno10 = new Aluno10(nome,nota1,nota2);
                    escola10.addNovoAluno(aluno10);
                    break;

                case 2:
                    escola10.listagemAlunos(escola10.getAluno10s());
                    break;

                case 3:
                    escola10.pesquisaNome(scanner);
                    break;

                case 4:
                    escola10.alterarDadosAluno(scanner);
                    break;

                case 5:
                    escola10.excluirDadosSistema(scanner);
                    break;

                case 6:
                    escola10.listaPorMaiorMedia();
                    break;

                case 7:
                    System.out.println(">>>Finalizando Programa...");
                    return;

                default:
                    System.out.println("Opção inválida Tente novamente.");
            }

        }
    }
}
