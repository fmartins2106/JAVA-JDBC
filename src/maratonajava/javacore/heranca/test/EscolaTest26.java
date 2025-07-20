package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno26;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola26;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor26;

import java.util.Scanner;

public class EscolaTest26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola26 escola26 = new Escola26();
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
                        cadastroAluno(scanner,escola26);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola26);
                        break;
                    case 3:
                        escola26.listaPessoasCadastradas();
                        break;
                    case 4:
                        escola26.exibirDetalhesPesquisa(scanner);
                        break;
                    case 5:
                        escola26.excluirDados(scanner);
                        break;
                    case 6:
                        escola26.alterarDados(scanner);
                        break;
                    case 7:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola26 escola26){
        String nome = Escola26.validandoNome(scanner);
        String cpf = Escola26.validandoCpf(scanner);
        int idade = Escola26.validandoIdade(scanner);
        int matricula = Escola26.validandoMatricula(scanner);
        double[] notas = Escola26.validandoNotas(scanner);
        Aluno26 aluno26 = new Aluno26(nome,cpf,idade,matricula,notas);
        escola26.addPessoa(aluno26);
    }

    public static void cadastroProfessor(Scanner scanner, Escola26 escola26){
        String nome = Escola26.validandoNome(scanner);
        String cpf = Escola26.validandoCpf(scanner);
        int idade = Escola26.validandoIdade(scanner);
        String disciplina = Escola26.validandoDisciplina(scanner);
        double salario = Escola26.validandoSalario(scanner);
        Professor26 professor26 = new Professor26(nome,cpf,idade,disciplina,salario);
        escola26.addPessoa(professor26);
    }
}
