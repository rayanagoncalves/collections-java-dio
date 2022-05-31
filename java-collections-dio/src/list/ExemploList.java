package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ExemploList {

    public static void main(String[] args) {
        List<Double> notasImutavel = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // lista nao pode ser alterada

        System.out.println("Crie uma lista e adicione sete notas: ");

        List<Double> notas = new ArrayList();
        notas.add(7.0); //atalho command+d para replicar as linhas
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5: " + notas.indexOf(5d));

        System.out.println("Adicione na lista a nota 8 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5 pela nota 6: ");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);

        System.out.println("Confirma se a nota 5 está na lista: " + notas.contains(5d));

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");

     //   for (Double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Double soma = 0.0;
        var iterator = notas.iterator();
        while(iterator.hasNext()) {
           Double next = iterator.next();
           soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);

        System.out.println("Remova a nota da posição 0: ");
        notas.remove(0);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        var iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

    /*    System.out.println("Apague toda a lista: ");
        notas.clear();
        System.out.println(notas); */

        System.out.println("Verifique se a lista está vazia: " + notas.isEmpty());

        // Exercicios linkedList

        var notas2 = new LinkedList<>(notas);

        System.out.println("Primeira nota da linkedList antes de removê-lo: " + notas2.get(0));

        notas2.remove(0);
        System.out.println("Primeira nota da linkedList depois de remover o item 0: " + notas2.get(0));

    }
}
