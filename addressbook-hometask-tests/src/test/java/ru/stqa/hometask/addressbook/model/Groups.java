package ru.stqa.hometask.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bebeka on 14.11.2016.
 */
public class Groups extends ForwardingSet<DataGroupFilling> {
    private Set<DataGroupFilling> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<>(groups.delegate());
    }

    public Groups() {
        this.delegate = new HashSet<>();
    }

  public Groups(Collection<DataGroupFilling> groups) {
    this.delegate = new HashSet<>(groups);
  }

  @Override
    protected Set<DataGroupFilling> delegate() {
        return delegate;
    }
    public Groups withAdded(DataGroupFilling group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }
    public Groups withOut(DataGroupFilling group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
