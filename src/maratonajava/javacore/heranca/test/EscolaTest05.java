package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor05;

import java.util.Scanner;

public class EscolaTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola05 escola05 = new Escola05();
        while (true){
            System.out.println("[1] Cadastro  de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados pessoa.");
            System.out.println("[6] Alterar dados pessoa.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das oções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrandoAluno(scanner,escola05);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola05);
                    break;
                case 3:
                    escola05.listaPessoas();
                    break;
                case 4:
                    escola05.pesquisaPorNome(scanner);
                    break;
                case 5:
                    escola05.excluirDados(scanner);
                    break;
                case 6:
                    escola05.alterarDados(scanner,escola05);
                    break;
                case 7:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastrandoAluno(Scanner scanner, Escola05 escola05){
        String nome = Escola05.validandoNome(scanner,escola05);
        int idade = Escola05.validandoIdade(scanner);
        String cpf = Escola05.validandoCpf(scanner);
        int matricula = Escola05.validandoMatricula(scanner,escola05.getPessoa05s());
        double[] notas = Escola05.validandonotas(scanner);
        Aluno05 aluno05 = new Aluno05(nome,idade,cpf,matricula,notas);
        escola05.addPessoas(aluno05);
    }

    public static void cadastroProfessor(Scanner scanner, Escola05 escola05){
        String nome = Escola05.validandoNome(scanner,escola05);
        int idade = Escola05.validandoIdade(scanner);
        String cpf = Escola05.validandoCpf(scanner);
        String disciplina = Escola05.validandoDisciplina(scanner,escola05);
        double salario = Escola04.validandoSalarioProfessor(scanner);
        Professor05 professor05 = new Professor05(nome,idade,cpf,disciplina,salario);
        escola05.addPessoas(professor05);
    }
}
