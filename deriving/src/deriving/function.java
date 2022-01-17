package deriving;
import java.util.Scanner;

public class function {
    String func_name=" ";
    element func[][];
    element func_der[][];
    Scanner in=new Scanner(System.in);
    int n=1;
    function()
    {
        System.out.println("enter n = ");
        n=in.nextInt();
        int m;
        func=new element[n][10];
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<10;k++)
              func[i][k]=null;
           
            System.out.println("enter m = ");
            m=in.nextInt();
            if(in.nextInt()==1)
                func[i][0]=new exponent();
            else
                func[i][0]=new triangle();
            for(int j=1;j<m;j++)
            {
                if(in.nextInt()==1)
                  func[i][j]=new exponent();
                else 
                  func[i][j]=new triangle();
             }
        func_name=func_name+(")+("+func[i].toString());
        }
        
    }
    function(element func[][],int n)
    {
        this.func=func;
        this.n=n;
    }
    void print()
    {
        //System.out.println(func_name);
        for(int i=0;i<n;i++)
        {if(i!=0)
            System.out.print("+");
        System.out.print("(");
        for(int j=0;j<10;j++)
        { if(func[i][j]==null)
             break;
        else 
            {if(j!=0)
            System.out.print("*");
         System.out.print("(");
        func[i][j].print();
        System.out.print(")");}}
        System.out.print(")");}
    }
    
    public function der_func()
    {
        func_der=new element[n][10];
        for(int i=0;i<n;i++)
        {for(int j=0;j<10;j++)
            func_der[i][j]=null;
        
        if(func[i][1]==null)
        {element work=func[i][0];
         int j=0;
         while(true)
          {if(work!=null)
             {func_der[i][j]=work.deriv_e();
               j++;
             work=work.value;}
             else
                 break;}}
        else 
            {func_der[i]=null;
                int new_lenght=new function(func_der,n).add(der_pro(func[i],this.n),this.n);
            this.n=new_lenght+this.n;}
            }
        return new function(func_der,this.n);
    }
    public element[][] der_pro(element func_pro[],int m)
    {
        element[] work_der=new element[6];
        for(int i=0;i<m;i++)
        {
            if(func_pro[i]!=null)
            {if(func_pro[i] instanceof exponent)
                    work_der[i]=(exponent)func_pro[i].deriv_e();
                else
                    work_der[i]=(triangle)func_pro[i].deriv_e();}
            else {m=i;break;}
        }
        element[][] work=new element[6][6];
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                work[i][j]=null;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<m;j++)
            {
                if(i==j)
                    work[i][j]=work_der[i];
                else
                    work[i][j]=func_pro[i];
            }
        return work;
    }
    
    public int add(element func_add[][],int n_add)
    {
        int j=0;
        for(int i=0;i<n_add;i++)
        {
           if(this.func[i][0]==null)
            {this.func[i]=func_add[j];
                j++;
                break;}
        }
        while(true)
        {
            if(func_add[j]!=null)
            {
                this.func[n_add++]=new element[10];
                this.func[n_add]=func_add[j];
                j++;
            }
            else break;
        }
        
        return j;
    }
}