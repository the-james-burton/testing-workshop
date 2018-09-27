# testing-workshop chapter3 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter3)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

Ok, so we are making progress. Coverage has improved. However, we are still testing a main method. We are therefore effectively doing a full application test on a very small system. This isn't scalable and doesn't allow us to test individual components.

## Your Mission

We need to start the refactoring process. You goal is to take the code out of the main method and put it in its own class that implements `Runnable`. Your main method will then need to create an instance of that class and call the run() method on it. You tests will need to be changed to do the same.