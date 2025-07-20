package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Veiculo23 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo23(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo23.PLACA.getDescricao());
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacasDuplicadas(String placa){
        if (placasCadastradas.contains(placa)){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo23.PLACA_DUPLICADA.getDescricao());
        }
    }

    private static final int MENOR_ANO_FABRICACAO = 1900;
    private static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo23.ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo23.COR.getDescricao());
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    private static final double MENOR_VALOR_MERCADO = 0;

    public static void validacaoValorDeMercado(double valorMercado){
        if (valorMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo23.VALOR_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
        }
    }

    public void setPlaca(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
        placasCadastradas.add(placa);
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setCor(String cor) {
        validacaoCor(cor);
        this.cor = formatoString(cor);
    }

    public static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public abstract double calcularIPVA();

    public boolean temMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquota(){
        if (temMais20Anos()){
            return 0.00;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
            return (entry != null) ? entry.getValue() : 0.00;
        }
    }
    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano de fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorMercado);
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Lista vazio, nenhum pagamento foi cadastrado.");
        }else {
            System.out.println("Histórico pagamento IPVA - placa:"+placa);
            for (Double valor : historicoIPVA) {
                System.out.println("Valor:R$"+df.format(valor));
            }
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento no valor de R$"+df.format(ipva)+" cadastrado com sucesso para placa:"+placa);
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorDeMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    public enum MensagensValidacaoVeiculo23{
        PLACA("Digite uma placa no formato AAA0000 ou AA0A00."),
        PLACA_DUPLICADA("Placa duplicada."),
        COR("Campo cor não pode ser vazio ou conter caracteres."),
        ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior %d."),
        VALOR_MERCADO("Valor de mercado não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoVeiculo23(String descricao) {
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
        return String.format("Placa: %s |Ano fabricação: %d |Cor: %s |Valor de mercado:R$%.2f",
                placa,anoFabricacao,cor,valorMercado);
    }
}
