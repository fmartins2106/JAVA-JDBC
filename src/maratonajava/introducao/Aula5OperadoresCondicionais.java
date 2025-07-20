package academy.devdojo.maratonajava.introducao;

public class Aula5OperadoresCondicionais {
    public static void main(String[] args) {
        //idade <15 categoria infantil
        // idade <= 15 && idade <18 categoria Juvenil
        // idade >=18 categoria adulto
        int idade = 17;
        if(idade <15){
            System.out.println("Ctegoria infantil");
        }else if (idade >=15 && idade<18) {
            System.out.println("Categoria Juvenil");
        }else{
                System.out.println("Ctegoria Adulto");
        }
    }
}
