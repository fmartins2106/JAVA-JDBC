package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Veiculo44 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo44(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{3}$")){
            throw new PlacaInvalidaException44();
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();
    public static void validacaoPlacaDuplicada(String placa){
        if (placasCadastradas.contains(placa)){
            throw new PlacaDuplicadaException44();
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < AnoFabricacaoException44.MENOR_ANO_FABRICACAO || anoFabricacao > AnoFabricacaoException44.MAIOR_ANO_FABRICACAO){
            throw new AnoFabricacaoException44();
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CorInvalidaException44();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < ValorMercadoInvalidoException44.MENOR_VALOR_MERCADO){
            throw new ValorMercadoInvalidoException44();
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
        int anoAtual = Year.now().getValue();
        int menorAno = 2006;
        double aliquota = 0.04;
        double descrecimo = 0.005;
        for (int ano = anoAtual; ano >= menorAno ; ano-=5) {
            ALIQUOTAS.put(ano,Math.max(aliquota,0.00));
            aliquota -= descrecimo;
        }
    }

    public boolean temMais20Anos() {
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }


    public double getAliquota() {
        if (temMais20Anos()){
            return 0.00;
        }
        Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.00;
    }

    public abstract double calcularIPVA();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void registrarPagamentoIPVA() {
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento de IPVA registrado para placa:"+this.placa+" no valor de R$"+df.format(ipva));
    }

    public void mostrarHistoricoIPVA() {
        if (historicoIPVA.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        System.out.println("Histórico de pagamento - placa:"+placa);
        for (Double valor : historicoIPVA) {
            System.out.println("Valor:R$"+df.format(valor));
        }
    }

    public void exibirInfo() {
        System.out.println("Placa:"+this.placa);
        System.out.println("Ano fabricação:"+this.anoFabricacao);
        System.out.println("Cor:"+this.cor);
        System.out.println("Valor de mercado:R$"+this.valorMercado);
    }

}
