# testing-workshop chapter5 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter5)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

At last your application is starting to look better. The `ApplicationMain` class creates an instance of `ProcessFile`, configures it and runs it. Your unit tests do exactly the same. However, the run method in `ProcessFile` is still too big and does too many things.

## Your Mission

Let's continue refactoring by extracting the file parsing logic into its own class called `FileParser`. In this class with be a new method that will receive a string filename parameter. What will it return? We have headers and rows, so you need a new class to represent them. Simply make a POJO called `ParsedFile` with two properties for the headers and rows, construct it in your new method and return it to a modified run method in `FileParser`