package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel32;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel32 extends ProdutoBase32{
    private LocalDate dataValidade;

  public ProdutoPerecivel32(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
    super(nome, preco, quantidade, estoqueMinimo);
    setDataValidade(dataValidade);
  }

  public static void validacaoDataValidade(LocalDate dataValidade){
    if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now())*/){
      throw new DataValidadePerecivel32();
    }
  }

  public LocalDate getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(LocalDate dataValidade) {
    validacaoDataValidade(dataValidade);
    this.dataValidade = dataValidade;
  }

  public boolean estaVencido(){
    return dataValidade.isBefore(LocalDate.now());
  }

  @Override
  public String toString() {
    return super.toString()+String.format(" |Data de validade:"+getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
  }
}
