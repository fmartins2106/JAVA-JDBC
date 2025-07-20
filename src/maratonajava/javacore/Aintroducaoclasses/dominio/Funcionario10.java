package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Funcionario10 implements Cloneable{
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario10(String nome, double salario, String cargo){
        setNome(nome);
        setSalario(salario);
        setCargo(cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo se caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validandoSalario(salario);
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo cargo não pode ser vazio ou conter caracteres.");
        }
        this.cargo = formatoNome(cargo);
    }
    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatandoNome.toString().trim();
    }
    private static final double MIN_SALARIO = 1510;
    private void validandoSalario(double nota){
        if (nota < MIN_SALARIO){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo.");
        }
    }
    @Override
    public Funcionario10 clone(){
        try {
            return (Funcionario10) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Erro na clonagem.");
        }
    }

}
