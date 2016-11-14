package ru.stqa.hometask.addressbook.model;

public class DataGroupFilling {
  private int id = 0;
  private String groupName;
  private String groupHeader;
  private String groupFooter;

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }

  public int getId() {
    return id;
  }

  public DataGroupFilling withId(int id) {
    this.id = id;
    return this;
  }

  public DataGroupFilling withGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public DataGroupFilling withGroupHeader(String groupHeader) {
    this.groupHeader = groupHeader;
    return this;
  }

  public DataGroupFilling withGroupFooter(String groupFooter) {
    this.groupFooter = groupFooter;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataGroupFilling that = (DataGroupFilling) o;

    if (id != that.id) return false;
    return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    return result;
  }



  @Override
  public String toString() {
    return "DataGroupFilling{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

}
