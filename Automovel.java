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
  
  public void move(){///move o veiculo dependendo da velocidade dele
    Random gerador = new Random();
    int n = gerador.nextInt(4);
    if(n==0){
      y=y+1;///move o automovel para cima
      if(y>59){
        y-=60;
      }
    }
    if(n==1){
      y=y-1;///move o automovel para baixo
      if(y<0){
        y+=60;
      }
    }
    if(n==2){
      x=x+1;///move o automovel para direita
      if(x>29){
        x-=30;
      }
    }
    if(n==3){
      x=x-1;///move o automovel para squerda
    }
    if(x<0){
        x+=30;
      }
  }
  /**
  * @param y;
  * @param x;
  */
  public void setposicao(int x,int y){
    this.x=x;///define o x do automovel
    this.y=y;///define o y do automovel
  }
    
  /**
  * @param f;
  */
  public void setfabrica(boolean f){
    fabrica =f;///define o boolean da fabrica
  }
  /**
   * 
   * @return 
   */
  public int getx(){
    return x;///retorna o x
  }
   /**
   * 
   * @return 
   */
  public int gety(){
    return y;///retorna o y
  }
  /**
  * @param v;
  */
  public void setvelocidade(int v){
    velocidade=v;///define a velocidade do automovel
  }
   /**
   * 
   * @return 
   */
  public int getvelocidade(){
    return velocidade;///retorna a velocidade
  }
   /**
   * 
   * @return 
   */
  public boolean getfabrica(){
    return fabrica;///retorna a fabrica
  }
  /**
  * @param c;
  */
  public void setcor(String c){
    cor=c;///define a cor
  }
   /**
   * 
   * @return 
   */
  public String getcor(){
    return cor;///devolve a cor
  }
}