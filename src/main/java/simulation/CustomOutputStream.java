package simulation;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * ICP 2027 - Assignment 1
 * Class: CustomOutputStream
 * Date: 4/1/2016
 * 
 * Extends OutputStream.
 * Facilitates writing to JTextArea instead of console.
 * @author EEU436
 */
public class CustomOutputStream extends OutputStream {
    
    JTextArea textArea;
    
    /**
     * Constructor for custom OutputStream.
     * @param textArea the client's textArea
     */
    public CustomOutputStream(JTextArea textArea){
        this.textArea = textArea;
    }
    
    /**
     * Write method overrides OutputStream
     * write method.
     * @param i
     * @throws IOException 
     */
    @Override
    public void write(int i) throws IOException {
        
        textArea.append(String.valueOf((char)i));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
}
