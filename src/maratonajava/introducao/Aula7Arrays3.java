package academy.devdojo.maratonajava.introducao;

public class Aula7Arrays3 {
    public static void main(String[] args) {
        int[] numeros = new int[]{1,2,3,4,5};
        int[] numeros1 = {10,11,12,13,14};
        int[] numeros2 = new int[5];
        for (int n=0;n<numeros2.length;n++){
            System.out.println(numeros[n]);
        }
//        outra forma de fazer, usando o FOR EACH
        for(int num: numeros1){
            System.out.println(num);
        }
    }
}
