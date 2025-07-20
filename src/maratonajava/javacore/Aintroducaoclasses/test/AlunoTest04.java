package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Aluno04;

import java.util.*;

public class AlunoTest04 {
    public static void main(String[] args) {
        Scanner aluno04 = new Scanner(System.in);
        ArrayList<Aluno04> aluno04s = new ArrayList<>();

        while (true){
            int opcao=0;
            System.out.println("Escolha uma das opções:");
            System.out.println("[ 1 ] Adicionar notas aluno.");
            System.out.println("[ 2 ] Listar alunos.");
            System.out.println("[ 3 ] Ver notas aluno.");
            System.out.println("[ 4 ] Alterar dados aluno.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma dads opções acima:");
                opcao = Integer.parseInt(aluno04.nextLine());
                if (opcao<0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válido. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage()+".Tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Aluno04.verificandoNome(aluno04);
                    double nota1 = Aluno04.verificandoNota1(aluno04);
                    double nota2 = Aluno04.verificandoNota2(aluno04);
                    Aluno04 aluno = new Aluno04(nome,nota1,nota2);
                    aluno04s.add(aluno);
                    break;

                case 2:
                    if (aluno04s.isEmpty()){
                        System.out.println("A lista está vazia, cadastre um aluno.");
                    }else {
                        for (int i = 0; i < aluno04s.size(); i++) {
                            Aluno04 alunos = aluno04s.get(i);
                            alunos.exibindoResultadoAlunos(i,aluno04s.size());
                        }
                        break;
                    }

                case 3:
                    if (aluno04s.isEmpty()){
                        System.out.println("A lista esta vazia, cadastre um aluno.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o numero da matricula:");
                                int matricula = Integer.parseInt(aluno04.nextLine());
                                if (matricula<= aluno04s.size()){
                                    Aluno04 aluno5 = aluno04s.get(matricula);
                                    aluno5.exibindoNotasAluno();
                                    break;
                                }else {
                                    System.out.println("ERRO. Digite uma matricula válida.");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERR:"+e.getMessage());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alterar dados do aluno.");
                    while (true){
                        try {
                            System.out.print("Digite a matricular do aluno:");
                            int matricula = Integer.parseInt(aluno04.nextLine());
                            if (matricula<= aluno04s.size()){
                                Aluno04 alterarDadosAluno = aluno04s.get(matricula);
                                String novoNome = Aluno04.verificandoNome(aluno04);
                                alterarDadosAluno.setNome(novoNome);
                                double novaNota1 = Aluno04.verificandoNota1(aluno04);
                                alterarDadosAluno.setNota1(novaNota1);
                                double novaNota2 = Aluno04.verificandoNota2(aluno04);
                                alterarDadosAluno.setNota2(novaNota2);
                                break;
                            }else {
                                System.out.println("ERRO. Número de matricula inválido. Tente novamente.");
                            }
                        }catch (NumberFormatException e){
                            System.out.println("ERRO:"+e.getMessage());
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando programa...");
                    return;

                default:
                    System.out.println("ERRO. Tente novamente.");
            }
        }
    }
}
