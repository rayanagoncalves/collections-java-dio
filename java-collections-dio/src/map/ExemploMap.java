package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um modelo que relacione os modelos e seus respectivos consumos: ");
        var carrosPopulares = new HashMap<String, Double>(){{
            put("gol", 16.1);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        System.out.println("Exiba os modelos: ");
        var modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        var consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        var consumoMaisEficiente = Collections.max(carrosPopulares.values());
        var entries = carrosPopulares.entrySet();
        var modeloMaisEficiente = "";

        for(var entry : entries) {
            if(entry.getValue() == consumoMaisEficiente) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " e seu respectivo consumo: " + consumoMaisEficiente);
            }
        }
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        var consumoMenosEficiente = Collections.min(carrosPopulares.values());
        var modeloMenosEficiente = "";
        for (var entry : carrosPopulares.entrySet()) {
            if(entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " e seu respectivo consumo: " + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        var iterator = carrosPopulares.values().iterator();
        var soma = 0d;
        while(iterator.hasNext()) {
            soma = iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a soma dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("Remova os carros com consumo igual a 15,6 km/l: ");
        var iterator2 = carrosPopulares.values().iterator();
        while(iterator2.hasNext()) {
            if(iterator2.next() == 15.6) iterator2.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem em que foi informado: ");
        var carrosPopularesLinkedHashMap = new LinkedHashMap<String, Double>(){{
            put("gol", 16.1);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopularesLinkedHashMap);

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        var carrosPopularesTreeMap = new LinkedHashMap<>(carrosPopularesLinkedHashMap);
        System.out.println(carrosPopularesTreeMap);

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
