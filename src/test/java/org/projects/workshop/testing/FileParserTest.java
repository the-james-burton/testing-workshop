package org.projects.workshop.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.projects.workshop.testing.model.ParsedFile;

public class FileParserTest {

  private FileParser fileParser;

  @Before
  public void setUp() {
    fileParser = new FileParser();
  }

  @Test
  public void parseFileShouldExtractHeadersAndRows() {
    ParsedFile parsedFile = fileParser.parseFile("src/test/resources/lse-companies-with-no-mkt-cap.tsv");

    assertTrue(parsedFile != null);

    List<String> headers = parsedFile.getHeaders();
    assertTrue(headers != null);
    assertTrue(headers.size() == 9);
    for (String header : headers) {
      assertTrue(header != null);
    }
    assertTrue(headers.get(4).equals("Country of Incorporation"));

    List<List<String>> rows = parsedFile.getRows();
    assertTrue(parsedFile.getRows() != null);
    assertTrue(parsedFile.getRows().size() == 7);
    for (List<String> row : parsedFile.getRows()) {
      assertTrue(row.size() == 9);
      for (String item : row) {
        assertTrue(item != null);
      }
    }
    assertTrue(rows.get(3).get(1).equals("ENTERTAINMENT ONE LTD."));
  }

}
