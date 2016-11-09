package ru.stqa.hometask.addressbook.model;

public class DataGroupFilling {
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  public DataGroupFilling(String groupName, String groupHeader, String groupFooter) {
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

  @Override
  // преобразуем имя группы в строку
  public String toString() {
    return "DataGroupFilling{" +
            "groupName='" + groupName + '\'' +
            '}';
  }

  @Override
  // генерируем метод equals для сравнения объектов DataGroupFilling
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataGroupFilling that = (DataGroupFilling) o;

    return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;

  }

  @Override
  public int hashCode() {
    return groupName != null ? groupName.hashCode() : 0;
  }
}
