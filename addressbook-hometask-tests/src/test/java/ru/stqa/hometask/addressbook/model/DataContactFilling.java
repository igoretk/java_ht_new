package ru.stqa.hometask.addressbook.model;

public class DataContactFilling {
  private int id = Integer.MAX_VALUE;
  ;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String secondaryAddress;
  private String notes;
  private String allPhones;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataContactFilling that = (DataContactFilling) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
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
    return home;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
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

  public DataContactFilling withHomePhone(String home) {
    this.home = home;
    return this;
  }

  public DataContactFilling withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public DataContactFilling withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public DataContactFilling withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

}
