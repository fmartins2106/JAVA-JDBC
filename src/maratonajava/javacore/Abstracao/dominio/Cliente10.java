package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente10 {
    private String nome;
    private String cpf;

    public Cliente10(String nome, String cpf) {
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
            throw new IllegalArgumentException(ErrosValidados.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(ErrosValidados.ERRO_CPF.getDescricao());
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

    public enum ErrosValidados{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        CONTA_BLOQUERADA("Conta bloqueada com sucesso."),
        ERRO_NUMERO_CONTA("Para ser validada, conta precisa ter 6 digitos númericos."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        ERRO_CONTA_DESBLOQUEADA("Operação inválida, verifique estatus da conta. Conta está cancelada ou Ativa."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CANCELAMENTO_CONTA("Para efetuar o cancelamento, conta precisa estar com saldo igual a zero."),
        ERRO_DEPOSITO("Valor do deposito precisa ser maior que zero."),
        PERMISSAO_DEPOSITO("Só é permitido efetuar deposito com a conta ativa."),
        ERR0_TRANSFERENCIA("Valor do transferência precisa ser menor que saldo."),
        ERRO_TRANSFERENCIA2("Para efetuar transferência, sua conta precisa estar ativa."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso.");

        private final String descricao;

        ErrosValidados(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoConta10{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta10{
        ATIVA, BLOQUEADA, CANCELADA;
    }

}
