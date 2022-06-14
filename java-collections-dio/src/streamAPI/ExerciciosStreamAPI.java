package streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

//        System.out.println("Imprima todos os elementos dessa lista de Strings: ");
//        numerosAleatorios.stream()
//                .forEach(System.out::println);
//        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e guarde dentro de um Set: ");
        var set = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());

        System.out.println("Transforme a lista de Strings em uma lista de Inteiros: ");
        List<Integer> listaInteiros = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Pegue os números pares e maiores 2 e guarde em uma lista: ");
        List<Integer> listaParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(i -> Integer.parseInt(i))
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        listaInteiros.removeIf(i -> (i % 2 != 0));
        System.out.println(listaInteiros);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        var countNumerosUnicos = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        listaInteiros.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        listaInteiros.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        int somaDosNumerosPares = listaInteiros.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> listaOrdemNumerica = listaInteiros.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(listaOrdemNumerica);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = listaInteiros.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);
    }
}
