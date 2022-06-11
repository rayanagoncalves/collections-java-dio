package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExercicioProposto02 {
    public static void main(String[] args) {
        int qtdLancamento = 100;

        var valores = new ArrayList<Integer>();
        Random geradorDeLancamento = new Random();
        for(int i = 0; i < qtdLancamento; i++) {
            int numero = geradorDeLancamento.nextInt(6) + 1;
            valores.add(numero);
        }

        var lancamentos = new HashMap<Integer, Integer>();
        for(Integer resultado : valores) {
            if(lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, lancamentos.get(resultado) + 1);
            }
            else
                lancamentos.put(resultado, 1);
        }

        System.out.print("Jogando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor " + " Quant. de vezes");
        for(Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}
