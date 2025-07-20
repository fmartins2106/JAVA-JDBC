package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno22;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola22;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor22;

import java.util.Scanner;

public class EscolaTest22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola22 escola22 = new Escola22();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro Professor.");
                System.out.println("[3] Lista de pessoas cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma opção válida.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola22);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola22);
                        break;
                    case 3:
                        escola22.listaPessoas();
                        break;
                    case 4:
                        escola22.exibirDadosPesquisaNome(scanner);
                        break;
                    case 5:
                        escola22.excluirDadosPessoa(scanner);
                        break;
                    case 6:
                        escola22.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando sistema...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida:");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola22 escola22){
        String nome = Escola22.validandoNome(scanner);
        String cpf = Escola22.validandoCpf(scanner);
        int idade = Escola22.validandoIdade(scanner);
        int matricula = Escola22.validandoMatricula(scanner);
        double[] notas = Escola22.validandoNotas(scanner);
        Aluno22 aluno22 = new Aluno22(nome,cpf,idade,matricula,notas);
        escola22.addPessoas(aluno22);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola22 escola22){
        String nome = Escola22.validandoNome(scanner);
        String cpf = Escola22.validandoCpf(scanner);
        int idade = Escola22.validandoIdade(scanner);
        String disciplina = Escola22.validandoDisciplina(scanner);
        double salario = Escola22.validandoSalario(scanner);
        Professor22 professor22 = new Professor22(nome,cpf,idade,disciplina,salario);
        escola22.addPessoas(professor22);
        System.out.println("Professor cadastrado com sucesso.");
    }
}
