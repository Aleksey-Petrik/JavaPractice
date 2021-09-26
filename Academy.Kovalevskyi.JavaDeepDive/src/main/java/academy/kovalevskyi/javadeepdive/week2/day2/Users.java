package academy.kovalevskyi.javadeepdive.week2.day2;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;
import academy.kovalevskyi.javadeepdive.week0.day3.RequestException;
import academy.kovalevskyi.javadeepdive.week2.day1.Controller;
import academy.kovalevskyi.javadeepdive.week2.day1.Get;
import academy.kovalevskyi.javadeepdive.week2.day1.Path;
import academy.kovalevskyi.javadeepdive.week2.day1.Post;

@Controller
public class Users {

  private final UserDB storage = new UserDB(new Csv.Builder()
          .header(new String[]{"mail", "firstName", "lastName", "password"})
          .values(new String[][]{}).build());

  @Get
  @Path("/users")
  public String[] users() {
    try {
      return storage.getNames();
    } catch (RequestException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Get
  @Path("/first")
  public User firstUser() {
    try {
      return storage.getUser(storage.getMails()[0]).get();
    } catch (RequestException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Post
  @Path("/users")
  public void addUser(User user) {
    try {
      storage.addUser(user);
    } catch (RequestException e) {
      e.printStackTrace();
    }
  }
}
