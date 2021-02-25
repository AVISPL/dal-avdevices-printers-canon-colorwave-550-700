package com.insightsystems.symphony.dal.oce;

import com.avispl.symphony.api.dal.dto.monitor.ExtendedStatistics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ColourWave700Test {
    ColourWave700 printer = new ColourWave700();

    @Before
    public void setup() throws Exception {
        printer.setHost("10.220.96.36");
        printer.setSnmpCommunity("public");
        printer.init();
    }

    @Test
    public void testExtendedProperties() throws Exception {
        Map<String,String> stats = ((ExtendedStatistics)printer.getMultipleStatistics().get(0)).getStatistics();

        Assert.assertEquals("Oce, ColorWave700 R4.1",stats.get("DeviceType"));
        Assert.assertNotEquals("",stats.get("DeviceUptime"));
        Assert.assertEquals("00:03:2d:36:f1:d0",stats.get("DevicePhysicalAddress"));
        Assert.assertEquals("10.220.96.36",stats.get("DeviceIpAddress"));
        Assert.assertEquals("Down",stats.get("StatusDevice"));
        Assert.assertEquals("0",stats.get("StatusDeviceErrorsCount"));
        Assert.assertEquals("Other",stats.get("StatusPrintState"));
        Assert.assertEquals("Low Toner",stats.get("StatusPrinterErrors"));
        Assert.assertEquals("38004 grams",stats.get("TotalTonerUsageCyan"));
        Assert.assertEquals("43793 grams",stats.get("TotalTonerUsageMagenta"));
        Assert.assertEquals("36964 grams",stats.get("TotalTonerUsageYellow"));
        Assert.assertEquals("21074 grams",stats.get("TotalTonerUsageBlack"));
        Assert.assertEquals("29222 m²",stats.get("TotalPrintedArea"));
        Assert.assertEquals("37712 m",stats.get("TotalPrintedLength"));

        Assert.assertEquals("14",stats.get("TonerLevelCyan (%)"));
        Assert.assertEquals("37",stats.get("TonerLevelYellow (%)"));
        Assert.assertEquals("3",stats.get("TonerLevelBlack (%)"));
        Assert.assertEquals("81",stats.get("TonerLevelMagenta (%)"));
        Assert.assertEquals("LFM091 Top Color Paper 120gsm A1 (594 mm)",stats.get("Media Roll 1"));
        Assert.assertEquals("LFM090 Top Color 90gsm A2 (420 mm)",stats.get("Media Roll 2"));
        Assert.assertEquals("LFM-F20S Ultra Satin 200gsm 42 inch",stats.get("Media Roll 3"));
        Assert.assertEquals("LFM091 Top Color Paper 120gsm A0 (841 mm)",stats.get("Media Roll 4"));
        Assert.assertEquals("LFM-F20S Ultra Satin 200gsm 42 inch",stats.get("Media Roll 5"));
        Assert.assertEquals("LFM091 Top Color Paper 120gsm A0 (841 mm)",stats.get("Media Roll 6"));
        Assert.assertEquals("Door Closed",stats.get("Status Front cover"));
        Assert.assertEquals("Door Closed",stats.get("Status Top cover"));
        Assert.assertEquals("Door Closed",stats.get("Status Back cover"));
    }
}
