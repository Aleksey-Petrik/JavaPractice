package academy.kovalevskyi.javadeepdive.week2.day2;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import academy.kovalevskyi.javadeepdive.week0.day3.InsertRequest;
import academy.kovalevskyi.javadeepdive.week0.day3.RequestException;
import academy.kovalevskyi.javadeepdive.week0.day3.SelectRequest;
import academy.kovalevskyi.javadeepdive.week0.day3.Selector;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDB {
  private Csv csv;

  public UserDB(Csv csv) {
    this.csv = csv;
  }

  public void addUser(User user) throws RequestException {
    csv = new InsertRequest.Builder().to(csv).insert(user.getFields()).build().execute();
  }

  public String[] getMails() throws RequestException {
    return getUserData("mail");
  }

  public String[] getNames() throws RequestException {
    return getUserData("firstName");
  }

  public String[] getUserData(String field) throws RequestException {
    String[][] mails = new SelectRequest.Builder().from(csv).select(new String[]{field}).build().execute();
    return Arrays.stream(mails).map(element -> element[0]).toArray(String[]::new);
  }

  public Optional<User> getUser(String mail) throws RequestException {

    String[][] userFields = new SelectRequest.Builder().from(csv).where(new Selector("mail", mail)).build().execute();
    if (userFields.length == 0){
      return Optional.empty();
    }

    User user = new User();
    user.mail = userFields[0][0];
    user.firstName = userFields[0][1];
    user.lastName = userFields[0][2];
    user.password = userFields[0][3];
    return Optional.of(user);
  }
}
