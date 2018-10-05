package org.projects.workshop.testing;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProcessFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ProcessFile processFile;

  @Before
  public void setUp() {
    processFile = new ProcessFile();
  }

  @Test
  public void processShouldThrowExceptionIfEmptyFile() {
    thrown.expect(RuntimeException.class);
    thrown.expectMessage("no first line!");
    processFile.setFilename("src/test/resources/lse-companies-empty-file.tsv");
    processFile.process();
  }

  @Test(expected = RuntimeException.class)
  public void processShouldThrowExceptionIfNoFile() {
    processFile.setFilename("no-file");
    processFile.process();
  }

  @Test
  public void processShouldRunWithoutError() {
    processFile.setFilename("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
    processFile.process();
  }
}
