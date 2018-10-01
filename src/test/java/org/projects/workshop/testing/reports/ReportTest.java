package org.projects.workshop.testing.reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.projects.workshop.testing.model.ParsedFile;

public abstract class ReportTest {

  ParsedFile makeParsedFile() {
    ParsedFile parsedFile = new ParsedFile();
    String[] headersString = { "Admission Date", "Company Name", "ICB Industry", "ICB Super-Sector", "Country of Incorporation",
        "World Region", "Market", "International Issuer", "Company Market Cap (£m)" };
    parsedFile.setHeaders(Arrays.<String> asList(headersString));

    List<List<String>> rows = new ArrayList<>();
    rows.add(Arrays.<String> asList("13/03/53", "4IMPRINT GROUP PLC", "Consumer Services", "Media", "United Kingdom", "Europe",
        "MAIN MARKET", "No", "603.84"));
    rows.add(Arrays.<String> asList("01/05/02", "AEOREMA COMMUNICATIONS PLC", "Consumer Services", "Media", "United Kingdom",
        "Europe", "AIM", "No", "none"));
    rows.add(Arrays.<String> asList("09/02/16", "ASCENTIAL PLC", "Consumer Services", "Media", "United Kingdom", "Europe",
        "MAIN MARKET", "No", "1726.22"));
    rows.add(Arrays.<String> asList("15/07/10", "ENTERTAINMENT ONE LTD.", "Consumer Services", "Media", "Canada",
        "North America", "MAIN MARKET", "Yes", "1693.04"));
    rows.add(Arrays.<String> asList("25/10/07", "GRUPO CLARIN S.A.", "Consumer Services", "Media", "Argentina",
        "Latin America", "MAIN MARKET", "Yes", "10.0"));
    rows.add(Arrays.<String> asList("14/11/07", "MINDS + MACHINES GROUP LIMITED", "Consumer Services", "Media",
        "British Virgin Islands", "North America", "AIM", "Yes", "56.16"));
    rows.add(Arrays.<String> asList("28/05/14", "TAPTICA INTERNATIONAL LTD", "Consumer Services", "Media", "Israel",
        "Middle East", "AIM", "Yes", "223.51"));
    parsedFile.setRows(rows);
    return parsedFile;
  }

}
