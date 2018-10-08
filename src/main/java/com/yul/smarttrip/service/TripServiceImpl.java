package com.yul.smarttrip.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yul.smarttrip.domain.Flight;
import com.yul.smarttrip.domain.FlightInfo;
import com.yul.smarttrip.domain.HotelInfo;
import com.yul.smarttrip.domain.hotel.Amenity;
import com.yul.smarttrip.domain.hotel.Award;
import com.yul.smarttrip.domain.params.HotelParam;
import com.yul.smarttrip.domain.trip.Trip;
import com.yul.smarttrip.domain.trip.TripParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import jdk.nashorn.internal.runtime.JSONFunctions;

@Service
public class TripServiceImpl implements TripService{
  private static final String AMADEUS_KEY = "QoPqt524NgWqUG198EIhSfwG5Iv8bQoz";

  @Autowired
  private RestTemplate template;

  @Autowired
  private HotelService hotelService;

  @Autowired
  private FlightService flightService;

  @Override
  public Flight getFlightInfo() {
    ResponseEntity<String> entity = template.getForEntity("https://api.sandbox.amadeus" +
        ".com/v1.2/flights/inspiration-search?apikey=QoPqt524NgWqUG198EIhSfwG5Iv8bQoz&origin=NYC&destination=DFW" +
        "&departure_date=2018-11-10&duration=5&direct=true&max_price=2000&aggregation_mode=COUNTRY", String.class);
    ObjectMapper objectMapper = new ObjectMapper();
    Flight flight = new Flight();
    try {
      flight = objectMapper.readValue(entity.getBody(), Flight.class);
      System.out.println("Log info: " + flight);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return flight;
  }

  @Override
  public Flight getFlightInfo(TripParam tripParam) {
    return null;
  }

  @Override
  public Trip getTripInfo(TripParam tripParam) {
    Trip trip = getRightTrip(tripParam);
    return trip;
  }

  private Trip getRightTrip(TripParam param) {
    if("Fastest".equalsIgnoreCase(param.getOptions())) {
      return getFastestTrip(param);
    } else if("Cheapest".equalsIgnoreCase(param.getOptions())) {
      return getCheapestTrip(param);
    } else {
      return getMostComfortableTrip(param);
    }
  }

  //Get the highest rated hotel
  private Trip getMostComfortableTrip(TripParam param) {
    HotelParam hotelParam = new HotelParam();
    hotelParam.setRadius(5);
    hotelParam.setCheck_in(param.getStartDate());
    hotelParam.setCheck_out("2018-12-11");
    hotelParam.setLocation(param.getDestinationCity());
    hotelParam.setMax_rate(5000);
    hotelParam.setChain("ES");
    hotelParam.setAmenity("POOL");
    List<HotelInfo> hotelInfos = hotelService.getHotelInfo(hotelParam);
    System.out.println("SIZE: " + hotelInfos.size());
    HotelInfo hotelInfo = getMostComfortableHotel(hotelInfos);
    System.out.println("Hotel Info: " + hotelInfo);
    Trip trip = new Trip();
    trip.setHotelInfo(hotelInfo);
    return trip;
  }

  private HotelInfo getMostComfortableHotel(List<HotelInfo> hotelInfos) {
    int score = 0;
    int max = 0;
    HotelInfo targetHotel = null;
    for (HotelInfo hotelInfo : hotelInfos) {
      score = calculate(hotelInfo);
      if(score > max) {
        targetHotel = hotelInfo;
        max = score;
      }
    }
    return targetHotel;
  }

  //calculate the total numbers of ratings and number of amenities
  private int calculate(HotelInfo hotelInfo) {
    int score = 0;
    List<Amenity> amenities = hotelInfo.getAmenities();

    score += 10 * amenities.size();

    List<Award> awards = hotelInfo.getAwards();
    for (Award award : awards) {
      score += Integer.valueOf(award.getRating());
    }
    return score;
  }


  private Trip getCheapestTrip(TripParam param) {
    return new Trip();
  }

  private Trip getFastestTrip(TripParam param) {
    return new Trip();
  }
}
