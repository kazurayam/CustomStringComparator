CustomStringComparator
======================


# What is this

This is a small Katalon Studio project for demonstration purpse.
You can download the zip of this project from the
[Releases](https://github.com/kazurayam/CustomStringComparator/releases)
page, unzip it to extract a project and open it with your Katalon Studio.

This project was developed using Katalon Studio ver 7.2.1.

This project was developed to propose a solution to a discussion in
the Katalon Forum:

- [Verify if sorting of alphanumeric with symbol character is correct](https://forum.katalon.com/t/verify-if-sorting-of-alphanumeric-with-symbol-characters-is-correct/42317)

## Getting started

Try running [Test Cases/main/TC1](./Scripts/main/TC1/Script1586997069360.groovy) where you can see
a set of sample code working.

- given with an array of String: `["AA-1", "AA-2", "AA-2 (1)", "AA-10"]`
- how `Collections.sort()` without Comparator works
- and how `Collections.sort()` with `CustomStringComparator` works

You can find the source of `com.kazurayam.katalonforum.CustomStringComparator` class
[here](./Keywords/com/kazurayam/katalonforum/CustomStringComapator.groovy).


## My opinion

Developing `com.kazurayam.katalonforum.CustomStringComparator` class required
seasoned skill of Java/Groovy programming. It involved unit-tests using JUnit.
This exercises would require a few years of intensive Java programming lessons.

I think that it is too much for a UI tester; a UI tester should not be responsible
for verifying the data-sorting algorithms.
Rather I would ask the server-side developers to test the AUT thoroughly enought using JUnit.
