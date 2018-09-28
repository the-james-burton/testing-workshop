package org.projects.workshop.testing.reports;

import java.util.List;
import java.util.StringJoiner;

import org.projects.workshop.testing.model.ParsedFile;

public class LongReport implements Report {

  @Override
  public String generateReport(ParsedFile parsedFile) {
    StringJoiner joiner = new StringJoiner("\n");
    for (List<String> row : parsedFile.getRows()) {
      joiner.add("---------------------------");
      for (int x = 0; x < parsedFile.getHeaders().size(); x++) {
        String rowToJoin = String.format("%s:%s", parsedFile.getHeaders().get(x), row.get(x));
        joiner.add(rowToJoin);
      }
    }
    return joiner.toString();
  }

}
