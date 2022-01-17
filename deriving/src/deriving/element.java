package deriving;
import java.util.Scanner;

public class  element {
    element value=null;
    Scanner in=new Scanner(System.in);
    element()
    {
        
    }
    public void print()
    {
        
    }
    public element[] deriv()
    {
        element []work=new element[2];
        return work;
    }
    public element deriv_e()
    {
         return new exponent();
    }
    public static element[] product(element a,element b)
    {
        element work[]=null;
        float one=1;
        if(a instanceof exponent&&b instanceof exponent)
        {
            if(  (((exponent)a).value==null&&((exponent)b).value==null) || ((((exponent)a).value!=null&&((exponent)b).value!=null)&&((exponent)a).value.equals2(((exponent)b).value)))
            {
                work=new element[2];
                work[0]=new exponent(((exponent)a).number*((exponent)b).number,((exponent)a).s+((exponent)b).s,((exponent)a).value);
                work[1]=null;
                        }
            else
            {
                work=new element[2];
                work[0]=new exponent(((exponent)a).number*((exponent)b).number,((exponent)a).s,((exponent)a).value);
                work[1]=new exponent(one,((exponent)b).s,((exponent)b).value);
                }
        }
        else
        {
            if(a instanceof triangle&&b instanceof triangle)
            { if(  (((exponent)a).value==null&&((exponent)b).value==null)||((((exponent)a).value!=null&&((exponent)b).value!=null)&&((triangle)a).value.equals2(((triangle)b).value)))
            {
                float tow=2;
                work=new element[2];
                work[0]=new exponent(one,tow,new triangle(((triangle)a).name,((triangle)a).value));
                work[1]=null;
            }
            else
            {
                work=new element[2];
                work[0]=a;
                work[1]=b;
                }}
            else
            {
                if((a instanceof triangle&&b instanceof exponent)||(b instanceof triangle&&a instanceof exponent))
                {
                work=new element[2];
                work[0]=a;
                work[1]=b;
                
        }}
    return work; }

public boolean equals2(element b)
{
    if(this==null&&b==null)
            return true;
    else
        if(this!=null&&b!=null)
          {if(b instanceof exponent)
              { if(((exponent)b).number==((exponent)this).number&&((exponent)this).s==((exponent)b).s&&((exponent)this).value.equals(((exponent)b).value))
                         return true;
               }
            else
              {  if(((triangle)b).name==((triangle)this).name&&((triangle)this).value.equals(((triangle)b).value))
                         return true;
               }}
    return false;
}

}
