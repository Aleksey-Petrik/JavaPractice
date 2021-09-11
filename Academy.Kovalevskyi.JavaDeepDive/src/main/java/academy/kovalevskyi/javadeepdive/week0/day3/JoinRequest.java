package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;
import java.util.Arrays;

public class JoinRequest extends AbstractRequest<Csv> {
  private final Csv leftTable;
  private final Csv rightTable;
  private final String whereColumn;

  private JoinRequest(Csv from, Csv on, String by) {
    super();
    leftTable = from;
    rightTable = on;
    whereColumn = by;
  }

  @Override
  protected Csv execute() throws RequestException {
    var valuesList = new ArrayList<String[]>();
    checkHeader(leftTable);
    checkHeader(rightTable);

    if (leftTable.values().length != rightTable.values().length) {
      throw new RequestException("Error");
    }

    int leftColumn = getIdColumn(leftTable, whereColumn);
    int rightColumn = getIdColumn(rightTable, whereColumn);

    String[]headerRightTable = rightTable.header();
    for (int i = rightColumn; i > 0; i--){
      String buf = headerRightTable[rightColumn];
      headerRightTable[rightColumn] = headerRightTable[rightColumn - 1];
      headerRightTable[rightColumn - 1] = buf;
    }

    String[] header = joinArrays(leftTable.header(), headerRightTable);

    for (String[] leftValue : leftTable.values()) {
      for (String[] rightValue : rightTable.values()) {
        if (leftValue[leftColumn].equals(rightValue[rightColumn])){
          valuesList.add(joinArrays(leftValue, rightValue));
          break;
        }
      }
    }
    return new Csv.Builder().header(header).values(valuesList.toArray(String[][]::new)).build();
  }

  private String[] joinArrays(String[] left, String[] right) {
    String[] unionArray = new String[left.length + right.length - 1];
    System.arraycopy(left, 0, unionArray, 0, left.length);
    System.arraycopy(right, 1, unionArray, left.length, right.length - 1);
    return unionArray;
  }

  public static class Builder {
    private Csv leftTable;
    private Csv rightTable;
    private String whereColumn;

    public Builder from(Csv from) {
      leftTable = from;
      return this;
    }

    public Builder on(Csv on) {
      rightTable = on;
      return this;
    }

    public Builder by(String by) {
      whereColumn = by;
      return this;
    }

    public JoinRequest build() {
      return new JoinRequest(leftTable, rightTable, whereColumn);
    }
  }

}
