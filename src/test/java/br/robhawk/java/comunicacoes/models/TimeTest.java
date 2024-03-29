package br.robhawk.java.comunicacoes.models;

import org.junit.Test;

import br.robhawk.java.comunicacoes.models.Time;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class TimeTest {
    
    @Test
    public void testDefaultTimezone() throws Exception {
        final Time time = new Time();
        assertEquals(TimeZone.getDefault().getDisplayName(), time.getTimezone());
    }

    @Test
    public void testSpecifiedTimezone() throws Exception {
        final TimeZone est = TimeZone.getTimeZone("EST");
        final Time time = new Time(est);
        assertEquals(est.getDisplayName(), time.getTimezone());
    }
}
