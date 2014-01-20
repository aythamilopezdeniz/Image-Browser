package Main;

import Model.Image;
import java.util.List;
import Control.Command;
import java.util.HashMap;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import Persistence.ImageListLoader;
import Persistence.File.FileImageListLoader;
import UserInterface.Swing.ActionListenerFactory;
import UserInterface.Swing.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class Main {
     private static final String path="C:\\Users\\Acer\\Desktop\\NuevaCarpeta";
    private HashMap<String, Command> commandMap;
    private ApplicationFrame frame;

     public static void main(String[] args) {
         Main main=new Main();
         main.execute();
     }

    private void execute() {
        ImageListLoader imageListLoader= createFileImageListLoader(path);
        List<Image> list=imageListLoader.load();
        frame=new ApplicationFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        addCommands();
        frame.setVisible(true);
    }

    private ImageListLoader createFileImageListLoader(String path) {
         return new FileImageListLoader(path);
    }

    private void addCommands() {
        commandMap=new HashMap<>();
        commandMap.put("Next", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewer()));
    }

    private ActionListenerFactory createActionListenerFactory() {
         return new ActionListenerFactory() {

             @Override
             public ActionListener CreateAction(final String action) {
                 return new ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent ea) {
                         Command command=commandMap.get(action);
                         if(command==null)return;
                         command.execute();
                     }
                 };
             }
         };
    }
 }