package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor14;

import java.util.Scanner;

public class EscolaTest14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola14 escola14 = new Escola14();
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de Professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola14);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola14);
                    break;
                case 3:
                    escola14.listarPessoas();
                    break;
                case 4:
                    escola14.pesquisaPorNome(scanner,escola14);
                    break;
                case 5:
                    escola14.excluirDados(scanner,escola14);
                    break;
                case 6:
                    escola14.alterarDados(scanner,escola14);
                    break;
                case 7:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola14 escola14){
        String nome = Escola14.validandoNome(scanner,escola14);
        String cpf = Escola14.validandoCpf(scanner, escola14);
        int idade = Escola14.validandoIdade(scanner,escola14);
        int matricula = Escola14.validandoMatricula(scanner,escola14);
        double[] notas = Escola14.validandoNotas(scanner,escola14);
        Aluno14 aluno14 = new Aluno14(nome,cpf,idade,matricula,notas);
        escola14.addPessoas(aluno14);
        System.out.println("Aluno cadastro com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola14 escola14){
        String nome = Escola14.validandoNome(scanner,escola14);
        String cpf = Escola14.validandoCpf(scanner,escola14);
        int idade = Escola14.validandoIdade(scanner,escola14);
        String disciplina = Escola14.validandoDisciplina(scanner,escola14);
        double salario = Escola14.validandoSalario(scanner,escola14);
        Professor14 professor14 = new Professor14(nome,cpf,idade,disciplina,salario);
        escola14.addPessoas(professor14);
    }
}
