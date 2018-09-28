# testing-workshop chapter8 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter8)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

The code for the reports are now in their own classes. However, there are no independent tests for these new classes. They are covered only because the `ProcessFile` class is being tested. This means that if, for example, the `FileParser` breaks and thus the `ProcessFileTest`, then the reports are no longer tested.

## Your Mission

Now that the reports have been extracted into their own classes, we can test them separately. This will make them independent of upstream failures. Make two new test classes to test your new report classes. For this example, I suggest you extract any setup into a common base class. 