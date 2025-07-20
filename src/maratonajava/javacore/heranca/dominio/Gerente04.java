package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Gerente04 extends Funcionario04{
    private String cargoGestao;
    private double salario;

    public Gerente04(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validandoString(cargoGestao);
        this.cargoGestao = formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    public static final double SALARIO_MINIMO_GESTAO=5000;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException("Salário para cartão de gestão não pode ser menor que R$5000");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Cargo gestão: "+cargoGestao+ "|Salário:R$ "+salario);
    }
}
