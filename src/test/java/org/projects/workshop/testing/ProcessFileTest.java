package org.projects.workshop.testing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFileTest {

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
  public void runShouldRunWithoutError() {
    processFile.setFilename("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
    processFile.process();
  }
}
