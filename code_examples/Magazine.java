public class Magazine extends ReadingMatter
{
    int issueNumber;

    public Magazine(String ti, int issue, int pc)
    {
        super(ti, pc);
        issueNumber = issue;
    }

    public String toString()
    {
        return title + " magazine (issue " + issueNumber + ").";
    }

}
