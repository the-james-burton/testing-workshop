package org.projects.workshop.testing;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessFile {

  public static void main(final String... args) throws Exception {
    File file = new File("/home/jimsey/Development/projects/testing-workshop/src/main/resources/lse-companies.tsv");
    Scanner input = new Scanner(file);
    input.useDelimiter("\n");

    List<String> headers = new ArrayList<>();
    List<List<String>> rows = new ArrayList<>();

    if (input.hasNext()) {
      String[] firstLine = input.next().split("\t");
      headers.addAll(Arrays.asList(firstLine));
    } else {
      System.out.println("no first line!");
    }
    
    while(input.hasNext()) {
        String[] line = input.next().split("\t");
        rows.add(Arrays.asList(line));
    }

    System.out.println(headers);
    System.out.println(rows);
    input.close();
  }
  
}
