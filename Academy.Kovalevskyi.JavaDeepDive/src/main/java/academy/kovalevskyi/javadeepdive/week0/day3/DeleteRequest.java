package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;

public class DeleteRequest extends AbstractRequest<Csv> {
  private final Selector whereSelector;

  private DeleteRequest(Csv target, Selector whereSelector) {
    super(target);
    this.whereSelector = whereSelector;
  }

  @Override
  protected Csv execute() throws RequestException {
    checkHeader();

    var valuesList = new ArrayList<String[]>();
    int column = getIdColumn(whereSelector.fieldName());
    for (String[] value : target.values()) {
      if (!value[column].equals(whereSelector.value())) {
        valuesList.add(value);
      }
    }
    return newCsv(valuesList);
  }

  public static class Builder {
    private Selector selector;
    private Csv csv;

    public Builder where(Selector selector) {
      this.selector = selector;
      return this;
    }

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public DeleteRequest build() {
      return new DeleteRequest(csv, selector);
    }
  }
}
