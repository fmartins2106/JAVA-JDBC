package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno34;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola34;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor34;

import java.util.Scanner;

public class EscolaTest34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola34 escola34 = new Escola34();
        while (true){
            try {
                System.out.println("[1] Cadastro de aluno.");
                System.out.println("[2] Cadastro de professor.");
                System.out.println("[3] Lista de alunos cadastrados.");
                System.out.println("[4] Lista de professores cadastrados.");
                System.out.println("[5] Pesquisa por nome.");
                System.out.println("[6] Excluir dados pessoa.");
                System.out.println("[7] Alterar dados pessoa.");
                System.out.println("[8] Listar pessoas cadastradas.");
                System.out.println("[9] Sair.");
                System.out.print("Digite uma das opções acima:");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola34);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola34);
                        break;
                    case 3:
                        escola34.listarDadosAluno();
                        break;
                    case 4:
                        escola34.listarDadosProfessor();
                        break;
                    case 5:
                        escola34.exibirDadosPequisaNome(scanner);
                        break;
                    case 6:
                        escola34.excluirDadosPessoa(scanner);
                        break;
                    case 7:
                        escola34.alterarDados(scanner);
                        break;
                    case 8:
                        escola34.listarPessoasCadastradas();
                        break;
                    case 9:
                        System.out.println(">>>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola34 escola34){
        String nome = Escola34.validandoNome(scanner);
        String cpf = Escola34.validandoCpf(scanner);
        int idade = Escola34.validandoIdade(scanner);
        int matricula = Escola34.valindandoMatricula(scanner);
        double[] notas = Escola34.validandoNotas(scanner);
        Aluno34 aluno34 = new Aluno34(nome,cpf,idade,matricula,notas);
        escola34.addCadastro(aluno34);
    }

    public static void cadastroProfessor(Scanner scanner, Escola34 escola34){
        String nome = Escola34.validandoNome(scanner);
        String cpf = Escola34.validandoCpf(scanner);
        int idade = Escola34.validandoIdade(scanner);
        String disciplina = Escola34.validandoDisciplina(scanner);
        double salario = Escola34.validandoSalarioProfessor(scanner);
        Professor34 professor34 = new Professor34(nome,cpf,idade,disciplina,salario);
        escola34.addCadastro(professor34);
    }
}
