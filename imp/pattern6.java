public class pattern6 {
    public static void main(String[] args)
    {
        int n=5,p=1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= 1.5*n; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= n-i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= p; j++) // *odd number of stars in every line like 1,3,5,7...
            {
                System.out.print("*");
            }
            p = p+2;
            System.out.print("\n");
        }

        
        for (int i = n;i >= 1;i--)
        {
            for (int j = 1;j <= n-i;j++)
            {
                System.out.print(" ");
            }
            for (int j = 1;j <= i;j++)
            {
                System.out.print("*");
            }
            for (int j = 0; j < 2.5*n; j++)
            {
                System.out.print("*");
            }
            for (int j = 1;j<= i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        

        for (int i = 1;i <= n;i++)
        {
            for (int j = 1;j<= 5-i;j++)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            for (int j = 0; j < 2.5*n; j++)
            {
                System.out.print("*");
            }
            for (int j = 1;j<= i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        p = p-2;
        for (int i = n; i >= 1; i--)
        {
            for (int j = 0; j < 1.4*n; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= n-i; j++)
            {
                System.out.print(" ");
            }
            for (int j = p; j >= 1; j--) // *odd number of stars in every line like 1,3,5,7...
            {
                System.out.print("*");
            }
            p = p-2;
            System.out.print("\n");
        }
    }
}