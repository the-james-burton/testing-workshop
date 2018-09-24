package org.projects.workshop.testing;

import java.io.File;
import java.util.Scanner;

public class ProcessFile {

  public static void main(final String... args) throws Exception {
    File file = new File("/home/jimsey/Development/projects/testing-workshop/src/main/resources/lse-companies.tsv");
    Scanner input = new Scanner(file);
    input.useDelimiter("\t");

    while(input.hasNext()) {
        String nextLine = input.nextLine();
        System.out.println(nextLine);
    }

    input.close();
  }
  
}
