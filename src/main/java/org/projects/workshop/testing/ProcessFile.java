package org.projects.workshop.testing;

import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFile {

  private FileParser fileParser;

  private Report reportGenerator1;

  private Report reportGenerator2;

  public String process(String filename) {
    ParsedFile parsedFile = fileParser.parseFile(filename);
    StringJoiner joiner = new StringJoiner("\n");

    String report1 = reportGenerator1.generateReport(parsedFile);
    joiner.add(report1);

    String report2 = reportGenerator2.generateReport(parsedFile);
    joiner.add(report2);

    return joiner.toString();
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
