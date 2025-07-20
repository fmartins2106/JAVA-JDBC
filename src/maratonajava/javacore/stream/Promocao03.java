package academy.devdojo.maratonajava.javacore.stream;

public enum Promocao03 {
    PROMOCAO("Promoção"),
    PRECO_NORMAL("Preço normal");

    private final String descricao;

    Promocao03(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }

}
