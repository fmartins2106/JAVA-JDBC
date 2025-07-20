package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class Escola09 {
    private ArrayList<Aluno09> aluno09s;

    public Escola09(){
        this.aluno09s = new ArrayList<>();
    }

    public void addAluno(Aluno09 aluno){
        aluno09s.add(aluno);
    }

    public void alterarDadosAluno(Scanner scanner){
        if (aluno09s.isEmpty()){
            System.out.println("Lista vazia, cadasdre alunos.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int indice = Integer.parseInt(scanner.nextLine());
                if (indice >= 0 && indice < aluno09s.size()){
                    Aluno09  aluno09 = aluno09s.get(indice);
                    aluno09.setNome(Escola09.validandoNome(scanner));
                    aluno09.setNota1(Escola09.validandoNota1(scanner));
                    aluno09.setNota2(Escola09.validandoNota2(scanner));
                }else {
                    System.out.println("Indice não encontrado. Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }

        }
    }

    public void buscarAluno(Scanner scanner){
        if (this.aluno09s.isEmpty()){
            System.out.println("Lista vazia. Cadastre alunos.");
        }else {
            String nome = Escola09.validandoNome(scanner);
            boolean encontrado = false;
            for (Aluno09 aluno09 : aluno09s){
                if (aluno09.getNome().equalsIgnoreCase(nome)){
                    System.out.println("Nome:"+ aluno09.getNome());
                    System.out.println("Nota1:"+ aluno09.getNota1());
                    System.out.println("Nota2:"+ aluno09.getNota2());
                    encontrado = true;
                }
            }
            if (!encontrado){
            System.out.println("Livro não encontrado.");
            }
        }
    }


    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Aluno09.formatoNome(nome);
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("nota1:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1 < 0 || nota1 > 10){
                    System.out.println("Nota não pode ser menor que zero e maior que dez.");
                    continue;
                }
                return nota1;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Nota2:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2 < 0 || nota2> 10){
                    System.out.println("Nota não pode ser menor que zero e maior que dez.");
                    continue;
                }
                return nota2;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listarAlunos(){
        if (aluno09s.isEmpty()){
            System.out.println("Lista. Vazia.");
        }else {
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-15s\n","No","Nome","Média","Situação");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        int index=0;
        for (Aluno09 aluno09 : aluno09s){
            System.out.printf("%-4d %-25s %-8.2f %-15s\n", index++,aluno09.getNome(),aluno09.getMedia(),aluno09.getSituacao());
        }
        for (int i = 0; i < 60; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void excluirDadosAluno(Scanner scanner){
        if (aluno09s.isEmpty()){
            System.out.println("Lista vazia. Tente novamente.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int indice = Integer.parseInt(scanner.nextLine());
                if (indice >= 0 && indice <= aluno09s.size()) {
                    aluno09s.remove(indice);
                }else {
                    System.out.println("matricula inválida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente.");
            }

        }
    }

    public ArrayList<Aluno09> getAluno09s() {
        return aluno09s;
    }

    public void setAluno09s(ArrayList<Aluno09> aluno09s) {
        this.aluno09s = aluno09s;
    }
}
