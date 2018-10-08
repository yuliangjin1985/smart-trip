package com.yul.smarttrip.domain.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class HotelParam implements Serializable {
  private String location;
  private String check_in;
  private String check_out;
  private int radius;
  private String lang;
  private String currency;
  private String chain;
  private int max_rate;
  private String amenity;
}
