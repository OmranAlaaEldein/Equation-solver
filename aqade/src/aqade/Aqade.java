package aqade;
import java.util.Scanner;

public class Aqade {

    public static void soul(float x,float y,float x1,float y1,String op,int n)
    {
        s.append("the main think is i^(2)=-1"
                + "so a+bi  where  a is real department and b is imaginary department"
                + "also (a+bi)==R(cos(o)+i*sin(o))"
                + "and (a+bi)=Re^(o)"
                + "where  cos(o)=a/R , sin(o)=b/r"
                + "1-(a+bi)+(c+di)=(a+c)+i(d+b)"
                + "2-(a+bi)*(c+di)=(a*c+b*d)-i(bc+ad)"
                + "3-z=(a+bi) => mar(Z)=(a-bi)"
                + "4-z1=z2 => a1=a2,b1=b2"
                + "5-z1/z2 => (a+bi)/(c+di)"
                + "6-(Z)^(n)=R(cos(n*o)+i*sin(n*o) )=R*e^(n*o)"
                + "7- sqrt(z)^(n) ==> zi=R*e^((o+2*3.14*i)/n)");
        Aqade work=new Aqade(x,y);
        Aqade work2=new Aqade(x1,y1);
        if("+".equals(op))
            (work.sum(work, work2)).print();
                    else if("-".equals(op))
            (work.min(work, work2)).print();
                    else if("*".equals(op))
            (work.product(work, work2)).print();
                    else if("/".equals(op))
            (work.div(work, work2)).print();
                    else if("pow".equals(op))
            (work.pow(work,n)).print();
        else  if("sqrt".equals(op))
        {Aqade here[]=work.sqrt(work,n);
        for(int i=0;i<here.length;i++)
        {System.out.print("the soul "+i+" is :\n ");
            here[i].print();
        }}
    }
    public static void main(String[] args) {
    Aqade a=new Aqade();
    a.print();
    Aqade b=new Aqade();
    b.print();
    (a.div(a, b)).print();
    (a.pow(a, 2)).print();
    a.sqrt(a, 4);
    (a.sum(a, b)).print();
    }
    float x,y,r;
    double o;
    static StringBuffer s=new StringBuffer("HELP::");
    Aqade()
    {
        Scanner in =new Scanner(System.in);
        System.out.print("\nenter x:");
        x=in.nextFloat();
        System.out.print("\nenter y:");
        y=in.nextFloat();
        r=(float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        
        if(x==0&&y<0)
            o=-3.14/2;
        if(x==0&&y>=0)
            o=+3.14/2;
        if(x!=0)
        {o=Math.atan(y/x);
        /*if(x<0&&y<0)
            o=o-3.14;
        if(x<0&&y>=0)
            o=o+3.14;*/}
     }
    Aqade(float x1,float y1)
    {
        x=x1;y=y1;
        r=(float)Math.sqrt(Math.pow(x, 2)+Math.pow(x, 2));
        
        if(x==0&&y<0)
            o=-3.14/2;
        if(x==0&&y>=0)
            o=+3.14/2;
        if(x!=0)
        {o=Math.atan(y/x);
        /*if(x<0&&y<0)
            o=o-3.14;
        if(x<0&&y>=0)
            o=o+3.14;*/}
     
    }
    public void print()
    {
        System.out.print("\nX = "+x+"  Y = "+y+"  R = "+r+"\nO = "+o+"  .\n"+x+" + ("+y+")I .");
    }
    public Aqade product(Aqade a,Aqade b)
    {
        return new Aqade(a.x*b.x-a.y*b.y,a.x*b.y-a.y*b.x);
    }
    public Aqade sum(Aqade a,Aqade b)
    {
        return new Aqade(a.x+b.x,b.y+a.y);
    }
    public Aqade min(Aqade a,Aqade b)
    {
        return new Aqade(a.x-b.x,b.y-a.y);
    }
    public boolean equal(Aqade a,Aqade b)
    {
        return ((a.x==b.x)&&(b.y==a.y));
    }
    public Aqade mrafeq(Aqade a)
    {
        return new Aqade(a.x,-(a.y));
    }
    public Aqade div(Aqade a,Aqade b)
    {
        return new Aqade((float)((a.x*b.x+a.y*b.y)/(Math.pow(a.x,2)*Math.pow(a.y,2))),(float)((b.x*a.y-a.x*b.y)/(Math.pow(a.x,2)*Math.pow(a.y,2))));
    }
    public Aqade pow(Aqade a,int n)
    {
        if(n==0)
            return new Aqade(1,0);
        else
            if(n>0)
               return new Aqade((float)Math.cos(n*a.o),(float)Math.sin(n*a.o));
            else
               return this.div(new Aqade(1,0),this.pow(a,n));
    }
    public Aqade[] sqrt(Aqade a,int n)
    {
        Aqade[] work=new Aqade[n];
        for(int i=0;i<n;i++)
        {
            work[i]=new Aqade ((float)Math.cos((a.o+(2*3.14*i))/n),(float)Math.sin((a.o+(2*3.14*i))/n));
        }
        return work;
    }
    }
 
