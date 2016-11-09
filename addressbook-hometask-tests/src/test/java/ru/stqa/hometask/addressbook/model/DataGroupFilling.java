package ru.stqa.hometask.addressbook.model;

public class DataGroupFilling {
  private final String id;
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  public DataGroupFilling( String groupName, String groupHeader, String groupFooter) {
    this.id = null;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }
  public DataGroupFilling(String id, String groupName, String groupHeader, String groupFooter) {
    this.id = id;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataGroupFilling that = (DataGroupFilling) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
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
