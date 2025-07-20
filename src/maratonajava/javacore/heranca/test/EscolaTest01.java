package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Aluno01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Escola01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Professor01;

import java.util.Scanner;

public class EscolaTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Escola01 escola01 = new Escola01();
        while (true){
            System.out.println("[1] Cadastro Aluno.");
            System.out.println("[2] Cadastro Professor09.");
            System.out.println("[3] Listar Registro.");
            System.out.println("[4] Pesquisa por nome.");
            System.out.println("[5] Excluir registro.");
            System.out.println("[6] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroAluno(scanner, escola01);
                    break;
                case 2:
                    cadastroProfessor(scanner, escola01);
                    break;
                case 3:
                    escola01.listarRegistros();
                    break;
                case 4:
                    escola01.buscarPorNome(scanner);
                    break;
                case 5:
                    escola01.excluirPessoa(scanner);
                    break;
                case 6:
                    System.out.println(">>>FInalizando programa...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static void cadastroAluno(Scanner scanner, Escola01 escola01){
        String nome = Escola01.validandoNome(scanner,escola01);
        int idade = Escola01.validandoIdade(scanner);
        String cpf = Escola01.validandoCpf(scanner);
        int matricula = Escola01.validandoMatricula(scanner);
        Aluno01 aluno01 = new Aluno01(nome,idade,cpf,matricula);
        double[] notas = new double[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Digite a "+(i+1)+"ª nota:");
            notas[i] =Double.parseDouble(scanner.nextLine());
        }
        aluno01.setNotas(notas);
        escola01.addPessoa(aluno01);
    }

    public static void cadastroProfessor(Scanner scanner, Escola01 escola01){
        String nome = Escola01.validandoNome(scanner, escola01);
        int idade = Escola01.validandoIdade(scanner);
        String cpf = Escola01.validandoCpf(scanner);
        String disciplina = Escola01.validandoDisciplina(scanner,escola01);
        double salario = Escola01.validandoSalario(scanner);
        Professor01 professor01 = new Professor01(nome,idade,cpf,disciplina,salario);
        escola01.addPessoa(professor01);
    }
}
