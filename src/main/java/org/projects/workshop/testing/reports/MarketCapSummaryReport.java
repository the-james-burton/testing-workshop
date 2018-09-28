package org.projects.workshop.testing.reports;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;

public class MarketCapSummaryReport implements Report {

  @Override
  public String generateReport(ParsedFile parsedFile) {
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

    StringJoiner joiner = new StringJoiner("\n");
    joiner.add("---------------------------");
    for (String region : marketCapByRegion.keySet()) {
      String rowToJoin = String.format("%1$20s : £%2$10.2fm", region, marketCapByRegion.get(region));
      joiner.add(rowToJoin);
    }
    return joiner.toString();
  }

}
