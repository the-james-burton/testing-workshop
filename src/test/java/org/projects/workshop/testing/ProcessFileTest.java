package org.projects.workshop.testing;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.projects.workshop.testing.reports.LongReport;
import org.projects.workshop.testing.reports.MarketCapSummaryReport;

public class ProcessFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ProcessFile processFile;

  @Before
  public void setUp() {
    processFile = new ProcessFile();
    processFile.setFileParser(new FileParser());
    processFile.setReportGenerator1(new LongReport());
    processFile.setReportGenerator2(new MarketCapSummaryReport());
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
