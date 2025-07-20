package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.*;

public class Escola11 {
    private List<Aluno11> aluno11s;

    public Escola11(){
        this.aluno11s = new ArrayList<>();
    }
    public void addAluno(Aluno11 aluno11){
        aluno11s.add(aluno11);
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite nome completo sem caracteres.");
                continue;
            }
            return Aluno11.formatoNome(nome);
        }
    }
    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1 < 0 || nota1 > 10){
                    System.out.println("Digite uma nota entre 0 e 10.");
                    continue;
                }
                return nota1;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }
    public static double validandoNota2(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a segunda nota:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2 < 0 || nota2 > 10){
                    System.out.println("Digite uma nota entre 0 e 10.");
                    continue;
                }
                return nota2;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }
    public void exibindoResultados(List<Aluno11> aluno11s){
        if (aluno11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-12s\n","No","Nome","Média","Situação");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            int index =0;
            for (Aluno11 aluno11 : aluno11s){
                System.out.printf("%-4d %-25s %-8.2f %-12s\n",index++,aluno11.getNome(),aluno11.getMedia(),aluno11.getSituacao());
            }
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void pesquisaNome(Scanner scanner){
        if (aluno11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            boolean encontrado = false;
            for (Aluno11 aluno11 : aluno11s){
                if (nome.equalsIgnoreCase(aluno11.getNome())){
                    System.out.println("Nome:"+aluno11.getNome());
                    System.out.println("Nota1:"+aluno11.getNota1());
                    System.out.println("Nota2:"+aluno11.getNota2());
                    System.out.println("Média:"+aluno11.getMedia());
                    System.out.println("Situação:"+aluno11.getSituacao());
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Nome não encontrado.");
            }
        }
    }
    public void alterarDadosAlunos(Scanner scanner){
        if (aluno11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            int matricula = 0;
            try {
                System.out.print("Digite o número da matricula:");
                matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <= aluno11s.size()){
                    Aluno11 aluno11 = aluno11s.get(matricula);
                    aluno11.setNome(validandoNome(scanner));
                    aluno11.setNota1(validandoNota1(scanner));
                    aluno11.setNota2(validandoNota2(scanner));
                }else {
                    System.out.println("Matrícula não encontrada.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void excluirDadosAluno(Scanner scanner){
        if (aluno11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            int matricula =0;
            try {
                System.out.print("Digite o número da matricula:");
                matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >= 0 && matricula <= aluno11s.size()){
                    aluno11s.remove(matricula);
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void listaAlunosPorMaiorMedia(){
        if (aluno11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            ArrayList<Aluno11> cloneList = new ArrayList<>();
            for (Aluno11 aluno11 : aluno11s){
                cloneList.add(aluno11.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Aluno11::getMedia).reversed());
            exibindoResultados(cloneList);
        }
    }

    public List<Aluno11> getAluno11s() {
        return aluno11s;
    }

    public void setAluno11s(List<Aluno11> aluno11s) {
        this.aluno11s = aluno11s;
    }
}
