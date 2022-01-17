package tow_variable;
import java.util.Scanner;


public class Tow_variable {

    public static void main(String[] args) {
    Tow_variable op=new Tow_variable();
    op.print(Math.abs(op.n));
    }
    
    float a,b;          //the member
    private int n;
    Float soul[][];
    static StringBuffer s=new StringBuffer("HELP:: \n");
    public static void soul(int a,int b,int n)
    {
        s.append("to find function append on theory tow fctor:"
            + "1-from 0 to n derg function we find consensual(n,r)"
            + "2-mult the product by A^(n-r)*B^(n-r)"
            + "3-sum this limit form the function");
    
        Tow_variable work=new Tow_variable(a,b,n);
        work.soul=new Float[3][Math.abs(n)+1];
        if(n<0)              
            work.opaeration(Math.abs(n));
         else if(n==0)              //n ==0 =>  (a+b)=1
                 {
                    work.soul[0][0]=(float)1;
                    work.soul[1][0]=(float)0;
                    work.soul[2][0]=(float)0;
                 }  
         else                          // n>0
                 work.opaeration(n);
        work.print(n);
            
    
    }
    Tow_variable(float a1,float b1,int n1)      //constructer
    {
        a=a1;b=b1;n=n1;
    }
    Tow_variable()      //constructer
    {
        Scanner in=new Scanner(System.in);
        System.out.println("enter the value ax ,by , n :");
        a=in.nextFloat();
        b=in.nextFloat();
        n=in.nextInt();
        soul=new Float[3][Math.abs(n)+1];
        if(n<0)              
            this.opaeration(Math.abs(n));
         else if(n==0)              //n ==0 =>  (a+b)=1
                 {
                    soul[0][0]=(float)1;
                    soul[1][0]=(float)0;
                    soul[2][0]=(float)0;
                 }  
         else                          // n>0
                 this.opaeration(n);
            
    }
    public float consensual(int n,int r)       //consensual
    {
        return   fib(n)/(fib(n-r)*fib(r));
    }
    public float fib(int f)                      //fibonaty
    {
        if(f>1)
            return fib(f-1)*f;
        else
            if(f==1||f==0)
                return 1;
            else 
                return -1;
    }
    
    public void opaeration(int n)              //the main operation
    {
        for(int i=0;i<=n;i++)
        {
            soul[0][i]=consensual(n,i);
            soul[1][i]=(float)n-i;
            soul[2][i]=(float)i;
        }
    }
    
    public void print(int n)                    //out the value
    {
        if(this.n<0)
            System.out.print("1/( ");
        for(int i=0;i<=n;i++)
            {
                if(i!=0)
                    System.out.print("+");
                System.out.print(soul[0][i]+"X^("+soul[1][i]+")Y^("+soul[2][i]+")");
            }
        if(this.n<0)
            System.out.print(" ).");
        
    }
}
