package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno24;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola24;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor24;

import java.util.Scanner;

public class EscolaTest24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola24 escola24 = new Escola24();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro professor.");
                System.out.println("[3] Lista de pessoas cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola24);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola24);
                        break;
                    case 3:
                        escola24.listaPessoas();
                        break;
                    case 4:
                        escola24.exibirDadosPesquisa(scanner);
                        break;
                    case 5:
                        escola24.excluirDadosPesquisa(scanner);
                        break;
                    case 6:
                        escola24.alterarDadosPesquisa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner,Escola24 escola24){
        String nome = Escola24.validandoNome(scanner);
        String cpf = Escola24.validandoCpf(scanner);
        int idade = Escola24.validandoIdade(scanner);
        int matricula = Escola24.validandoMatricula(scanner);
        double[] notas = Escola24.validandoNotas(scanner);
        Aluno24 aluno24 = new Aluno24(nome,cpf,idade,matricula,notas);
        escola24.addPessoa(aluno24);
    }

    public static void cadastroProfessor(Scanner scanner, Escola24 escola24){
        String nome = Escola24.validandoNome(scanner);
        String cpf = Escola24.validandoCpf(scanner);
        int idade = Escola24.validandoIdade(scanner);
        String disciplina = Escola24.validandoDisciplina(scanner);
        double salario = Escola24.validandoSalarioProfessor(scanner);
        Professor24 professor24 = new Professor24(nome,cpf,idade,disciplina,salario);
        escola24.addPessoa(professor24);
    }

}
