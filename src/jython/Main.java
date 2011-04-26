/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jython;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author eoestr0
 */
public class Main {
    private static List<IPrinter> printers = new LinkedList<IPrinter>();
    
    private static ScriptEngine pyEngine;
    private static ScriptEngine rbEngine;
    
    private static Invocable pyIEngine;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        /* Get Scripting Engine */
        ScriptEngineManager factory = new ScriptEngineManager();
        pyEngine = factory.getEngineByName("python");
        if (pyEngine == null) {
            throw new RuntimeException("Could not find python Engine");
        }
        pyIEngine = (Invocable) pyEngine;
        
        rbEngine = factory.getEngineByName("ruby");
        if (rbEngine == null) {
            throw new RuntimeException("Could not find ruby Engine");
        }
        loadScripts();
        
        for(int i = 0; i < 10; i++){
            Update();
        }
    }

    private static void loadScripts() throws ScriptException, FileNotFoundException, NoSuchMethodException {
        File dir = new File("scripts");
        
        for(File file : dir.listFiles()){
            InputStream is = new FileInputStream(file); // use for relative to application
            Reader reader = new InputStreamReader(is);

            int index = file.getName().lastIndexOf(".");
            String extension = file.getName().substring(index);
            
            if(extension.equals(".py")){
                pyEngine.eval(reader);
                printers.add((IPrinter) pyIEngine.invokeFunction(file.getName().substring(0, index)));
            }
            else if(extension.equals(".rb")){
                printers.add((IPrinter) rbEngine.eval(reader));
            }
        }
    }
    
    public static void Update(){
        for(IPrinter printer : printers){
            printer.Update();
        }
    }
}
