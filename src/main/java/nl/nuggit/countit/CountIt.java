package nl.nuggit.countit;

public class CountIt {

    public String parse(String document) {
        return document.replaceAll("\\d+", "");
    }

}
