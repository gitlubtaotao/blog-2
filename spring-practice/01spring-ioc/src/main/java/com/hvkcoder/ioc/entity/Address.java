package com.hvkcoder.ioc.entity;

import lombok.Data;

/**
 * @author h-vk
 * @date 2019-11-22
 * @since V1.0
 */
@Data
public class Address {
  private String province;
  private String city;
  private String street;

  @Override
  public String toString() {
    return "Address{"
        + "province='"
        + province
        + '\''
        + ", city='"
        + city
        + '\''
        + ", street='"
        + street
        + '\''
        + '}';
  }
}
