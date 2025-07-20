
package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno20;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola20;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor20;

import java.util.Scanner;

public class EscolaTest20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola20 escola20 = new Escola20();
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
                        cadastroAluno(scanner,escola20);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola20);
                        break;
                    case 3:
                        escola20.listaPessoas();
                        break;
                    case 4:
                        escola20.exibirDadosPesquisa(scanner);
                        break;
                    case 5:
                        escola20.excluindoDadosPessoa(scanner);
                        break;
                    case 6:
                        escola20.alterandoDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando o programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção valida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola20 escola20){
        String nome = Escola20.validandoNome(scanner);
        String cpf = Escola20.validandoCpf(scanner);
        int idade = Escola20.validandoIdade(scanner);
        int matricula = Escola20.validandoMatricula(scanner);
        double[] notas = Escola20.validandoNotas(scanner);
        Aluno20 aluno20 = new Aluno20(nome,cpf,idade,matricula,notas);
        escola20.addPessoas(aluno20);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola20 escola20){
        String nome = Escola20.validandoNome(scanner);
        String cpf = Escola20.validandoCpf(scanner);
        int idade = Escola20.validandoIdade(scanner);
        String disciplina = Escola20.validandoDisciplina(scanner);
        double salario = Escola20.validandoSalarioProfessor(scanner);
        Professor20 professor20 = new Professor20(nome,cpf,idade,disciplina,salario);
        escola20.addPessoas(professor20);
        System.out.println("Professor cadastrado com sucesso.");
    }
}
