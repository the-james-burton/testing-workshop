# testing-workshop chapter10 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter10)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

So our top level main method is now being tested, that's good. However, if you look at the logic in `ProcessFile` you can see that this creates instances of the `FileParser` and the two reports classes itself, in the process() method. This means that the test for this method is also effective an application test. We testing more than just the logic inside the `ProcessFile` class, which is hard coded to rely on the logic in the parser and report generators. If they break, so too will our test for the `ProcessFile` class.

## Your Mission

We should isolate the functionality in `ProcessFile`. To do this, we're going to do some dependency injection. Refactor the `ProcessFile` class so that the calling class (in this case `ApplicationMain`) creates the parser and report generators and 'injects' them into the `ProcessFile` class through new setters that you also write. You will also need to update the test to make it do the same.
