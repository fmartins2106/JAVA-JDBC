package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario06 {
    private String nome;
    private String departamento;
    private int idade;

    public Funcionario06(String nome, String departamento, int idade) {
        setNome(nome);
        setDepartamento(departamento);
        setIdade(idade);
    }
    public static final String MENSAGEM_NOME_PADRAO = "Campo nome não pode conter caracteres, ser vazio.Digite nome completo";
    public static final String MENSAGEM_DEPARTAMENTO_PADRAO = "Campo departamento não pode ser vazio ou conter caracteres.";
    public static final double IDADE_MINIMA = 18;
    public static final String MENSAGEM_IDADE_MINIMA = "Idade não pode ser menor que 18.";

    private void validandoStringNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_NOME_PADRAO);
        }
    }

    private void validandoStringDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_DEPARTAMENTO_PADRAO);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoStringNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validandoStringDepartamento(departamento);
        this.departamento = formatoNome(departamento);
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_IDADE_MINIMA);
        }
        this.idade = idade;
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
    public String toString() {
        return String.format("|Nome: %s |Departamento: %s |Idade: %d",nome,departamento,idade);
    }
}
