package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


public class Funcionario02 {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario02(String nome,String cargo, double salario){
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
            throw new IllegalArgumentException("Nome inválido. Tente novamente digitando seu nome completo.");
        }
        this.nome = formantandoNome(nome);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()){
            throw new IllegalArgumentException("Campo não pode ficar vázio, tente novamente.");
        }else {
            this.cargo = cargo.trim();
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <=1449.99){
            throw new IllegalArgumentException("Salário precisa ser maior que salario minimo.");
        }
        this.salario = salario;
    }

//    public void AumentoSalarial(Double aumento){
//        this.salario += this.salario*(aumento/100);
//    }

    public void ExibirDadosFuncionarios02(){
        System.out.println("Nome:"+getNome());
        System.out.println("Cargo:"+getCargo());
        System.out.println("Salário:R$"+String.format("%.2f",getSalario()));
        System.out.println("________________________________________________________");

    }

    private static String formantandoNome(String nome){
        String[] nomeCompleto = nome.toLowerCase().split("\\s+");
        StringBuilder nomeformatado = new StringBuilder();
        for (String palavra : nomeCompleto){
            nomeformatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeformatado.toString().trim();
    }
}
