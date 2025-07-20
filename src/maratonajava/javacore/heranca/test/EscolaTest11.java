package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor11;

import java.util.Scanner;

public class EscolaTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola11 escola11 = new Escola11();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro Professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima.");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola11);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola11);
                    break;
                case 3:
                    escola11.listaPessoas();
                    break;
                case 4:
                    escola11.pesquisaPorNome(scanner,escola11);
                    break;
                case 5:
                    escola11.excluirDados(scanner,escola11);
                    break;
                case 6:
                    escola11.alterandoDados(scanner,escola11);
                    break;
                case 7:
                    System.out.println(">>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola11 escola11){
        String nome = Escola11.validandoNome(scanner,escola11);
        String cpf = Escola11.validandoCpf(scanner,escola11);
        int idade = Escola11.validandoIdade(scanner,escola11);
        int matricula = Escola11.validandoMatricula(scanner,escola11);
        double[] notas = Escola11.validandoNotas(scanner,escola11);
        Aluno11 aluno11 = new Aluno11(nome,idade,cpf,matricula,notas);
        escola11.addPessoas(aluno11);
    }

    public static void cadastroProfessor(Scanner scanner, Escola11 escola11){
        String nome = Escola11.validandoNome(scanner,escola11);
        String cpf = Escola11.validandoCpf(scanner,escola11);
        int idade = Escola11.validandoIdade(scanner,escola11);
        String disciplina = Escola11.validandoDisciplina(scanner,escola11);
        double salario = Escola11.validandoSalario(scanner,escola11);
        Professor11 professor11 = new Professor11(nome,idade,cpf,disciplina,salario);
        escola11.addPessoas(professor11);
    }
}
