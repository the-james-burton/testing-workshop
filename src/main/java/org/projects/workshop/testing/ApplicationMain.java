package org.projects.workshop.testing;

public class ApplicationMain {

  public static void main(final String... args) {
    ProcessFile processFile = new ProcessFile();
    String result = processFile.process("src/main/resources/lse-companies.tsv");
    System.out.println(result);
  }

}
