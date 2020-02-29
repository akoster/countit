# Readme

Readme for the word processing coding test

## Build & run

To build:
```
mvn clean install
```

To run:
```
java -cp target\classes\ nl.nuggit.countit.WordProcessor "The big brown fox number 4 jumped over the lazy dog. THE BIG BROWN FOX JUMPED OVER THE LAZY DOG. The Big Brown Fox 123."
```

## Implementation notes

Special symbols like the dot are also ignored. 

There are two Document implementations that use different strategies. The MapBasedDocument is currently wired in the 
ComponentFactory but it can be exchanged for the SimpleDocument. The implementations have different memory and time
consumption.

