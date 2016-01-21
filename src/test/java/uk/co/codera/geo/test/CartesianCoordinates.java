package uk.co.codera.geo.test;

import static uk.co.codera.geo.CartesianCoordinate.aCartesianCoordinate;

import uk.co.codera.geo.CartesianCoordinate;
import uk.co.codera.geo.CartesianCoordinate.Builder;

public class CartesianCoordinates {

	private CartesianCoordinates() {
		super();
	}

	public static Builder lunchCoordinate() {
		return aCartesianCoordinate().eastings(430369).northings(432592);
	}

	public static Builder workCoordinate() {
		return aCartesianCoordinate().eastings(429919).northings(432366);
	}
	
	public static Builder trainStationCoordinate() {
		return aCartesianCoordinate().eastings(430062).northings(433338);
	}
	
	public static Builder appleStoreCoordinate() {
		return aCartesianCoordinate().eastings(430113).northings(433485);
	}

	public static CartesianCoordinate.Builder aValidCartesianCoordinate() {
		return workCoordinate();
	}
}