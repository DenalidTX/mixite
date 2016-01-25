package org.codetome.hexameter.core.internal;

import org.codetome.hexameter.core.api.HexagonOrientation;
import org.junit.After;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static junit.framework.Assert.assertEquals;
import static org.codetome.hexameter.core.api.HexagonOrientation.FLAT_TOP;
import static org.codetome.hexameter.core.api.HexagonOrientation.POINTY_TOP;

public class SharedHexagonDataTest {

    private static final HexagonOrientation ORIENTATION = FLAT_TOP;
    private static final double RADIUS = 30;
    SharedHexagonData target;

    @After
    public void tearDown() {
        target = null;
    }

    @Test
    public void shouldProperlyReturnRadiusWhenGetRadiusIsCalled() {
        target = new SharedHexagonData(ORIENTATION, RADIUS);
        assertEquals(RADIUS, target.getRadius());
    }

    @Test
    public void shouldProperlyCalculateWidthWithPointyHexagonsWhenGetWidthIsCalled() {
        target = createWithPointy();
        final double expectedWidth = sqrt(3) * RADIUS;
        final double actualWidth = target.getWidth();
        assertEquals(expectedWidth, actualWidth);
    }

    private SharedHexagonData createWithPointy() {
        return new SharedHexagonData(POINTY_TOP, RADIUS);
    }

    @Test
    public void shouldProperlyCalculateWidthWithFlatHexagonsWhenGetWidthIsCalled() {
        target = createWithFlat();
        final double expectedWidth = RADIUS * 3 / 2;
        final double actualWidth = target.getWidth();
        assertEquals(expectedWidth, actualWidth);
    }

    private SharedHexagonData createWithFlat() {
        return new SharedHexagonData(FLAT_TOP, RADIUS);
    }

    @Test
    public void shouldProperlyCalculateHeightWithPointyHexagonsWhenGetHeightIsCalled() {
        target = createWithPointy();
        final double expectedHeight = RADIUS * 3 / 2;
        final double actualHeight = target.getHeight();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void shouldProperlyCalculateHeightWithFlatHexagonsWhenGetHeightIsCalled() {
        target = createWithFlat();
        final double expectedHeight = sqrt(3) * RADIUS;
        final double actualHeight = target.getHeight();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void shouldReturnProperOrientationWhenGetOrientationIsCalled() {
        target = new SharedHexagonData(ORIENTATION, RADIUS);
        assertEquals(ORIENTATION, target.getOrientation());
    }

    @Test
    public void shouldReturnProperCoordinateOffsetWhengetCoordinateOffsetIsCalled() {
        target = new SharedHexagonData(ORIENTATION, RADIUS);
        assertEquals(ORIENTATION.getCoordinateOffset(), target.getOrientation().getCoordinateOffset());
    }
}
