package com.yul.smarttrip.controller;

import com.yul.smarttrip.domain.Flight;
import com.yul.smarttrip.domain.HotelInfo;
import com.yul.smarttrip.domain.params.HotelParam;
import com.yul.smarttrip.domain.trip.Trip;
import com.yul.smarttrip.domain.trip.TripParam;
import com.yul.smarttrip.service.HotelService;
import com.yul.smarttrip.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TripController {

  @Autowired
  private TripService tripService;

  @Autowired
  private HotelService hotelService;

  @GetMapping(value = "/getFlightInfo")
  public Flight getFlightInfo() {
    return tripService.getFlightInfo();
  }

  @GetMapping(value = "/getTripInfo")
  public Trip getTripInfo(@RequestParam("origin") String originalCity, @RequestParam("desti") String
      destinationCity, @RequestParam("startDate") String startDate, @RequestParam("days") int days, String options) {
    TripParam tripParam = new TripParam(originalCity, destinationCity, startDate, days, options);
    return tripService.getTripInfo(tripParam);
  }

  @GetMapping(value = "/getHotelInfo")
  public List<HotelInfo> getHotelInfo(@RequestParam("location") String location, @RequestParam("check_in") String
      check_in, @RequestParam("check_out") String check_out, @RequestParam("radius") int radius, @RequestParam("chain")
          String chain, @RequestParam("max_rate") int max_rate, @RequestParam("amenity") String amenity) {
    HotelParam hotelParam = new HotelParam();
    hotelParam.setLocation(location);
    hotelParam.setCheck_in(check_in);
    hotelParam.setCheck_out(check_out);
    hotelParam.setRadius(radius);
    hotelParam.setChain(chain);
    hotelParam.setMax_rate(max_rate);
    hotelParam.setAmenity(amenity);
    return hotelService.getHotelInfo(hotelParam);
  }
}
