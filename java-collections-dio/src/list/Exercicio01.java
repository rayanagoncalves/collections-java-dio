package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> listaTemperaturaMediaDosMeses = new ArrayList<>();

        for(int i = 1; i <= 6; i++) {
            System.out.println("Informe a temperatura média do mês " + i);
            var temperaturaMedia = sc.nextDouble();
            listaTemperaturaMediaDosMeses.add(temperaturaMedia);
        }

        System.out.print("Todas as temperaturas: ");
        listaTemperaturaMediaDosMeses.forEach(t -> System.out.print(t + " "));

        var media = listaTemperaturaMediaDosMeses.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        System.out.println("Temperaturas acima da média: ");
        listaTemperaturaMediaDosMeses.stream()
                .filter(t -> t > media)
                .forEach(t -> System.out.println(t + ""));

        System.out.println("Meses das temperaturas acima da média: ");
        var iterator = listaTemperaturaMediaDosMeses.iterator();

        var contador = 0;
        while(iterator.hasNext()) {
            var temp = iterator.next();
            if(temp > media) {
                switch (contador) {
                    case (0):
                        System.out.println("1 - Janeiro");
                        break;
                    case (1):
                        System.out.println("2 - Fevereiro");
                        break;
                    case (2):
                        System.out.println("3 - Março");
                        break;
                    case (3):
                        System.out.println("4 - Abril");
                        break;
                    case (4):
                        System.out.println("5 - Maio");
                        break;
                    case (5):
                        System.out.println("6 - Junho");
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média");
                }
            }
            contador++;
        }
    }
}