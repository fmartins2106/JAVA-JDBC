package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno04;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno05;

import java.util.*;

public class AlunoTest05 {
    public static void main(String[] args) {
        Scanner scannerAluno05 = new Scanner(System.in);
        ArrayList<Aluno05> aluno05s = new ArrayList<>();
        while (true){
            int opcao=0;
            System.out.println("[ 1 ] Cadastrar aluno.");
            System.out.println("[ 2 ] Relatório de alunos.");
            System.out.println("[ 3 ] Ver Nota aluno.");
            System.out.println("[ 4 ] Alterar dados aluno.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scannerAluno05.nextLine());
                if (opcao<=0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage()+". Tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Aluno05.validandoNome(scannerAluno05);
                    double nota1 = Aluno05.validandoNota1(scannerAluno05);
                    double nota2 = Aluno05.validandoNota2(scannerAluno05);
                    Aluno05 aluno = new Aluno05(nome,nota1,nota2);
                    aluno05s.add(aluno);
                    break;

                case 2:
                    if (aluno05s.isEmpty()){
                        System.out.println("ERRO. Sem alunos cadastrados.");
                    }else {
                        for (int i = 0; i < aluno05s.size(); i++) {
                            Aluno05 aluno05 = aluno05s.get(i);
                            aluno05.exibindoTabelaResultados(i, aluno05s.size());
                        }
                    }
                    break;

                case 3:
                    if (aluno05s.isEmpty()){
                        System.out.println("ERRO. Lista está vazia, cadastre um aluno.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número da matricula:");
                                int matricula = Integer.parseInt(scannerAluno05.nextLine());
                                if (matricula<=-1 || matricula >= aluno05s.size()){
                                    System.out.println("ERRO. Digite um valor válido. Tente novamente.");
                                }else {
                                    Aluno05 aluno05 = aluno05s.get(matricula);
                                    aluno05.exibindoNotas(matricula);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO:"+e.getMessage());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alterar dados aluno.");
                    if (aluno05s.isEmpty()){
                        System.out.println("Lista vazia. Cadastre pelo menor uma aluno e tente novamente.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula:");
                                int matricula = Integer.parseInt(scannerAluno05.nextLine());
                                if (matricula<=-1 || matricula >= aluno05s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válido. Tente novamente.");
                                }else {
                                    Aluno05 alunos = aluno05s.get(matricula);
                                    String novoNome = Aluno05.validandoNome(scannerAluno05);
                                    alunos.setNome(novoNome);
                                    double novaNota1 = Aluno05.validandoNota1(scannerAluno05);
                                    alunos.setNota1(novaNota1);
                                    double novaNota2 = Aluno05.validandoNota2(scannerAluno05);
                                    alunos.setNota2(novaNota2);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO:"+e.getMessage());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Opção invalida, tente novamente.");
            }
        }
    }
}
