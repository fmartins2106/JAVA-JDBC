package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Gerente01 extends Funcionario01{
    private String nivelGestao;
    private double salario;

    public Gerente01(String nome, int idade, String departamento, String nivelGestao, double salario) {
        super(nome, idade, departamento);
        setNivelGestao(nivelGestao);
        setSalario(salario);

    }

    public String getNivelGestao() {
        return nivelGestao;
    }

    public void setNivelGestao(String nivelGestao) {
        if (nivelGestao == null || nivelGestao.isEmpty() || !nivelGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo não pode ser vazio ou conter caracteres.");
        }
        this.nivelGestao = nivelGestao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 5000){
            throw new IllegalArgumentException("Salário de gerente não pode ser menor que R$5.000,00");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Nível de gestão: "+nivelGestao+ "|Salário:R$ "+salario);
    }

}
