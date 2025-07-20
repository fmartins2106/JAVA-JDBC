package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno33;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola33;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor33;

import java.util.Scanner;

public class EscolaTest33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola33 escola33 = new Escola33();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Lista de alunos cadastrados.");
            System.out.println("[5] lista de professores cadastrados.");
            System.out.println("[6] Pesquisa por nome.");
            System.out.println("[7] Excluir dados.");
            System.out.println("[8] Alterar dados.");
            System.out.println("[9] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola33);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola33);
                        break;
                    case 3:
                        escola33.listarPessoasCadastradas();
                        break;
                    case 4:
                        escola33.listarAlunos();
                        break;
                    case 5:
                        escola33.listarProfessores();
                        break;
                    case 6:
                        escola33.exibirPesquisaPorNome(scanner);
                        break;
                    case 7:
                        escola33.excluirDados(scanner);
                        break;
                    case 8:
                        escola33.alterarDados(scanner);
                        break;
                    case 9:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola33 escola33){
        String nome = Escola33.validandoNome(scanner);
        String cpf = Escola33.validandoCpf(scanner);
        int idade = Escola33.validandoIdade(scanner);
        int matricula = Escola33.validandoMatricula(scanner);
        double[] notas = Escola33.validandoNotas(scanner);
        Aluno33 aluno33 = new Aluno33(nome,cpf,idade,matricula,notas);
        escola33.addPessoas(aluno33);
    }

    public static void cadastroProfessor(Scanner scanner, Escola33 escola33){
        String nome = Escola33.validandoNome(scanner);
        String cpf = Escola33. validandoCpf(scanner);
        int idade = Escola33.validandoIdade(scanner);
        String disciplina = Escola33.validandoDisciplina(scanner);
        double salario = Escola33.validandoSalario(scanner);
        Professor33 professor33 = new Professor33(nome,cpf,idade,disciplina,salario);
        escola33.addPessoas(professor33);
    }
}
