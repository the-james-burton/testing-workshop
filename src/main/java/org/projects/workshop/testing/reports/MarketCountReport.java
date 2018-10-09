package org.projects.workshop.testing.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;

public class MarketCountReport implements Report {

  @Override
  public String generateReport(ParsedFile parsedFile) {
    Map<String, Long> countByMarket = new HashMap<>();
    for (List<String> row : parsedFile.getRows()) {
      String market = row.get(6);
      countByMarket.computeIfAbsent(market, key -> 0l);
      countByMarket.compute(market, (key, value) -> value + 1);
    }

    StringJoiner joiner = new StringJoiner("\n");
    for (String region : countByMarket.keySet()) {
      String rowToJoin = String.format("%s : %d", region, countByMarket.get(region));
      joiner.add(rowToJoin);
    }
    return joiner.toString();
  }

}
