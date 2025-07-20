package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Veiculo18 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorDeMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();


    public Veiculo18(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorDeMercado(valorDeMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo18.PLACA.getDescricao());
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacaDuplicada(String placa){
        if (placasCadastradas.contains(placa)){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo18.PLACA_DUPLICADA.getDescricao());
        }
    }

    private static final int MENOR_ANO_FABRICACAO = 1900;
    private static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo18.ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validandoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo18.COR.getDescricao());
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()+
                palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    private static final double MENOR_VALOR_MERCADO = 0;

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo18.VALOR_DE_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
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
        validacaoAnoFabricacao(anoFabricacao);
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        validandoCor(cor);
        this.cor = formatoString(cor);
    }

    public double getValorDeMercado() {
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        this.valorDeMercado = valorDeMercado;
    }

    private static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public boolean temVeiculoMaisDe20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquotaIPVA(){
        if (temVeiculoMaisDe20Anos()){
            return 0.00;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
            return (entry != null) ? entry.getValue() : 0.00;
        }
    }

    public abstract double calcularIPVA();


    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void registroPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento de R$"+df.format(ipva)+" registrado para placa:"+getPlaca());
    }

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
        }else {
            System.out.println(">>>Histórico para placa:"+getPlaca());
            for (Double valor : historicoIPVA) {
                System.out.println("Pagamento valor:R$"+df.format(valor));
            }
        }
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano de fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:"+valorDeMercado);
    }

    public enum MensagensValidacaoVeiculo18{
        PLACA("Digite uma placa no formato AAA0000 ou AAA0A00."),
        PLACA_DUPLICADA("Placa duplicada."),
        ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d"),
        COR("Campo cor não pode ser vazio ou conter caracteres."),
        VALOR_DE_MERCADO("Valor de mercado não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoVeiculo18(String descricao){
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
        return String.format("Placa: %s |Ano de fabricação: %d |Cor: %s |Valor de mercado: %.2f",placa,anoFabricacao,cor,valorDeMercado);
    }
}
