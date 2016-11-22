package ru.stqa.hometask.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.hometask.addressbook.model.DataContactFilling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {

    ContactDataGenerator generator = new ContactDataGenerator();
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
    List<DataContactFilling> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
        saveAsJson(contacts, new File(file));
    } else {
      System.out.println("unrecognized format: " + format);
    }
  }

  private void saveAsJson(List<DataContactFilling> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<DataContactFilling> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(DataContactFilling.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<DataContactFilling> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (DataContactFilling contact : contacts) {
      writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getAddress()));
    }
    writer.close();
  }

  private List<DataContactFilling> generateContacts(int count) {
    List<DataContactFilling> contacts = new ArrayList<DataContactFilling>();
    for (int i = 0; i < count; i++) {
      contacts.add(new DataContactFilling()
              .withFirstName(String.format("testName %s", i))
              .withLastName(String.format("testLastName %s", i))
              .withAddress(String.format("testAddress %s", i)));
    }
    return contacts;
  }

}