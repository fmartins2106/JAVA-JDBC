package academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio;

public class Funcionarios {
    public String nome;
    public int idade;
    public double[] salarios;

    public void imprimir(){
        System.out.println(this.nome);
        System.out.println(this.idade);
        for (double salario : salarios){
            System.out.println(salario+" ");
        }
        imprimirMedSalario();
    }
    public void imprimirMedSalario(){
        double media = 0;
        for (double salario : salarios){
            media +=salario;
        }
        media/= salarios.length;
        System.out.println("Média salarial:"+media);
    }
}
