import java.util.*;

/**
 * Class <code>AutoPartTest</code> is a toy class for illustrating
 * <code>TreeSet</code> and <code>HashSet</code> using <code>AutoPart</code>.
 * 
 * @author <a href="mailto:sjr@dcs.shef.ac.uk">Steve Renals</a>
 * @version Last modified: <2005-02-16 13:14:38 GMT (jpb)>
 */
public class AutoPartTest
{

    public static void main(String[] args)
    {

        // first store in an unordered hash set
        Set<AutoPart> auto_hset = new HashSet<AutoPart>();
        auto_hset.add(new AutoPart(13));
        auto_hset.add(new AutoPart(109));
        auto_hset.add(new AutoPart(24));
        auto_hset.add(new AutoPart(3));
        auto_hset.add(new AutoPart(33));
        auto_hset.add(new AutoPart(113));
        auto_hset.add(new AutoPart(1));
        auto_hset.add(new AutoPart(71));
        auto_hset.add(new AutoPart(88));
        System.out.println(auto_hset);

        // duplicate add will fail
        auto_hset.add(new AutoPart(1));
        System.out.println(auto_hset);

        // now store in an ordered tree set
        Set<AutoPart> auto_tset = new TreeSet<AutoPart>();
        auto_tset.add(new AutoPart(13));
        auto_tset.add(new AutoPart(109));
        auto_tset.add(new AutoPart(24));
        auto_tset.add(new AutoPart(3));
        auto_tset.add(new AutoPart(33));
        auto_tset.add(new AutoPart(113));
        auto_tset.add(new AutoPart(1));
        auto_tset.add(new AutoPart(71));
        auto_tset.add(new AutoPart(88));
        System.out.println(auto_tset);

        // duplicate add will fail
        auto_tset.add(new AutoPart(1));
        System.out.println(auto_tset);
    }
}
