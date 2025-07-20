package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor12;

import java.util.Scanner;

public class EscolaTest12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola12 escola12 = new Escola12();
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola12);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola12);
                    break;
                case 3:
                    escola12.listaPessoas();
                    break;
                case 4:
                    escola12.pesquisaNome(scanner,escola12);
                    break;
                case 5:
                    escola12.excluirPessoa(scanner,escola12);
                    break;
                case 6:
                    escola12.alterandoDados(scanner,escola12);
                    break;
                case 7:
                    System.out.println(">>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner,Escola12 escola12){
        String nome = Escola12.validandoNome(scanner,escola12);
        String cpf = Escola12.validandoCpf(scanner,escola12);
        int idade = Escola12.validandoIdade(scanner,escola12);
        int matricula = Escola12.validandoMatricula(scanner,escola12);
        double[] notas = Escola12.validandoNotas(scanner, escola12);
        Aluno12 aluno12 = new Aluno12(nome,cpf,idade,matricula,notas);
        escola12.addPessoas(aluno12);
    }

    public static void cadastroProfessor(Scanner scanner, Escola12 escola12) {
        String nome = Escola12.validandoNome(scanner, escola12);
        String cpf = Escola12.validandoCpf(scanner, escola12);
        int idade = Escola12.validandoIdade(scanner, escola12);
        String disciplina = Escola12.validandoDisciplina(scanner, escola12);
        double salario = Escola12.validandoSalario(scanner, escola12);
        Professor12 professor12 = new Professor12(nome, cpf, idade, disciplina, salario);
        escola12.addPessoas(professor12);
    }

}

