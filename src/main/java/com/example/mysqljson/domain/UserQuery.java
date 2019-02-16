package com.example.mysqljson.domain;

import com.example.mysqljson.StringMultimapConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Multimap;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserQuery {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String userId;
  private String name;
  private Boolean active;
  @Convert(converter = StringMultimapConverter.class)
  @Column(columnDefinition = "JSON")
  private Multimap<String, String> query;

  public Long getId() {
    return id;
  }

  public UserQuery setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public UserQuery setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getName() {
    return name;
  }

  public UserQuery setName(String name) {
    this.name = name;
    return this;
  }

  public Boolean getActive() {
    return active;
  }

  public UserQuery setActive(Boolean active) {
    this.active = active;
    return this;
  }

  public Multimap<String, String> getQuery() {
    return query;
  }

  public void setQuery(Multimap<String, String> query) {
    this.query = query;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserQuery userQuery = (UserQuery) o;
    return Objects.equals(id, userQuery.id) &&
        Objects.equals(userId, userQuery.userId) &&
        Objects.equals(name, userQuery.name) &&
        Objects.equals(active, userQuery.active) &&
        Objects.equals(query, userQuery.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, name, active, query);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", UserQuery.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("userId='" + userId + "'")
        .add("name='" + name + "'")
        .add("active=" + active)
        .add("query=" + query)
        .toString();
  }
}
