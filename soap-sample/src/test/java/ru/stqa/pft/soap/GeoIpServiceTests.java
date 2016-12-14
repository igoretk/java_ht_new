package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {
  @Test
  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("82.117.247.43");
    System.out.println(geoIP);

    System.out.println(geoIP.getCountryCode());
    System.out.println(geoIP.getCountryName());

    assertEquals(geoIP.getCountryCode(), "UKR");
  }
}
