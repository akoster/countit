package nl.nuggit.countit;

import nl.nuggit.countit.components.DocumentFactory;
import nl.nuggit.countit.components.Parser;
import nl.nuggit.countit.components.Scrambler;
import nl.nuggit.countit.components.Sorter;
import nl.nuggit.countit.implementations.CountIt;
import nl.nuggit.countit.implementations.InsertionSorter;
import nl.nuggit.countit.implementations.MapBasedDocument;
import nl.nuggit.countit.implementations.SuperSecretScrambler;

public class ComponentFactory {

    public static Parser getParser() {
        return new CountIt(getSorter(), getScrambler(), getDocumentFactory());
    }

    private static DocumentFactory getDocumentFactory() {
        // or try the SimpleDocument
        return MapBasedDocument::new;
    }

    public static Scrambler getScrambler() {
        return new SuperSecretScrambler();
    }

    public static Sorter getSorter() {
        // or try the SystemSorter
        return new InsertionSorter();
    }

}
