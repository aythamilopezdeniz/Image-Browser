package Control;

import UserInterface.ImageViewer;

public class PrevImageCommand extends ImageCommand {

    public PrevImageCommand(ImageViewer imageViewer) {
        super(imageViewer);
    }
    
    @Override
    public void execute(){
        this.getImageViewer().showPrevImage();
    }
}