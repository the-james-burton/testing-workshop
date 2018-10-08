# testing-workshop chapter14 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter14)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

You're `ProcessFileTest` class is now fully mocking all dependencies for the class under test. We're now only testing the actual logic in `ProcessFile`. Firstly, it parses the file and sends the results to two report generators and secondly, both generated reports are in the output.

## Your Mission

Uses of the assertTrue() method from JUnit can be hard to understand when they get more complex. This lead to the development of two alternatives. [Hamcrest](http://hamcrest.org/JavaHamcrest/) came first and a version is bundled with JUnit itself. However, it is not under active development anymore. It has given way to a more modern alternative called [AssertJ](https://joel-costigliola.github.io/assertj/) which is based on a fluent API instead of the static 'matchers' provided by Hamcrest. Add AssertJ to your `pom.xml` and convert your existing assertions to use it. Note the rich comparisons available to you directly from your IDE autocompletion.