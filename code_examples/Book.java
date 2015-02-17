public class Book extends ReadingMatter
{
    String author;
    String[] chapterTitles;

    public Book(String ti, String au, int numChapters, int pc)
    {
        super(ti, pc);
        author = au;
        chapterTitles = new String[numChapters];
        for (int i = 0; i < numChapters; i++)
            chapterTitles[i] = "not yet known";
    }

    public void addChapter(int cn, String ti)
    {
        if (cn <= chapterTitles.length)
            chapterTitles[cn - 1] = ti;
    }

    public String printableContents()
    {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < chapterTitles.length; i++)
            s.append("Chapter " + (i + 1) + " " + chapterTitles[i] + "\n");
        return s.toString();
    }

    public String toString()
    {
        return title + " by " + author + " (" + chapterTitles.length
                + " chapters, " + pageCount + " pages).";
    }

}
