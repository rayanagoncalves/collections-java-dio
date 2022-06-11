package map;

import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações");
        var estadosNe = new HashMap<String, Integer>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> estado : estadosNe.entrySet()) {
            System.out.println(estado.getKey() + " - " + estado.getValue() + " habitantes");
        }

        System.out.println("\nSubstitua a populacao do RN por 3.534.165");
        estadosNe.put("RN", 3534165);
        for (Map.Entry<String, Integer> estado : estadosNe.entrySet()) {
            System.out.println(estado.getKey() + " - " + estado.getValue() + " habitantes");
        }

        System.out.println("\nConfira se o estado PB, caso não adicione PB - 4.039.267");
        if(!estadosNe.containsKey("PB")) {
            estadosNe.put("PB", 4039267);
        }
        for (Map.Entry<String, Integer> estado : estadosNe.entrySet()) {
            System.out.println(estado.getKey() + " - " + estado.getValue() + " habitantes");
        }

        System.out.println("\nExiba a população de Pernambuco: " + estadosNe.get("PE"));

        System.out.println("\nExiba todos os estados e suas populações na ordem em que foi informado");
        var estadosNe2 = new LinkedHashMap<String, Integer>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 918703);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> estado : estadosNe2.entrySet()) {
            System.out.println(estado.getKey() + " - " + estado.getValue() + " habitantes");
        }

        System.out.println("\nExiba todos os estados e suas populações em ordem alfabética");
        var estadosNe3 = new TreeMap<>(estadosNe);
        for (Map.Entry<String, Integer> estado : estadosNe3.entrySet()) {
            System.out.println(estado.getKey() + " - " + estado.getValue() + " habitantes");
        }

        var listaEstados = estadosNe.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> estado : estadosNe.entrySet()) {
           if(estado.getValue().equals(Collections.max(listaEstados))) {
               estadoMaiorPopulacao = estado.getKey();
           }
           if(estado.getValue().equals(Collections.min(listaEstados))) {
               estadoMenorPopulacao = estado.getKey();
           }
        }

        System.out.println("\nEstado com menor população: " + estadoMenorPopulacao + " - " + Collections.min(listaEstados));
        System.out.println("Estado com maior população: " + estadoMaiorPopulacao + " - " + Collections.max(listaEstados));

        var somaPopulacao = 0;
        for (Map.Entry<String, Integer> estado : estadosNe.entrySet()) {
            somaPopulacao += estado.getValue();
        }

        System.out.println("\nExiba a soma da população dos estados: " + somaPopulacao);
        System.out.println("\nExiba a média da população deste dicionário de dados: " + somaPopulacao/estadosNe.size());

        System.out.println("\nRemova os estados com a população menor que 4.000.000");
        for (Map.Entry<String, Integer> estado : estadosNe3.entrySet()) {
            if(estado.getValue() < 4000000) {
                estadosNe.remove(estado.getKey());
            }
        }
        System.out.println(estadosNe);

        System.out.println("\nApague o dicionário de estados");
        estadosNe.clear();

        System.out.println("\nO dicionário de estados está vazio? " + estadosNe.isEmpty());
    }
}
