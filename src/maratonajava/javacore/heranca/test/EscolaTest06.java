package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor06;

import java.util.Scanner;

public class EscolaTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola06 escola06 = new Escola06();
        while (true){
            System.out.println("[1] Cadastro de aluno;");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir pessoa.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao=0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola06);
                    break;
                case 2:
                    cadastrandoProfessor(scanner,escola06);
                    break;
                case 3:
                    escola06.listaPessoas();
                    break;
                case 4:
                    escola06.pesquisaPorPessoa(scanner);
                    break;
                case 5:
                    escola06.excluirPessoa(scanner);
                    break;
                case 6:
                    escola06.alterandoDados(scanner,escola06);
                    break;
                case 7:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Digite uma das opções acima.");
            }
        }
    }
    public static void cadastroAluno(Scanner scanner, Escola06 escola06){
        String nome = Escola06.validandoNome(scanner,escola06);
        int idade = Escola06.validandoIdade(scanner);
        String cpf = Escola06.validandoCpf(scanner);
        int matricula = Escola06.validandoMatricula(scanner,escola06.getPessoa06s());
        double[] notas = Escola06.validandoNotas(scanner);
        Aluno06 aluno06 = new Aluno06(nome,idade,cpf,matricula,notas);
        escola06.addPessoas(aluno06);
    }

    public static void cadastrandoProfessor(Scanner scanner, Escola06 escola06){
        String nome = Escola06.validandoNome(scanner,escola06);
        int idade = Escola06.validandoIdade(scanner);
        String cpf = Escola06.validandoCpf(scanner);
        String disciplina = Escola06.validandoDisciplina(scanner,escola06);
        double salario = Escola06.validandoSalario(scanner);
        Professor06 professor06 = new Professor06(nome,idade,cpf,disciplina,salario);
        escola06.addPessoas(professor06);
    }
}
