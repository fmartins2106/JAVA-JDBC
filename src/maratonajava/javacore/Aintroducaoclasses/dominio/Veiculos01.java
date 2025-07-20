package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;



import java.time.*;

public class Veiculos01 {
    private String nome;
    private String placa;
    private int ano;
    private String cor;

    public Veiculos01(String nome,String placa, int ano, String cor){
        setNome(nome);
        setPlaca(placa);
        setAno(ano);
        setCor(cor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[a-zA-Z\\s]+")){
            throw new IllegalArgumentException("ERRO.Digite apenas o nome do carro.");
        }else {
            this.nome = formantandoNomeCarro(nome);
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}-[0-9]{4}$")){
             throw new IllegalArgumentException("Digite placa no formato ABC-1234");
        }else {
            this.placa = placa.toUpperCase();
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = Year.now().getValue();
        if (ano<=1900 || ano>=anoAtual){
            throw new IllegalArgumentException("ERRO. Digite um ano maior que 1900.");
        }else {
            this.ano = ano;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor == null || cor.trim().isEmpty())
            throw new IllegalArgumentException("Digite uma cor válida.");
        this.cor = cor = cor.substring(0,1).toUpperCase()+cor.substring(1).toLowerCase();
    }

    public void monstrandoDadosCarro(){
        System.out.println("Nome:"+getNome());
        System.out.println("Placa:"+getPlaca());
        System.out.println("Ano:"+getAno());
        System.out.println("Cor:"+getCor());
    }


    private static String formantandoNomeCarro(String nome){
        String[] palavras = nome.toLowerCase().split(" ");
        StringBuilder nomeCarroFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeCarroFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeCarroFormatado.toString().trim();
    }
}
