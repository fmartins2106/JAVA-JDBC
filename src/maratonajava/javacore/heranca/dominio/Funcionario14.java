package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario14 {
    private String nome;
    private int idade;
    private String cpf;
    private String departamento;

    public Funcionario14(String nome, int idade, String cpf, String departamento) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
        setDepartamento(departamento);
    }

    public static final int IDADE_MINIMA = 18;

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_IDADE.getDescricao());
        }
    }

    private void validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_DEPARTAMENTO.getDescricao());
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validacaoIdade(idade);
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validacaoDepartamento(departamento);
        this.departamento = formatoNome(departamento);
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Idade: %d |CPF: %s |Departamento: %s",nome,idade,cpf,departamento);
    }

    public enum MensagensDeValidacao{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        ERRO_IDADE("Idade não pode ser menor que 18."),
        ERRO_DEPARTAMENTO("Campo departamento não pode ser vazio ou conter caracteres."),
        ERRO_CARGO_GERAL("Campo cargo não pode ser vazio ou conter caracteres."),
        ERRO_SALARIO_GERAL("SaLário não pode ser menor que R$2.000"),
        ERRO_CARGO_GESTAO("Campo cargo gestão não pode ser vazio ou conter caracteres."),
        ERRO_SALARIO_GESTAO("Salário gestão não pode ser menor que R$4.000");

        private final String descricao;

        MensagensDeValidacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
