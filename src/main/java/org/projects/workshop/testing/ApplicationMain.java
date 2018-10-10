package org.projects.workshop.testing;

public class ApplicationMain {

  public static void main(final String... args) {
    ProcessFile processFile = new ProcessFile();
    String result = processFile.process(args[0]);
    System.out.println(result);
  }

}
