package ru.stqa.hometask.addressbook.generators;

import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  public static void main(String[] args) throws IOException {

    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<DataGroupFilling> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<DataGroupFilling> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (DataGroupFilling group : groups) {
      writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
    }
    writer.close();
  }

  private static List<DataGroupFilling> generateGroups(int count) {
    List<DataGroupFilling> groups = new ArrayList<DataGroupFilling>();
    for (int i = 0; i < count; i++) {
      groups.add(new DataGroupFilling()
              .withGroupName(String.format("test %s", i))
              .withGroupHeader(String.format("header %s", i))
              .withGroupFooter(String.format("footer %s", i)));
    }
    return groups;
  }

}
