package academy.kovalevskyi.javadeepdive.week2.day1;

@Controller
public class UsersList {

  @Get
  @Path("/users")
  public String[] users() {
    return new String[] {"one", "two"};
  }

  @Post
  @Path("/users")
  public void addUser(User user) {
  }

  @Get
  @Path("/javadeepdive/list")
  public String[] getList() {
    return new String[]{"one", "two"};
  }

  @Get
  @Path("/javadeepdive/empty")
  public String[] getEmptyList() {
    return new String[]{};
  }
}
