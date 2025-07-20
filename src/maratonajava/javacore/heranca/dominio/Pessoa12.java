package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Pessoa12 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa12(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static final int IDADE_MINIMA = 6;

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(validationMessage.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(validationMessage.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 &&  (cpf.charAt(10) - '0') == digito2;
    }

    private void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(validationMessage.ERRO_IDADE.getDescricao());
        }
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
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
        return String.format("Nome: %s |CPF: %s |Idade: %d",nome,cpf,idade);
    }


    public enum validationMessage{
        ERRO_NOME("Campo mensagem não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        ERRO_IDADE("Idade não pode ser menor que 6."),
        ERRO_MATRICULA("Matricula não pode ser menor que 1."),
        ERRO_NOTAS("Nota não pode ser menor que zero ou maior que dez."),
        ERRO_DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        ERRO_SALARIO("Salário não pode ser menor que R$3.500");

        private String descricao;

        validationMessage(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

    }
}


