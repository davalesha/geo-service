package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";

    @Test
    public void testSenderRuSuccess() {
        Country country = Country.RUSSIA;
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(country))
                .thenReturn("Добро пожаловать");

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, MOSCOW_IP);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String actual = messageSender.send(headers);

        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSenderEnSuccess() {
        Country country = Country.USA;
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(country))
                .thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, NEW_YORK_IP);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String actual = messageSender.send(headers);

        String expected = "Welcome";
        Assertions.assertEquals(expected, actual);
    }

}
