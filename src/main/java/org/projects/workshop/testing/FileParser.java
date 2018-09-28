package org.projects.workshop.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.projects.workshop.testing.model.ParsedFile;

public class FileParser {

  public ParsedFile parseFile(String filename) {
    File file = new File(filename);
    Scanner input = null;
    try {
      input = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("unable to create scanner!");
      throw new RuntimeException(e);
    }
    input.useDelimiter("\n");

    ParsedFile parsedFile = new ParsedFile();

    if (input.hasNext()) {
      String[] firstLine = input.next().split("\t");
      parsedFile.getHeaders().addAll(Arrays.asList(firstLine));
    } else {
      input.close();
      String message = "no first line!";
      System.out.println(message);
      throw new RuntimeException(message);
    }

    while (input.hasNext()) {
      String[] line = input.next().split("\t");
      parsedFile.getRows().add(Arrays.asList(line));
    }
    input.close();

    return parsedFile;
  }
}
