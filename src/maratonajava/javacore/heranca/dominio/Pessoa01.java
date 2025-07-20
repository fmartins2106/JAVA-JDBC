package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Pessoa01 {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa01(String nome, int idade, String cpf) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
    }

    public static final String MENSAGEM_FORMATO_INVALIDO ="Campo não pode ser vazio ou conter caracteres. Digite descrição completa.";
    private void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_FORMATO_INVALIDO);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoString(nome);
        this.nome = nome;
        formatoNome(nome);
    }

    public int getIdade() {
        return idade;
    }

    public static final String MENSAGEM_VALIDANDO_IDADE = "Idade não pode ser menor que 6.";
    public static final int IDADE_MINIMA = 6;
    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_VALIDANDO_IDADE);
        }
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException("CPF Inválido.");
        }
        this.cpf = cpf;
    }
    private static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count()==1){
            return false;
        }
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+= (cpf.charAt(i)-'0') *(10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 :digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+= (cpf.charAt(i) -'0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
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
    public String toString(){
        return "Nome:"+nome+ "|Idade:"+idade+ "|CPF:"+cpf;
    }


}
