package org.projects.workshop.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class ProcessFile {

  private String filename;

  public ProcessFile() {
  }

  public String process() {
    File file = new File(filename);
    Scanner input = null;
    try {
      input = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("unable to create scanner!");
      throw new RuntimeException(e);
    }
    input.useDelimiter("\n");

    List<String> headers = new ArrayList<>();
    List<List<String>> rows = new ArrayList<>();

    if (input.hasNext()) {
      String[] firstLine = input.next().split("\t");
      headers.addAll(Arrays.asList(firstLine));
    } else {
      input.close();
      String message = "no first line!";
      System.out.println(message);
      throw new RuntimeException(message);
    }

    while (input.hasNext()) {
      String[] line = input.next().split("\t");
      rows.add(Arrays.asList(line));
    }
    input.close();

    System.out.println(headers);
    System.out.println(rows);

    StringJoiner joiner = new StringJoiner("\n");
    for (List<String> row : rows) {
      joiner.add("---------------------------");
      for (int x = 0; x < headers.size(); x++) {
        String rowToJoin = String.format("%s:%s", headers.get(x), row.get(x));
        joiner.add(rowToJoin);
      }
    }

    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator(',');
    symbols.setDecimalSeparator('.');
    String pattern = "#,##0.0#";
    DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
    decimalFormat.setParseBigDecimal(true);
    Map<String, BigDecimal> marketCapByRegion = new HashMap<>();
    for (List<String> row : rows) {
      String region = row.get(5);
      String marketCapText = row.get(8);
      marketCapByRegion.computeIfAbsent(region, key -> BigDecimal.ZERO);
      try {
        BigDecimal marketCap = (BigDecimal) decimalFormat.parse(marketCapText);
        marketCapByRegion.compute(region, (key, value) -> value.add(marketCap));
      } catch (ParseException e) {
        System.out.println("not a number!");
      }
    }

    joiner.add("---------------------------");
    for (String region : marketCapByRegion.keySet()) {
      String rowToJoin = String.format("%1$20s : £%2$10.2fm", region, marketCapByRegion.get(region));
      joiner.add(rowToJoin);
    }

    return joiner.toString();
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

}
