package uk.co.codera.geo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class DistanceTest {

    @Test
    public void shouldReturnUnderlyingDitanceCorrectly() {
        BigDecimal underlyingDistance = new BigDecimal("27.4");
        assertThat(Distance.of(underlyingDistance).getDistance(), is(underlyingDistance));
    }
    
    @Test
    public void shouldEqualSameInstace() {
        Distance distance = Distance.of("24.3");
        assertThat(distance, equalTo(distance));
    }
    
    @Test
    public void shouldEqualSameDistance() {
        assertThat(Distance.of("34.4"), equalTo(Distance.of("34.4")));
    }
    
    @Test
    public void sameDistanceShouldHaveSameHashCode() {
        assertThat(Distance.of("34.4").hashCode(), equalTo(Distance.of("34.4").hashCode()));
    }
    
    @Test
    public void shouldEqualSameDistanceToDifferentDecimalPlaces() {
        assertThat(Distance.of("34.4"), equalTo(Distance.of("34.40")));
    }
    
    @Test
    public void sameDistanceToDifferentDecimalPlacesShouldHaveSameHashCode() {
        assertThat(Distance.of("34.4").hashCode(), equalTo(Distance.of("34.40").hashCode()));
    }
    
    @Test
    public void shouldNotEqualNull() {
        assertThat(Distance.of("34.4"), not(equalTo(nullValue())));
    }
    
    @Test
    public void shouldNotEqualNoneDistanceInstance() {
        assertThat(Distance.of("34.4"), not(equalTo(new Object())));
    }
    
    @Test
    public void shouldNotEqualDifferentDistance() {
        assertThat(Distance.of("34.4"), not(equalTo(Distance.of("34.5"))));
    }
    
    @Test
    public void differentDistanceShouldHaveDifferentHashCode() {
        assertThat(Distance.of("34.4").hashCode(), not(equalTo(Distance.of("34.5").hashCode())));
    }
    
    @Test
    public void toStringShouldReportDistance() {
        assertThat(Distance.of("21.2").toString(), containsString("distance=21.2"));
    }
}