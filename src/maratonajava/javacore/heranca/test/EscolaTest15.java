package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor15;

import java.util.Scanner;

public class EscolaTest15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola15 escola15 = new Escola15();
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola15);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola15);
                    break;
                case 3:
                    escola15.listaPessoas();
                    break;
                case 4:
                    escola15.pesquisaPorNome(scanner,escola15);
                    break;
                case 5:
                    escola15.excluirDados(scanner,escola15);
                    break;
                case 6:
                    escola15.alterarDados(scanner,escola15);
                    break;
                case 7:
                    System.out.println(">>>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola15 escola15){
        String nome = Escola15.validandoNome(scanner,escola15);
        String cpf = Escola15.validandoCpf(scanner,escola15);
        int idade = Escola15.validandoIdade(scanner,escola15);
        int matricula = Escola15.validandoMatricula(scanner,escola15);
        double[] notas = Escola15.validandoNotas(scanner,escola15);
        Aluno15 aluno15 = new Aluno15(nome,cpf,idade,matricula,notas);
        escola15.addPessoas(aluno15);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola15 escola15){
        String nome = Escola15.validandoNome(scanner,escola15);
        String cpf = Escola15.validandoCpf(scanner,escola15);
        int idade = Escola15.validandoIdade(scanner,escola15);
        String disciplina = Escola15.validandoDisciplina(scanner,escola15);
        double salario = Escola15.validandoSalario(scanner,escola15);
        Professor15 professor15 = new Professor15(nome,cpf,idade,disciplina,salario);
        escola15.addPessoas(professor15);
        System.out.println("Professor cadastrado com sucesso.");
    }
}
