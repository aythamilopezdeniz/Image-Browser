package UserInterface.Swing;

import Model.Image;
import UserInterface.ImageViewer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageViewer {
    private int position;
    private int pressedX;

    public ImagePanel() {
        this.position = 0;
        this.hookEvents();
    }

    private Image image;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    private void hookEvents() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                pressedX = me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (position > image.getBitmap().getWidth() / 2) {
                    showPrevImage();
                } else if (position < image.getBitmap().getWidth() / 2) {
                    showNextImage();
                }
                position = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                position=me.getX()-pressedX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        });
    }

    private void showNextImage() {
        image = image.getNext();
        repaint();
    }

    private void showPrevImage() {
        image = image.getPrev();
        repaint();
    }
}
