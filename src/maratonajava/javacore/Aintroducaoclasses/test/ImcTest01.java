package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Imc01;


import java.util.*;

public class ImcTest01 {
    public static void main(String[] args) {
        Scanner scannerImc01 = new Scanner(System.in);

        ArrayList<Imc01> imc01s = new ArrayList<>();

        while (true){
            for (int i = 0; i < 50; i++) {
                System.out.print("=");
            }
            System.out.println();
            int opcao = 0;
            System.out.println("[ 1 ] Cadastrar pessoa.");
            System.out.println("[ 2 ] Lista de pessoas cadastradas.");
            System.out.println("[ 3 ] Analisar IMC.");
            System.out.println("[ 4 ] Alterar cadastro.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scannerImc01.nextLine());
                if (opcao<=0 || opcao>6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }
            switch (opcao){
                case 1:
                    String nome = Imc01.validandoNome(scannerImc01);
                    double peso = Imc01.validandoPeso(scannerImc01);
                    double altura = Imc01.validandoAltura(scannerImc01);
                    Imc01 imc01 = new Imc01(nome,peso,altura);
                    imc01s.add(imc01);
                    break;

                case 2:
                    if (imc01s.isEmpty()){
                        System.out.println("Lista está vazia, adicione pessoas para poder ver a lista com dados.");
                    }else {
                        for (int i = 0; i < imc01s.size(); i++) {
                            Imc01 imc2 = imc01s.get(i);
                            imc2.exibindoResultados(i, imc01s.size());
                        }
                        break;
                    }
                    break;

                case 3:
                    if (imc01s.isEmpty()){
                        System.out.println("ERRO. Lista está vazia. Para analisar IMC, primeiro Cadastre pessoas.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula:");
                                int matricula = Integer.parseInt(scannerImc01.nextLine());
                                if (matricula>= 0 && matricula<  imc01s.size()){
                                    Imc01 imc2 = imc01s.get(matricula);
                                    imc2.avaliacaoIMC();
                                    break;
                                }else {
                                    System.out.println("ERRO. Matricula inválida, tente novamente.");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO:"+e.getMessage());
                            }
                        }
                    }
                    break;

                case 4:
                    if (imc01s.isEmpty()){
                        System.out.println("Lista vazia. Não é possivel alterar cadastro.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o nome da matricula:");
                                int matricula = Integer.parseInt(scannerImc01.nextLine());
                                if (matricula>= 0 && matricula<  imc01s.size()){
                                    Imc01  alterandoDados = imc01s.get(matricula);
                                    String novoNome = Imc01.validandoNome(scannerImc01);
                                    alterandoDados.setNome(novoNome);
                                    double novoPeso = Imc01.validandoPeso(scannerImc01);
                                    alterandoDados.setPeso(novoPeso);
                                    double novaAltura = Imc01.validandoAltura(scannerImc01);
                                    alterandoDados.setAltura(novaAltura);
                                    break;
                                }else {
                                    System.out.println("ERRO. Matricula inválida, tente novamente.");
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
                    System.out.println("ERRO. Tente outra opção.");
            }
        }
    }
}
