package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Veiculos01;

import java.util.*;

public class VeiculoTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Veiculos01> veiculos01s = new ArrayList<>();

        while (true){
            String nome ="";
            while (true){
                System.out.print("Nome:");
                nome= scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Digite o nome do carro. Tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+")){
                        System.out.println("Digite o nome do carro. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            String placa = "";
            while (true){
                System.out.print("Placa:");
                placa = scanner.nextLine().trim().toUpperCase();
                if (placa.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!placa.matches("^[A-Z]{3}-[0-9]{4}$")){
                        System.out.println("ERRO. Tente novamente, placa deve ser no modelo ABC-1234");
                    }else {
                        break;
                    }
                }
            }
            int ano=0;
            int anoAtual = java.time.Year.now().getValue();
            while (true){
                try {
                    System.out.print("Ano:");
                    ano = Integer.parseInt(scanner.nextLine());
                    if (ano<=1900 || ano>=anoAtual){
                        System.out.println("Ano carro não pode ser menor que 1900 ou maior que ano atual.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido, tente novamente.");
                }
            }
            String cor="";
            while (true){
                System.out.print("Cor:");
                cor = scanner.nextLine().trim();
                if (cor.isEmpty()){
                    System.out.println("Digite uma cor válida.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+$")){
                        System.out.println("Digite uma cor válida, tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            Veiculos01 veiculos01 = new Veiculos01(nome,placa,ano,cor);
            veiculos01s.add(veiculos01);
            String cadastrarVeiculo;
            while (true){
                System.out.print("Quer adicionar outro veiculo?(sim/não):");
                cadastrarVeiculo = scanner.nextLine().trim().toLowerCase();
                if (cadastrarVeiculo.equals("sim") || cadastrarVeiculo.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (cadastrarVeiculo.equals("não")){
                System.out.println("Finalizando o programa...");
                for (Veiculos01 veiculo : veiculos01s){
                    veiculo.monstrandoDadosCarro();
                }
                break;
            }
        }

    }


}
