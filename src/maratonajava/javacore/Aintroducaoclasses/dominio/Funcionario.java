package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Funcionario {
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario(String nome, double salario, String cargo){
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario>0){
            this.salario = salario;
        }else {
            System.out.println("Salário inválido.");
        }

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

//    aumentar salário
    public void AumentarSalario(Double percetual){
        this.salario += this.salario*(percetual/100);
    }

    public void exibirInformacoes(){
        System.out.println("Nome:"+getNome());
        System.out.println("Salário:R$"+getSalario());
        System.out.println("Cargo:"+getCargo());
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
    }


}
