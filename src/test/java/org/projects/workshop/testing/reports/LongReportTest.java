package org.projects.workshop.testing.reports;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.projects.workshop.testing.model.ParsedFile;

public class LongReportTest extends ReportTest {

  @Test
  public void shouldGenerateReport() throws Exception {

    ParsedFile parsedFile = makeParsedFile();
    Report longReport = new LongReport();
    String report = longReport.generateReport(parsedFile);
    System.out.println(report);

    assertThat(report)
        .isNotNull()
        .isNotEmpty()
        .hasSize(1918)
        .contains(
            "---------------------------",
            "Company Name:ENTERTAINMENT ONE LTD.");
  }

}
