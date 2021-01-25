package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {
    private final LocalizationService LOCALIZATION_SERVICE = new LocalizationServiceImpl();
    private final Country COUNTRY_RUSSIA = Country.RUSSIA;
    private final Country COUNTRY_USA = Country.USA;
    private final String ACTUAL_RUSSIA = "Добро пожаловать";
    private final String ACTUAL_USA = "Welcome";

    @Test
    void testLocaleRussiaSuccess() {
        //when
        String expected = LOCALIZATION_SERVICE.locale(COUNTRY_RUSSIA);

        //then
        Assertions.assertEquals(expected,ACTUAL_RUSSIA);
    }

    @Test
    void testLocaleRussiaNotSuccess() {
        //when
        String expected = LOCALIZATION_SERVICE.locale(COUNTRY_RUSSIA);

        //then
        Assertions.assertNotEquals(expected,ACTUAL_USA);
    }

    @Test
    void testLocalUSASuccess() {
        //when
        String expected = LOCALIZATION_SERVICE.locale(COUNTRY_USA);

        //then
        Assertions.assertEquals(expected,ACTUAL_USA);
    }

    @Test
    void testLocalUSANotSuccess() {
        //when
        String expected = LOCALIZATION_SERVICE.locale(COUNTRY_USA);

        //then
        Assertions.assertNotEquals(expected,ACTUAL_RUSSIA);
    }
}