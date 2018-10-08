package com.yul.smarttrip.domain.trip;

import com.yul.smarttrip.domain.FlightInfo;
import com.yul.smarttrip.domain.HotelInfo;

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
public class Trip implements Serializable {
  private HotelInfo hotelInfo;
  private FlightInfo flightInfo;
}
