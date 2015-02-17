import java.io.*;

/**
 * <code>ContactDetails</code> class contains email, tel number and office
 * number
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2001-02-02 17:10:53 GMT (sjr)>
 * @see Serializable
 */
public class ContactDetails implements Serializable
{
    public ContactDetails(String e, int tel, int off)
    {
        emailAddress = e;
        telNumber = tel;
        office = off;
    }

    /**
     * Return the email address
     * 
     * @return email address as a string
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * return telephone number
     * 
     * @return telephone number as <code>int</code>
     */
    public int getTelNumber()
    {
        return telNumber;
    }

    /**
     * return office number
     * 
     * @return office number as <code>int</code>
     */
    public int getOffice()
    {
        return office;
    }

    /**
     * Return contact details as a string
     * 
     * @return the string
     */
    public String toString()
    {
        return emailAddress + ":" + telNumber + ":" + office;
    }

    /**
     * Indicate if some other object is equal to this one. Compares email,tel
     * number and office number fields
     * 
     * @param obj
     *            object with shich to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ContactDetails))
            return false;
        ContactDetails c = (ContactDetails) obj;
        return emailAddress.equals(c.emailAddress) && telNumber == c.telNumber
                && office == c.office;
    }

    private String emailAddress;
    private int telNumber;
    private int office;
}
