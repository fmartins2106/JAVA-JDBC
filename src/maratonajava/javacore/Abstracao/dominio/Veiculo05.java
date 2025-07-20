package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.time.Year;
import java.util.*;

public abstract class Veiculo05 {
    protected String placa;
    protected int ano;
    protected String cor;
    protected double valorDeMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo05(String placa, int ano, String cor, double valorDeMercado) {
        setPlaca(placa);
        setAno(ano);
        setCor(cor);
        setValorDeMercado(valorDeMercado);
    }

    public static final int MENOR_ANO = 1900;
    public static final int MAIOR_ANO = Year.now().getValue();
    public static final double MENOR_VALOR = 0;

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo05.ERRO_PLACA.getDescricao());
        }
    }

    public static void validacaoAno(int ano){
        if (ano < MENOR_ANO || ano > MAIOR_ANO){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo05.ERRO_ANO.getDescricaoFormatada(MENOR_ANO,MAIOR_ANO));
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo05.ERRO_COR.getDescricao());
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormtado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormtado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormtado.toString().trim();
    }

    public static void validacaoValorDeMercado(double valorDeMercado){
        if (valorDeMercado < MENOR_VALOR){
            throw new IllegalArgumentException(MensagensValidacaoVeiculo05.ERRO_VALOR_MERCADO.getDescricaoFormatada(MENOR_VALOR));
        }
    }

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
        int idadeVeiculo = anoAtual - ano;
        return idadeVeiculo > 20;
    }

    protected double getAliquotaIPVA(){
        if (isVeiculoComMais20Anos()){
            return 0.0;
        }else {
            Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(ano);
            return (entry != null) ? entry.getValue() : 0.0;
        }
    }

    public abstract double calcularIPVA();

    public void mostrarHistoricoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println(MensagensValidacaoVeiculo05.HISTORICO_IPVA_VAZIO.getDescricao());
        }else {
            System.out.println("Histórico IPVA para o veícuilo da placa:"+getPlaca());
            System.out.println("Histórico IPVA");
            for (double valor : historicoIPVA){
                System.out.println("Valor IPVA:"+valor);
            }
        }
    }

    public void registrarPagamentoIPVA(){
        double IPVA = calcularIPVA();
        historicoIPVA.add(IPVA);
        System.out.println("Pagamento de IPVA registrado:R$"+IPVA);
        mostrarHistoricoIPVA();
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+ano);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:"+valorDeMercado);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        validacaoAno(ano);
        this.ano = ano;
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

    public enum MensagensValidacaoVeiculo05{
        ERRO_PLACA("Placa deve ter formato AAA-0000 ou AAA0A00."),
        HISTORICO_IPVA_VAZIO("Lista vazia."),
        ERRO_ANO("Ano não pode ser menor que %d ou maior que %d."),
        ERRO_COR("Campo cor não pode ser vazio ou conter caracteres."),
        ERRO_VALOR_MERCADO("Valor de mercado não pode ser menor que %.2f");

        private final String descricao;

        MensagensValidacaoVeiculo05(String descricao){
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
        return String.format("Placa: %s |Ano: %d |Cor: %s |Valor de mercado: %.2f",placa,ano,cor,valorDeMercado);
    }

}
