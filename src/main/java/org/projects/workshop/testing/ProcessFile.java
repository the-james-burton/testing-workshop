package org.projects.workshop.testing;

import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.LongReport;
import org.projects.workshop.testing.reports.MarketCapSummaryReport;
import org.projects.workshop.testing.reports.Report;

public class ProcessFile {

  private String filename;

  private FileParser fileParser;

  private Report reportGenerator1;

  private Report reportGenerator2;

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

  public void setFileParser(FileParser fileParser) {
    this.fileParser = fileParser;
  }

  public void setReportGenerator1(Report reportGenerator1) {
    this.reportGenerator1 = reportGenerator1;
  }

  public void setReportGenerator2(Report reportGenerator2) {
    this.reportGenerator2 = reportGenerator2;
  }

}
