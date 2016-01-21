package uk.co.codera.geo.test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static uk.co.codera.geo.test.CartesianCoordinates.appleStoreCoordinate;
import static uk.co.codera.geo.test.CartesianCoordinates.lunchCoordinate;
import static uk.co.codera.geo.test.CartesianCoordinates.trainStationCoordinate;
import static uk.co.codera.geo.test.CartesianCoordinates.workCoordinate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

import uk.co.codera.geo.CartesianCoordinate;
import uk.co.codera.geo.Distance;
import uk.co.codera.geo.Locatable;
import uk.co.codera.geo.Locator;

public class LocatorTest {

	// work -> apple store = 1136m
	// work -> train station = 982m
	// work -> lunch = 504m

	private Location appleStore;
	private Location trainStation;
	private Location lunch;

	private Locator locator;

	@Before
	public void before() {
		this.locator = new Locator();
		this.appleStore = location(appleStoreCoordinate());
		this.trainStation = location(trainStationCoordinate());
		this.lunch = location(lunchCoordinate());
	}

	@Test
	public void shouldFindLocationsWithinSpecifiedDistance() {
		assertThat(findLocationsFromWorkWithin(oneKilometre()), contains(this.trainStation, this.lunch));
	}

	private List<Location> findLocationsFromWorkWithin(Distance distance) {
		return this.locator.findWithinStraightLineDistance(destinationsFromWork(), workCoordinate().build(), distance);
	}

	private List<Location> destinationsFromWork() {
		return locations(this.appleStore, this.trainStation, this.lunch);
	}

	private List<Location> locations(Location... locations) {
		return Arrays.asList(locations);
	}

	private Location location(CartesianCoordinate.Builder coordinate) {
		return new Location(coordinate.build());
	}
	
	private Distance oneKilometre() {
		return Distance.of(new BigDecimal("1000"));
	}

	private static class Location implements Locatable {

		private final CartesianCoordinate coordinate;

		private Location(CartesianCoordinate coordinate) {
			this.coordinate = coordinate;
		}

		@Override
		public CartesianCoordinate getLocation() {
			return this.coordinate;
		}
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
}