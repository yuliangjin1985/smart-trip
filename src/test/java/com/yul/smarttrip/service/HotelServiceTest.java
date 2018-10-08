package com.yul.smarttrip.service;

import com.yul.smarttrip.domain.params.HotelParam;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HotelServiceTest {

  @Test
  public void testHotelServiceUrl() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    String targetUrl = "https://api.sandbox.amadeus.com/v1.2/hotels/search-airport?apikey=QoPqt524NgWqUG198EIhSfwG5Iv8bQoz" +
        "&location=BOS&check_in=2018-12-15&check_out=2018-12-16&radius=5&lang=EN&currency=USD&chain=ES&max_rate=500&number_of_results=20&all_rooms=false&show_sold_out=false&amenity=POOL";


    Method getRequestUrl = HotelServiceImpl.class.getDeclaredMethod("getRequestUrl", HotelParam.class);
    getRequestUrl.setAccessible(true);

    HotelParam hotelParam = new HotelParam();
    hotelParam.setLocation("BOS");
    hotelParam.setCheck_in("2018-12-15");
    hotelParam.setCheck_out("2018-12-16");
    hotelParam.setRadius(5);
    hotelParam.setChain("ES");
    hotelParam.setMax_rate(500);
    hotelParam.setAmenity("POOL");

    HotelService hotelService = new HotelServiceImpl();

    String resultStr = (String) getRequestUrl.invoke(hotelService, hotelParam);
    Assert.assertEquals(targetUrl, resultStr);
  }
}
