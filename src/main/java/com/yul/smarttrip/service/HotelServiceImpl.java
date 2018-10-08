package com.yul.smarttrip.service;

import com.google.common.collect.Lists;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yul.smarttrip.domain.HotelInfo;
import com.yul.smarttrip.domain.hotel.HotelEntity;
import com.yul.smarttrip.domain.params.HotelParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper objectMapper;



  public static final String BASE_URL = "https://api.sandbox.amadeus" +
      ".com/v1.2/hotels/search-airport?apikey=QoPqt524NgWqUG198EIhSfwG5Iv8bQoz";
  @Override
  public List<HotelInfo> getHotelInfo(HotelParam param) {
    ResponseEntity<String> hotelEntity = restTemplate.getForEntity(getRequestUrl(param), String.class);
    List<HotelInfo> hotelInfos = null;
    try {
      String body = hotelEntity.getBody();
      HotelEntity entity = objectMapper.readValue(body, HotelEntity.class);
      hotelInfos = entity.getResults();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return hotelInfos;
  }

  private String getRequestUrl(HotelParam param) {
    StringBuilder stringBuilder = new StringBuilder(BASE_URL);
    stringBuilder.append("&location=" + param.getLocation());
    stringBuilder.append("&check_in=" + param.getCheck_in());
    stringBuilder.append("&check_out=" + param.getCheck_out());
    stringBuilder.append("&radius=" + String.valueOf(param.getRadius()));
    stringBuilder.append("&lang=EN&currency=USD");
    stringBuilder.append("&chain=" + param.getChain());
    stringBuilder.append("&max_rate=" + param.getMax_rate());
    stringBuilder.append("&number_of_results=20&all_rooms=false&show_sold_out=false");
    stringBuilder.append("&amenity=" + param.getAmenity());
    String url = stringBuilder.toString();
    System.out.println("URL: " + url);
    return url;
  }
}
