package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.*;

public class Escola10 {
    private List<Aluno10> aluno10s;

    public Escola10(){
        this.aluno10s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite nome completo sem caracteres.");
                continue;
            }
            return Aluno10.formatoNome(nome);
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Nota1:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1 < 0 || nota1 > 10 ){
                    System.out.println("Nota precisa ser entre 0 e 10.");
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
            System.out.print("Nota2:");
            double nota2 = Double.parseDouble(scanner.nextLine());
            if (nota2 < 0 || nota2 > 10){
                System.out.println("Nota precisa ser entre 0 e 10.");
                continue;
            }
            return nota2;
        }
    }

    public void addNovoAluno(Aluno10 aluno10){
        aluno10s.add(aluno10);
    }
    public void listagemAlunos(List<Aluno10> aluno10s){
        if (aluno10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-10s%n","No","Nome","Média","Situação");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            int index=0;
            for (Aluno10 aluno10 : aluno10s) {
                System.out.printf("%-4d %-25s %-8.2f %-10s%n",index++,aluno10.getNome(),aluno10.getMedia(),aluno10.getSituacao());
            }
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void pesquisaNome(Scanner scanner){
        if (aluno10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = Escola10.validandoNome(scanner);
            boolean encontrado = false;
            for (Aluno10 aluno10 : aluno10s){
                if (nome.equalsIgnoreCase(aluno10.getNome())){
                    encontrado = true;
                    for (int i = 0; i < 40; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                    System.out.println("Nome:"+aluno10.getNome());
                    System.out.println("Nota 1:"+aluno10.getNota1());
                    System.out.println("Nota 2:"+aluno10.getNota2());
                    for (int i = 0; i < 40; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                }
            }
            if (!encontrado){
                System.out.println("Aluno não encontrado.");
            }
        }
    }
    public void alterarDadosAluno(Scanner scanner){
        if (aluno10s.isEmpty()){
            System.out.println("Lista está vazia.");
        }else {
            int matricula = 0;
            try {
                System.out.print("Digite o número da matricula:");
                matricula = Integer.parseInt(scanner.nextLine());
                if ( matricula >= 0 && matricula <= aluno10s.size()){
                    Aluno10 aluno10 = aluno10s.get(matricula);
                    aluno10.setNome(Escola10.validandoNome(scanner));
                    aluno10.setNota1(Escola10.validandoNota1(scanner));
                    aluno10.setNota2(Escola10.validandoNota2(scanner));
                }else {
                    System.out.println("Número de matricula inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirDadosSistema(Scanner scanner){
        if (aluno10s.isEmpty()){
            System.out.println();
        }else {
            try {
                System.out.print("Digite o número de matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <= aluno10s.size()){
                    aluno10s.remove(matricula);
                }else {
                    System.out.println("Número de matricula inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }
    public void listaPorMaiorMedia(){
        if (aluno10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            ArrayList<Aluno10> cloneList = new ArrayList<>();
            for (Aluno10 aluno10 : aluno10s){
                cloneList.add(aluno10.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Aluno10::getMedia).reversed());
            listagemAlunos(cloneList);
        }
    }

    public List<Aluno10> getAluno10s() {
        return aluno10s;
    }

    public void setAluno10s(List<Aluno10> aluno10s) {
        this.aluno10s = aluno10s;
    }
}
