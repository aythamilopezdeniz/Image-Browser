package Persistence.File;

import Model.Image;
import Persistence.ImageListLoader;
import Persistence.ProxyImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileImageListLoader extends ImageListLoader{
    private final String path;

    public FileImageListLoader(String path) {
        this.path=path;
    }

    @Override
    public List<Image> load() {
        return linkImages(loadImages());
    }

    private List<Image> loadImages() {
        List<Image> list = new ArrayList<>();
        for (String file : new File(path).list()) {
            if(file.contains(".jpg"))
                list.add(new ProxyImage(new FileImageLoader(path+"/"+file)));
        }
        return list;
    }

    private List<Image> linkImages(List<Image> images) {
        for (int i = 0; i < images.size(); i++) {
            Image image=images.get(i);
            image.setNext(images.get(getNextIndex(i, images.size())));
            image.setPrev(images.get(getPrevIndex(i, images.size())));
        }
        return images;
    }

    private int getNextIndex(int i, int size) {
        return (i+1)%size;
    }

    private int getPrevIndex(int i, int size) {
        return (i+size-1)%size;
    }
}