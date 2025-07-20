package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Pessoa02 {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa02(String nome, int idade, String cpf) {
        setNome(nome);
        setIdade(idade);
        setcpf(cpf);
    }

    public static final String MENSAGEM_CONDICOES_NOME = "Campo nome não pode ser vazio, conter caracteres. Digite nome completo.";
    public static final int IDADE_MINIMA = 6;
    public static final String MENSAGEM_IDADE_MINIMA = "Idade mínima para cadastro é 6 anos.";
    public static final String MENSAGEM_CPF_INVALIDO = "Este número de CPF é inválido, tente novamente.";

    private void validandoString(String palavra){
        if (palavra == null  || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_CONDICOES_NOME);
        }
    }

    public static String formatoNome(String nome){
        String[] palavras  = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
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

    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_IDADE_MINIMA);
        }
        this.idade = idade;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MENSAGEM_CPF_INVALIDO);
        }
        this.cpf = cpf;
    }

    private static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count()==1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i)-'0')* (10- i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11-i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Idade: %d |CPF: %s",nome,idade,cpf);
    }

}
