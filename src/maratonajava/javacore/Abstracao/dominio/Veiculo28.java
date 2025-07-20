package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Stream;

public abstract class Veiculo28 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo28(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo28.PLACA.getDescricao());
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacasDuplicadas(String placa){
        if (placasCadastradas.contains(placa)){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo28.PLACA_DUPLICADA.getDescricao());
        }
    }

    public static final int MENOR_ANO_FABRICAO = 1900;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICAO | anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo28.ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo28.COR.getDescricao());
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private static final double MENOR_VALOR_MERCADO = 0;

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo28.VALOR_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
        }
    }

    public void setPlaca(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
        placasCadastradas.add(placa);
    }

    public void setAnoFabricacao(int anoFabricacao) {
        validacaoAnoFabricacao(anoFabricacao);
        this.anoFabricacao = anoFabricacao;
    }

    public void setCor(String cor) {
        validacaoCor(cor);
        this.cor = formatoString(cor);
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    public static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public boolean temMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquota(){
        if (temMais20Anos()){
            return 0.00;
        }
        Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.00;
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarHistoricoPagamentoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        System.out.println("Histórico pagamento para placa:"+placa);
        for (Double valor : historicoIPVA) {
            System.out.println("Valor pago:R$"+df.format(valor));
        }
    }

    public abstract double calcularIPVA();

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Placa:"+placa);
        System.out.println("Pagamento de IPVA"+df.format(ipva)+" registrado com sucesso");
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorMercado);
    }

    private enum MensagensValidacaoVeiculo28{
        PLACA("Digite placa no formato AAA0000 ou AAA0A00."),
        PLACA_DUPLICADA("Placa duplicada."),
        ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d."),
        COR("Campo cor não pode ser vazio ou conter caracteres."),
        VALOR_MERCADO("Valor de mercado não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoVeiculo28(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Placa: %s |Ano de fabricação: %d |Cor: %s |Valor de mercado:R$%.2f",
                placa,anoFabricacao,cor,valorMercado);
    }

}
