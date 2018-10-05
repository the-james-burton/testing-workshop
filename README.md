# testing-workshop chapter13 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter13)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

Great work, you've done your first proper mocking! However, we are still using the real file parser so we've not completely isolated the testing yet.

## Your Mission

In your `ProcessFileTest`, extend your mocking to include the `FileParser` too. When mocking the processFile() method, You will need to ensure a valid `ParsedFile` object is returned. If you look at the code in `ProcessFile`, notice that this object is simply given to your already mocked report generators. Therefore the contents of your `ParsedFile` don't actually matter beyond the fact that the one you gave it is also given to your mock report generators. See if you can use Mockito to verify this. Why not also make a few assertions about the return value of the `ProcessFile` method.