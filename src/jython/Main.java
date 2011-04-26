/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jython;

import java.io.FileNotFoundException;
import javax.script.ScriptException;

/**
 *
 * @author eoestr0
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptManager sm = new ScriptManager();
        
        sm.run();
    }
}
