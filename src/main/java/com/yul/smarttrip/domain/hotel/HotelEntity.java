package com.yul.smarttrip.domain.hotel;

import com.yul.smarttrip.domain.HotelInfo;

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
public class HotelEntity implements Serializable {
  private List<HotelInfo> results;
}
