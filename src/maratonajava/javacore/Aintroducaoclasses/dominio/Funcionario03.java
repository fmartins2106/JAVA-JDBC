package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Funcionario03 {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario03(String nome, String cargo, double salario){
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}+]+$)")){
            throw new IllegalArgumentException("ERRO. Digite o nome completo. Tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Tente novamente.");
        }
        this.cargo = formatandoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<=1499.99){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo. Tente novamente.");
        }
        this.salario = salario;
    }

    public void mostrandosDadosFuncionarios(){
        System.out.println("Nome:"+getNome());
        System.out.println("Cargo:"+getCargo());
        System.out.println("Salário:R$"+getSalario());
        System.out.println("______________________________________________________");
    }


    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
