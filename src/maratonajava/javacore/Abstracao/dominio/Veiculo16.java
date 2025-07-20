package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;

public abstract class Veiculo16 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorDeMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo16(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorDeMercado(valorDeMercado);
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo16.PLACA.getDescricao());
        }
    }

    public static void validandoPlacasDuplicadas(String placa){
        if (placasCadastradas.contains(placa)){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo16.PLACA_DUPLICADA.getDescricao());
        }
    }

    private static final int MENOR_ANO_FABRICACAO = 1900;
    private static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();

    public static void validacaoAnoDeFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo16.ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo16.COR.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private static final double MENOR_VALOR_DE_MERCADO = 0;

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < MENOR_VALOR_DE_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo16.VALOR_DE_MERCADO.getDescricaoFormatada(MENOR_VALOR_DE_MERCADO));
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
        this.cor = formatoNome(cor);
    }

    public double getValorDeMercado() {
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        validacaoValorDeMercado(valorDeMercado);
        this.valorDeMercado = valorDeMercado;
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public boolean temMaisDe20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquotaIPVA(){
        if (temMaisDe20Anos()){
            return 0.00;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
            return (entry != null) ? entry.getValue() : 0.00;
        }
    }

    public void registrarPagamento(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento realizado no valor de R$"+df.format(ipva)+" para veiculo placa:"+getPlaca());
    }

    public void exibirHistoricoPagamento(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum pagamento foi registrado.");
        }else {
            System.out.println("Histórico pagamento IPVA para placa:"+getPlaca());
            for (Double valor : historicoIPVA) {
                System.out.println("Valor:"+df.format(valor));
            }
        }
    }


    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano de fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorDeMercado);
    }

    public abstract double calcularIPVA();

    public enum MensagensValidacaoVeiculo16{
        PLACA("Digite um número de placa no formato AAA000 ou AAA0A00."),
        PLACA_DUPLICADA("Placa duplicada."),
        ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d."),
        COR("Campo cor não pode ser vazio ou conter caracteres."),
        VALOR_DE_MERCADO("Valor de mercado não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoVeiculo16(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

   @Override
   public String toString(){
        return String.format("Placa: %s |Ano de fabricação: %d |Cor: %s |Valor de mercado:R$%.2f.",placa,anoFabricacao,cor,valorDeMercado);
   }
}
