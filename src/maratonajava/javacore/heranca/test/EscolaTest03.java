package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor03;

import java.util.Scanner;

public class EscolaTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola03 escola03 = new Escola03();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro Professor09.");
            System.out.println("[3] Pesquisa nome.");
            System.out.println("[4] Excluir cadastro.");
            System.out.println("[5] Listar pessoas.");
            System.out.println("[6] Alterar dados pessoa.");
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
                    cadastroAluno(scanner,escola03);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola03);
                    break;
                case 3:
                    escola03.pesquisaPorNome(scanner);
                    break;
                case 4:
                    escola03.excluindoPessoa(scanner);
                    break;
                case 5:
                    escola03.listarPessoas();
                    break;
                case 6:
                    escola03.alterandoDados(scanner,escola03);
                    break;
                case 7:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola03 escola03){
        String nome = Escola03.validandoNome(scanner,escola03);
        int idade = Escola03.validandoIdade(scanner);
        String cpf = Escola03.validandoCpf(scanner);
        int matricula = Escola03.validandoMatricula(scanner,escola03.getPessoa03s());
        double[] nota = Escola03.validandoNotas(scanner);
        Aluno03 aluno03 = new Aluno03(nome,idade,cpf,matricula,nota);
        escola03.addPessoas(aluno03);
    }

    public static void cadastroProfessor(Scanner scanner, Escola03 escola03){
        String nome = Escola03.validandoNome(scanner,escola03);
        int idade = Escola03.validandoIdade(scanner);
        String cpf = Escola03.validandoCpf(scanner);
        String disciplina = Escola03.validandoDisciplina(scanner,escola03);
        double salario = Escola03.validandoSalario(scanner);
        Professor03 professor03 = new Professor03(nome,idade,cpf,disciplina,salario);
        escola03.addPessoas(professor03);
    }
}
