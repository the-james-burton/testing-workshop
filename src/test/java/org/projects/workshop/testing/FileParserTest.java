package org.projects.workshop.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

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

    assertTrue(parsedFile != null);

    List<String> headers = parsedFile.getHeaders();
    assertThat(headers).isNotNull();
    assertThat(headers).hasSize(9);
    assertThat(headers).allSatisfy(header -> assertThat(header).isNotNull());
    assertThat(headers).element(4).isEqualTo("Country of Incorporation");

    List<List<String>> rows = parsedFile.getRows();
    assertThat(parsedFile.getRows()).isNotNull();
    assertThat(parsedFile.getRows()).hasSize(7);
    assertThat(parsedFile.getRows()).allSatisfy(row -> assertThat(row).allSatisfy(item -> assertThat(item).isNotNull()));
    assertThat(rows).element(3).satisfies(row -> assertThat(row).element(1).isEqualTo("ENTERTAINMENT ONE LTD."));
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
