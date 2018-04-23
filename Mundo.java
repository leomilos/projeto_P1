class Mundo{
  private int [][] mundo = new int[30][60];
  ///cria o mundo com fabricas 
  public void prenche(){
    for(int i=0;i<30;i++){
      for(int j=0;j<60;j++){
        if(i==0||i==29||j==0||j==59){
          mundo[i][j]=1;
        }else{
          mundo[i][j]=0;
        }
        if(j>=6&&j<10&&i>=4&&i<=6){
          mundo[i][j]=2;
        }
        if(j>=6&&j<10&&i>=22&&i<=24){
          mundo[i][j]=2;
        }
        if(j>=49&&j<53&&i>=4&&i<=6){
          mundo[i][j]=2;
        }
        if(j>=49&&j<53&&i>=22&&i<=24){
          mundo[i][j]=2;
        }

      }
    }
  }
  
  ///imprime o mundo de cada cor dependendo de onde os objetos estao
  public void imprime(){
    for(int i=0;i<30;i++){
        for(int j=0;j<60;j++){
          if(mundo[i][j]==0){
            System.out.printf( "\33[7;30m \33[0m");
          }
          if(mundo[i][j]==1){
            System.out.printf( "\33[7;31m \33[0m");
          }
          if(mundo[i][j]==2){
            System.out.printf( "\33[7;32m \33[0m");
          }
          if(mundo[i][j]==3){
            System.out.printf( "\33[7;33m \33[0m");
          }
          if(mundo[i][j]==4){
            System.out.printf( "\33[7;34m \33[0m");
          }
          if(mundo[i][j]==5){
            System.out.printf( "\33[7;37m \33[0m");
          }
        }
        System.out.printf( "\n");
      }
      System.out.printf( "\n\n\n\n\n\n\n\n\n");
  }
  ///define uma posicao pro objeto pedido
  public void setposicao(int x,int y,int objeto){
    mundo[x][y] = objeto;
  }
  ///devolve o mundo pra funcao
  public int[][] getmundo(){
    return mundo;
  }
}