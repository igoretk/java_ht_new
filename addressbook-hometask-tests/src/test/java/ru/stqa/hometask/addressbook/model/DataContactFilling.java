package ru.stqa.hometask.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")

public class DataContactFilling {

  @XStreamOmitField

  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String email1;
  private String email2;
  private String email3;
  private String allPhones;
  private String allEmails;
  private String names;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public DataContactFilling withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
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

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
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

  public String getAllEmails() {
    return allEmails;
  }
  public String getNames() {
    return names;
  }
  public DataContactFilling withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public DataContactFilling withAddress(String address) {
    this.address = address;
    return this;
  }

  public DataContactFilling withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public DataContactFilling withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public DataContactFilling withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public DataContactFilling withNames(String names) {
    this.names = names;
    return this;
  }

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
            ", lastName='" + lastName + '\'' +
            '}';
  }


}
