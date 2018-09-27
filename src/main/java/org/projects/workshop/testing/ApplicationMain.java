package org.projects.workshop.testing;

public class ApplicationMain {

  public static void main(final String... args) {
    ProcessFile processFile = new ProcessFile();
    processFile.setFilename("src/main/resources/lse-companies.tsv");
    processFile.run();
  }

}
