package uk.co.codera.geo;

@FunctionalInterface
public interface Locatable {

    CartesianCoordinate getLocation();
}