package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor13;

import java.util.Scanner;

public class EscolaTest13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola13 escola13 = new Escola13();
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola13);
                    break;
                case 2:
                    cadastroProfessor(scanner, escola13);
                    break;
                case 3:
                    escola13.listaPessoas();
                    break;
                case 4:
                    escola13.pesquisaPorNome(scanner,escola13);
                    break;
                case 5:
                    escola13.excluindoDados(scanner,escola13);
                    break;
                case 6:
                    escola13.alterarDados(scanner,escola13);
                    break;
                case 7:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
    public static void cadastroAluno(Scanner scanner, Escola13 escola13){
        String nome = Escola13.validandoNome(scanner,escola13);
        String cpf = Escola13.validandoCpf(scanner,escola13);
        int idade = Escola13.validandoIdade(scanner,escola13);
        int matricula = Escola13.validandoMatricula(scanner,escola13);
        double[] notas = Escola13.validandoNotas(scanner,escola13);
        Aluno13 aluno13 = new Aluno13(nome,cpf,idade,matricula,notas);
        escola13.addPessoas(aluno13);
    }

    public static void cadastroProfessor(Scanner scanner, Escola13 escola13){
        String nome = Escola13.validandoNome(scanner,escola13);
        String cpf = Escola13.validandoCpf(scanner,escola13);
        int idade = Escola13.validandoIdade(scanner,escola13);
        String disciplina = Escola13.validandoDisciplina(scanner,escola13);
        double salario = Escola13.validandoSalario(scanner, escola13);
        Professor13 professor13 = new Professor13(nome,cpf,idade,disciplina,salario);
        escola13.addPessoas(professor13);
    }
}
