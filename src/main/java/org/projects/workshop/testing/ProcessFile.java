package org.projects.workshop.testing;

import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.LongReport;
import org.projects.workshop.testing.reports.MarketCapSummaryReport;
import org.projects.workshop.testing.reports.Report;

public class ProcessFile {

  private String filename;

  public ProcessFile() {
  }

  public String process() {
    FileParser fileParser = new FileParser();
    ParsedFile parsedFile = fileParser.parseFile(filename);

    StringJoiner joiner = new StringJoiner("\n");
    Report longReportGenerator = new LongReport();
    String longReport = longReportGenerator.generateReport(parsedFile);
    joiner.add(longReport);

    Report marketCapSummaryReportGenerator = new MarketCapSummaryReport();
    String marketCapSummaryReport = marketCapSummaryReportGenerator.generateReport(parsedFile);
    joiner.add(marketCapSummaryReport);
    return joiner.toString();
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

}
