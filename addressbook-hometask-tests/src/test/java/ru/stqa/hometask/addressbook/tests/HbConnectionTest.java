package ru.stqa.hometask.addressbook.tests;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.hometask.addressbook.model.DataContactFilling;
import ru.stqa.hometask.addressbook.model.DataGroupFilling;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test
  public void testHbConnectionGroups() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<DataGroupFilling> result = session.createQuery("from DataGroupFilling").list();
    for (DataGroupFilling group : result) {
      System.out.println(group);
      System.out.println("группа содержит контакты: \n" + group.getContacts());
    }
    session.getTransaction().commit();
    session.close();

  }
  @Test
  public void testHbConnectionContacts() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<DataContactFilling> result = session.createQuery("from DataContactFilling where deprecated = '0000-00-00'").list();
    for (DataContactFilling contact : result) {
      System.out.println(contact);
      System.out.println("контакт содержится в группах: \n" + contact.getGroups());
    }
    session.getTransaction().commit();
    session.close();

  }
}
