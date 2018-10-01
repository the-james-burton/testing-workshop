# testing-workshop chapter9 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter9)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

We have made a lot of progress on this application. The logic is separated out and we now have independent tests for the file parsing and report generation. Unfortunately, the application main is still not tested in any way.

## Your Mission

Let's revisit the testing of `ApplicationMain` and see if we can write some tests for it to increase the coverage. Create a new test called `ApplicationMainTest` with just one test method. Use `System.setOut` to redirect the console output of the program and make assertions on the content of it after you run the main method.