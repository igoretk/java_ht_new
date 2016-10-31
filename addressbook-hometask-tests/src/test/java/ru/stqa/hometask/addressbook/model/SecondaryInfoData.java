package ru.stqa.hometask.addressbook.model;

public class SecondaryInfoData {
  private final String secondaryAddress;
  private final String notes;

  public SecondaryInfoData(String secondaryAddress, String notes) {
    this.secondaryAddress = secondaryAddress;
    this.notes = notes;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getNotes() {
    return notes;
  }
}
