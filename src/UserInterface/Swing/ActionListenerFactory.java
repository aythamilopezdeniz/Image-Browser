package UserInterface.Swing;

import java.awt.event.ActionListener;

public interface ActionListenerFactory {
    public ActionListener CreateAction(String action);
}