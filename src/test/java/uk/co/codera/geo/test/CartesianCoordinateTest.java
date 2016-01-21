package uk.co.codera.geo.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static uk.co.codera.geo.test.CartesianCoordinates.aValidCartesianCoordinate;
import static uk.co.codera.geo.test.CartesianCoordinates.lunchCoordinate;
import static uk.co.codera.geo.test.CartesianCoordinates.workCoordinate;

import java.math.BigDecimal;

import org.junit.Test;

import uk.co.codera.geo.CartesianCoordinate;
import uk.co.codera.geo.Distance;

public class CartesianCoordinateTest {

	@Test
	public void shouldReturnEastingsCorrectly() {
		assertThat(aValidCartesianCoordinate().eastings(452312).build().getEastings(), is(452312));
	}

	@Test
	public void shouldReturnNorthingsCorrectly() {
		assertThat(aValidCartesianCoordinate().northings(132475).build().getNorthings(), is(132475));
	}

	@Test
	public void shouldCalculateStraightlineDistanceBetweenTwoCoordinatesToNearestMetre() {
		assertThat(straightLineDistanceBetween(workCoordinate(), lunchCoordinate()).getDistance(),
				comparesEqualTo(new BigDecimal("504")));
	}

	@Test
	public void shouldCalculateSameDistanceWithPointsReversed() {
		assertThat(straightLineDistanceBetween(workCoordinate(), lunchCoordinate()),
				equalTo(straightLineDistanceBetween(lunchCoordinate(), workCoordinate())));
	}
	
	private Distance straightLineDistanceBetween(CartesianCoordinate.Builder pointA,
			CartesianCoordinate.Builder pointB) {
		return pointA.build().straightLineDistanceBetween(pointB.build());
	}
}