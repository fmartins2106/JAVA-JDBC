package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor09;

import java.util.Scanner;

public class EscolaTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola09 escola09 = new Escola09();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro Professor.");
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
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola09);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola09);
                    break;
                case 3:
                    escola09.listaPessoas();
                    break;
                case 4:
                    escola09.pesquisaPorNome(scanner,escola09);
                    break;
                case 5:
                    escola09.excluirDados(scanner,escola09);
                    break;
                case 6:
                    escola09.alterandoDadosPessoa(scanner,escola09);
                    break;
                case 7:
                    System.out.println(">>>Finalizando Programa...");
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola09 escola09){
        String nome = Escola09.validandoNome(scanner,escola09);
        int idade = Escola09.validandoIdade(scanner,escola09);
        String cpf = Escola09.validandoCpf(scanner,escola09);
        int matricula = Escola09.validandoMatricula(scanner,escola09);
        double[] notas = Escola09.validandoNotas(scanner,escola09);
        Aluno09 aluno09 = new Aluno09(nome,idade,cpf,matricula,notas);
        escola09.addPessoas(aluno09);
    }

    public static void cadastroProfessor(Scanner scanner, Escola09 escola09){
        String nome = Escola09.validandoNome(scanner,escola09);
        int idade = Escola09.validandoIdade(scanner,escola09);
        String cpf = Escola09.validandoCpf(scanner,escola09);
        String disciplina = Escola09.validandoDisciplina(scanner,escola09);
        double salario = Escola09.validandoSalarioProfessor(scanner,escola09);
        Professor09 professor09 = new Professor09(nome,idade,cpf,disciplina,salario);
        escola09.addPessoas(professor09);
    }
}
