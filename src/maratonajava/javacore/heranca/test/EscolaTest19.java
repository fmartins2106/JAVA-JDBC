package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno19;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola19;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor19;

import java.util.Scanner;

public class EscolaTest19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola19 escola19 = new Escola19();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro Professor.");
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
                        cadastroAluno(scanner,escola19);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola19);
                        break;
                    case 3:
                        escola19.listaPessoasCadastradas();
                        break;
                    case 4:
                        escola19.exibirDadosPesquisa(scanner);
                        break;
                    case 5:
                        escola19.excluirDados(scanner);
                        break;
                    case 6:
                        escola19.alterarDados(scanner);
                        break;
                    case 7:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um número válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola19 escola19){
        String nome = Escola19.validandoNome(scanner);
        String cpf = Escola19.validandoCpf(scanner);
        int idade = Escola19.validandoIdade(scanner);
        int matricula = Escola19.validandoMatricula(scanner);
        double[] notas = Escola19.validandoNotas(scanner);
        Aluno19 aluno19 = new Aluno19(nome,cpf,idade,matricula,notas);
        escola19.addPessoas(aluno19);
    }

    public static void cadastroProfessor(Scanner scanner, Escola19 escola19){
        String nome = Escola19.validandoNome(scanner);
        String cpf = Escola19.validandoCpf(scanner);
        int idade = Escola19.validandoIdade(scanner);
        String disciplina = Escola19.validandoDisciplina(scanner);
        double salario = Escola19.validandoSalario(scanner);
        Professor19 professor19 = new Professor19(nome,cpf,idade,disciplina,salario);
        escola19.addPessoas(professor19);
    }

}
