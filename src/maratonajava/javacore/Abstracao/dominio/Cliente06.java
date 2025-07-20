package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente06 {
    private String nome;
    private String cpf;

    public Cliente06(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Validation.ERRO_NOME.getDescricao());
        }
    }

    public void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(Validation.ERRO_CPF.getDescricao());
        }
    }

    public boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11  - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 =  (digito2 >= 10) ? 0: digito2;

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


    public enum Validation{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        ERRO_DIGITOS_CONTA("Conta precisa ter 6 digitos para ser válido."),
        BLOQUEIO_CONTA("Conta bloqueada."),
        CONTA_INATIVA("Operação negada conta inativa."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CANCELAMENTO("Para cancelar a conta o saldo precisa ser igual a zero."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        Validation(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoDaConta{
        CORRENTE, POUPANCA;
    }

    public enum StatusDaConta{
        ATIVA, BLOQUEADA, CANCELADA;
    }


}
