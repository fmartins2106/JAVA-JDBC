package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor10;

import java.util.Scanner;

public class EscolaTes10 {
    public static void main(String[] args) {
        Escola10 escola10 = new Escola10();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola10);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola10);
                    break;
                case 3:
                    escola10.listaPessoas();
                    break;
                case 4:
                    escola10.pesquisaPorNome(scanner,escola10);
                    break;
                case 5:
                    escola10.excluirDados(scanner,escola10);
                    break;
                case 6:
                    escola10.alterandoDados(scanner,escola10);
                    break;
                case 7:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola10 escola10){
        String nome = Escola10.validandoNome(scanner,escola10);
        int idade = Escola10.validandoIdade(scanner,escola10);
        String cpf = Escola10.validandoCpf(scanner,escola10);
        int matricula = Escola10.validandoMatricula(scanner,escola10);
        double[] notas = Escola10.validandoNotas(scanner,escola10);
        Aluno10 aluno10 = new Aluno10(nome,idade,cpf,matricula,notas);
        escola10.addPessoas(aluno10);
    }

    public static void cadastroProfessor(Scanner scanner,Escola10 escola10){
        String nome = Escola10.validandoNome(scanner,escola10);
        int idade = Escola10.validandoIdade(scanner,escola10);
        String cpf = Escola10.validandoCpf(scanner,escola10);
        String disciplina = Escola10.validandoDisciplina(scanner,escola10);
        double salario = Escola10.validandoSalario(scanner,escola10);
        Professor10 professor10 = new Professor10(nome,idade,cpf,disciplina,salario);
        escola10.addPessoas(professor10);
    }

}
