class EnumTest
{
    public static void main(String args[])
    {
        // ResGroup agroup;
        // System.out.println("My group has " + ResGroup.SpandH.getNAcademics()
        // + " academics.")
        // for (ResGroup g: ResGroup.values())
        // System.out.println(g + "has" + g.getNAcademics() + "academics.");
        int[] a = {1, 2, 3};
        for (int x : a)
            System.out.println(x);
    }
}

enum ResGroup
{
    SpandH(7), NLP(6), Graphics(3), VandT(9), ML(3), NRG(2), CompBio(4);
    private int nAcademics;
    ResGroup(int n)
    {
        nAcademics = n;
    }
    int getNAcademics()
    {
        return nAcademics;
    }
}
