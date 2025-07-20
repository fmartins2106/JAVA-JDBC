package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno32;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola32;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor32;

import java.util.Scanner;

public class EscolaTest32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola32 escola32 = new Escola32();
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
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola32);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola32);
                        break;
                    case 3:
                        escola32.listarPessoas();
                        break;
                    case 4:
                        escola32.exibirPesquisaPorNome(scanner);
                        break;
                    case 5:
                        escola32.excluirDadosPessoa(scanner);
                        break;
                    case 6:
                        escola32.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola32 escola32){
        String nome = Escola32.validandoNome(scanner);
        String cpf = Escola32.validandoCpf(scanner);
        int idade = Escola32.validandoIdade(scanner);
        int matricula = Escola32.validandoMatricula(scanner);
        double[] notas = Escola32.validandoNotas(scanner);
        Aluno32 aluno32 = new Aluno32(nome,cpf,idade,matricula,notas);
        escola32.addPessoa(aluno32);
    }

    public static void cadastroProfessor(Scanner scanner, Escola32 escola32){
        String nome = Escola32.validandoNome(scanner);
        String cpf = Escola32.validandoCpf(scanner);
        int idade = Escola32.validandoIdade(scanner);
        String disciplina = Escola32.validandoDisciplina(scanner);
        double salario = Escola32.validandoSalario(scanner);
        Professor32 professor32 = new Professor32(nome,cpf,idade,disciplina,salario);
        escola32.addPessoa(professor32);
    }
}
