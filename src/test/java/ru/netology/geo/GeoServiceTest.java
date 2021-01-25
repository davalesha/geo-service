package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GeoServiceTest {
   private final String MOSCOW_IP = "172.0.32.11";
   private final String NEW_YORK_IP = "96.44.183.149";
   private final Location ACTUAL_USA = new Location("New York", Country.USA, " 10th Avenue", 32);
   private final Location ACTUAL_RUSSIA = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
   private final GeoService geoService = new GeoServiceImpl();
    @Test
    public void testByIpRuSuccess(){
        //when
        Location expected = geoService.byIp(MOSCOW_IP);

        //then
        assertEquals(expected,ACTUAL_RUSSIA);
    }

    @Test
    public void testByIpRuNotSuccess(){
        //when
        Location expected = geoService.byIp(NEW_YORK_IP);

        //then
        assertNotEquals(expected,ACTUAL_RUSSIA);
    }

    @Test
    public void testByIpUSASuccess(){
        //when
        Location expected = geoService.byIp(NEW_YORK_IP);

        //then
        assertEquals(expected,ACTUAL_USA);
    }

    @Test
    public void testByIpUSANotSuccess(){
        //when
        Location expected = geoService.byIp(MOSCOW_IP);

        //then
        assertNotEquals(expected,ACTUAL_USA);
    }
}
