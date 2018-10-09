package org.projects.workshop.testing.reports;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.projects.workshop.testing.model.ParsedFile;

public class MarketCountReportTest extends ReportTest {

  @Test
  public void shouldGenerateReport() throws Exception {

    ParsedFile parsedFile = makeParsedFile();
    Report marketCountReport = new MarketCountReport();
    String report = marketCountReport.generateReport(parsedFile);
    System.out.println(report);

    assertThat(report)
        .isNotNull()
        .isNotEmpty()
        .hasSize(23)
        .contains(
            "AIM : 3",
            "MAIN MARKET : 4");
  }
}
