package ru.stqa.pft.mantis.ru.stqa.pft.mantis.model;

public class Users {
  public int id;
  public String userName;
  public String email;

  public Users(int id, String userName, String email) {
    this.id = id;
    this.userName = userName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id= " + id +
            ", userName= '" + userName + '\'' +
            ", email= '" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Users that = (Users) o;

    if (id != that.id) return false;
    if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userName != null ? userName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
