package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Funcionario04 {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario04(String nome, String cargo, double salario){
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome ==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
            throw new IllegalArgumentException("Valor não pode ser nulo, vazio ou sem o nome completo.");
        }
        this.nome = formatandoNome(nome);
    }
    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo==null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("Cargo não pode ser nulo, vazio ou conter caracteres.");
        }
        this.cargo = formatandoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<=1499.99){
            throw new IllegalArgumentException("Salário não pode ser menor que salário minimo, tente novamente.");
        }
        this.salario = salario;
    }
    public void aumentoSalarial(double percentual){
        this.salario += this.salario*(percentual/100);
    }

    public void monstrandoResultadosFuncionarios(){
        System.out.println("Nome:"+getNome());
        System.out.println("Cargo:"+getCargo());
        System.out.println("Novo salário:"+getSalario());
        System.out.println("__________________________________________");

    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormantado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormantado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormantado.toString().trim();
    }
}
