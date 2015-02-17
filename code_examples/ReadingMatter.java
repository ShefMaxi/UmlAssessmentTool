public class ReadingMatter
{
    protected int pageCount;
    protected long serialNumber;
    protected String title;

    public ReadingMatter(String ti, int pc)
    {
        pageCount = pc;
        title = ti;
    }

    public ReadingMatter()
    {
        this("unknown", 0);
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public String toString()
    {
        return "Reading matter entitled: " + title + " (" + pageCount
                + " pages).";
    }

    public static void main(String[] args)
    {
        ReadingMatter rm = new ReadingMatter();
        System.out.println(rm);
    }
}
