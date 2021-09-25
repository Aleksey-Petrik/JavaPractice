package academy.kovalevskyi.javadeepdive.week2.day1;

public class User {
  private String mail;
  private String password;

  public User() {
  }

  public User(String mail, String password) {
    this.mail = mail;
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public String getPassword() {
    return password;
  }

}
