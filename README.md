# testing-workshop chapter6 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter6)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

Good. We have started to extract some logic from the big method into a smaller unit. We still only have an application test. 

## Your Mission

Write some unit tests for your new file parser! Start by making a new test class named the same but with `Test` on the end as this is best practice. Put it in a package with the same name in `src\test\resources`. You unit tests can use the same test files that you created earlier. When the test receives back a `ParsedFile` object, make some assertions on it using the `assertTrue` method in junit.