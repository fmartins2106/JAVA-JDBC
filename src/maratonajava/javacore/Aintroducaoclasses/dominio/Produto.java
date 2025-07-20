package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Produto {
    public String nome;
    public double preco;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj ==null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return Double.compare(produto.preco, preco) == 0 && nome.equals(produto.nome);
    }
}
