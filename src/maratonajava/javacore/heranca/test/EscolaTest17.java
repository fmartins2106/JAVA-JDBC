package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor17;

import java.util.Scanner;

public class EscolaTest17 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Escola17  escola17 = new Escola17();
        while (true){
            System.out.println("[1] Cadastro aluno.");
            System.out.println("[2] Cadastro professor.");
            System.out.println("[3] Lista pessoa.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma opção válida:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola17);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola17);
                        break;
                    case 3:
                        escola17.listaPessoas();
                        break;
                    case 4:
                        escola17.exibirDadosPesquisaFuncionario(scanner,escola17);
                        break;
                    case 5:
                        escola17.excluirDadosPessoa(scanner,escola17);
                        break;
                    case 6:
                        escola17.alterarDadosPessoa(scanner,escola17);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException w){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner,Escola17 escola17){
        String nome = Escola17.validandoNome(scanner,escola17);
        String cpf = Escola17.validandoCpf(scanner,escola17);
        int idade = Escola17.validandoIdade(scanner,escola17);
        int matricula = Escola17.validandoMatricula(scanner,escola17);
        double[] notas = Escola17.validandoNotas(scanner,escola17);
        Aluno17 aluno17 = new Aluno17(nome,cpf,idade,matricula,notas);
        escola17.addPessoas(aluno17);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void cadastroProfessor(Scanner scanner, Escola17 escola17){
        String nome = Escola17.validandoNome(scanner,escola17);
        String cpf = Escola17.validandoCpf(scanner,escola17);
        int idade = Escola17.validandoIdade(scanner,escola17);
        String disciplina = Escola17.validandoDisciplina(scanner,escola17);
        double salario = Escola17.validandoSalario(scanner,escola17);
        Professor17 professor17 = new Professor17(nome,cpf,idade,disciplina,salario);
        escola17.addPessoas(professor17);
        System.out.println("Professor cadastrado com sucesso.");
    }



}
