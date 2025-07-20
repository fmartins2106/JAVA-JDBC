package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Funcionario09 implements  Cloneable{
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario09(String nome, double salario, String cargo){
        setNome(nome);
        setSalario(salario);
        setCargo(cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome precisa ter nome completo, não pode ser vazio ou conter caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<1510){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo.");
        }
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
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }
    @Override
    public Funcionario09 clone(){
        try {
            return (Funcionario09) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Erro na clonagem");
        }
    }

}
