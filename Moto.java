import java.util.ArrayList;
import java.util.Random;
class Moto extends Automovel{//cria uma moto com mesmas propriedades dos automovel
  Automovel a=new Automovel();
  private int capacidade_carga;
  public void CriaMoto(){
    Random gerador = new Random();
    int temp = gerador.nextInt(29);//gera um numero aleatorio pro x
    int temp2 = gerador.nextInt(59);//gera um numero aleatorio para o y
    a.setposicao(temp,temp2);//define aonde vai comecar a moto
    a.setvelocidade(3);//define a velocidade da moto
    a.setcor("Azul");//define a cor da moto
  }
  public void mover(){
    for(int i=0;i<velocidade;i++){
       a.move();//move a moto
     }
  }
  public int getx(){
    return a.getx();//devolve o x caso necessario
  }
  public int gety(){
    return a.gety();//devolve o y caso necessario
  }
  public boolean getf(){
    return getfabrica();//retorna o boolean da fabrica se necessario
  }
  public void setf(boolean f){
    setfabrica(f);//define o boleano da fabrica
  }
}