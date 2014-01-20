package Control;

import UserInterface.ImageViewer;

public abstract class ImageCommand extends Command {
    public ImageViewer imageViewer;

    public ImageCommand(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }
}
