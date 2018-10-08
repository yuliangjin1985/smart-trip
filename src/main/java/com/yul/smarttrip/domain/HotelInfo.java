package com.yul.smarttrip.domain;

import com.yul.smarttrip.domain.hotel.Address;
import com.yul.smarttrip.domain.hotel.Amenity;
import com.yul.smarttrip.domain.hotel.Award;
import com.yul.smarttrip.domain.hotel.Contact;
import com.yul.smarttrip.domain.hotel.Location;
import com.yul.smarttrip.domain.hotel.Price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
//Only used partial data
public class HotelInfo implements Serializable {
  private String property_code;
  private String property_name;
  private Location location;
  private Address address;
  private Price total_price;
  private Price min_daily_rate;
  private List<Contact> contacts;
  private List<Amenity> amenities;
  private List<Award> awards;
}
