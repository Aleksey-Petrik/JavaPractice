package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;

public class UpdateRequest extends AbstractRequest<Csv> {
  private final Selector whereSelector;
  private final Selector updateToSelector;

  private UpdateRequest(Csv target, Selector whereSelector, Selector updateToSelector) {
    super(target);
    this.whereSelector = whereSelector;
    this.updateToSelector = updateToSelector;
  }

  @Override
  protected Csv execute() throws RequestException {
    checkHeader();
    var valuesList = new ArrayList<String[]>();

    int columnWhere = getIdColumn(selectorNonNull(whereSelector).fieldName());
    int columnUpdate = getIdColumn(selectorNonNull(updateToSelector).fieldName());

    for (String[] value : target.values()) {
      if (value[columnWhere].equals(whereSelector.value())) {
        value[columnUpdate] = updateToSelector.value();
      }
      valuesList.add(value);
    }
    return newCsv(valuesList);
  }

  public static class Builder {
    private Csv csv;
    private Selector whereSelector;
    private Selector updateToSelector;

    public Builder where(Selector selector) {
      this.whereSelector = selector;
      return this;
    }

    public Builder update(Selector updateSelector) {
      this.updateToSelector = updateSelector;
      return this;
    }

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public UpdateRequest build() {
      return new UpdateRequest(csv, whereSelector, updateToSelector);
    }
  }
}
