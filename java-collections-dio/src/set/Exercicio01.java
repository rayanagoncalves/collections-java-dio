package set;

import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) {
        // Crie um conjunto contendo todas as cores do arco-iris
        var coresArcoIris = new HashSet<>(Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Anil", "Violeta"));

        System.out.println("Exiba todas as cores uma embaixo da outra:");
        coresArcoIris.stream().forEach(System.out::println);

        System.out.println("Exiba a quantidade de cores que o arco-íris tem:");
        System.out.println("Quantidade de cores do arco-iris: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética");
        var coresArcoIrisOrdemAlfabetica = new TreeSet<>(Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Anil", "Violeta"));
        System.out.println(coresArcoIrisOrdemAlfabetica);

        System.out.println("Exiba as cores na ordem inversa em que foi informada:");
        var coresArcoIrisLinkedHashSet = new LinkedHashSet<>(Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Anil", "Violeta"));
        var coresArcoIrisList= new ArrayList<>(coresArcoIrisLinkedHashSet);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        System.out.println("Exiba todas as cores que começam com a letra V");
        coresArcoIris.stream().filter(c -> c.startsWith("V")).forEach(s -> System.out.println(s));

        System.out.println("Remova todas as cores que não começam com a letra \"V\"");
        System.out.println();
        var iterator = coresArcoIris.iterator();
        while(iterator.hasNext()) {
            var next = iterator.next();
            if(!next.startsWith("V")) iterator.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("Limpe o conjunto:");
        coresArcoIris.clear();

        System.out.println("Confira se o conjunto está vazio");
        System.out.println("O conjunto está vazio? " + coresArcoIris.isEmpty());
    }

}
