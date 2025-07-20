package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.time.Year;
import java.util.*;

public abstract class Veiculo09 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorDeMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo09(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorDeMercado(valorDeMercado);
    }

    public static final int MENOR_ANO_FABRICACAO = 0;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();
    public static final double MENOR_VALOR_MERCADO = 0;


    private static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo09.ERRO_PLACA.getDescricao());
        }
        if (placasCadastradas.contains(placa)){
            System.out.println(MensagensValidacaoVeiculo09.PLACA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo09.ERRO_ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo09.ERRO_COR.getDescricao());
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo09.ERRO_VALOR_DE_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
        placasCadastradas.add(placa);
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        validacaoCor(cor);
        this.cor = formatoString(cor);
    }

    public double getValorDeMercado() {
        validacaoValorDeMercado(valorDeMercado);
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        this.valorDeMercado = valorDeMercado;
    }


    public List<Double> getHistoricoIPVA() {
        return historicoIPVA;
    }

    public void setHistoricoIPVA(List<Double> historicoIPVA) {
        this.historicoIPVA = historicoIPVA;
    }

    public static final NavigableMap<Integer,Double> ALIQUOTA = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTA.put(2025, 0.04);
        ALIQUOTA.put(2020, 0.035);
        ALIQUOTA.put(2015, 0.03);
        ALIQUOTA.put(2010, 0.025);
        ALIQUOTA.put(2005, 0.02);
    }

    public boolean temVeiculoMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquotaIPVA(){
        if (temVeiculoMais20Anos()){
            return 0.0;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTA.floorEntry(anoFabricacao);
            return (entry != null) ? entry.getValue() : 0.0;
        }
    }

    public abstract double calcularIPVA();

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.println("Histórico IPVA:"+getPlaca());
            for (double valor : historicoIPVA){
                System.out.println("Valor:R$"+valor);
            }
        }
    }

    public void registrarPagamentoIPVA(){
        double IPVA = calcularIPVA();
        historicoIPVA.add(IPVA);
        System.out.println("Pagamento de IPVA registrado:"+IPVA);
        mostrarHistoricoIPVA();
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercador:"+valorDeMercado);
    }

    public enum MensagensValidacaoVeiculo09{
        ERRO_PLACA("Digite placa no formato AAA0000 ou AAA0A00."),
        PLACA_DUPLICADA("Placa já cadastrada. Tente outro número."),
        ERRO_ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d."),
        ERRO_COR("Campo cor não pode ser vazio ou conter caracteres."),
        ERRO_VALOR_DE_MERCADO("Valor de mercador não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoVeiculo09(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormada(String... valores){
            return String.format(descricao, (Object[])valores);
        }
    }

    @Override
    public String toString(){
        return String.format("Placa: %s |Ano de fabricação: %d |Cor: %s |Valor de mercado:R$%.2f",
                placa,anoFabricacao,cor,valorDeMercado);
    }
}
