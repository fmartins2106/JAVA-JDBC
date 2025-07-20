package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor02;

import java.util.Scanner;

public class EscolaTest02 {
    public static void main(String[] args) {
        Escola02 escola02 = new Escola02();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir pessoa.");
            System.out.println("[5] Listar pessoas.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Opção inválida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner,escola02);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola02);
                    break;
                case 3:
                    escola02.pesquisaPorNome(scanner);
                    break;
                case 4:
                    escola02.excluirPessoa(scanner);
                    break;
                case 5:
                    escola02.listaRegistro();
                    break;
                case 6:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola02 escola02){
        String nome = Escola02.validandoNome(scanner,escola02);
        int idade = Escola02.validandoIdade(scanner);
        String cpf = Escola02.validandoCpf(scanner);
        int matricula = Escola02.validandoMatricula(scanner, escola02.getPessoa02s());
        Aluno02 aluno02 = new Aluno02(nome,idade,cpf,matricula);
        double[] notas = Escola02.validandoNotas(scanner);
        aluno02.setNotas(notas);
        escola02.addProdutos(aluno02);
    }

    public static void cadastroProfessor(Scanner scanner, Escola02 escola02){
        String nome = Escola02.validandoNome(scanner, escola02);
        int idade = Escola02.validandoIdade(scanner);
        String cpf = Escola02.validandoCpf(scanner);
        String disciplina = Escola02.validandoDisciplina(scanner,escola02);
        double salario = Escola02.validandoSalario(scanner);
        Professor02 professor02 = new Professor02(nome,idade,cpf,disciplina,salario);
        escola02.addProdutos(professor02);
    }




}
