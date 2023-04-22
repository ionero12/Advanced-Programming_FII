package org.example.lab1;

class HelloWorld{
    public static void main(String args[])
    {
        System.out.println("Hello World!");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "Javascript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n=n*3;
        n=n+0b10101;
        n=n+0xFF;
        n=n*6;
        int sum=0;
        while(n>0 || sum>9)
        {
            if(n==0)
            {
                n=sum;
                sum=0;
            }
            sum+=n%10;
            n=n/10;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum] + ".");
        System.out.println(sum);
    }
}
