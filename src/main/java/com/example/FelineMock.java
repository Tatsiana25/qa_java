package com.example;

import java.util.Arrays;
import java.util.List;

public class FelineMock implements Predator {
    @Override
    public List<String> eatMeat() throws Exception {
        return Arrays.asList("Корм для Хищника");
    }
}
