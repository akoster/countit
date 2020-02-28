package nl.nuggit.countit.dependencies;

import nl.nuggit.countit.tools.Scrambler;

public class AwesomeScrambler implements Scrambler {
    @Override
    public String scramble(String word) {
        StringBuilder sb = new StringBuilder(word).reverse();
        for (int i = 1; i < sb.length(); i = i + 2) {
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }
        return sb.toString();
    }
}
