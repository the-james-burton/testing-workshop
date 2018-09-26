package org.projects.workshop.testing;

import java.io.File;
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
    System.out.println(joiner.toString());

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
    
    joiner = new StringJoiner("\n");
    joiner.add("---------------------------");
    for (String region : marketCapByRegion.keySet()) {
      String rowToJoin = String.format("%1$20s : £%2$10.2fm", region, marketCapByRegion.get(region));
      joiner.add(rowToJoin);
    }
    System.out.println(joiner.toString());

  }

}
