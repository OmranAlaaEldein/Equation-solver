package project_array;

import java.util.Scanner;

public class PROJECT_ARRAY {

    public static void main(String[] args) {
        solve();
        }
    //////////////////VARIABLE///////////////////
    int lenght;
    int width;
    Float my_array[][] = new Float[lenght][width];
    static StringBuffer s=new StringBuffer(" ");
    static StringBuffer s2=new StringBuffer(" ");
    static StringBuffer s3=new StringBuffer(" ");
    //////////////////////////////////////////////

    PROJECT_ARRAY(int Lenght, int Width, Float[][] My_array) {
        lenght = Lenght;
        width = Width;
        my_array = My_array;
    }

    PROJECT_ARRAY() //the member
    {
        lenght = 0;
        width = 0;
        my_array = null;
    }
    /////////////////////////////////////////////////

    public static PROJECT_ARRAY enter() //enter value
    {
        Scanner in = new Scanner(System.in);
        System.out.print("THE ARRAY::\nenter lenght : ");
        int lenght = in.nextInt();
        System.out.print("enter width : ");
        int width = in.nextInt();

        Float arr[][] = new Float[lenght][width];
        System.out.print("enter value : ");
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("arr[" + i + "][" + j + "]= ");
                arr[i][j] = in.nextFloat();
            }
        }
        return new PROJECT_ARRAY(lenght, width, arr);
    }

    public static PROJECT_ARRAY enter_b(int lenght_b) //enter B
    {
        Scanner in = new Scanner(System.in);
        System.out.println("THE (B) ARRAY::");
        Float arr[][] = new Float[lenght_b][1];
        for (int i = 0; i < lenght_b; i++) {
            System.out.print("arr[" + i + "]= ");
            arr[i][0] = in.nextFloat();
        }
        return new PROJECT_ARRAY(lenght_b, 1, arr);
    }

    public void print() //print this array 
    {
        System.out.println("array information : lenght = " + lenght + " , width = " + width + " . ");
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("array [" + i + "][" + j + "] = " + my_array[i][j]);
            }
        }
    }
    public void print_X() //print this array 
    {
        for (int i = 0; i < lenght; i++) 
            {for (int j = 0; j < width-1; j++) {
                System.out.print(my_array[i][j]+"X(" + j + ")+ ");
            System.out.print(my_array[i][width-1]+"X(" + (width-1) + ")\n");}
            }
    }

    public static PROJECT_ARRAY sum(PROJECT_ARRAY a, PROJECT_ARRAY b) //sum tow array
    {
        if (a.lenght == b.lenght && a.width == b.width) {
            Float c[][] = new Float[a.lenght][a.width];
            System.out.println("THE SUM: ");
            for (int i = 0; i < a.lenght; i++) {
                for (int j = 0; j < a.width; j++) {
                    c[i][j] = a.my_array[i][j] + b.my_array[i][j];
                }
            }
            return new PROJECT_ARRAY(a.lenght, a.width, c);
        } else {
            System.out.println("the array can not sum (the are not like)...");
            return null;
        }
    }

    public static PROJECT_ARRAY product(PROJECT_ARRAY a, PROJECT_ARRAY b) //product tow array.
    {
        Float c[][] = new Float[a.lenght][b.width];
        float num = 0;
        if (a.width == b.lenght) {
            for (int i = 0; i < a.lenght; i++) {
                for (int j = 0; j < b.width; j++) {
                    c[i][j] = num;
                    for (int k = 0; k < b.lenght; k++) {
                        c[i][j] = c[i][j] + (a.my_array[i][k] * b.my_array[k][j]);
                    }
                }
            }
            return new PROJECT_ARRAY(a.lenght, b.width, c);
        } else {
            System.out.println("cant product(second row dont equal first columns)...");
            return null;
        }
    }

    public static PROJECT_ARRAY exponent(PROJECT_ARRAY a, int n) //(A)^(n)
    {
        if (a.square()) {
            if (n > 0) {
                PROJECT_ARRAY b = a;
                for (int i = 0; i < n; i++) {
                    a = product(a, b);
                }
                return a;
            } else if (n == 0) {
                return new PROJECT_ARRAY(a.lenght, a.lenght, a.ones(a.lenght));
            } else {
                PROJECT_ARRAY b = a.invert();
                PROJECT_ARRAY b2 = b;
                for (int i = 0; i < n; i++) {
                    b2 = product(b2, b);
                }
                return b2;
            }
        } else {
            System.out.println("the array is not square...");
            return null;
        }
    }

    public boolean square() //L==W.
    {
        if (this.lenght == this.width) {
            return true;
        } else {
            return false;
        }
    }

    public Float[][] ones(int lenght) //all zero but  the main  one 
    {
        float one = 1, zero = 0;
        Float work[][] = new Float[lenght][lenght];
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                work[i][j] = zero;
            }
            work[i][i] = one;
        }
        return work;
    }

    public float small(PROJECT_ARRAY a, int k) //SMALL member
    {
        Float work[][] = null;

        if (k < a.lenght && k < a.width) {
            Integer rand_r[] = new Integer[k];
            Integer rand_c[] = new Integer[k];
            work = new Float[k][k];
            double n = 0.1, m = 0.1;
            for (int i = 0; i < k; i++) {
                rand_r[i] = (int) (n + (Math.random() * (a.lenght - n)));
            }
            for (int i = 0; i < k; i++) {
                rand_c[i] = (int) (m + (Math.random() * (a.width - m)));
            }

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    work[i][j] = a.my_array[rand_r[i]][rand_c[j]];
                    System.out.println(work[i][j]);
                }
            }
        }
        return this.Det(work, k, 0);
    }
    //////////////////////////////////////////////////////////////
    ////////////////////////X=A^(-1)*B////////////////////////////

    public PROJECT_ARRAY invert() //(A)^(-1)
    {
        if (this.square()) {
            float det = this.Det(this.my_array, this.lenght, 0);
            if (det != 0) {
                Float work[][] = this.T(this.acomp(this.my_array, this.lenght), this.lenght);
                for (int i = 0; i < this.lenght; i++) {
                    for (int j = 0; j < this.width; j++) {
                        work[i][j] = (work[i][j] / det);
                    }
                }
                return new PROJECT_ARRAY(this.lenght, this.width, work);
            } else {
                System.out.print("det is zerooooo....");
                return null;
            }
        } else {
            System.out.print("it is not quare....");
            return null;
        }
    }

    public PROJECT_ARRAY solve_invert(PROJECT_ARRAY b) //X=A^(-1)*B
    {
        PROJECT_ARRAY a = this.invert();
        if(a!=null)
        return product(a, b);
        else return null;
    }
    /////////////////////kramer/////////////////////////////

    public PROJECT_ARRAY solve_kramer(PROJECT_ARRAY b) {
        PROJECT_ARRAY solve_kramer = null;
        if (this.square() && this.lenght == 3) {
            Float[][] c = new Float[this.lenght][this.width];
            solve_kramer = new PROJECT_ARRAY(1, 3, new Float[1][3]);
            float det = this.Det(this.my_array, this.lenght, 0);
            for (int j = 0; j < this.width; j++) {
                for (int n = 0; n < this.lenght; n++) {
                    for (int m = 0; m < this.width; m++) {
                        c[n][m] = this.my_array[n][m];
                    }
                }

                for (int i = 0; i < this.lenght; i++) {
                    c[i][j] = b.my_array[i][0];            //enter B in A
                }

                solve_kramer.my_array[0][j] = (this.Det3(c)) / (det);   //find solve[i]
            }
        } else {
            System.out.println("it is not able to solve by cramer...");
        }
        return solve_kramer;
    }
    //////////////////////GAOTH/////////////////////////////////

    public Float[][] I(Float[][] arr, int l, int w) {
        for (int k = 0; k < w; k++) {
            for (int i = k; i < l; i++) {
                if (arr[i][k] != 0)//??
                {
                    float d = arr[i][k];

                    for (int j = 0; j < w; j++) {
                        arr[i][j] = arr[i][j] / d;
                    }
                    if (i != k) {
                        for (int j = 0; j < w; j++) {
                            arr[i][j] = arr[i][j] - arr[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < l - 1; i++) {
            int value;
            if (i >= w) {
                value = w - 1;
            } else {
                value = i;
            }
            if (arr[i][value] == 0) {
                for (int j = 0; j < w; j++) {
                    float t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;
                }
            }
        }

        return arr;
    }

    public PROJECT_ARRAY vast(PROJECT_ARRAY a, Float b[][]) //[A|B]
    {
        Float work[][] = new Float[a.lenght][a.width + 1];
        for (int i = 0; i < a.lenght; i++) {
            for (int j = 0; j < a.width; j++) {
                work[i][j] = a.my_array[i][j];
            }
        }

        for (int i = 0; i < a.lenght; i++) {
            work[i][a.width] = b[i][0];
        }
        return new PROJECT_ARRAY(a.lenght, a.width + 1, work);
    }

    public boolean able2() //able to solve by raaed
    {
        for (int i = this.lenght - 1; i >= 0; i--) {
            for (int j = 0; j < this.width - 1; j++) {
                if (this.my_array[i][j] != 0) {
                    return true;
                }
            }
            if (this.my_array[i][this.width - 1] != 0) {
                return false;
            }

        }
        return true;
    }
    public Integer[] raaed_place(PROJECT_ARRAY a) //place raaed of evry row
    {
        Integer raaed[] = new Integer[a.lenght + 1];
        for (int i = 0; i < a.lenght; i++)//if is not able to solve??
        {
            raaed[i] = -1;
        }
        raaed[a.lenght] = 0;  //number of raaed 
        for (int i = 0; i < a.lenght; i++) {
            if (a.my_array[i][i] != 0) {
                raaed[i] = i;
                raaed[a.lenght] = raaed[a.lenght] + 1;
            } else {
                for (int k = i; k < a.lenght; k++) {
                    {for (int j = i + 1; j < a.width; j++) {
                    if (a.my_array[k][j] != 0) {
                        raaed[k] = j;
                        raaed[a.lenght] = raaed[a.lenght] + 1;break;
                    }}
                }
            }
        return raaed;}
        
    }
   return raaed;}

    public PROJECT_ARRAY solve_gaoth(PROJECT_ARRAY a, Integer raaed[]) {
        if (a.width - 1 == raaed[a.lenght])//??
        {
            Float solve[] = new Float[a.lenght];
            System.out.println("there is one solve ... . .  .");
            for (int i = a.lenght - 1; i >= 0; i--) {
                solve[i] = solve_x(a.my_array[i], solve, a.width, raaed[i]);
            }
            Float solve2[][] = new Float[1][a.lenght];
            solve2[0] = solve;
            return new PROJECT_ARRAY(1, a.lenght, solve2);
        } else if (a.width - 1> raaed[a.lenght])//??
        {
            System.out.println("there are more solve by n-r variable... . .  .");
            Float solve[][] = new Float[raaed[a.lenght]+1][a.width - raaed[a.lenght]+1];//+const
            /////////////////////////////////////////////////////
            for(int i=0;i<raaed.length-1; i++)
            {if(raaed[i]!=-1) if(raaed[i]!=null)  {solve[i+1][0]=(float)raaed[i];}}
            
            int k=1;
            for(int i=0;i<a.width; i++)
            {   if(notfind(i,raaed)) {solve[0][k]=(float)i;k=k+1;}}
            
            
            ////////////////////////////////////////////////////
            for (int i = raaed[a.lenght] ; i >= 1; i--) {
                {
                    //if(i==raaed[a.lenght])
                    {for (int w = 1 ; w <=a.width - raaed[a.lenght] ; w++) {
                                        int y=solve[0][w].intValue();
                                        if(w==a.width - raaed[a.lenght])
                                        solve[i][w]=a.my_array[i-1][y];
                                        else solve[i][w]=-1*a.my_array[i-1][y];
                                        if(i!=raaed[a.lenght] )
                                        {
                                            for (int op = i+1 ; op <=raaed[a.lenght] ; op++)
                                            {
                                                solve[i][w]=solve[i][w]-a.my_array[i-1][solve[op][0].intValue()]*solve[op][w];
                                                System.out.println(solve[op][0].intValue()+"  "+a.my_array[i-1][solve[op][0].intValue()]);
                                            }
                                        }
                    }
                    }
                } 
            /*for (int i = raaed[a.lenght] - 1; i >= 0; i--) {
                for (int j = (raaed[i]+1), m = 0; j < a.width; j++, m++) {
                    float x = 0;
                    if (j != a.width - 1) {
                        x = -a.my_array[i][j];
                    } else {
                        x = a.my_array[i][j];
                    }
                    for (int k = i + 1; k < raaed[a.lenght]; k++) {
                        x = x - solve[k][m] * a.my_array[i][k];
                    }
                    x = x / a.my_array[i][raaed[i]];
                    solve[i][m] = x;
                }
            }*/
            
        }return new PROJECT_ARRAY(raaed[a.lenght]+1,a.width - raaed[a.lenght]+2, solve);
        }return null;
    }
public boolean notfind(int i,Integer raaed[])
    {
        for(int j=0;j<raaed.length-1;j++)
        {if(raaed[j]==i) return false;}
        return true;
    }
    public Float solve_x(Float[] arr, Float solve[], int w, int raaed) {
        float x = arr[w - 1];
        if (raaed == -1) {
            return new Float(0);
        }
        for (int i = w - 2; i > raaed; i--) {
            x = x - arr[i] * solve[i];
        }
        return (x / arr[raaed]);
    }

    //////////////////////DET////////////////////////////
    public Float[][] acomp(Float c[][], int lenght) //motamemat gabria
    {
        Float work[][] = new Float[lenght][lenght];
        if(lenght==2)
        {
            work[0][0]=c[1][1];work[0][1]=c[1][0];work[1][0]=c[0][1];work[1][1]=c[0][0];
        }else{
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                work[i][j] = this.Det(this.div(c, lenght, i, j), lenght - 1, 1);
            }
        }}
        return work;

    }

    public Float[][] div(Float[][] arr, int l, int m, int n) {     //arrat without i row and j 

        Float new_arr[][] = new Float[l][l];
        int o = 0;
        for (int i = 0; i < l; i++) {
            int p = 0;
            if (i != m) {
                for (int j = 0; j < l; j++) {
                    if (j != n) {
                        new_arr[o][p] = arr[i][j];
                        p++;
                    }
                }
                o++;
            }
        }
        return new_arr;
    }

    public Float Det3(Float[][] arr) //??
    {
        if (arr.length == 3) {
            return ((arr[0][0] * arr[1][1] * arr[2][2]) + (arr[0][1] * arr[1][2] * arr[2][0]) + (arr[0][2] * arr[1][0] * arr[2][1])) - ((arr[0][2] * arr[1][1] * arr[2][0]) + (arr[0][0] * arr[1][2] * arr[2][1]) + (arr[0][1] * arr[1][0] * arr[2][2]));
        } else {
            return null;
        }
    }

    public Float Det(Float[][] arr, int l, int in) {
        float det = 0;
        /////////////////
        if (l > 2) {
            Float arr_active[][] = new Float[this.lenght - 1][this.lenght - 1];//??
            for (int k = 0; k < l; k++) {
                
                arr_active = this.div(arr, this.lenght, 0, k);

                if (in == 0) {
                    det = det + (arr[0][k] * power(k) * Det(arr_active, l - 1, 0));
                } else {
                    det = det + (power(k) * Det(arr_active, l - 1, 1));
                }
            }
            return det;
        } else {
            return ((arr[0][0] * arr[1][1]) - (arr[0][1] * arr[1][0]));
        }

    }

    public Float[][] T(Float[][] arr, int l) {
        Float a[][] = new Float[10][10];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                a[i][j] = arr[j][i];
            }
        }
        return a;
    }

    float power(int n) {
        if (n % 2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }

    boolean zero() {
        for (int i = 0; i < this.lenght; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.my_array[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    ////////////////////draw/////////////////////////////////////////

    public void draw_pro(PROJECT_ARRAY b, Float solve[][], double max, double min) {
            for(int j = 0; j < this.lenght; j++) {
                double y = (double) b.my_array[j][0];//??    
                double z = (double) b.my_array[j][0];//??    
                for(int k = 1; k < this.width; k++) {
                    if (k == 1) {
                        {y = y - min * this.my_array[j][k];
                         z = z- max * this.my_array[j][k];}
                    } else if (k != 2) {
                        y = y - this.my_array[j][k] * solve[k][0];
                        z = z - this.my_array[j][k] * solve[k][0];
                    }if (k == this.width-1) {y=y/this.my_array[j][0];z=z/this.my_array[j][0];
                    }
                    }System.out.println(" v1("+j+") : "+min+"  "+y+" v2("+j+") : "+max+"  "+z);
                  //apkdraw(min,y);
            }
        
    }
    ////////////////////SOLVE/////////////////////////////////////////

    public static void solve() {
        PROJECT_ARRAY a =enter();
        PROJECT_ARRAY b = enter_b(a.lenght);
        
        
        System.out.println("enter type solve");
        String type = (new Scanner(System.in)).next();
        PROJECT_ARRAY c=null;
        if ("gaoth".equals(type)) {
            s.append("the first step : find the vast array A|B by add const array (B) like column in end of column A: \n"
                    + "the second step : find the graded array for vast array :\n"
                    + "the type is to find the major element in every row and every element is located on right of next rowelement. \n"
                    + "we can use operation like : 1-between tow row \n2-divied row on k value \n3-do opertion like(+,-,*,/) between tow  row."
                    + "my type is : first devid evry row under the row i in by first element "
                    + "\nsecond : minus evry row from the row i in."
                    + "\ntherd : "
                    + "note : (major variable is the first element not equal zero in row)."
                    + "now : if number of major element of A array not equal number of major element of vast [A|B] array so we dont have solve\n"
                    + "if number of major element of A equal number of major element of [A|B] so we have solve:\n"
                    + "{if number of variable equal major we have unique solve\n"
                    + "if number of variable less than major we have solve by n-r variable}"
                    + "if the const array equals zero and the solve is unique so the solve will be zero"
                    + "to solve by Gaoth : "
                        + "if we have solve we have t/o solve the group of arrays after find graded style.");
            a = a.vast(a, b.my_array);
            a.my_array = a.I(a.my_array, a.lenght, a.width);
            a.print();
            Integer raaed[] = a.raaed_place(a);
            for (int i = 0; i < a.lenght + 1; i++) {
                System.out.println(" " + raaed[i]);
            }
            
            if (b.zero() && a.width - 1 == raaed[a.lenght]) {
                System.out.println("the all solve is zero ");
            } else {
                System.out.println("the solve by Gaoth : ");
                if(a.able2()&&(c=a.solve_gaoth(a, raaed))!=null) 
                {if(c.width>1)   c.print_X();
                    else c.print();}
                else System.out.println("there are not solve");
                
                }

        } else if ("kramer".equals(type)) {
            s2.append(" kramer type is especial to (3*3) array : "
                    + "FIRST we find delta to the array"
                    + "SECOND we find delta1 and  delta2 and delta3 to the array after change one then tow then three column by B "
                    + "finally we find the solve(n) by divied delta(n)/delta . "
                    + "note: we can find delta by saros type : "
                    + "(a11*a22*a33)+(a12*a23*a31)+(a13*a21*a32)-(a31*a22*a13)-(a32*a23*a11)-(a33*a21*a12)");
            if ((c = (a.solve_kramer(b))) != null) 
                  {if(c.width>1)   c.print_X();
                    else c.print();}
            else System.out.println("there are not solve");
         

        } else if ("A".equals(type) ) {
            s3.append("invert type is especial to square array:"
                    + "first : we find invert A."
                    + "1-we find delta (note : if delta=0 we dont have solve)"
                    + "\n2-we find [Aij]"
                    + "\n3-we find [Aji] to array"
                    + "\n4-we dived the adj(A) by delte."
                    + "now we have invert A."
                    + "second :  to fint solve we find ((A)^(-1))*B.");
            if ((c = (a.solve_invert(b))) != null)
              {if(c.width>1)   c.print_X();
                    else c.print();}
            else System.out.println("there are not solve");
         
        } else {
            System.out.println("ERROR ENTER  . . . . . ");
        }

////////////////////drawwwwww//////////////////////
        System.out.println("do you want draw funcions?? ");
         String type2=" ";
        if ("yes".equals((new Scanner(System.in)).next())) {
            if (c != null && c.width == 0) {
                    a.draw_pro(b, c.my_array, 100, -100);
            }
            else if (c == null ||!"yes".equals(type2)||c.width!=0)
            {Float[][] draw_solve = new Float[a.width][1];
            draw_solve[0][0] = 0.f;
                    draw_solve[1][0] =0.f;
                    for (int i = 2; i < a.width; i++) {
                        draw_solve[i][0] =1.f;
                        a.draw_pro(b,draw_solve, 100, -100);
                    }

                
            }
            
        }
/////////////////////////////drawwwwww//////////////////////
       /* System.out.println("do you want draw funcions?? ");
         String type2=" ";
        if ("yes".equals((new Scanner(System.in)).next())) {
            Float[][] draw_solve = new Float[a.width][1];
            System.out.println("enter min to rang ::");
            int min = (new Scanner(System.in)).nextInt();
            System.out.println("enter max to rang ::");
            int max = (new Scanner(System.in)).nextInt();

            if (c != null && c.width == 0) {
                System.out.println("do you want take vlue from solve?? ");
                type2=(new Scanner(System.in)).next();
                if ("yes".equals(type2)) {
                    draw_solve = c.my_array;
                } 

            }
            else if (c == null ||!"yes".equals(type2)||c.width!=0)
            {
                float a11=0,b11=0;
                draw_solve[0][0] = a11;
                    draw_solve[1][0] =b11;
                    System.out.println("enter value to draw :: ");
                    for (int i = 2; i < a.width; i++) {
                        System.out.println("enter " + i + " value ::");
                        draw_solve[i][0] = (new Scanner(System.in)).nextFloat();
                    }

                
            }
            a.draw_pro(b, draw_solve, max, min);

        }*/
        ////////////////////drawwwwwwwwwwwwww////////////////
    }
}
