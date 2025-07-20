package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario07 {
    private String nome;
    private String departamento;
    private int idade;

    public Funcionario07(String nome, String departamento, int idade) {
        setNome(nome);
        setDepartamento(departamento);
        setIdade(idade);
    }

    public static final String MENSAGEM_NOME_INVALIDO = "Campo nome não pode ser vazio ou conter caracteres. Digite nome completo.";
    public static final String MENSAGEM_DEPARTAMENTO_INVALIDO = "Campo categoria não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_IDADE_INVALIDA = "Idade não pode ser menor que 18.";
    public static final int IDADE_MINIMA = 18;

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

    public void validandoFormatoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_NOME_INVALIDO);
        }
    }

    public void validandoFormatoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_DEPARTAMENTO_INVALIDO);
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoFormatoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validandoFormatoCategoria(departamento);
        this.departamento = formatoNome(departamento);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_IDADE_INVALIDA);
        }
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |Departamento: %s |Idade: %d ",nome,departamento,idade);
    }
}
