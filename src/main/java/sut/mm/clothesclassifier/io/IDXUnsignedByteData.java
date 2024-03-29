package sut.mm.clothesclassifier.io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IDXUnsignedByteData {

    private static int convertToUnsignedByte(byte signed) {
        return 0xff & signed;
    }

    private IDXData base;

    public IDXUnsignedByteData(IDXData base) {
        this.base = base;
    }

    public int[] getAllElements() {
        return getAllElementsStream().toArray();
    }

    public IntStream getAllElementsStream() {
        return Arrays.stream(getAllRawElements())
                .mapToInt(bytes -> convertToUnsignedByte(bytes[0]));
    }

    /**
     * A shortcut method for 1D data to improve the performance
     */
    public int getElement(int i) {
        byte[] raw = getRawElement(i);
        return convertToUnsignedByte(raw[0]);
    }

    /**
     * A shortcut method for 2D data to improve the performance
     */
    public int getElement(int i, int j) {
        byte[] raw = getRawElement(i, j);
        return convertToUnsignedByte(raw[0]);
    }

    public int getElement(int... locations) {
        byte[] raw = getRawElement(locations);
        return convertToUnsignedByte(raw[0]);
    }

    public List<Integer> getDimensions() {
        return base.getDimensions();
    }

    public byte[][] getAllRawElements() {
        return base.getAllRawElements();
    }

    public byte[] getRawElement(int i) {
        return base.getRawElement(i);
    }

    public byte[] getRawElement(int i, int j) {
        return base.getRawElement(i, j);
    }

    public byte[] getRawElement(int... location) {
        return base.getRawElement(location);
    }
}
