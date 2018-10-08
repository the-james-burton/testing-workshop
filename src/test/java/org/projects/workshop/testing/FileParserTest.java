package org.projects.workshop.testing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.projects.workshop.testing.model.ParsedFile;

public class FileParserTest {

  private FileParser fileParser;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    fileParser = new FileParser();
  }

  @Test
  public void parseFileShouldExtractHeadersAndRows() {
    ParsedFile parsedFile = fileParser.parseFile("src/test/resources/lse-companies-with-no-mkt-cap.tsv");

    assertThat(parsedFile).isNotNull();

    List<String> headers = parsedFile.getHeaders();
    assertThat(headers)
        .isNotNull()
        .hasSize(9)
        .allSatisfy(header -> assertThat(header).isNotNull())
        .element(4).isEqualTo("Country of Incorporation");

    List<List<String>> rows = parsedFile.getRows();
    assertThat(rows)
        .isNotNull()
        .hasSize(7)
        .allSatisfy(row -> assertThat(row).allSatisfy(item -> assertThat(item).isNotNull()))
        .element(3).satisfies(row -> assertThat(row).element(1).isEqualTo("ENTERTAINMENT ONE LTD."));
  }

  @Test
  public void runShouldThrowExceptionIfEmptyFile() {
    thrown.expect(RuntimeException.class);
    thrown.expectMessage("no first line!");
    fileParser.parseFile("src/test/resources/lse-companies-empty-file.tsv");
  }

  @Test(expected = RuntimeException.class)
  public void runShouldThrowExceptionIfNoFile() {
    fileParser.parseFile("no-file");
  }

}
