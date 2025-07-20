package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno21;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola21;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor21;

import java.util.Scanner;

public class EscolaTest21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola21 escola21 = new Escola21();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro professor.");
                System.out.println("[3] Lista de pessoas cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner, escola21);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola21);
                        break;
                    case 3:
                        escola21.listaPessoas();
                        break;
                    case 4:
                        escola21.exibirDadosPesquisa(scanner);
                        break;
                    case 5:
                        escola21.excluirDadosPessoas(scanner);
                        break;
                    case 6:
                        escola21.alterardadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Opção inválida. Digite uma das opções acima.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner,Escola21 escola21){
        String nome = Escola21.validandoNome(scanner);
        String cpf = Escola21.validandoCpf(scanner);
        int idade = Escola21.validandoIdade(scanner);
        int matricula = Escola21.validandoMatricula(scanner);
        double[] notas = Escola21.validandoNotas(scanner);
        Aluno21 aluno21 = new Aluno21(nome,cpf,idade,matricula,notas);
        escola21.addPessoas(aluno21);
    }

    public static void cadastroProfessor(Scanner scanner, Escola21 escola21){
        String nome = Escola21.validandoNome(scanner);
        String cpf = Escola21.validandoCpf(scanner);
        int idade = Escola21.validandoIdade(scanner);
        String disciplina = Escola21.validandoDisciplin(scanner);
        double salario = Escola21.validacaoSalario(scanner);
        Professor21 professor21 = new Professor21(nome,cpf,idade,disciplina,salario);
        escola21.addPessoas(professor21);
    }
}
