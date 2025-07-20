package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario01 {
    private String nome;
    private int idade;
    private String departamento;

    public Funcionario01(String nome, int idade, String departamento) {
        setNome(nome);
        setIdade(idade);
        setDepartamento(departamento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoString(nome);
        this.nome = formatoNome(nome);
    }

    public int getIdade() {
        return idade;
    }

    private static final int IDADE_MINIMA =18;
    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException("Idade não pode ser menor que 18.");
        }
        this.idade = idade;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validandoString(departamento);
        this.departamento = formatoNome(departamento);

    }

    private void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo "+palavra+" não pode ficar vazio ou conter caracteres. Tente novamente.");
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Idade: %d |Departamento: %s",nome,idade,departamento);
    }

}
