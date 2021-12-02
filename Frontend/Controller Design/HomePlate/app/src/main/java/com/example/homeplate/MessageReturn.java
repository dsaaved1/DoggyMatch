package com.example.homeplate;
import com.example.homeplate.DoggyInterface;

/**
 * MessageReturn is an object
 * for storing Return values with
 * an ENUM Type and
 * a String Message (Error or Success Message)
 */
public class MessageReturn {

    // Local Variables
    private String message;
    private DoggyInterface.Status status;

    /**
     * Empty Constructor
     * creates null values for
     * Message and Status
     */
    public MessageReturn()
    {
        message = "";
        status = null;
    }

    /**
     * Create a QUICK Object.
     * Constructor for Return Message with given values.
     * @param message String Message
     * @param status ENUM Status
     */
    public MessageReturn(String message, DoggyInterface.Status status)
    {
        this.message = message;
        this.status = status;
    }

    /**
     * Set the Status
     * @param status ENUM Status
     */
    public void setStatus(DoggyInterface.Status status)
    {
        this.status = status;
    }

    /**
     * Set the Message
     * @param message String Message
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Get Status
     * @return Status (ENUM)
     */
    public DoggyInterface.Status getStatus()
    {
        return status;
    }

    /**
     * Get Message
     * @return Message (String)
     */
    public String getMessage()
    {
        return message;
    }
}
