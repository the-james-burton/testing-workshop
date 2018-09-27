package org.projects.workshop.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProcessFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void mainShouldThrowExceptionIfEmptyFile() {
    thrown.expect(RuntimeException.class);
    thrown.expectMessage("no first line!");
    ProcessFile.main("src/test/resources/lse-companies-empty-file.tsv");
  }

  @Test(expected = RuntimeException.class)
  public void mainShouldThrowExceptionIfNoFile() {
    ProcessFile.main("no-file");
  }

  @Test
  public void mainShouldRunWithoutError() {
    ProcessFile.main("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
  }
}
