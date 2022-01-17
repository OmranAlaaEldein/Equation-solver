package deriving;


public class triangle extends element{
    
    String name;
    triangle()
    {
        System.out.print("\nenetr Tri : ");
        name=in.nextLine();
        if("cos1".equals(name)||"sin1".equals(name))
        {System.out.print("(");
         value=new exponent();
        System.out.print(")\n");
        }
        else if("cos2".equals(name)||"sin2".equals(name))
        {System.out.print("(");
         value=new triangle();
        System.out.print(")");
        }}
    triangle(String name,element der)
    {
        this.name=name;
        this.value=der;
    }
    @Override
    public void print()
    {
        if(value!=null)
        {System.out.print("("+this.name+"(");
        value.print();
        System.out.print(")");
    }}
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
    @Override
    public element deriv_e()
    {
        if("cos1".equals(this.name))
            this.name="sin1";
        else if("sin1".equals(this.name))
            this.name="cos1";
        else if("sin2".equals(this.name))
            this.name="cos2";
        else if("sin2".equals(this.name))
            this.name="cos2";
        
        return new triangle(this.name,this.value);
    }
    
}
