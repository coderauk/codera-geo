package uk.co.codera.geo;

import java.math.BigDecimal;

public class Distance {

	private final BigDecimal distance;

	private Distance(BigDecimal distance) {
		this.distance = distance;
	}

	public static Distance of(BigDecimal distance) {
		return new Distance(distance);
	}

	public BigDecimal getDistance() {
		return this.distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Distance other = (Distance) obj;
		return this.distance.compareTo(other.distance) == 0;
	}
}