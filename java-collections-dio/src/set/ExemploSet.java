package set;

import java.util.*;

public class ExemploSet {
    // Características do Set: não permite elementos duplicados, não possui índice
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione as notas: ");
        var notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        System.out.println("Confira se a nota 5 está no conjunto: " + notas.contains(5d));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        var iterator = notas.iterator();
        var soma = 0;

        while (iterator.hasNext()) {
            var next = iterator.next();
            soma += next;
        }

        System.out.println("A soma das notas é: " + soma);

        System.out.println("A média das notas é: " + soma/notas.size());

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba na lista: ");
        var iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            var next = iterator1.next();
            if(next < 7d) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informdas: ");
        var notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d); // nao será inserido
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        var notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());

    }
}
