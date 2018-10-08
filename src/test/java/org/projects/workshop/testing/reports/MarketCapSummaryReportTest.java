package org.projects.workshop.testing.reports;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.projects.workshop.testing.model.ParsedFile;

public class MarketCapSummaryReportTest extends ReportTest {

  @Test
  public void shouldGenerateReport() throws Exception {

    ParsedFile parsedFile = makeParsedFile();
    Report longReport = new MarketCapSummaryReport();
    String report = longReport.generateReport(parsedFile);
    System.out.println(report);

    assertThat(report)
        .isNotNull()
        .isNotEmpty()
        .hasSize(171)
        .contains(
            "---------------------------",
            "              Europe : £   2330.06m");
  }
}
