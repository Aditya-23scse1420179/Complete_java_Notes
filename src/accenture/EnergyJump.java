package accenture;

public class EnergyJump {
    public static void main(String[] args){
        int n=2;
        int []j={5};
        int[]e={2,7};
        int t=13;
        System.out.println(helper(n,j,e,t));
    }public static int helper(int n,int[]j,int[]e,int t){
        int en=e[0],ti=1;
        for(int i=1;i<n;i++){
            if(en>=t)return ti;
            while(en<j[i-1]){
                en+=e[i-1];
                ti++;
            }
            en-=j[i-1];
            ti++;

        }
        while(en<t){
            en+=e[n-1];
            ti++;
        }
        return ti;
    }
}
