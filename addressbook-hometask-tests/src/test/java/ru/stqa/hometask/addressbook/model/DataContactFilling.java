package ru.stqa.hometask.addressbook.model;

public class DataContactFilling {
  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String fax;
  private final String secondaryAddress;
  private final String notes;


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

  public DataContactFilling(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String secondaryAddress, String notes) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.secondaryAddress = secondaryAddress;
    this.notes = notes;
  }

  public DataContactFilling(int id, String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String secondaryAddress, String notes) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.secondaryAddress = secondaryAddress;
    this.notes = notes;
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

  public void setId(int id) {
    this.id = id;
  }

}
