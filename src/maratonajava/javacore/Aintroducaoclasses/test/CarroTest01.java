package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

import java.util.ArrayList;
import java.util.*;


public class CarroTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> dadosCarros = new ArrayList<>();
        while (true){
            System.out.println("Vamos coletar informações dos carros.");
            System.out.print("Marca:");
            String marcaCarro = scanner.nextLine().trim().toLowerCase();
            System.out.print("Nome:");
            String nomeCarro = scanner.nextLine().trim().toLowerCase();
            System.out.print("Modelo:");
            String carroModelo = scanner.nextLine().trim().toLowerCase();
            System.out.print("Ano:");
            int anoCarro = scanner.nextInt();
            scanner.nextLine();
            String cadastrOutroCarro;
            Carro carro = new Carro(marcaCarro,nomeCarro,carroModelo,anoCarro);
            dadosCarros.add(carro);
            do {
                System.out.print("Quer cadastrar outro carro?(sim/não):");
                cadastrOutroCarro = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrOutroCarro.equals("não") && !cadastrOutroCarro.equals("sim"));
            if (cadastrOutroCarro.equals("não")){
                for (Carro c : dadosCarros){
                    System.out.println("Marca:"+c.getMarca());
                    System.out.println("Nome:"+c.getNome());
                    System.out.println("Modelo:"+c.getModelo());
                    System.out.println("Ano:"+c.getAno());
                }
                for (int n=0;n<30;n++){
                    System.out.print("=");
                }
                System.out.println();
                break;
            }
        }
    }
}
