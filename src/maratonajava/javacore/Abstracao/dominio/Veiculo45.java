package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Veiculo45 {
    private String placa;
    private int anoFabricacao;
    private String cor;
    private double valorMercado;
    private List<Double> historicoIPVA = new ArrayList<>();


    public Veiculo45(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new PlacaInvalidaException45();
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacaDuplicada(String placa){
        if (placasCadastradas.contains(placa)){
            throw new PlacaDuplicadaException45();
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < AnoFabricacaoException45.MENOR_ANO_FABRICACAO || anoFabricacao > AnoFabricacaoException45.MAIOR_ANO_FABRICACAO){
            throw new AnoFabricacaoException45();
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CorInvalidaException45();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < ValorMercadoriaException45.MENOR_VALOR_FATURA){
            throw new ValorMercadoriaException45();
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

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    public static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        int anoAtual = Year.now().getValue();
        int menorAno = 2006;
        double aliquota = 0.04;
        double descrecimo = 0.005;
        for (int ano = anoAtual; ano >= menorAno ; ano -= 5) {
            ALIQUOTAS.put(ano,Math.max(aliquota,0.00));
            aliquota -= descrecimo;
        }
    }

    public boolean temMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - this.anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquota(){
        if (temMais20Anos()){
            return  0.00;
        }
        Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.00;
    }

    public abstract double calcularIPVA();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        System.out.println("Histórico pagamentoIPVA - placa:"+this.placa);
        for (Double valor : historicoIPVA) {
            System.out.println("Valor:R$"+df.format(valor));
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento registrado no valor de R$"+df.format(ipva)+" para placa:"+this.placa);
    }

    public void exibirInfo(){
        System.out.println("Placa:"+this.placa);
        System.out.println("Ano de fabricação:"+this.anoFabricacao);
        System.out.println("Cor:"+this.cor);
        System.out.println("Valor de mercado:"+this.valorMercado);
    }

}
