package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.time.Year;
import java.util.*;

public abstract class Veiculo11 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorDeMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo11(String placa, int anoFabricacao, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorDeMercado(valorDeMercado);
    }

    private static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo11.PLACA_DUPLICADA.getDescricao());
        }
        if (placasCadastradas.contains(placa)){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo11.PLACA_DUPLICADA.getDescricao());
        }
    }

    public static final int MENOR_ANO_FABRICACAO = 1900;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < MENOR_ANO_FABRICACAO || anoFabricacao > MAIOR_ANO_FABRICACAO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo11.ERRO_ANO_FABRICACAO.getDescricaoFormatada(MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo11.ERRO_COR.getDescricao());
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

    public static final double MENOR_VALOR_MERCADO = 0;

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < MENOR_VALOR_MERCADO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo11.ERRO_VALOR_DE_MERCADO.getDescricaoFormatada(MENOR_VALOR_MERCADO));
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
        validacaoCor(cor);
        this.cor = formatoString(cor);
    }

    public double getValorDeMercado() {
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        validacaoValorDeMercado(valorDeMercado);
        this.valorDeMercado = valorDeMercado;
    }

    public static final NavigableMap<Integer,Double> ALIQUOTA = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTA.put(2025,0.04);
        ALIQUOTA.put(2020,0.035);
        ALIQUOTA.put(2015,0.03);
        ALIQUOTA.put(2010,0.025);
        ALIQUOTA.put(2005,0.02);
    }

    public boolean temVeiculoMaisDe20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public abstract double calcularIPVA();

    public double getAliquotaIPVA(){
        if (temVeiculoMaisDe20Anos()){
            return 0.0;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTA.floorEntry(anoFabricacao);
                return (entry != null) ? entry.getValue() : 0.00;
        }
    }

    public void registrarPagamentoIPVA(){
        double IPVA = calcularIPVA();
        historicoIPVA.add(IPVA);
        System.out.println("Pagamento de IPVA para placa:"+getPlaca());
        System.out.println("Pagamento IPVA:R$"+IPVA);

    }

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum veículo cadastrado.");
        }else {
            System.out.println("Histórico pagamento veiculo:"+getPlaca());
            for (Double valor : historicoIPVA) {
                System.out.println("Pagamento IPVA realizado:R$"+valor);
            }
        }
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorDeMercado);
    }

    public enum MensagensValidacaoVeiculo11{
        ERRO_PLACA("Placa deve ter formato AAA0000 ou AAA0A00."),
        PLACA_DUPLICADA("Placa duplicada."),
        ERRO_ANO_FABRICACAO("Ano de fabricação não pode ser menor que %d ou maior que %d."),
        ERRO_COR("Campo cor não pode ser vazio ou conter caracteres."),
        ERRO_VALOR_DE_MERCADO("Valor de mercado não pode ser menor que R$%.2f");

        private final String descricao;

        MensagensValidacaoVeiculo11(String descricao){
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
}
