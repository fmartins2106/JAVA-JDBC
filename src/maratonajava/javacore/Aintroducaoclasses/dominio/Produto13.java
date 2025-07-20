package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Produto13 {
    private int codigo;
    private String nome;
    private String categoria;
    private double valor;
    private int quantidadeEstoque;
    private int estoqueMinimo;

    public Produto13(int codigo, String nome, String categoria, double valor, int quantidadeEstoque,int estoqueMinimo){
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setValor(valor);
        setQuantidadeEstoque(quantidadeEstoque);
        setEstoqueMinimo(estoqueMinimo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < 0){
            throw new IllegalArgumentException("Código não pode ser menor que zero.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo sem uso de caracteres.");
        }
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo categoria não pode ficar vazio ou conter caracteres.");
        }
        this.categoria = formatoNome(categoria);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10000){
            throw new IllegalArgumentException("Campo valor deve ser maior que zero e menor que R$10.000,00");
        }
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0 ){
            throw new IllegalArgumentException("Campo quantidade não pode ser menor que zero.");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < 50 ){
            throw new IllegalArgumentException("Estoquei minimo precisa ser maior que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatacaoNome = new StringBuilder();
        for (String palavra : palavras){
            formatacaoNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatacaoNome.toString().trim();
    }

    public boolean isEstoqueBaixo(){
        return quantidadeEstoque < estoqueMinimo;
    }
    @Override
    public String toString(){
        return String.format("Código: %s |Nome: %s |Categoria: %s |Preço:R$ %.2f |Estoque: %d |Estoque mínimo: %d",codigo,nome,categoria,valor,quantidadeEstoque,estoqueMinimo);
    }

}
