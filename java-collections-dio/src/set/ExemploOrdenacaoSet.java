package set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória");
        var minhasSeries = new HashSet<Serie>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that'70s show", "comédia", 25));
        }};
        for (Serie s : minhasSeries) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }

        System.out.println("Ordem de inserção");
        var minhasSeriesOrdemInsercao = new LinkedHashSet<Serie>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that'70s show", "comédia", 25));
        }};
        for (Serie s : minhasSeriesOrdemInsercao) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }

        System.out.println("Ordem natural (tempoEpisodio)");
        var minhasSeriesOrdemNatural = new TreeSet<Serie>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that'70s show", "comédia", 25));
        }};
        for (Serie s : minhasSeriesOrdemNatural) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }

        System.out.println("Ordem (nome/genero/tempoEpisodio)");
        var minhasSeriesOrdemNomeGeneroTempoEpisodio = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeriesOrdemNomeGeneroTempoEpisodio.addAll(minhasSeries);
        for (Serie s : minhasSeriesOrdemNomeGeneroTempoEpisodio) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }

        System.out.println("Ordem gênero");
        var minhasSeriesOrdemGenero = new TreeSet<>(new ComparatorGenero());
        minhasSeriesOrdemGenero.addAll(minhasSeries);
        for (Serie s : minhasSeriesOrdemGenero) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }

        System.out.println("Ordem Tempo Episódio");
        var minhasSeriesOrdemTempoEpisodio= new TreeSet<>(new ComparatorTempoEpisodio());
        minhasSeriesOrdemTempoEpisodio.addAll(minhasSeries);
        for (Serie s : minhasSeriesOrdemTempoEpisodio) {
            System.out.println(s.getNome() + " - " + s.getGenero() + " - " + s.getTempoEpisodio());
        }
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
       int nome = s1.getNome().compareTo(s2.getNome());
       if (nome != 0) return nome;

       int genero = s1.getGenero().compareTo(s2.getGenero());
       if (genero != 0) return genero;

       return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareTo(s2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int tempoEpisodio =  Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        int genero = s1.getGenero().compareTo(s2.getGenero());

        return (tempoEpisodio != 0) ? tempoEpisodio : genero;
    }
}