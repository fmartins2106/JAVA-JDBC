package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente14 {
    private String nome;
    private String cpf;

    public Cliente14(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
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

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensErroCliente14.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensErroCliente14.ERRO_CPF.getDescricao());
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

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
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

    public enum MensagensErroCliente14{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        VALIDACAO_DIGITOS_CONTA("Para número da conta ser válida, precisa ter "+ Conta14.DIGITOS_CONTA+" digitos."),
        VALIDACAO_SALDO_MINIMO("Saldo não pode ser menor que "+Conta14.SALDO_MINIMO+"."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Verifique o status da conta, pois já pode está bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Verifique o status da conta, pois conta já pode estar ativa ou cancelada."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Verifique status da sua conta, ela já pode estar bloqueada ou cancelada."),
        ERRO_CONTA_CANCELADA2("Para efetuar o cancelamento da conta seu saldo precisa ser igual a zero."),
        ERRO_DEPOSITO("Valor do popósito não pode ser menor que zero."),
        ERRO_VALOR_SAQUE("Saldo insuficiente para efetuar o saque, verifique seu saldo."),
        ERRO_STATUS_SAQUE("Para efetuar o saque conta precisa esta ativa, verifique o status da sua conta."),
        ERRO_DEPOSITO2("Operação inválida, status da conta pode estar bloqueada ou cancelada."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensErroCliente14(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoConta14{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta14{
        ATIVA, BLOQUEADA,CANCELADA;
    }

}
