package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno30;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola30;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor30;

import java.util.Scanner;

public class EscolaTest30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola30 escola30 = new Escola30();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro professor.");
            System.out.println("[3] Lista de pessoas cadastradas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir cadastro.");
            System.out.println("[6] Alterar cadastro.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola30);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola30);
                        break;
                    case 3:
                        escola30.listarPessoasCadastradas();
                        break;
                    case 4:
                        escola30.exibirPesquisaPorNome(scanner);
                        break;
                    case 5:
                        escola30.excluirDadosPessoa(scanner);
                        break;
                    case 6:
                        escola30.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma das opções acima.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner,Escola30 escola30){
        String nome = Escola30.validandoNome(scanner);
        String cpf = Escola30.validandoCpf(scanner);
        int idade = Escola30.validandoIdade(scanner);
        int matricula = Escola30.validandoMatricula(scanner);
        double[] notas = Escola30.validandoNotas(scanner);
        Aluno30 aluno30 = new Aluno30(nome,cpf,idade,matricula,notas);
        escola30.addPessoaSistema(aluno30);
    }

    public static void  cadastroProfessor(Scanner scanner, Escola30 escola30){
        String nome = Escola30.validandoNome(scanner);
        String cpf = Escola30.validandoCpf(scanner);
        int idade = Escola30.validandoIdade(scanner);
        String disciplina = Escola30.validandoDisciplina(scanner);
        double salario = Escola30.validandoSalarioProfessor(scanner);

        Professor30 professor30 = new Professor30(nome,cpf,idade,disciplina,salario);
        escola30.addPessoaSistema(professor30);
    }
}
