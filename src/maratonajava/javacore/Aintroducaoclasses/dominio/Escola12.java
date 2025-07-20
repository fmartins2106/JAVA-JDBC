package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.*;

public class Escola12 {
    private List<Aluno12>aluno12s;

    public Escola12(){
        this.aluno12s = new ArrayList<>();
    }

    public void addNotasAluno(Aluno12 aluno12){
        aluno12s.add(aluno12);
    }

    public static String validandoNomeAluno(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite nome completo sem adição de caracteres.");
                continue;
            }
            return Aluno12.formatoNome(nome);
        }
    }

    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a primeira nota:");
                int nota1 = Integer.parseInt(scanner.nextLine());
                if (nota1 < 0 || nota1 > 10){
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
            try {
                System.out.print("Digite a segunda nota:");
                int nota2 = Integer.parseInt(scanner.nextLine());
                if ( nota2  < 0 || nota2 > 10){
                    System.out.println("Nota precisa ser entre 0 e 10.");
                    continue;
                }
                return nota2;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public void listaAlunos(List<Aluno12>aluno12s){
        if (aluno12s.isEmpty()){
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
            int index = 0;
            for (Aluno12 aluno12 : aluno12s){
                System.out.printf("%-4d %-25s %-8.2f %-12s\n",index++,aluno12.getNome(),aluno12.getMedia(),aluno12.getSituacao());
            }
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    public void alterarDadosAluno(Scanner scanner){
        if (aluno12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o númer da matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >=0 && matricula <= aluno12s.size()){
                    Aluno12 aluno12 = aluno12s.get(matricula);
                    aluno12.setNome(validandoNomeAluno(scanner));
                    aluno12.setNota1(validandoNota1(scanner));
                    aluno12.setNota2(validandoNota2(scanner));
                }else {
                    System.out.println("Número de matricula inválida..");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void pesquisaAlunoNome(Scanner scanner){
        if (aluno12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNomeAluno(scanner);
            for (Aluno12 aluno12 : aluno12s){
                if (nome.equalsIgnoreCase(aluno12.getNome())){
                    System.out.println("_________________________________________");
                    System.out.println("Nome:"+aluno12.getNome());
                    System.out.println("Nota 1:"+aluno12.getNota1());
                    System.out.println("Nota 2:"+aluno12.getNota2());
                    System.out.println("Média:"+aluno12.getMedia());
                    System.out.println("Situação:"+aluno12.getSituacao());
                    System.out.println("_________________________________________");
                }else {
                    System.out.println("Aluno não encontrado.");
                }
            }
        }
    }
    public void excluirAluno(Scanner scanner){
        if (aluno12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o número da matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula >=0 && matricula <=aluno12s.size()){
                    Aluno12 aluno12 = aluno12s.get(matricula);
                    aluno12s.remove(aluno12);
                }else {
                    System.out.println("Número de matricula inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }
    public void listaMaiorMedia(Scanner scanner,List<Aluno12>aluno12s){
        if (aluno12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            List<Aluno12> cloneList = new ArrayList<>();
            for (Aluno12 aluno12 : aluno12s){
                cloneList.add(aluno12.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Aluno12::getMedia).reversed());
            listaAlunos(cloneList);
        }
    }

    public List<Aluno12> getAluno12s() {
        return aluno12s;
    }

    public void setAluno12s(List<Aluno12> aluno12s) {
        this.aluno12s = aluno12s;
    }
}
