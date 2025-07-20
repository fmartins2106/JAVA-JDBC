package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno29;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola29;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor29;

import java.util.Scanner;

public class EscolaTest29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola29 escola29 = new Escola29();
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
                        cadastroAluno(scanner,escola29);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola29);
                        break;
                    case 3:
                        escola29.listarPessoasCadastradas();
                        break;
                    case 4:
                        escola29.exibirPesquisaPorNome(scanner);
                        break;
                    case 5:
                        escola29.excluirDados(scanner);
                        break;
                    case 6:
                        escola29.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>>Finalizando programa.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola29 escola29){
        String nome = Escola29.validandoNome(scanner);
        String cpf = Escola29.validandoCpf(scanner);
        int idade = Escola29.validandoIdade(scanner);
        int matricula = Escola29.validandoMatricala(scanner);
        double[] notas = Escola29.validandoNotas(scanner);
        Aluno29 aluno29 = new Aluno29(nome,cpf,idade,matricula,notas);
        escola29.addPessoas(aluno29);
    }

    public static void cadastroProfessor(Scanner scanner, Escola29 escola29){
        String nome = Escola29.validandoNome(scanner);
        String cpf = Escola29.validandoCpf(scanner);
        int idade = Escola29.validandoIdade(scanner);
        String disciplina = Escola29.validandoDisciplina(scanner);
        double salario = Escola29.validandoSalario(scanner);
        Professor29 professor29 = new Professor29(nome,cpf,idade,disciplina,salario);
        escola29.addPessoas(professor29);
    }
}