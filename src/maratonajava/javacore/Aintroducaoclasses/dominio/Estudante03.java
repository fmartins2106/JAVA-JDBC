package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Estudante03 {
    private String nome;
    private int idade;
    private String curso;

    public Estudante03(String nome, int idade, String curso){
        setNome(nome);
        setIdade(idade);
        setCurso(curso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Digite o seu nome completo.");
        }
        this.nome = formatandoNome(nome);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <=18){
            throw new IllegalArgumentException("Digite um número maior que 18.");
        }
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso.isEmpty()){
            throw new IllegalArgumentException("Campo não pode ser vazio, tente novamente.");
        }else {
            this.curso = curso.substring(0,1).toUpperCase()+curso.substring(1).toLowerCase();
        }
    }
    public void cadastroEstudantes(){
        System.out.println("Nome:"+getNome());
        System.out.println("Idade:"+getIdade());
        System.out.println("Curso:"+getCurso());
        System.out.println("__________________________________________________");
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }

}
