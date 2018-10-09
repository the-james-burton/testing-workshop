# testing-workshop chapter15 [![Build Status](https://api.travis-ci.org/the-james-burton/testing-workshop.svg?branch=chapter15)](https://travis-ci.org/the-james-burton/testing-workshop)

*DRAFT*

## The Situation

Great, you've put AssertJ in and now we're sure that you'll never use assertTrue() again! We've finished refactoring and testing and your project is now in a suitably good state. Not only is it nicely tested, but it is also extensible as we will see now.

## Your Mission

New requirement! A senior business stakeholder has asked for a new report. She would like to know how many companies are in each market. No clever formatting is required, just a simple list of markets and how many companies are in them, one market per row. To implement this requirement, you are going to do a 'test driven development' cycle.

0. Create a class for your new test implementing your existing `Report` interface. Your new generateReport() method should simply return an empty string for now. We will come back and write the implementation later.

0. Write a test for the new report. You can base it on an existing report test. Look at the source file `lse-companies.tsv` and make a few simple assertions. 

0. Run the test. Observe that it fails because of course the empty string being returned is not the report that the stakeholder wants to see!

0. Implement the report. When done run your test and it should now pass.