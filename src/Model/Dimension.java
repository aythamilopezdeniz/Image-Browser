package Model;

public class Dimension implements Bitmap{
    private final int height;
    private final int width;

    public Dimension(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}