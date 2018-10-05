# testing-workshop chapter12 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter12)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

Great work, you've done your first proper mocking! However, we are still using the real file parser so we've not completely isolated the testing yet.

## Your Mission

In your `ProcessFileTest`, you still have some tests that are really testing the behaviour of the `FileParser`. These are the ones that are checking for exceptions. Move these to the `FileParserTest` class. 