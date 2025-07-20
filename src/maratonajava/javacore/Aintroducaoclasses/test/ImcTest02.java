package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Imc02;

import java.util.*;

public class ImcTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Imc02> imc02s = new ArrayList<>();

        while (true){
            int opcao =0;
            System.out.println("[ 1 ] Cadastro de paciente.");
            System.out.println("[ 2 ] Relatório de pacientes cadastradas.");
            System.out.println("[ 3 ] Avaliação do IMC.");
            System.out.println("[ 4 ] Alterar dados paciente.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao>=6){
                    System.out.println("Erro. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um opção válida. Tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Imc02.validandoNome(scanner);
                    double peso = Imc02.validandoPeso(scanner);
                    double altura = Imc02.validandoAltura(scanner);
                    Imc02 imc02 = new Imc02(nome,peso,altura);
                    imc02s.add(imc02);
                    break;

                case 2:
                    if (imc02s.isEmpty()){
                        System.out.println("Sem paciente cadastrado. Para gerar relatório efeitue o cadastro de pacientes.");
                    }else {
                        for (int i = 0; i < imc02s.size(); i++) {
                            Imc02 imc = imc02s.get(i);
                            imc.relatorioPessoasCadastradas(i, imc02s.size());
                        }
                    }
                    break;

                case 3:
                    System.out.println("AVALIÇÃO IMC PACIENTE.");
                    if (imc02s.isEmpty()){
                        System.out.println("Sem paciente cadastrado. Para verificar avaliação do ICM, cadastre um paciente primeiro.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula do paciente:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= imc02s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válido. Tente novamente.");
                                    continue;
                                }
                                Imc02 imcs = imc02s.get(matricula);
                                imcs.exibindoAvaliacaoImc();
                                break;
                            }catch (NumberFormatException erro){
                                System.out.println("Digite um valor válido, tente novamente.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("ALTERAR DADOS PACIENTE.");
                    if (imc02s.isEmpty()){
                        System.out.println("ERRO. Nenhum paciente cadastrado. Cadastre um paciente primeiro.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula do paciente.");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= imc02s.size()){
                                    System.out.println("Digite um número de matricula válido. Tente novamente.");
                                }else {
                                    Imc02 imcAlterarDados = imc02s.get(matricula);
                                    String novoNome = Imc02.validandoNome(scanner);
                                    imcAlterarDados.setNome(novoNome);
                                    double novoPeso = Imc02.validandoPeso(scanner);
                                    imcAlterarDados.setPeso(novoPeso);
                                    double novaAltura = Imc02.validandoAltura(scanner);
                                    imcAlterarDados.setAltura(novaAltura);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("Digite um valor válido. Tente novamente.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando o programa.");
                    return;

                default:
                    System.out.println("ERRO. Digite uma opção válida.");
            }
        }



    }
}
