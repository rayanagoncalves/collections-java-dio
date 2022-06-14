package streamAPI;

import map.exercicioProposto03.Contato;

import java.util.*;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {
        var agenda = new HashMap<Integer, Contato>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for(Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nOrdem inserção");
        var agenda1 = new LinkedHashMap<Integer, Contato>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for(Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nOrdem id");
        var agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for(Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nOrdem número telefone");
        Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(Comparator.comparing(
                c -> c.getValue().getTelefone()
        ));
        agenda3.addAll(agenda.entrySet());
        System.out.println(agenda3);
        for(Map.Entry<Integer, Contato> entry : agenda3) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\nOrdem nome contato");
//        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//                return cont1.getValue().getNome().compareTo(cont2.getValue().getNome());
//            }
//        });
//        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
//                new Function<Map.Entry<Integer, Contato>, String>() {
//                    @Override
//                    public String apply(Map.Entry<Integer, Contato> cont) {
//                        return cont.getValue().getNome();
//                    }
//                }
//        ));

        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNome()));
        agenda4.addAll(agenda.entrySet());
        System.out.println(agenda4);
        for(Map.Entry<Integer, Contato> entry : agenda4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}

class OrdenacaoNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getTelefone().compareTo(c2.getValue().getTelefone());
    }
}

