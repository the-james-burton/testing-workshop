package org.projects.workshop.testing;

import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFile implements Runnable {

  private String filename;

  private FileParser fileParser;

  private Report reportGenerator1;

  private Report reportGenerator2;

  public ProcessFile() {
  }

  public void run() {
    ParsedFile parsedFile = fileParser.parseFile(filename);

    String report1 = reportGenerator1.generateReport(parsedFile);
    System.out.println(report1);

    String report2 = reportGenerator2.generateReport(parsedFile);
    System.out.println(report2);
  }

  public String getFilename() {
    return filename;
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
