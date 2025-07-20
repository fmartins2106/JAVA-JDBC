package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario08;

import java.util.*;

public class FuncionarioTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario08> funcionario08s = new ArrayList<>();

        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar funcionário.");
            System.out.println("[2] Lista de funcionários cadastrados.");
            System.out.println("[3] Listar funcionário por salário");
            System.out.println("[4] Alterar dados funcionário.");
            System.out.println("[5] Excluir funcionário da lista.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Escolha uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<-0 || opcao>=7){
                    System.out.println("ERRO. Digite uma opção válida.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Funcionario08.validandoNome(scanner);
                    double salario = Funcionario08.validandoSalario(scanner);
                    String cargo = Funcionario08.validandoCargo(scanner);
                    Funcionario08 funcionario08 = new Funcionario08(nome,salario,cargo);
                    funcionario08s.add(funcionario08);
                    break;

                case 2:
                    if (funcionario08s.isEmpty()){
                        System.out.println("Lista vazio. Cadastre um funcionário.");
                    }else {
                        for (int i = 0; i < funcionario08s.size(); i++) {
                            Funcionario08 funciorio = funcionario08s.get(i);
                            funciorio.exibindoListaFuncionarios(i, funcionario08s.size());
                        }
                        break;
                    }
                    break;

                case 3:
                    if (funcionario08s.isEmpty()){
                        System.out.println("Lista vazio. Cadastre funcionarios.");
                    }else {
                        ArrayList<Funcionario08> cloneList = new ArrayList<>();
                        for (Funcionario08 funcionario : funcionario08s){
                            cloneList.add(funcionario.clone());
                        }
                        Collections.sort(cloneList,Comparator.comparingDouble(Funcionario08::getSalario).reversed());
                        for (int i = 0; i < cloneList.size(); i++) {
                            Funcionario08 funcionariosCloneList = cloneList.get(i);
                            funcionariosCloneList.exibindoListaFuncionarios(i, cloneList.size());
                        }
                    }
                    break;

                case 4:
                    if (funcionario08s.isEmpty()){
                        System.out.println("Lista vazia, cadastre funcionários.");
                    }else {
                        while (true) {
                            try {
                                System.out.print("Digite o número da matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>= funcionario08s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válida.");
                                }else {
                                    Funcionario08 funcionario = funcionario08s.get(matricula);
                                    funcionario.setNome(Funcionario08.validandoNome(scanner));
                                    funcionario.setSalario(Funcionario08.validandoSalario(scanner));
                                    funcionario.setCargo(Funcionario08.validandoCargo(scanner));
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO. Digite um valor válido;");
                            }
                        }
                    }
                    break;

                case 5:
                    if (funcionario08s.isEmpty()){
                        System.out.println("Lista vazia, cadastre funcionários.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula <0 || matricula >= funcionario08s.size()){
                                    System.out.println("Número de matricula inválida.");
                                }else {
                                    Funcionario08 funcioario = funcionario08s.remove(matricula);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO. Digite um valor válido. Tente novamente.");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println(">>Finaliando o programa<<");
                    return;
                default:
                    System.out.println("Erro. Digite um valor válido.");
            }
        }
    }
}
