package controller;

import java.io.IOException;

public class Redo implements ICommand{


    @Override
    public void execute()  {
        CommandHistory.redo();
        System.out.println("REDO");
    }
}
