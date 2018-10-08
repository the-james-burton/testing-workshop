# testing-workshop chapter11 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter11)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

So now the `ApplicationMain` class creates the parser and report generators and gives them to the `ProcessFile` class. You may be wondering why we have done this. The code appears to have just increased in complexity for no obvious reason. However, the `ProcessFileTest` is now in control of what implementation the `ProcessFile` class uses. At the moment, these implementations are the same as the application.

## Your Mission

We are now in a position to control the execution context of the `ProcessFile` class. We do not have to give it the same implementation as used by the `ApplicationMain`. We are able to 'mock' the injected dependencies to test only the specific behaviour of the code we really want to test, without depending on anything else. Add [mockito](https://site.mockito.org/) to your `pom.xml`. Using it, change your `ProcessFileTest` class to provide mock report generators instead of the real things. Make them return a simple string instead of actually doing any processing. You should use mockito when() and thenReturn() methods to achieve this. 