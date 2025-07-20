package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno27;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola27;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor27;

import java.util.Scanner;

public class EscolaTest27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola27 escola27 = new Escola27();
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
                        cadastroAluno(scanner,escola27);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola27);
                        break;
                    case 3:
                        escola27.listarPessoas();
                        break;
                    case 4:
                        escola27.exibirDadosPesquisaPorNome(scanner);
                        break;
                    case 5:
                        escola27.excluirDados(scanner);
                        break;
                    case 6:
                        escola27.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma das opções acima.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola27 escola27){
        String nome = Escola27.validandoNome(scanner);
        String cpf = Escola27.validandoCpf(scanner);
        int idade = Escola27.validandoIdade(scanner);
        int matricula = Escola27.validandoMatricula(scanner);
        double[] notas = Escola27.validandoNotas(scanner);
        Aluno27 aluno27 = new Aluno27(nome,cpf,idade,matricula,notas);
        escola27.addPessoa(aluno27);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola27 escola27){
        String nome = Escola27.validandoNome(scanner);
        String cpf = Escola27.validandoCpf(scanner);
        int idade = Escola27.validandoIdade(scanner);
        String disciplina = Escola27.validandoDisciplina(scanner);
        double salario = Escola27.validandoSalarioProfessor(scanner);
        Professor27 professor27 = new Professor27(nome,cpf,idade,disciplina,salario);
        escola27.addPessoa(professor27);
    }
}
