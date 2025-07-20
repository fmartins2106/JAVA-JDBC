package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno28;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola28;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor28;

import java.util.Scanner;

public class EscolaTest28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola28 escola28 = new Escola28();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola28);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola28);
                        break;
                    case 3:
                        escola28.listaPessoasCasdastradas();
                        break;
                    case 4:
                        escola28.exibirDadosPesquisa(scanner);
                        break;
                    case 5:
                        escola28.excluirDadosPessoa(scanner);
                        break;
                    case 6:
                        escola28.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola28 escola28){
        String nome = Escola28.validandoNome(scanner);
        String cpf = Escola28.validandoCpf(scanner);
        int idade = Escola28.validandoIdade(scanner);
        int matricula = Escola28.validandoMatricula(scanner);
        double[] notas = Escola28.validandoNotas(scanner);
        Aluno28 aluno28 = new Aluno28(nome,cpf,idade,matricula,notas);
        escola28.addPessoa(aluno28);
    }

    public static void cadastroProfessor(Scanner scanner, Escola28 escola28){
        String nome = Escola28.validandoNome(scanner);
        String cpf = Escola28.validandoCpf(scanner);
        int idade = Escola28.validandoIdade(scanner);
        String disciplina = Escola28.validandoDisciplina(scanner);
        double salario = Escola28.validandoSalario(scanner);
        Professor28 professor28 = new Professor28(nome,cpf,idade,disciplina,salario);
        escola28.addPessoa(professor28);
    }
}
