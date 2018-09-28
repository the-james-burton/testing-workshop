package org.projects.workshop.testing;

import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.LongReport;
import org.projects.workshop.testing.reports.MarketCapSummaryReport;
import org.projects.workshop.testing.reports.Report;

public class ProcessFile implements Runnable {

  private String filename;

  public ProcessFile() {
  }

  public void run() {
    FileParser fileParser = new FileParser();
    ParsedFile parsedFile = fileParser.parseFile(filename);

    Report longReportGenerator = new LongReport();
    String longReport = longReportGenerator.generateReport(parsedFile);
    System.out.println(longReport);

    Report marketCapSummaryReportGenerator = new MarketCapSummaryReport();
    String marketCapSummaryReport = marketCapSummaryReportGenerator.generateReport(parsedFile);
    System.out.println(marketCapSummaryReport);
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

}
