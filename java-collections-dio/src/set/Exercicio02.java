package set;

import java.util.*;

public class Exercicio02 {

    public static void main(String[] args) {
        var minhasLinguagensFavoritas = new HashSet<LinguagemFavorita>();
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        System.out.println("Ordem inserção");
        var minhasLinguagensFavoritasOrdemInsercao = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "IntelliJ"),
                        new LinguagemFavorita("Java", 1991, "Visual Studio Code")
                )
        );
        minhasLinguagensFavoritasOrdemInsercao.stream().forEach(s -> System.out.println(s.getNome() + " - " + s.getAnoDeCriacao() + " - " + s.getIde()));

        System.out.println("Ordem natural:");
        var minhasLinguagensFavoritasOrdemNatural = new TreeSet<>(minhasLinguagensFavoritas);
        minhasLinguagensFavoritasOrdemNatural.stream().forEach(s -> System.out.println(s.getNome() + " - " + s.getAnoDeCriacao() + " - " + s.getIde()));

        System.out.println("Ordem IDE:");
        var minhasLinguagensFavoritasOrdemIde = new TreeSet<>(new ComparatorIde());
        minhasLinguagensFavoritasOrdemIde.addAll(minhasLinguagensFavoritas);
        minhasLinguagensFavoritasOrdemIde.stream().forEach(s -> System.out.println(s.getNome() + " - " + s.getAnoDeCriacao() + " - " + s.getIde()));

        System.out.println("Ordem Ano de Criaçao e Nome:");
        var minhasLinguagensFavoritasOrdemAnoCriacaoENome = new TreeSet<>(new ComparatorAnoCriacaoENome());
        minhasLinguagensFavoritasOrdemAnoCriacaoENome.addAll(minhasLinguagensFavoritas);
        minhasLinguagensFavoritasOrdemAnoCriacaoENome.stream().forEach(s -> System.out.println(s.getNome() + " - " + s.getAnoDeCriacao() + " - " + s.getIde()));

        System.out.println("Ordem Ano de Criaçao/Nome/IDE:");
        var minhasLinguagensFavoritasOrdemAnoCriacaoENomeEIde = new TreeSet<>(new ComparatorAnoCriacaoENomeEIde());
        minhasLinguagensFavoritasOrdemAnoCriacaoENomeEIde.addAll(minhasLinguagensFavoritas);
        minhasLinguagensFavoritasOrdemAnoCriacaoENomeEIde.stream().forEach(s -> System.out.println(s.getNome() + " - " + s.getAnoDeCriacao() + " - " + s.getIde()));

    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareTo(l2.getIde());
    }
}

class ComparatorAnoCriacaoENome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(anoCriacao != 0) return anoCriacao;

        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatorAnoCriacaoENomeEIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(anoCriacao != 0) return anoCriacao;

        int ide = l1.getIde().compareTo(l2.getIde());
        if(ide != 0) return ide;

        return l1.getNome().compareTo(l2.getNome());
    }
}


