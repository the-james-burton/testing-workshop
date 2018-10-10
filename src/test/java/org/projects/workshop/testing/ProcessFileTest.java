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
    processFile.process("src/test/resources/lse-companies-empty-file.tsv");
  }

  @Test(expected = RuntimeException.class)
  public void processShouldThrowExceptionIfNoFile() {
    processFile.process("no-file");
  }

  @Test
  public void processShouldRunWithoutError() {
    processFile.process("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
  }
}
