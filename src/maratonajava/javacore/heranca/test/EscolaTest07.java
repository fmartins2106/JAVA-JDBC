package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor07;

import java.util.Scanner;

public class EscolaTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola07 escola07 = new Escola07();
        while (true){
            int opcao=0;
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola07);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola07);
                    break;
                case 3:
                    escola07.listarPessoas();
                    break;
                case 4:
                    escola07.pesquisaPorNome(scanner);
                    break;
                case 5:
                    escola07.excluindoCadastro(scanner);
                    break;
                case 6:
                    escola07.alterarDadosPessoa(scanner,escola07);
                    break;
                case 7:
                    System.out.println(">>>Finalizando programa....");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola07 escola07){
        String nome = Escola07.validandoNome(scanner,escola07);
        int idade = Escola07.validandoIdade(scanner);
        String cpf = Escola07.validandoCpf(scanner,escola07);
        int matricula = Escola07.validandoMatricula(scanner,escola07.getPessoa07s());
        double[] notas = Escola07.validandoNotas(scanner);
        Aluno07 aluno07 = new Aluno07(nome,idade,cpf,matricula,notas);
        escola07.addPessoas(aluno07);
    }

    public static void cadastroProfessor(Scanner scanner, Escola07 escola07){
        String nome = Escola07.validandoNome(scanner,escola07);
        int idade = Escola07.validandoIdade(scanner);
        String cpf = Escola07.validandoCpf(scanner,escola07);
        String disciplina = Escola07.validandoDisciplina(scanner,escola07);
        double salario = Escola07.validandoSalario(scanner);
        Professor07 professor07 = new Professor07(nome,idade,cpf,disciplina,salario);
        escola07.addPessoas(professor07);
    }
}
