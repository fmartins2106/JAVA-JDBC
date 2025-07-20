package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno25;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola24;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola25;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor25;

import java.util.Scanner;

public class EscolaTest25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola25 escola25 = new Escola25();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro professo.");
                System.out.println("[3] Lista de pessoa cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola25);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola25);
                        break;
                    case 3:
                        escola25.listarPessoasCadastradas();
                        break;
                    case 4:
                        escola25.exibirDadosPesquisaNome(scanner);
                        break;
                    case 5:
                        escola25.excluirDados(scanner);
                        break;
                    case 6:
                        escola25.alterarDados(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola25 escola25){
        String nome = Escola25.validandoNome(scanner);
        String cpf = Escola25.validandoCpf(scanner);
        int idade = Escola25.validandoIdade(scanner);
        int matricula =Escola25.validandoMatricula(scanner);
        double[] notas = Escola24.validandoNotas(scanner);
        Aluno25 aluno25 = new Aluno25(nome,cpf,idade,matricula,notas);
        escola25.addPessoas(aluno25);
    }

    public static void cadastroProfessor(Scanner scanner, Escola25 escola25){
        String nome = Escola25.validandoNome(scanner);
        String cpf = Escola25.validandoCpf(scanner);
        int idade = Escola25.validandoIdade(scanner);
        String disciplina = Escola25.validandoDisciplina(scanner);
        double salario = Escola25.validandoSalario(scanner);
        Professor25 professor25 = new Professor25(nome,cpf,idade,disciplina,salario);
        escola25.addPessoas(professor25);
    }

}
