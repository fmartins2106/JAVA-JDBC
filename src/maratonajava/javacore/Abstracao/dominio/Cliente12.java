package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente12 {
    private String nome;
    private String cpf;

    public Cliente12(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(ValidanacaoErrosCliente12.ERRO_NOME.getDescricao());
        }
    }

    public static String formatoNomes(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(ValidanacaoErrosCliente12.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
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

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') ==digito2;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNomes(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public enum ValidanacaoErrosCliente12{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_DIGITOS_CONTA("Conta deve ter somente 6 digitos."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CANCELAMENTO_CONTA("Para efetuar o cancelamento da conta, o seu saldo precisa ser igual a zero."),
        ERRO_DEPOSITO("Para efetuar depósito, conta precisa estar ativa."),
        DEPOSITO("Deposito realizado com sucesso."),
        DEPOSITO_VALOR_INVALIDO("Valor inválido."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_DESBLOQUEIO_ATIVA("Conta já estava ativa, verifique!"),
        ERRO_DESBLOQUEIO_CANCELADA("Conta já está bloqueada. Verifique."),
        ERRO_SAQUE("Saque não pode ser realizado, verifique status da conta."),
        SAQUE("Saque realizado com sucesso."),
        ERRO_VALOR_SAQUE("Valor inválido, verifique."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        ValidanacaoErrosCliente12(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoConta12{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta12{
        ATIVA, BLOQUEADA, CANCELADA;
    }

}
