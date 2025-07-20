package academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio;

import java.lang.ref.SoftReference;

public class Calculadora {

    public void somaDoisNumeros(){
        System.out.println(10+10);
    }

    public void subtraiDoisNumeros(){
        System.out.println(20-10);
    }

    public void multiplicarDoisNumeros(int num1, int num2){
        System.out.println(num1*num2);
    }

    public double dividindoDoisNumeros(double num1, double num2){
        if (num2!=0){
            return num1/num2;
        }
        return 0;
    }
    public void dividindoDoisNumeros2(double num1, double num2){
        if (num2==0){
            System.out.println("Não existe divisão por zero.");
            return;
        }
        System.out.println(num1/num2);
    }
    public void somarArray(int[] numeros){
        int soma=0;
        for (int numero : numeros){
            soma+=numero;
        }
        System.out.println(soma);
    }
    public void somaVarArgs(int... numeros){
        int soma=0;
        for (int numero : numeros){
            soma+=numero;
        }
        System.out.println(soma);
    }


}
