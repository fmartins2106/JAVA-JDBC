package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.time.Year;
import java.util.*;

public abstract class Veiculo02 {
    private String placa;
    private int anoFabricacao;
    private String cor;
    private double valorDeMercado;
    private List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo02(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorDeMercado(valorDeMercado );
    }

    public static final int ANO_MINIMO_FABRICACAO = 1900;
    public static final int ANO_MAXIMO_FABRICACAO = Year.now().getValue();
    public static final double VALOR_MINIMO_MERCADO = 0;

    private static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public boolean isVeiculoComMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    protected double getAliquotaIPVA() {
        if (isVeiculoComMais20Anos()) {
            return 0.0;
        }
        Map.Entry<Integer, Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.0;
    }

    public static void validacaoPlacas(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo02.ERRO_PLACA.getDescricao());
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < ANO_MINIMO_FABRICACAO || anoFabricacao > ANO_MAXIMO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo02.ERRO_ANO_FABRICACAO.getdescricaoFormatada(ANO_MINIMO_FABRICACAO,ANO_MAXIMO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo02.ERRO_COR.getdescricaoFormatada());
        }
    }

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < VALOR_MINIMO_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo02.ERRO_VALOR_MERCADO.getdescricaoFormatada(VALOR_MINIMO_MERCADO));
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

    public abstract double calcularIPVA();

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println(MensagensValidacaoVeiculo02.HISTORICO_IPVA_VAZIO.getDescricao());
        }else {
            System.out.println("Histórico de IPVA:");
            for (double valor : historicoIPVA){
                System.out.println("Valor:R$"+valor);
            }
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento de IPVA registrado R$:"+ipva);
        mostrarHistoricoIPVA();
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado R$:"+valorDeMercado);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        validacaoPlacas(placa);
        this.placa = placa.toUpperCase();

    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        validacaoAnoFabricacao(anoFabricacao);
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

    public enum MensagensValidacaoVeiculo02{
        ERRO_PLACA("ERRO: Placa inválida. Placa deve ser o padrão AAA-0000 ou AAA0A00."),
        ERRO_ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d."),
        HISTORICO_IPVA_VAZIO("Nenhum hístórico de IPVA registrado."),
        ERRO_VALOR_MERCADO("Valor de mercador não pode ser menor que R$%.2f"),
        ERRO_COR("Compo cor não pode ser vazio ou conter caracteres.");

        private final String descricao;

        MensagensValidacaoVeiculo02(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getdescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Placa: %s |Ano fabricação: %d |Cor: %s |Valor de mercado:R$%.2f",placa,anoFabricacao,cor,valorDeMercado);
    }
}
