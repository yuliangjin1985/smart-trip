package com.yul.smarttrip.domain.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class TripParam implements Serializable {

  private String originalCity;
  private String destinationCity;
  private String startDate;
  private int days;
  private String options;
}
