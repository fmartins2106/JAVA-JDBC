package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno18;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola18;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor18;

import java.util.Scanner;

public class EscolaTest18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola18 escola18 = new Escola18();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro professor.");
            System.out.println("[3] Lista pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola18);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola18);
                        break;
                    case 3:
                        escola18.listaPessoas();
                        break;
                    case 4:
                        escola18.exibirDadosPesquisa(scanner,escola18);
                        break;
                    case 5:
                        escola18.excluirDadosPessoa(scanner,escola18);
                        break;
                    case 6:
                        escola18.alterarDadosPessoa(scanner,escola18);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando sistema...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");

                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma das opções acima.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola18 escola18){
        String nome = Escola18.validandoNome(scanner, escola18);
        String cpf = Escola18.validandoCpf(scanner,escola18);
        int idade = Escola18.validandoIdade(scanner, escola18);
        int matricula = Escola18.validandoMatricula(scanner, escola18);
        double[] notas = Escola18.validandoNotas(scanner,escola18);
        Aluno18 aluno18 = new Aluno18(nome,cpf,idade,matricula,notas);
        escola18.addPessoas(aluno18);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner,Escola18 escola18){
        String nome = Escola18.validandoNome(scanner,escola18);
        String cpf = Escola18.validandoCpf(scanner,escola18);
        int idade = Escola18.validandoIdade(scanner,escola18);
        String disciplina = Escola18.validandoDisciplina(scanner, escola18);
        double salario = Escola18.validandoSalarioProfessor(scanner,escola18);
        Professor18 professor18 = new Professor18(nome,cpf,idade,disciplina,salario);
        escola18.addPessoas(professor18);
        System.out.println("Professor cadastrado com sucesso.");
    }
}
