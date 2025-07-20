package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor16;

import java.util.Scanner;

public class EscolaTest16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola16 escola16 = new Escola16();
        while (true){
            System.out.println("[1] Cadastro de aluno.");
            System.out.println("[2] Cadastro de professor.");
            System.out.println("[3] Lista de pessoas.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma opção válida:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroAluno(scanner,escola16);
                        break;
                    case 2:
                        cadastroProfessor(scanner,escola16);
                        break;
                    case 3:
                        escola16.listaPessoa();
                        break;
                    case 4:
                        escola16.pesquisaPorNome(scanner,escola16);
                        break;
                    case 5:
                        escola16.excluirDados(scanner,escola16);
                        break;
                    case 6:
                        escola16.alterarDados(scanner,escola16);
                        break;
                    case 7:
                        System.out.println(">>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola16 escola16){
        String nome = Escola16.validandoNome(scanner,escola16);
        String cpf = Escola16.validandoCpf(scanner,escola16);
        int idade = Escola16.validandoIdade(scanner,escola16);
        int matricula = Escola16.validandoMatricula(scanner,escola16);
        double[] notas = Escola16.validandoNotas(scanner,escola16);
        Aluno16 aluno16 = new Aluno16(nome,cpf,idade,matricula,notas);
        escola16.addPessoa(aluno16);
    }

    public static void cadastroProfessor(Scanner scanner, Escola16 escola16){
        String nome = Escola16.validandoNome(scanner,escola16);
        String cpf = Escola16.validandoCpf(scanner,escola16);
        int idade = Escola16.validandoIdade(scanner,escola16);
        String disciplina = Escola16.validandoDisciplina(scanner,escola16);
        double salario = Escola16.validandoSalario(scanner,escola16);
        Professor16 professor16 = new Professor16(nome,cpf,idade,disciplina,salario);
        escola16.addPessoa(professor16);
    }

}
