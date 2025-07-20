package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor04;

import java.util.Scanner;

public class EscolaTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola04 escola04 = new Escola04();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Lista de pessoas cadastradas.");
            System.out.println("[5] Excluir pessoas.");
            System.out.println("[6] Alterar dados pessoas.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opçoes acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroDeAluno(scanner,escola04);
                    break;
                case 2:
                    cadastroDeProfessor(scanner,escola04);
                    break;
                case 3:
                    escola04.pesquisaNome(scanner);
                    break;
                case 4:
                    escola04.listarPessoas();
                    break;
                case 5:
                    escola04.excluirDados(scanner);
                    break;
                case 6:
                    escola04.alterandoDados(scanner,escola04);
                    break;
                case 7:
                    System.out.println(">>>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroDeAluno(Scanner scanner, Escola04 escola04){
        String nome = Escola04.validandoNome(scanner,escola04);
        int idade = Escola04.validandoIdade(scanner);
        String cpf = Escola04.validandoCpf(scanner);
        int matricula = Escola04.validandoMatricula(scanner,escola04.getPessoa04s());
        double[] notas = Escola04.validandoNotas(scanner);
        Aluno04 aluno04 = new Aluno04(nome,idade,cpf,matricula,notas);
        escola04.addPessoas(aluno04);
    }

    public static void cadastroDeProfessor(Scanner scanner, Escola04 escola04){
        String nome = Escola04.validandoNome(scanner,escola04);
        int idade = Escola04.validandoIdade(scanner);
        String cpf = Escola04.validandoCpf(scanner);
        String disciplina = Escola04.validandoDisciplina(scanner,escola04);
        double salario = Escola04.validandoSalarioProfessor(scanner);
        Professor04 professor04 = new Professor04(nome,idade,cpf,disciplina,salario);
        escola04.addPessoas(professor04);
    }
}
