package ru.stqa.hometask.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {

    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<DataGroupFilling> groups = generateGroups(count);
    save(groups, new File(file));
  }

  private void save(List<DataGroupFilling> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (DataGroupFilling group : groups) {
      writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
    }
    writer.close();
  }

  private List<DataGroupFilling> generateGroups(int count) {
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
