package ru.stqa.hometask.addressbook.model;

public class DataContactFilling {
  private int id=Integer.MAX_VALUE;;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String fax;
  private String secondaryAddress;
  private String notes;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataContactFilling that = (DataContactFilling) o;

    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

  }

  @Override
  public int hashCode() {
    return firstName != null ? firstName.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "DataContactFilling{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }


  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getNotes() {
    return notes;
  }

  public DataContactFilling withId(int id) {
    this.id = id;
    return this;
  }

  public DataContactFilling withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public DataContactFilling withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
}
