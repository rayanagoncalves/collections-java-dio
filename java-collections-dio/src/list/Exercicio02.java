package list;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var perguntas = new ArrayList<Character>();

        System.out.println("Telefonou para a vítima? ");
        perguntas.add(sc.next().charAt(0));

        System.out.println("Esteve no local do crime? ");
        perguntas.add(sc.next().charAt(0));

        System.out.println("Mora perto da vítima? ");
        perguntas.add(sc.next().charAt(0));

        System.out.println("Devia para a vítima? ");
        perguntas.add(sc.next().charAt(0));

        System.out.println("Já trabalhou com a vítima? ");
        perguntas.add(sc.next().charAt(0));

        var contador = 0;
        for(Character c : perguntas) {
            if(c.equals('S')) {
                contador++;
            }
        }

        if(contador == 2) {
            System.out.println("Suspeita");
        } else if(contador >= 3 && contador <= 4) {
            System.out.println("Cúmplice");
        } else if(contador == 5) {
            System.out.println("Assassina");
        } else {
            System.out.println("Inocente");
        }

    }
}

