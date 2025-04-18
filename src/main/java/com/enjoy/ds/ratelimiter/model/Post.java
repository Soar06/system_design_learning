package com.enjoy.ds.ratelimiter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Post implements Serializable {
  private String id;
  private String description;

  @JsonCreator
  public Post(@JsonProperty("id") String id, @JsonProperty("description") String description) {
    this.id = id;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  // You can also add setters if you need them
  public void setId(String id) {
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
