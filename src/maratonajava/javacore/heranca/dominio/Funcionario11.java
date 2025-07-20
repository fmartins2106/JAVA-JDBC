package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario11 {
    private String nome;
    private String departamento;
    private int idade;

    public Funcionario11(String nome, String departamento, int idade) {
        setNome(nome);
        setDepartamento(departamento);
        setIdade(idade);
    }

    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_DEPARTAMENTO = "Campo departamento não pode ser vazio ou conter caracteres.";
    public static final int MENOR_IDADE = 18;
    public static final String MENSAGEM_ERRO_IDADE = "Idade não pode ser menor que 18.";

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DEPARTAMENTO);
        }
    }

    private void validacaoIdade(int idade){
        if (idade < MENOR_IDADE){
            System.out.println(MENSAGEM_ERRO_IDADE);
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validacaoDepartamento(departamento);
        this.departamento = formatoNome(departamento);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validacaoIdade(idade);
        this.idade = idade;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Departamento: %s |Idade: %d",nome,departamento,idade);
    }

}
