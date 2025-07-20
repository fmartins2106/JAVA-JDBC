package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno23;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola23;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor23;

import java.util.Scanner;

public class EscolaTest23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola23 escola23 = new Escola23();
        while (true){
            try {
                System.out.println("[1] Cadastro aluno.");
                System.out.println("[2] Cadastro Professor.");
                System.out.println("[3] Lista de pessoas cadastradas.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados.");
                System.out.println("[7] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola23);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola23);
                        break;
                    case 3:
                        escola23.listaDePessoas();
                        break;
                    case 4:
                        escola23.exibirDadosPesquisaPorNome(scanner);
                        break;
                    case 5:
                        escola23.excluindoDados(scanner);
                        break;
                    case 6:
                        escola23.alterarDados(scanner);
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma das opções válidas.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola23 escola23){
        String nome = Escola23.validandoNome(scanner);
        String cpf = Escola23.validandoCpf(scanner);
        int idade = Escola23.validandoIdade(scanner);
        int matricula = Escola23.validandoMatricula(scanner);
        double[] notas = Escola23.validandoNotas(scanner);
        Aluno23 aluno23 = new Aluno23(nome,cpf,idade,matricula,notas);
        escola23.addPessoas(aluno23);
    }

    public static void cadastroProfessor(Scanner scanner,Escola23 escola23){
        String nome = Escola23.validandoNome(scanner);
        String cpf = Escola23.validandoCpf(scanner);
        int idade = Escola23.validandoIdade(scanner);
        String disciplina = Escola23.validandoDisciplina(scanner);
        double salario = Escola23.validandoSalario(scanner);
        Professor23 professor23 = new Professor23(nome,cpf,idade,disciplina,salario);
        escola23.addPessoas(professor23);
    }

}
