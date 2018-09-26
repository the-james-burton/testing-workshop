# testing-workshop chapter1 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter1)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

There is a main method in `ProcessFile.java` that reads the contents of a file and prints out two reports. Unfortunately, this code has no tests at all!

## Your Mission

Write a very simple test that just executes the method by calling the main method with no arguments. Observe that the test runs when built on the command line with `mvn test` and that a coverage report is generated. 