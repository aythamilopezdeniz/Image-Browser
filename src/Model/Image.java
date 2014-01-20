package Model;

public abstract class Image {
    private Image nextImage;
    private Image preImage;
    
    public abstract Bitmap getBitmap();
    
    public void setNext(Image image){
        this.nextImage=image;
    }
    
    public void setPrev(Image image){
        this.preImage=image;
    }
    
    public Image getNext(){
        return nextImage;
    }
    
    public Image getPrev(){
        return preImage;
    }
}