package org.projects.workshop.testing;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.projects.workshop.testing.model.ParsedFile;
import org.projects.workshop.testing.reports.Report;

public class ProcessFileTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ProcessFile processFile;

  private ParsedFile parsedFile;

  @Mock
  FileParser mockFileParser;

  @Mock
  Report mockLongReport;

  @Mock
  Report mockMarketCapSummaryReport;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    parsedFile = new ParsedFile();

    when(mockFileParser.parseFile(anyString()))
        .thenReturn(parsedFile);
    when(mockLongReport.generateReport(any(ParsedFile.class)))
        .thenReturn("longReportOutput");
    when(mockMarketCapSummaryReport.generateReport(any(ParsedFile.class)))
        .thenReturn("marketCapSummaryReportOutput");

    processFile = new ProcessFile();
    processFile.setFileParser(mockFileParser);
    processFile.setReportGenerator1(mockLongReport);
    processFile.setReportGenerator2(mockMarketCapSummaryReport);

  }

  @Test
  public void runShouldThrowExceptionIfEmptyFile() {
    thrown.expect(RuntimeException.class);
    thrown.expectMessage("no first line!");
    processFile.setFilename("src/test/resources/lse-companies-empty-file.tsv");
    processFile.process();
  }

  @Test(expected = RuntimeException.class)
  public void runShouldThrowExceptionIfNoFile() {
    processFile.setFilename("no-file");
    processFile.process();
  }

  @Test
  public void runShouldRunWithoutError() {
    processFile.setFilename("src/test/resources/lse-companies-with-no-mkt-cap.tsv");
    processFile.process();
    verify(mockLongReport).generateReport(parsedFile);

  }
}
