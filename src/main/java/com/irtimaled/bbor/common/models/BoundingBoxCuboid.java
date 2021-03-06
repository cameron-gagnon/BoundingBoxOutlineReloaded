package com.irtimaled.bbor.common.models;

import com.irtimaled.bbor.common.BoundingBoxType;

public class BoundingBoxCuboid extends AbstractBoundingBox {
    private final Coords minCoords;
    private final Coords maxCoords;

    protected BoundingBoxCuboid(Coords minCoords, Coords maxCoords, BoundingBoxType type) {
        super(type);
        this.minCoords = minCoords;
        this.maxCoords = maxCoords;
    }

    public static BoundingBoxCuboid from(Coords minCoords, Coords maxCoords, BoundingBoxType type) {
        return new BoundingBoxCuboid(minCoords, maxCoords, type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + minCoords.hashCode();
        result = prime * result + maxCoords.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BoundingBoxCuboid other = (BoundingBoxCuboid) obj;
        return minCoords.equals(other.minCoords) && maxCoords.equals(other.maxCoords);
    }

    @Override
    public String toString() {
        return "(" + minCoords.toString() + "; " + maxCoords.toString() + ")";
    }

    public Coords getMinCoords() {
        return minCoords;
    }

    public Coords getMaxCoords() {
        return maxCoords;
    }

    @Override
    public Boolean intersectsBounds(int minX, int minZ, int maxX, int maxZ) {
        boolean minXWithinBounds = isBetween(minCoords.getX(), minX, maxX);
        boolean maxXWithinBounds = isBetween(maxCoords.getX(), minX, maxX);
        boolean minZWithinBounds = isBetween(minCoords.getZ(), minZ, maxZ);
        boolean maxZWithinBounds = isBetween(maxCoords.getZ(), minZ, maxZ);

        return (minXWithinBounds && minZWithinBounds) ||
                (maxXWithinBounds && maxZWithinBounds) ||
                (minXWithinBounds && maxZWithinBounds) ||
                (maxXWithinBounds && minZWithinBounds);
    }

    private boolean isBetween(int val, int min, int max) {
        return val >= min && val <= max;
    }
}
