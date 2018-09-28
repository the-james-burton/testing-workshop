# testing-workshop chapter7 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter7)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

You have written your first genuine unit test that tests some isolated functionality and makes assertions. This is great progress but the report generation is still in one big method and we're not testing it very well as there are no assertions.

## Your Mission

Refactor the code in the `ProcessFile` class run method to pull out the two reports into their own classes. Since they both require a `ParsedFile` object and produce a string, you should your new classes implement a new interface called `Report` that specifies a single method `generateReport` which takes a `ParsedFile` as parameter and returns a string which is the report it creates.