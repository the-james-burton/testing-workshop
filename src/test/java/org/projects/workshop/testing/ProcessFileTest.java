package org.projects.workshop.testing;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ProcessFile processFile;

  @Before
  public void setUp() {
    Report mockLongReport = Mockito.mock(Report.class);
    Report mockMarketCapSummaryReport = Mockito.mock(Report.class);

    Mockito.when(mockLongReport.generateReport(Mockito.any(ParsedFile.class)))
        .thenReturn("longReportOutput");
    Mockito.when(mockMarketCapSummaryReport.generateReport(Mockito.any(ParsedFile.class)))
        .thenReturn("marketCapSummaryReportOutput");

    processFile = new ProcessFile();
    processFile.setFileParser(new FileParser());
    processFile.setReportGenerator1(mockLongReport);
    processFile.setReportGenerator2(mockMarketCapSummaryReport);
  }

  @Test
  public void runShouldThrowExceptionIfEmptyFile() {
    thrown.expect(RuntimeException.class);
    thrown.expectMessage("no first line!");
    processFile.setFilename("src/test/resources/lse-companies-empty-file.tsv");
    processFile.run();
  }

  @Test(expected = RuntimeException.class)
  public void runShouldThrowExceptionIfNoFile() {
    processFile.setFilename("no-file");
    processFile.run();
  }

  @Test
  public void runShouldRunWithoutError() {
    processFile.setFilename("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
    processFile.run();
  }
}
