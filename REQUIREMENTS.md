# Coding test: Word processing

You are writing the software class CountIt in a word processing system that is capable of counting words in a DOCUMENT. The document is basically a string that needs to be parsed. The following remarks below apply:

* Numbers are not processed
* Next to the total number of words the number of occurrences of each word is also calculated
* The total number of occurrences next to the word must be shown on screen on by one (in lowercase)
* Counting the occurrences per word is case insensitive (so Matchbox, matchbox, and MATCHBOX are all the same word)
* When printing the occurrences, the words must be in alphabetical order
* You cannot use a built in .NET sort routine, so write on of your own, it does not have to be the fastest sort routine as long as it is reliable
* Since the CIA and RUSSIA are monitoring every move of what you are doing the list of words must also be returned by your CountIt in a scrambled form, that is the letters must in reversed order and every EVEN letter in the word must be capitalized. Mind you the word scrambling routine you have to write is used throughout the system, and might be replaced later on 
* When the processed data is returned it must be shown in a console application for now
* The code must be production code, use everything you would use in production. You are allowed to use third party components if required.
* The document can be provided as a string to your CountIt class, so no file IO is necessary
* All classes can be in one console application
* Everything must be done TDD. Use SOLID and full object-oriented programming

Any questions or something not clear? feel free to ask …

So:

If your document is
 
“The big brown fox number 4 jumped over the lazy dog. THE BIG BROWN FOX JUMPED OVER THE LAZY DOG. The Big Brown Fox 123.”

Your console output would be:
```
Number of words: 23
big 3
brown 3
dog 2
fox 3
jumped 2
lazy 2
number 1
over 2
the 5

gIb
nWoRb
gOd
xOf
dEpMuJ
yZaL
rEbMuN
rEvO
eHt
```




