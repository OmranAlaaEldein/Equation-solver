package deriving;

public class exponent extends element{
    float number;
    float s;
    
    
    exponent()
    {
        System.out.print("enter number : ");
        number=in.nextInt();
        System.out.print("\nenter val : ");
        String now=in.next();
        if(now.equals("1("))
        {value =new exponent();
        }
        else if(now.equals("2("))
        {value =new triangle();
        }
        System.out.print("\nenter S : ");
        s=in.nextInt();}
    exponent(float number,float s,element value)
    {
        this.number=number;
        this.s=s;
        this.value=value;
    }
    
    @Override
    public void print()
     {System.out.print("("+this.number);
        if(value==null)
            System.out.print("*X");
        else
            value.print();
        System.out.print("^("+this.s+"))");} 
    @Override
    public element[] deriv()
    {
        element der[]=new element[2];
        der[0]=this.deriv_e();
        if(value!=null)
            der[1]=this.value.deriv_e();
        else
            der[1]=null;
         return der;
    }
    public element deriv_e()
    {
         return new exponent(number*s,s-1,this.value);
    }
}
