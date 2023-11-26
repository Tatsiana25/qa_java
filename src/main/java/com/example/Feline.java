package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    private Animal animal;

    public Feline() {
    }

    public Feline(Animal animal) {
        this.animal = animal;
    }

    @Override
    public List<String> eatMeat() throws Exception {
        throw new Exception("Не могу есть мясо!");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
