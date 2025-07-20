package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente15 {
    private String nome;
    private String cpf;

    public Cliente15(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensErroCliente15.ERRO_NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        String[] palabras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palabras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoCpf(String cpf){
        if (cpf ==  null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensErroCliente15.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma  % 11);
        digito1 = (digito1 >=10) ? 0:digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0:digito2;

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

    public  enum MensagensErroCliente15{
        ERRO_NOME("Campo nome não  pode ser vazio ou conter carcateres."),
        DIGITOS_CONTA("Número da conta precisa ter " + Conta15.DIGITOS_CONTA+"digitos."),
        SALDO_MINIMO("Saldo não pode ser menor que "+Conta15.SALDO_MINIMO+"."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Verifique status da conta, ela já pode estar bloqueada ou cancelada."),
        ERRO_CONTA_DESBLOQUEADA("Operação inválida, conta já pode estar ativa ou cancelada. Verifique."),
        ERRO_CONTA_CANCELADA("Operação inválida, conta pode estar bloqueada ou cancelada."),
        ERRO_DEPOSITO_CONTA_INATIVA("Operação inválida, conta cancelada ou bloqueada."),
        ERRO_DEPOSITO_VALOR_INVALIDO("Operação inválida. Valor inválido."),
        ERRO_SAQUE_VALOR_INVALIDO("Operação inválida. Valor inválido."),
        ERRO_SAQUE_CONTA_INATIVA("Operação inválida, conta cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Para efetuar o cancelamento da conta, primeiramente a conta precisa estar com saldo igual a zero."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensErroCliente15(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoConta15{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta15{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
