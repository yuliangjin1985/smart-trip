package com.yul.smarttrip.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class FlightInfo implements Serializable {

  private String destination;
  private Date departure_date;
  private Date return_date;
  private String price;
  private String airline;
}
