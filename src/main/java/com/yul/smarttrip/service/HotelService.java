package com.yul.smarttrip.service;

import com.yul.smarttrip.domain.Hotel;
import com.yul.smarttrip.domain.HotelInfo;
import com.yul.smarttrip.domain.params.HotelParam;

import java.util.List;

public interface HotelService {
  List<HotelInfo> getHotelInfo(HotelParam param);
}
