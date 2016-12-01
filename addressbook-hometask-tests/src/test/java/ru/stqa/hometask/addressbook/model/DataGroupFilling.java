package ru.stqa.hometask.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class DataGroupFilling {
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = 0;

  @Column(name = "group_name")
  private String groupName;

  @Column(name = "group_header")
  @Type(type = "text")
  private String groupHeader;

  @Column(name = "group_footer")
  @Type(type = "text")
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
  public String toString() {
    return "DataGroupFilling{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataGroupFilling that = (DataGroupFilling) o;

    if (id != that.id) return false;
    if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
    if (groupHeader != null ? !groupHeader.equals(that.groupHeader) : that.groupHeader != null) return false;
    return groupFooter != null ? groupFooter.equals(that.groupFooter) : that.groupFooter == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    result = 31 * result + (groupHeader != null ? groupHeader.hashCode() : 0);
    result = 31 * result + (groupFooter != null ? groupFooter.hashCode() : 0);
    return result;
  }
}
