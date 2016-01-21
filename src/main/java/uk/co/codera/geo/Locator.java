package uk.co.codera.geo;

import java.util.List;
import java.util.stream.Collectors;

public class Locator {

	public Locator() {
		super();
	}

	public <L extends Locatable> List<L> findWithinStraightLineDistance(List<L> destinations,
			CartesianCoordinate currentLocation, Distance distance) {
		return destinations.stream().filter(
				d -> d.getLocation().straightLineDistanceBetween(currentLocation).getDistance().compareTo(distance.getDistance()) < 0)
				.collect(Collectors.toList());
	}
}