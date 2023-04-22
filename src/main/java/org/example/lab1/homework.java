package org.example.lab1;

class Homework {
    //Sau Ionela Alexandra
    int n;
    String strRow,strColumn;
    public Homework(int n1){
        n=n1;
    }
    public void createLatinSquare(int n, int[][] m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (i + j + 1) % n;
                if (m[i][j] == 0)
                    m[i][j] = n;
            }
        }
    }

    public void displaySolution(int n, int[][] m){
        for (int i = 0; i < n; i++) {
            strRow="";
            strColumn="";
            for (int j = 0; j < n; j++)
            {
                strRow += Integer.toString(m[i][j]);
                strColumn += Integer.toString(m[j][i]);
            }
            System.out.println("strRow:" + strRow);
            System.out.println("strColumn: " + strColumn);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Introduceti un numar.");
            System.exit(-1);
        }
        else if(args.length>1){
            System.out.println("Introduceti un singur numar.");
            System.exit(-1);
        }
        int n1=Integer.parseInt(args[0]);
        int[][] m=new int[n1][n1];
        Homework h1=new Homework(n1);
        if(h1.n>=30000)
        {
            long startTime = System.nanoTime();
            h1.createLatinSquare(h1.n,m);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime + "nanoseconds");
        }
        else{
            h1.createLatinSquare(h1.n,m);
            h1.displaySolution(h1.n,m);
        }
    }
}