package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.*;

public class Escola13 {
    private List<Aluno13> aluno13s;

    public Escola13(){
        this.aluno13s = new ArrayList<>();
    }
    public void addAlunosLista(Aluno13 aluno13){
        aluno13s.add(aluno13);
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite seu nome completo sem adição de caracteres.");
                continue;
            }
            return Aluno13.formatoNome(nome);
        }
    }

    public static double validandoNota1(Scanner scanner){
        while (true){
            try {
                System.out.print("Nota 1:");
                double nota1 = Double.parseDouble(scanner.nextLine());
                if (nota1 < 0 || nota1 >10){
                    System.out.println("Nota precisa ser entre 0 e 10 para ser válida.");
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
                System.out.print("Nota 2:");
                double nota2 = Double.parseDouble(scanner.nextLine());
                if (nota2 < 0 || nota2 > 10){
                    System.out.println("Nota precia ser maior que 0 e menor que 10 para ser validada.");
                    continue;
                }
                return nota2;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }

    public void listaAlunos(Scanner scanner, List<Aluno13> aluno13s){
        if (aluno13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-12s\n","No","Nome","Média","Situação");
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
            int index = 0;
            for (Aluno13 aluno13 : aluno13s){
                System.out.printf("%-4d %-25s %-8.2f %-12s\n",index++,aluno13.getNome(),aluno13.getMedia(),aluno13.getSituacao());;
            }
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void alterarDadosAluno(Scanner scanner){
        if (aluno13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            boolean encontrado = false;
            for (Aluno13 aluno13 : aluno13s){
                if (nome.equalsIgnoreCase(aluno13.getNome())){
                    aluno13.setNome(validandoNome(scanner));
                    aluno13.setNota1(validandoNota1(scanner));
                    aluno13.setNota2(validandoNota2(scanner));
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public void excluindoDadosAluno(Scanner scanner){
        if (aluno13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Digite o número da matricula:");
            int matricula = Integer.parseInt(scanner.nextLine());
            if (matricula >= 0 && matricula <= aluno13s.size()){
                Aluno13 aluno13 = aluno13s.get(matricula);
                aluno13s.remove(aluno13);
            }else {
                System.out.println("Matricula inválida.");
            }
        }
    }

    public void listaMaiorMedia(Scanner scanner){
        if (aluno13s.isEmpty()){
            System.out.println("Listaa vazia.");
        }else {
            List<Aluno13> cloneList = new ArrayList<>();
            for (Aluno13 aluno13 : aluno13s){
                cloneList.add(aluno13.clone());
            }
            Collections.sort(cloneList, Comparator.comparingDouble(Aluno13::getMedia).reversed());
            listaAlunos(scanner,cloneList);
        }
    }

    public void pesquisarPorNome(Scanner scanner){
        if (aluno13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner);
            Aluno13 aluno13 = aluno13s.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
            if (aluno13 != null){
                System.out.println("_________________________________________");
                System.out.println("Nome:"+aluno13.getNome());
                System.out.println("Nota 1:"+aluno13.getNota1());
                System.out.println("Nota 2:"+aluno13.getNota2());
                System.out.println("Média:"+aluno13.getMedia());
                System.out.println("Situação:"+aluno13.getSituacao());
                System.out.println("_________________________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Aluno13> getAluno13s() {
        return aluno13s;
    }

    public void setAluno13s(List<Aluno13> aluno13s) {
        this.aluno13s = aluno13s;
    }
}
