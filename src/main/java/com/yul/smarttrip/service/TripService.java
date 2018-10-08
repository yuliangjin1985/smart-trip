package com.yul.smarttrip.service;

import com.yul.smarttrip.domain.Flight;
import com.yul.smarttrip.domain.trip.Trip;
import com.yul.smarttrip.domain.trip.TripParam;

public interface TripService {
  Flight getFlightInfo();

  Flight getFlightInfo(TripParam tripParam);

  Trip getTripInfo(TripParam tripParam);
}
