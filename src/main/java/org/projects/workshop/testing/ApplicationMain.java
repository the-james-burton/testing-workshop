package org.projects.workshop.testing;

import org.projects.workshop.testing.reports.LongReport;
import org.projects.workshop.testing.reports.MarketCapSummaryReport;

public class ApplicationMain {

  public static void main(final String... args) {
    ProcessFile processFile = new ProcessFile();
    processFile.setFileParser(new FileParser());
    processFile.setReportGenerator1(new LongReport());
    processFile.setReportGenerator2(new MarketCapSummaryReport());
    processFile.setFilename("src/main/resources/lse-companies.tsv");
    String result = processFile.process();
    System.out.println(result);
  }

}
