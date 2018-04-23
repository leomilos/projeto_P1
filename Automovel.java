/**
 * 
 * @brief Classe da entidade Automovel
 * @author Leonardo Milos Ra:22.117.012-9
 * @version 1.0
 * @minoe 22-04-2018
 */ 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
class Automovel{

  private int y;
  private int x;
  int velocidade;
  private boolean fabrica;
  private String cor;
  
  public void move(){
    ///move o veiculo dependendo da velocidade dele
    Random gerador = new Random();
    int n = gerador.nextInt(4);
    if(n==0){
      y=y+1;
      ///move o automovel para cima
      if(y>59){
        y-=60;
      }
    }
    if(n==1){
      y=y-1;
      ///move o automovel para baixo
      if(y<0){
        y+=60;
      }
    }
    if(n==2){
      x=x+1;
      ///move o automovel para direita
      if(x>29){
        x-=30;
      }
    }
    if(n==3){
      x=x-1;
      ///move o automovel para squerda
    }
    if(x<0){
        x+=30;
      }
  }
  public void setposicao(int x,int y){
    ///define o x do automovel
    this.x=x;
    ///define o y do automovel
    this.y=y;
  }
  public void setfabrica(boolean f){
    ///define o boolean da fabrica
    fabrica =f;
  }
  public int getx(){
    ///retorna o x
    return x;
  }
  public int gety(){
    ///retorna o y
    return y;
  }
  public void setvelocidade(int v){
    ///define a velocidade do automovel
    velocidade=v;
  }
  public int getvelocidade(){
    ///retorna a velocidade
    return velocidade;
  }
  public boolean getfabrica(){
    ///retorna a fabrica
    return fabrica;
  }
  public void setcor(String c){
    ///define a cor
    cor=c;
  }
  public String getcor(){
    ///devolve a cor
    return cor;
  }
}