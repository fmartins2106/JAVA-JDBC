package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno31;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola31;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor31;

import java.util.Scanner;

public class EscolaTest31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola31 escola31 = new Escola31();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro professor.");
                System.out.println("[3] Lista de pessoas cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados pessoa.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola31);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola31);
                        break;
                    case 3:
                        escola31.listarPessoasCadastradas();
                        break;
                    case 4:
                        escola31.exibirDadosPesquisaNome(scanner);
                        break;
                    case 5:
                        escola31.excluirDados(scanner);
                        break;
                    case 6:
                        escola31.alterarDadosPessoa(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola31 escola31){
        String nome = Escola31.validandoNome(scanner);
        String cpf = Escola31.validandoCpf(scanner);
        int idade = Escola31.validandoIdade(scanner);
        int matricula = Escola31.validandoMatricula(scanner);
        double[] notas = Escola31.validandoNotas(scanner);
        Aluno31 aluno31 = new Aluno31(nome,cpf,idade,matricula,notas);
        escola31.addPessoa(aluno31);
    }

    public static void cadastroProfessor(Scanner scanner, Escola31 escola31){
        String nome = Escola31.validandoNome(scanner);
        String cpf = Escola31.validandoCpf(scanner);
        int idade = Escola31.validandoIdade(scanner);
        String disciplina = Escola31.validandoDisciplina(scanner);
        double salario = Escola31.validandoSalario(scanner);
        Professor31 professor31 = new Professor31(nome,cpf,idade,disciplina,salario);
        escola31.addPessoa(professor31);
    }


}
