package Persistence;

import Model.Bitmap;
import Model.Image;

public class ProxyImage extends Image {
    private Image image;
    private final ImageLoader imageLoader;

    public ProxyImage(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public Bitmap getBitmap() {
        checkImageLoader();
        return image.getBitmap();
    }

    private void checkImageLoader() {
        if(image!=null) return;
        image=imageLoader.load();
    }
}