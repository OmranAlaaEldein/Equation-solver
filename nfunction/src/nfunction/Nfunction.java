package nfunction;
import java.util.Scanner;

public class Nfunction {
public static void soul(float arr_soul[])
{
    Nfunction one=new Nfunction(arr_soul,arr_soul.length);
    if(arr_soul.length==2)
    {s1.append("derg(1) type"
            + "the soulation is -a0/a1");
    (one.soul1()).print();
    }else if(arr_soul.length==3)
    {s2.append("derg(2) type"
            + "1-find delta=(B)^(2)-4AC"
            + "2-if delta>0  X1=(-B+sqrt(delta))/2A,X2=(-B-sqrt(delta))/2A"
            + "3-if deelta==0  X1,2=-B/2A ."
            + "4-if deelta<0 there are not real soulation .");
    
    (one.soul2()).print();
    }else if(arr_soul.length==4)
    {s3.append("derg(3) type"
            + "1-change equation(Y^(3)+aY^(2)+bY+c) to standard like(X^(3)+pX+q) y:x-a/3"
            + "2-find delte = q^(4)/4+p^(3)/27  and A=power(-q/2+sqrt((delta),0.33))  and  b=power(-q/2-sqrt((delta),0.33))"
            + "3-if delta>0  A+B"
            + "3-if deelta==0  X1=2A,X2=X3=-A ."
            + "4-if deelta<0 Xk=2(sqrt(-p/3)cos(o+2*3.14*k/3)) (k=0,1,2),(o=cos^(-1)(q/pow(-p/3),1.5)).");
    
       (one.soul3()).print();
    }else   {s.append("to all derg we use bezo type"
            + "if a0!=0:"
            + "1-we find factors to a0."
            + "2-we find factors to an."
            + "3-we test all value(devied all factors of an by all factors of a0 )by divied on (x-a) and we use horner table "
            + "if the abider=0 the value is root."
            + "if a0==0: zero is root to the equation "
            + "to find rest root we find root to same equation after dieved on X..");
   Float work[]=((one.soultion_a0n()));
         System.out.println("the soulation : [");
       for(int i=0;i<work.length;i++)
       {
           if(work[i]!=null) System.out.println(work[i]);
       }
       
           System.out.println("]");
    }
    System.out.println("\nthe soul:");
    
}
public static void main_dieved(float soul_A[],float soul_B[])
{
    s4.append("dived on function "
           + "1-we dived the limit bigest on the limit bigest on second equation "
           + "2-we mult the product by the second equation "
           + "3-then we minus the product from the main equation"
           + "4-we rework the operation until we cant dieved limite bigest from main equation on second from main equation");
    
    Nfunction one=new Nfunction(soul_A,soul_A.length);
    Nfunction tow=new Nfunction(soul_B,soul_B.length);
    if(soul_A.length<soul_B.length)
        System.out.println("error A<B");
    else (one.devied(tow.function)).print2();
    
}
public static void oper_soul(float arr_b[],float arr_a[])
{
    Nfunction a=new Nfunction(arr_a,arr_a.length);
    System.out.println("enter the op");
    String op=(new Scanner(System.in)).next();
    ((a).operation(new Nfunction(arr_b,arr_b.length),op)).print();
}

   public static void main(String[] args) {
    
   }
   
   int n;
   float function[];       //
   float soultion[];
   static StringBuffer s=new StringBuffer(" "); 
   static StringBuffer s1=new StringBuffer(" "); 
   static StringBuffer s2=new StringBuffer(" "); 
   static StringBuffer s3=new StringBuffer(" "); 
   static StringBuffer s4=new StringBuffer(" "); 
   Scanner in=new Scanner(System.in);
   ///////////////////////////////////
   Nfunction()
   {
       System.out.print("enter n: ");
       
       n=in.nextInt();
       function=new float[n];//soultion=new float[n-1];
       
       for(int i=0;i<n;i++)
       {System.out.print("\nenter a"+i+" : ");
           function[i]=in.nextFloat();
       if(function[i]==0&&i==n-1){
           System.out.print("\nerror renter : ");i=i-1;}}
    }
   Nfunction(float function[],int n)
   {
       this.function=function;
       this.n=n;
   }
   ////////////////////////////////////
   public void print()
   {
       for(int i=0;i<n;i++)
       {
           if(i!=0)
               System.out.print("+");
           System.out.print(function[i]+"^("+i+")");
       }
   }
   public void print2()
   {
           System.out.println("the soulation : [");
       for(int i=0;i<n;i++)
       {
           System.out.println(function[i]);
       }
       
           System.out.println("]");
   }
   ///////////////////////////////////
   public boolean equals(Nfunction tow)
   {
       for(int i=0;i<n;i++)
          if(this.function[i]!=tow.function[i])
               return false;
       return true;
   }
   public Nfunction soul2()
   {   float soul[]=new float[2]; 
       double d=Math.pow(this.function[1],2)-2*this.function[2]*this.function[0];
       if(d>=0)
       {
           //float soul[]=new float[2]; 
           soul[0]=(float)((-1*this.function[1])+Math.sqrt(d))/(2*this.function[2]);
           System.out.print(this.function[0]+"  "+this.function[1]+"  "+this.function[2]+"  "+d );
           soul[1]=(float)((-1*this.function[1])-Math.sqrt(d))/(2*this.function[2]);
           //return new Nfunction(soul, 2);
       }/*else if(d>0)
       {
           float soul[][]=new float[2][2]; 
           soul[0][0]=(float)(-1*this.function[1])/2*this.function[2];
           soul[1][0]=(float)(-1*this.function[1])/2*this.function[2];
           soul[0][1]=(float)(Math.sqrt(d))/2*this.function[2];
           soul[1][1]=(float)(-1*Math.sqrt(d))/2*this.function[2];
           return new Nfunction(soul, 2);
       }*/
       System.out.println("there are not real soul");
       return new Nfunction(soul, 2);
   }
   public Nfunction soul1()
   {
       float soul[]={-this.function[0]/this.function[1]}; 
       return new Nfunction(soul, 1);
   }
   public Nfunction soul3()
   {
       double a=this.function[2]/this.function[3],b=this.function[1]/this.function[3],c=this.function[0]/this.function[3];
       double p=(-5*(Math.pow(a, 2)/9))+b;
       double q=(4*(Math.pow(a, 3)/27))-((b*a)/3)+c;
       double d=Math.pow(q, 2)/4+Math.pow(p, 3)/27;
       double aw=Math.pow((-q/2)+Math.sqrt(d),0.33333);
       double bw=Math.pow((-q/2)-Math.sqrt(d),0.33333);
       if(d==0)
       {
           float soul[]={2*(float)a-((float)a/3),-1*(float)a-((float)a/3),-1*(float)a-((float)a/3)}; 
       return new Nfunction(soul, 3);
       }else if(d>0)
       {float soul[]={(float)a+(float)b-((float)a/3)}; 
       return new Nfunction(soul, 1);
       }else
       {float soul[]={(float)(2*(Math.sqrt(-(p/3))*Math.cos( Math.acos(q/( Math.pow((-p)/3, 1.5)))/3)))-((float)a/3),(float)(2*(Math.sqrt(-(p/3))*Math.cos(( Math.acos(q/( Math.pow((-p)/3, 1.5)))+3.14)/3)))-((float)a/3),(float)(2*(Math.sqrt(-(p/3))*Math.cos(( Math.acos(q/( Math.pow((-p)/3, 1.5)))+2*3.14)/3)))-((float)a/3)}; 
       return new Nfunction(soul, 3);
       } 
   }
   public Nfunction operation(Nfunction tow,String oper)
   {
       int n_oper;
       if(this.n>tow.n)
           n_oper=this.n;
       else
           n_oper=tow.n;
       
       float soultion_oper[]=new float[n_oper];
       
       for(int i=0;i<n_oper;i++)
       { if(i<this.n&&i<tow.n&&"+".equals(oper))
                soultion_oper[i]=tow.function[i]+this.function[i];
         else   if(i<this.n&&i<tow.n&&"-".equals(oper))
                   soultion_oper[i]=tow.function[i]-this.function[i];
         else  if(n_oper==this.n)   
             soultion_oper[i]=this.function[i];
         else if("+".equals(oper))
             soultion_oper[i]=tow.function[i];
         else soultion_oper[i]=-tow.function[i];
        }
       return new Nfunction(soultion_oper,n_oper);
       
   }
   //////////////////////////////////////////////
   public Nfunction product(Nfunction tow)
   {
       int n_oper=this.n+tow.n;
       float soultion_product[]=new float[n_oper];
       for(int i=0;i<n_oper;i++)
           soultion_product[i]=0;
       
       for(int i=0;i<this.n;i++)
           for(int j=0;j<tow.n;j++)
           {
             soultion_product[i+j]=soultion_product[i+j]+this.function[i]*tow.function[j];  
           }
       return new Nfunction(soultion_product,n_oper);
   }
   public Nfunction[] divied_a(float a)
   {
       float soultion_divied_a[]=new float[this.n-1];
       
       soultion_divied_a[this.n-2]=this.function[n-1];
       for(int i=(this.n-3);i>=0;i--)
           soultion_divied_a[i]=(soultion_divied_a[i+1]*a)+this.function[i+1];
       
       float soultion_divied_r[]=new float[1];
       soultion_divied_r[0]=(soultion_divied_a[0]*a)+this.function[0];
       
       Nfunction[] div=new Nfunction[2];
       div[0]=new Nfunction(soultion_divied_a,this.n-1);
       div[1]=new Nfunction(soultion_divied_r,1);
       
       return div;
   }
   //////////////////////////////////////////////
   public  Float[] soultion_a0n()
   {
       Float[] soul=new Float [this.n];
       if(this.function[0]!=0)
       {
              Integer[] fact_0=factors(Math.abs(this.function[0]));
           Integer[] fact_1=factors(Math.abs(this.function[this.n-1]));
           int k=0;
           for(int i=0;i<fact_0.length;i++)
              for(int j=0;j<fact_1.length;j++)
              {if(fact_0[i]!=null&&fact_1[j]!=null&&divied_a(fact_1[j]/fact_0[i])[1].function[0]==0&&sure(fact_1[j]/fact_0[i],k,soul))
                      {soul[k]=(float)fact_1[j]/fact_0[i];k++;}
              }
           while(k!=n)
           {soul[k]=null;k++;}    }
       else
       {
           float func[]=reenter(this.function,n);
           soul=(new Nfunction(func,this.n-1)).soultion_a0n();
           for(int i=0;i<n-1;i++)
           {
               if(soul[i]==null)
               {soul[i]=new Float(0);break;}
           }}
        return soul;
   }
   ///////////////////////////////////////////
   float[] reenter(float func[],int n)
   {float soul[]=new float[n-1];
       for(int i=0;i<n-1;i++)
       {
           soul[i]=func[i+1];
       }return soul;
   }
   boolean sure(float value,int n,Float soul[])
   {
       for(int j=0;j<n;j++)
       {
           if((float)value==(float)soul[j])
               return false;
       }
       return true;
   }
   public static Integer[] factors(float x)
   {
       int k=(int)x+3;
       Integer[] soul=new Integer[k];
       int j=0;
       for(int i=0;i<k-3;i++)
       {if((x%i)==0)
           {soul[j]=i;j=j+1;soul[j]=-i;j=j+1;}}
       
       soul[j]=(int)x;j=j+1;soul[j]=-(int)x;j=j+1;
       while(j!=k)
         {soul[j]=null;j++;}
       return soul;
       
   }
   public  Nfunction devied(float[] devied_on)
   {
       int k=devied_on.length-1;
       float soul[]=new float[n-k];
       for(int i=n-1;i>=0;i--)
       {
           int l=i-(devied_on.length-1);
           if(l>=0)
           {
               soul[l]=this.function[i]/devied_on[k];
               int k2=k;
               while(k2>-1)
               {
                   this.function[l+k2]=this.function[l+k2]-soul[l]*devied_on[k2];
                   k2=k2-1;
               }
           }
           else
           {
               System.out.println("the rest : ");
               for(int j=0;j<=i;j++)
               {   if(j!=0)
                       System.out.print("+");
                   System.out.print(this.function[j]+"x^("+j+")");
       
               }
               return new Nfunction(soul,soul.length);
           }
       }return new Nfunction(soul,soul.length);
   }
}
