package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Gerente02 extends Funcionario02{
    private String nivelGestao;
    private double salario;

    public Gerente02(String nome, String departamento, int idade, String nivelGestao, double salario) {
        super(nome, departamento, idade);
        setNivelGestao(nivelGestao);
        setSalario(salario);
    }

    public String getNivelGestao() {
        return nivelGestao;
    }

    public void setNivelGestao(String nivelGestao) {
        validandoNivelGerencia(nivelGestao);
        this.nivelGestao = Funcionario02.formatoNome(nivelGestao);
    }

    public double getSalario() {
        return salario;
    }

    public void validandoNivelGerencia(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo "+palavra+" não pode ser vazio ou conter caracteres.");
        }
    }

    private static final double SALARIO_GERENCIA=5000;
    public void setSalario(double salario) {
        if (salario < SALARIO_GERENCIA){
            throw new IllegalArgumentException("Salário gerência não pode ser menor que R$5.000,00");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Nível Gestão: "+nivelGestao+ "|Salário:R$ "+salario);
    }

}
