import java.util.*;

/**
 * <code>PhoneMapTest</code> is a test class to demonstrate use of the
 * <code>Map</code> interface and <code>HashMap</code>
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2006-02-16 13:33:00 GMT (jpb)>
 */
public class PhoneMapTest
{

    public static void main(String[] args)
    {
        Map<String, Person> phoneMap = new HashMap<String, Person>();
        phoneMap.put("21836", new Person("Steve", "Renals"));
        phoneMap.put("21821", new Person("Guy", "Brown"));
        phoneMap.put("21908", new Person("Yoshi", "Gotoh"));
        System.out.println(phoneMap);

        // retrieve
        Person p = phoneMap.get("21836");
        System.out.println("21836: " + p);

        // delete
        phoneMap.remove("21908");
        System.out.println(phoneMap);

        // replace
        phoneMap.put("21836", new Person("Stephen", "Renals"));
        System.out.println(phoneMap);

        phoneMap.put("21908", new Person("Yoshi", "Gotoh"));
        System.out.println(phoneMap);

        Set<String> keys = phoneMap.keySet();
        for (Iterator<String> i = keys.iterator(); i.hasNext();)
        {
            String key = i.next();
            System.out.println(key);
            // Do something else with key if you want
        }

        Set<Map.Entry<String, Person>> key_value = phoneMap.entrySet();
        for (Iterator<Map.Entry<String, Person>> i = key_value.iterator(); i
                .hasNext();)
        {
            Map.Entry e = i.next();
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }

}
