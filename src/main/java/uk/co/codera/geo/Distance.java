package uk.co.codera.geo;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Distance {

    private final BigDecimal distance;

    private Distance(BigDecimal distance) {
        this.distance = distance;
    }

    public static Distance of(BigDecimal distance) {
        return new Distance(distance);
    }
    
    public static Distance of(String distance) {
        return of(new BigDecimal(distance));
    }

    public BigDecimal getDistance() {
        return this.distance;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.distance.stripTrailingZeros()).toHashCode();
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}