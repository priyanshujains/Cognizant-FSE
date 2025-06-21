public class Logger {
    // Private static instance of the class
    private static Logger instance;
    
    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Initialize resources here if needed
    }
    
    // Public static method to get the single instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {   // Lock for thread safety
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    // Example method for logging
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

/*
*   My UnderStanding-
*   Singleton Pattern ensures that a class has only one instance and provides a global point of access to it.
*   To make thread safe we introduce the locking in the method getInstance()
*   Locking is expensive, so we check instance == null first to skip locking if already created
*   If two threads enter simultaneously, synchronized block ensures only one creates the instance
*/