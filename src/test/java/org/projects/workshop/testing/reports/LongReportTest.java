package org.projects.workshop.testing.reports;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.workshop.testing.model.ParsedFile;

public class LongReportTest extends ReportTest {

  @Test
  public void shouldGenerateReport() throws Exception {

    ParsedFile parsedFile = makeParsedFile();
    Report longReport = new LongReport();
    String report = longReport.generateReport(parsedFile);
    System.out.println(report);

    assertTrue(report != null);
    assertTrue(!report.isEmpty());
    assertTrue(report.contains("---------------------------"));
    assertTrue(report.contains("Company Name:ENTERTAINMENT ONE LTD."));
    assertTrue(report.length() == 1918);
  }

}
