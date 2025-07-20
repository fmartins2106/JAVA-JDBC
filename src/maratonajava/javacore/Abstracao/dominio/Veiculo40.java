package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Veiculo40 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo40(String placa, int anoFabricacao, String cor, double valorMercado) {
        setNome(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new PlacaInvalidaException40();
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacaDuplicada(String placa){
        if (placasCadastradas.contains(placa)){
            throw new PlacaDuplicadaException40();
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < AnoFabricacaoException40.MENOR_ANO_FABRICACAO || anoFabricacao > AnoFabricacaoException40.MAIOR_ANO_FABRICACAO){
            throw new AnoFabricacaoException40();
        }
    }

    public static void validacaoCorVeiculo(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CorInvalidaException40();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < ValorMercadoInvalidoException40.MENOR_VALOR_MERCADO){
            throw new ValorMercadoInvalidoException40();
        }
    }

    public void setNome(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
        placasCadastradas.add(placa);
    }

    public void setAnoFabricacao(int anoFabricacao) {
        validacaoAnoFabricacao(anoFabricacao);
        this.anoFabricacao = anoFabricacao;
    }

    public void setCor(String cor) {
        validacaoCorVeiculo(cor);
        this.cor = formatoString(cor);
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    private static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        int anoAtual = Year.now().getValue();
        int anoFinal = 2006;
        double aliquotaInicial = 0.04;
        double descrecimo = 0.005;

        for (int ano = anoAtual; ano >= anoFinal ; ano-=5) {
            ALIQUOTAS.put(ano,Math.max(aliquotaInicial,0.00));
            aliquotaInicial -= descrecimo;
        }
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

    public abstract double calcularIPVA();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum pagamento foi cadastrado.");
            return;
        }
        System.out.println("Histórico pagamento IPVA:"+placa);
        for (Double valor : historicoIPVA) {
            System.out.println("Valor:R$"+df.format(valor));
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento de IPVA no valor de R$"+df.format(ipva)+" registrado para placa:"+placa);
    }

    public void exibirInfo(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorMercado);
    }
}
