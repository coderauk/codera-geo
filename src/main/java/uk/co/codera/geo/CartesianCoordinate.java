package uk.co.codera.geo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CartesianCoordinate {

    private final int eastings;
    private final int northings;

    private CartesianCoordinate(Builder builder) {
        this.eastings = builder.eastings;
        this.northings = builder.northings;
    }

    public static Builder aCartesianCoordinate() {
        return new Builder();
    }

    public int getEastings() {
        return this.eastings;
    }

    public int getNorthings() {
        return this.northings;
    }

    public Distance straightLineDistanceBetween(CartesianCoordinate otherCoordinate) {
        BigDecimal distance = BigDecimal.valueOf(calculateDistanceUsingPythagoras(otherCoordinate));
        return Distance.of(distance.setScale(0, RoundingMode.HALF_UP));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    private double calculateDistanceUsingPythagoras(CartesianCoordinate otherCoordinate) {
        return Math.sqrt((double) calculateLengthAndSquare(this.eastings, otherCoordinate.eastings)
                + (double) calculateLengthAndSquare(this.northings, otherCoordinate.northings));
    }

    private int calculateLengthAndSquare(int a, int b) {
        return (b - a) * (b - a);
    }

    public static class Builder {

        private int eastings;
        private int northings;

        private Builder() {
            super();
        }

        public Builder eastings(int eastings) {
            this.eastings = eastings;
            return this;
        }

        public Builder northings(int northings) {
            this.northings = northings;
            return this;
        }

        public CartesianCoordinate build() {
            return new CartesianCoordinate(this);
        }
    }
}