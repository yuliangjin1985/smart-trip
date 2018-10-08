package com.yul.smarttrip.service;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerImpl;
import com.yul.smarttrip.domain.HotelInfo;
import com.yul.smarttrip.domain.hotel.Amenity;
import com.yul.smarttrip.domain.hotel.Award;
import com.yul.smarttrip.domain.params.HotelParam;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TripServiceTest {

  @Test
  public void testHotelServiceUrl() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method calculate = TripServiceImpl.class.getDeclaredMethod("calculate", HotelInfo.class);
    calculate.setAccessible(true);

    HotelInfo hotelInfo = new HotelInfo();
    ArrayList<Amenity> amenities = new ArrayList<>();
    amenities.add(new Amenity("POOL", 23, ""));
    amenities.add(new Amenity("POOL", 23, ""));
    amenities.add(new Amenity("POOL", 23, ""));
    amenities.add(new Amenity("POOL", 23, ""));
    hotelInfo.setAmenities(amenities);

    List<Award> awards = new ArrayList<>();
    awards.add(new Award("AAA", "5"));
    awards.add(new Award("AAA", "3"));
    awards.add(new Award("AAA", "3"));
    awards.add(new Award("AAA", "6"));
    hotelInfo.setAwards(awards);

    TripServiceImpl tripService = new TripServiceImpl();
    int score = (int) calculate.invoke(tripService, hotelInfo);
    System.out.println(score);
  }
}
