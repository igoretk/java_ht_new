package ru.stqa.hometask.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<DataContactFilling> {

  private Set<DataContactFilling> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<DataContactFilling>(contacts.delegate());
  }

  public Contacts() {
    this.delegate = new HashSet<DataContactFilling>();
  }

  @Override
  protected Set<DataContactFilling> delegate() {
    return delegate;
  }
  public Contacts withAdded(DataContactFilling contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }
  public Contacts withOut(DataContactFilling contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
