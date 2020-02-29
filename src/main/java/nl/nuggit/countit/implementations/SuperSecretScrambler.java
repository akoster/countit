package nl.nuggit.countit.implementations;

import nl.nuggit.countit.components.Scrambler;

public class SuperSecretScrambler implements Scrambler {
    @Override
    public String scramble(String word) {
        StringBuilder sb = new StringBuilder(word).reverse();
        for (int i = 1; i < sb.length(); i = i + 2) {
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }
        return sb.toString();
    }
}
