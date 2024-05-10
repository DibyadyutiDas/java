public class pattern5 {
    public static void main(String[] args)
    {
        int i,j,n=5,p=1;
        for ( i = 1; i <= n; i++)
        {
            for ( j = 1; j <= n-i; j++)
            {
                System.out.print(" ");
            }
            for ( j = 1; j <= p; j++) // *odd number of stars in every line like 1,3,5,7...
            {
                System.out.print("*");
            }
            p = p+2;
            System.out.print("\n");
        }
    }
}