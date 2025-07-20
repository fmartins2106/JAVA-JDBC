package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.time.Year;
import java.util.*;

public abstract class Veiculo03 {
    private String placa;
    private int anoFabricacao;
    private String cor;
    private double valorMercado;
    private List<Double> histoticoIPVA = new ArrayList<>();

    public Veiculo03(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static final int MENOR_ANO_FABRICACAO = 1900;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();
    public static final double MENOR_VALOR_MERCADO = 0;

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

    protected double getAliquotaIPVA(){
        if (isVeiculoComMais20Anos()){
            return 0.0;
        }
        Map.Entry<Integer, Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.0;
    }

    public static void validacaoPlacas(String placas){
        if (placas == null || placas.isEmpty() || !placas.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo03.ERRO_PLACA.getDescricao());
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo03.ERRO_ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo03.ERRO_COR.getDescricao());
        }
    }

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo03.ERRO_VALOR_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
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
        if (histoticoIPVA.isEmpty()){
            System.out.println(MensagensValidacaoVeiculo03.LISTA_HISTORICO_IPVA_VAZIA.getDescricao());
        }else {
            System.out.println("Histórico de IPVA:");
            for (double valor : histoticoIPVA){
                System.out.println("Valor:R$"+valor);
            }
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        histoticoIPVA.add(ipva);
        System.out.println("Pagamento de IPVA registrado:"+ipva);
        mostrarHistoricoIPVA();
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorMercado);
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

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    public enum MensagensValidacaoVeiculo03{
        ERRO_PLACA("Digite número de placa no padrão AAA-0000 ou AAA0A00."),
        ERRO_VALOR_MERCADO("Valor de mercador não pode ser menor que R$%.2f."),
        ERRO_ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que ano atual."),
        LISTA_HISTORICO_IPVA_VAZIA("Nenhum histórico de IPVA cadastrado."),
        ERRO_COR("Campo cor não pode ser vazio ou conter caracteres.");

        private final String descricao;

        MensagensValidacaoVeiculo03(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Placa: %s |Ano fabricação: %d |Cor: %s |Valor de mercado:R$%.2f",placa,anoFabricacao,cor,valorMercado);
    }
}
