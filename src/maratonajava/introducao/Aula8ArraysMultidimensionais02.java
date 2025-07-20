package academy.devdojo.maratonajava.introducao;

public class Aula8ArraysMultidimensionais02 {
    public static void main(String[] args) {
        int[][] arrayInt = new int[3][];
        int[][] arrayint2 = {{0,0}, {1,2,3,4}, {1,2,3,4,5,6}};

        arrayInt[0] = new int[2];
        arrayInt[1] = new int[]{1,2,3,4};
        arrayInt[2] = new int[6];
        


        for (int[] numero: arrayInt){
            System.out.println("____________");
            for (int num: numero){
                System.out.println(num+" ");
            }
        }
    }
}
