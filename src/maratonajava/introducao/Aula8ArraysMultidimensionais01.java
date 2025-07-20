package academy.devdojo.maratonajava.introducao;



public class Aula8ArraysMultidimensionais01 {
    public static void main(String[] args) {
//        1,2,3,4,5,6...meses
//        31,28,31,30 dias
        int[][] dias = new int[3][3];
        dias[0][0]=31;
        dias[0][1]=30;
        dias[0][2]=29;

        dias[1][0]=28;
        dias[1][1]=27;
        dias[1][2]=26;

        dias[2][0]=25;
        dias[2][1]=24;
        dias[2][2]=23;

        for (int i=0;i<dias.length;i++){
            for (int j=0;j< dias[i].length;j++){
                System.out.println(dias[i][j]);
            }
        }
        for (int[] numeroDias: dias){
            for (int num: numeroDias){
                System.out.println(num);
            }
        }
    }
}
