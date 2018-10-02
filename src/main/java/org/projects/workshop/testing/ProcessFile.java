package org.projects.workshop.testing;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;

public class ProcessFile implements Runnable {

  private String filename;

  public ProcessFile() {
  }

  public void run() {
    FileParser fileParser = new FileParser();
    ParsedFile parsedFile = fileParser.parseFile(filename);

    StringJoiner joiner = new StringJoiner("\n");
    for (List<String> row : parsedFile.getRows()) {
      joiner.add("---------------------------");
      for (int x = 0; x < parsedFile.getHeaders().size(); x++) {
        String rowToJoin = String.format("%s:%s", parsedFile.getHeaders().get(x), row.get(x));
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
    for (List<String> row : parsedFile.getRows()) {
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

  public void setFilename(String filename) {
    this.filename = filename;
  }

}
