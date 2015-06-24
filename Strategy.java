/**
 * User: Rich
 * Date: 6/23/2015
 * Time: 1:12 PM
 *
 * Strategy Pattern:
 * - A strategy pattern defines a family of algorithms.
 * - Encapsulates each one.
 * - And then makes them interchangeable.
 *
 * In this way we can build loosely coupled applications via polymorphism with the ability to swap out
 * the various algorithms at runtime.
 *
 *
 */
package Strategy;


/**
 *
 * @author Rich
 */
public class Strategy {

    // Encapsulate and make them interchangeable.
    interface Logger {
        public void log(String data);
    }
    
    
    // Define a family of algorithms.
    public static class LogToFile implements Logger {
        
        @Override
        public void log(String data)
        {
            System.out.printf("Log %s to a file.\n",data);
        }
    }
    
    public static class LogToDataBase implements Logger {
        
        @Override
        public void log(String data)
        {
            System.out.printf("Log %s to a database.\n",data);
        }
    }
    
    public static class LogToWebService implements Logger {
        
        @Override
        public void log(String data)
        {
            System.out.printf("Log %s to a web service.\n",data);
        }
    }
    
    static class App {
        public void log(String data)
        {   
            Logger logger = new LogToFile();

            logger.log(data);
        }
        
        public void log(String data, Logger logger)
        {
            if (logger == null)
            {
                this.log(data);
                return;
            }
            logger.log(data);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        App app = new App();
        
        Logger logs[]={new LogToFile(), new LogToDataBase(), new LogToWebService(), null};
        
        for (Logger log : logs)
        {
            app.log("Some DATA", log);
        }
        app.log("Some DATA");
        
    }
    
}
