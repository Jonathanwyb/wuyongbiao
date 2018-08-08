package algorithm.components;
public class Test{
    public static void test(){
        int list[]=new int[]{2,5,9,8,4,5};
        quickSort(list, 0, 5);
        for(int i=0;i<6;i++){
            System.out.print(list[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    //kuai su pai xu
    static void quickSort(int list[],int f,int l){
        if(f<l){
            int q=partition(list,f,l);
            quickSort(list, f, q-1);
            quickSort(list, q+1, l);
        }
    }
    static int partition(int list[],int f,int l){
        int i=f,j=l;
        int v=list[f],k=i;
        while(true){
            while(list[j]>=v&&i<j)j--;
            if(i>=j)break;
            swap(list,i,j);
            i++;
            k=j;
            while(list[i]<=v&&i<j)i++;
            if(i>=j)break;
            swap(list,i,j);
            j--;
            k=i;
        }
        return k;
    }
    static void swap1(int list[],int i,int j){
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }
    //gui bing pai xu
    static void mergeSort(int list[],int f,int l){
        if(f<l){
            int m=(f+l)/2;
            mergeSort(list, f, m);
            mergeSort(list, m+1, l);
            merge(list,f,m,l);
        }
    }
    static void merge(int list[],int f,int m,int l){
        int fk=f,lk=m+1,i,j,k;
        int []temp=new int[l-f+1];
        for(i=0;fk<=m&&lk<=l;i++){
            if(list[fk]<=list[lk]){
                temp[i]=list[fk];
                fk++;
            }else {
                temp[i]=list[lk];
                lk++;
            }
        }
        if(fk<=m){
            for(k=i,j=fk;j<=m;k++,j++){
                temp[k]=list[j];
            }
        }
        if(lk<=l){
            for(k=i,j=lk;j<=l;k++,j++){
                temp[k]=list[j];
            }
        }
        for(i=0,j=f;j<=l;i++,j++){
            list[j]=temp[i];
        }
        
    }
    //er fen cha zhao
    static int binarySearch(int list[],int k,int n){
        int f=0,l=n-1;
        while(f<=l){
            int m=(l+f)/2;
            if(list[m]==k){
                System.out.print("th value sit is ");
                return 1;
            }
            else if(list[m]>k)l=m-1;
            else f=m+1;
        }
        System.out.print("insert sit is ");
        return f;
    }
    //han nuo ta
    static void hannoi(int n,int a,int b,int c){
        if(n>0){
            hannoi(n-1,a,c,b);
            move(a,b);
            hannoi(n-1,c,b,a);
        }
    }
    static void move(int a,int b){
        System.out.println(a+"->"+b);
    }
    //quan pai lie
    static void perm(int list[],int f,int l){
        if(f==l){
            for(int i=0;i<=l;i++){
                System.out.print(list[i]);
            }
            System.out.println();
        }
        else{
            for(int i=f;i<=l;i++){
                swap(list,i,f);
                perm(list,f+1,l);
                swap(list,i,f);
            }
        }
    }
    static void swap(int list[],int a,int b){
        int temp=list[b];
        list[b]=list[a];
        list[a]=temp;
    }
    //fibonacci shulie
    static int fibonacci(int n){
        if(n==0||n==1) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }
    //jiechen
    static int factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }
}