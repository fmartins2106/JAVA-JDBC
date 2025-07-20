package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor08;

import java.util.Scanner;

public class EscolaTest08 {
    public static void main(String[] args) {
        Escola08 escola08 = new Escola08();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro professor.");
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
                    cadastrandoAluno(scanner,escola08);
                    break;
                case 2:
                    cadastroProfessor(scanner,escola08);
                    break;
                case 3:
                    escola08.listaPessoasCadastradas();
                    break;
                case 4:
                    escola08.pesquisaPorNome(scanner,escola08);
                    break;
                case 5:
                    escola08.excluirDadosPessoa(scanner,escola08);
                    break;
                case 6:
                    escola08.alterarDados(scanner,escola08);
                    break;
                case 7:
                    System.out.println(">>>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    private static void cadastrandoAluno(Scanner scanner,Escola08 escola08){
        String nome = Escola08.validandoNome(scanner,escola08);
        int idade = Escola08.validandoIdade(scanner,escola08);
        String cpf = Escola08.validandoCpf(scanner,escola08);
        int matricula = Escola08.validandoMatricula(scanner,escola08);
        double[] notas = Escola08.validandoNotas(scanner,escola08);
        Aluno08 aluno08 = new Aluno08(nome,idade,cpf,matricula,notas);
        escola08.addPessoalista(aluno08);
    }

    private static void cadastroProfessor(Scanner scanner, Escola08 escola08){
        String nome = Escola08.validandoNome(scanner,escola08);
        int idade = Escola08.validandoIdade(scanner,escola08);
        String cpf = Escola08.validandoCpf(scanner,escola08);
        String disciplina = Escola08.validacaoDisciplina(scanner,escola08);
        double salario = Escola08.validandoSalario(scanner,escola08);
        Professor08 professor08 = new Professor08(nome,idade,cpf,disciplina,salario);
        escola08.addPessoalista(professor08);
    }

}
