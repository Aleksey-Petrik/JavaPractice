package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertRequest extends AbstractRequest<Csv> {
  private String[] line;

  private InsertRequest(Csv target, String[] line) {
    super(target);
    this.line = line;
  }

  @Override
  public Csv execute() throws RequestException {
    checkHeader();

    var valuesList = new ArrayList<>(Arrays.asList(target.values()));
    valuesList.add(line);

    return newCsv(valuesList);
  }

  public static class Builder {
    private String[] line;
    private Csv csv;

    public Builder insert(String[] line) {
      this.line = line;
      return this;
    }

    public Builder to(Csv csv) {
      this.csv = csv;
      return this;
    }

    public InsertRequest build() {
      return new InsertRequest(csv, line);
    }
  }
}
