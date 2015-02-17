class GenMethod {
    static <T, V extends T> boolean isIn(T x, V[] y) {
        for (int i=0; i< y.length; i++)
            if (x.equals(y[i]))
                return true;
        return false;
    }

    public static void main (String args[]) {
        Integer nums[]={1,2,3,4,5};
        if (isIn(2, nums))
            System.out.println("2 is in nums");
        if (isIn((Object)"two", nums))  // Error!
            System.out.println("two is in nums");
    }
}
