/**
 * 
 * @brief Classe da entidade Automovel
 * @author Leonardo Milos Ra:22.117.012-9
 * @version 1.0
 * @minoe 22-04-2018
 */ 
//programa para movimentar carros,caminhoes e motos em um mundo que caso passe em uma fabrica ele se duplica e caso eles se batem o menor e destruido
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    ArrayList <Carro> carro = new ArrayList<>();//cria o ArrayList de carro
    ArrayList <Moto> moto = new ArrayList<>();//cria o ArrayList de moto
    ArrayList <Caminhao> caminhao = new ArrayList<>();//cria o ArrayList de caminhao
    Mundo m= new Mundo();//cria o mundo
    m.prenche();//prenche o mundo
    int [][] t=m.getmundo();//copia o mundo para uma variavel
    int x,y,i,j,k,l;//variaveis para contador e para simplificar o x e y
    for( i=0;i<10;i++){
      moto.add(new Moto());//adicionar no ArrayList da moto
      carro.add(new Carro());//adicionar no ArrayList da carro
      caminhao.add(new Caminhao());//adicionar no ArrayList do Caminhao
      carro.get(i).CriaCarro();//criar carro na posicao i
      moto.get(i).CriaMoto();//criar moto na posicao i
      caminhao.get(i).CriaCaminhao();//criar caminhao na posicao i
      if(t[carro.get(i).getx()][carro.get(i).gety()]==2){
        carro.get(i).setf(true);//seta a fabrica para true caso ele naca na fabrica
      }else{
        carro.get(i).setf(false);//seta a fabrica para false caso ele nao naca na fabrica
      }
      if(t[caminhao.get(i).getx()][caminhao.get(i).gety()]==2){
        caminhao.get(i).setf(true);//seta a fabrica para true caso ele naca na fabrica
      }else{
        caminhao.get(i).setf(false);//seta a fabrica para false caso ele nao naca na fabrica
      }
      if(t[moto.get(i).getx()][moto.get(i).gety()]==2){
        moto.get(i).setf(true);//seta a fabrica para true caso ele naca na fabrica
      }else{
        moto.get(i).setf(false);//seta a fabrica para false caso ele nao naca na fabrica
      }
    }
    
    while(true){
      m.prenche();//prenche novamente o mapa vazio
      for(i=0;i<moto.size();i++){
        m.setposicao(moto.get(i).getx(),moto.get(i).gety(),4);//coloca as motos dentro do mundo
      }
      for(i=0;i<carro.size();i++){
        m.setposicao(carro.get(i).getx(),carro.get(i).gety(),3);//coloca os carros dentro do mundo
      }
      for(i=0;i<caminhao.size();i++){
         m.setposicao(caminhao.get(i).getx(),caminhao.get(i).gety(),5);//coloca os Caminhoes dentro do mundo
      }
      System.out.printf( "Numero de Carros \33[7;33m \33[0m : %d        Numero de Caminhoes \33[7;37m \33[0m : %d        Numero de Moto \33[7;34m \33[0m :%d\n",carro.size(),caminhao.size(),moto.size());//imprime a quantidade de cada automovel existente
      m.imprime();//imprime o mundo
      try {
                Thread.sleep(333); //coloca um time para a repeticao do processo
            } catch (Exception e) {
                e.printStackTrace();
      }
      for(i =0;i<moto.size();i++){
        moto.get(i).mover();//move a moto
        x=moto.get(i).getx();
        y=moto.get(i).gety();
        if(moto.get(i).getf()==false && t[x][y]==2){//verifica se a moto passou pela fabrica
          moto.add(new Moto());//adiciona um no vetor da moto
          moto.get(moto.size()-1).CriaMoto();//cria a moto 
          moto.get(i).setf(true);//seta como verdade ela estar em uma fabrica
          if(t[moto.get(moto.size()-1).getx()][moto.get(moto.size()-1).gety()]>2){//verifica se nao naceu colidindo com nenhum veiculo acima
            moto.remove(moto.size()-1);//remove ela caso tenha colidid
            continue;//pula o resto caso ela ja tenha sido destruida
          }
          if(t[moto.get(moto.size()-1).getx()][moto.get(moto.size()-1).gety()]==2){//verifica se a nova moto naceu na fabrica caso tenha nacido e setada como true caso nao e false
            moto.get(moto.size()-1).setf(true);
          }else{
            moto.get(moto.size()-1).setf(false);
          }
        }
        if(moto.get(i).getf()==true && t[x][y]!=2){//caso uma moto saia da fabrica e mudado para false o boolean
          moto.get(i).setf(false);
        }
      }
      for(i =0;i<carro.size();i++){
        carro.get(i).mover();//move o carro
        x=carro.get(i).getx();
        y=carro.get(i).gety();
        if(carro.get(i).getf()==false && t[x][y]==2){//checa se o carro entrou em uma fabrica
          carro.add(new Carro());//adiciona um no vetor de objetos do carro
          carro.get(carro.size()-1).CriaCarro();//adiciona um carro na nova posicao
          if(t[carro.get(carro.size()-1).getx()][carro.get(carro.size()-1).gety()]==2){//verifica se o novo carro naceu ou nao na fabrica
            carro.get(carro.size()-1).setf(true);
          }else{
            carro.get(carro.size()-1).setf(false);
          }
          carro.get(i).setf(true);
        }
        if(carro.get(i).getf()==true && t[x][y]!=2){
          carro.get(i).setf(false);
        }
      }
      for(i=0;i<caminhao.size();i++){
        caminhao.get(i).mover();//move o caminhao
        x=caminhao.get(i).getx();
        y=caminhao.get(i).gety();
        if(caminhao.get(i).getf()==false && t[x][y]==2){
          caminhao.add(new Caminhao());//adiciona um no vetor de caminhao
          caminhao.get(caminhao.size()-1).CriaCaminhao();//cria um novo caminhao
          if(t[caminhao.get(caminhao.size()-1).getx()][caminhao.get(caminhao.size()-1).gety()]==2){//verifica se o novo caminha naceu ou nao numa fabrica
            caminhao.get(caminhao.size()-1).setf(true);
          }else{
            caminhao.get(caminhao.size()-1).setf(false);
          }
          caminhao.get(i).setf(true);
        }
        if(caminhao.get(i).getf()==true && t[x][y]!=2){
          caminhao.get(i).setf(false);
        }
      }
      for(i=0;i<caminhao.size();i++){
        int camx,camy;
        camx=caminhao.get(i).getx();
        camy=caminhao.get(i).gety();
        for(l=i+1;l<caminhao.size();l++){
          if(camx==caminhao.get(l).getx()&&camy==caminhao.get(l).gety()){//verifica se tem um caminhao na mesma posicao que este
            if(l==i){
                  continue;
                }
            caminhao.remove(i);//remove os caminhos
            if(i>l){
              caminhao.remove(l);//remove os caminhoes
            }else{
              caminhao.remove(l-1);//remove os caminhoes
            }
            l--;
            i--;
          }
        }
        if(carro.size()==0){//ve se todos os carros ja foram destruidos
          for(k=0;k<moto.size();k++){
            int mox,moy;
            mox=moto.get(k).getx();
            moy=moto.get(k).gety();
            if(mox==camx&&moy==camy){//verifica se tem um caminhao na mesma posicao da moto se tiver remove a moto
              moto.remove(k);
              k--;
              continue;
            }
            for(l=k+1;l>moto.size();l++){
              if(mox==moto.get(l).getx()&&moy==moto.get(l).gety()){//verifica se tem uma moto no mesmo lugar que ela
                if(l==k){
                  continue;
                }else{
                  moto.remove(k);//remove a moto
                  if(k>l){
                    moto.remove(l);//remove a moto
                  }else{
                    moto.remove(l-1);//remove a moto
                  }
                  l--;
                  k--;
                }
              }
            }
          }
        }
        for(j=0;j<carro.size();j++){
          int cax,cay;
          cax=carro.get(j).getx();
          cay=carro.get(j).gety();
          for(l=j+1;l<carro.size();l++){
            if(cax==carro.get(l).getx()&&cay==carro.get(l).gety()){//ve se tem um carro na mesma possicao que ele
              if(l==j){
                  continue;
                }
              carro.remove(j);//remove o carro
              if(j>l){
                carro.remove(l);//remove o carro
              }else{
                carro.remove(l-1);//remove o carro
              }
              l--;
              j--;
            }
          }
          for(k=0;k<moto.size();k++){
            int mox,moy;
            mox=moto.get(k).getx();
            moy=moto.get(k).gety();
            if(mox==cax&&moy==cay){//ve se tem um carro na mesma posicao da moto
              moto.remove(k);//destroi a moto
              k--;
              continue;
            }
            if(mox==camx&&moy==camy){//ve se tem um caminhao na mesma posicao da moto
              moto.remove(k);//destroi a moto
              k--;
              continue;
            }
            for(l=k+1;l>moto.size();l++){
              if(mox==moto.get(l).getx()&&moy==moto.get(l).gety()){//ve se tem duas moto no mesmo lugar 
                if(l==k){
                }else{
                  moto.remove(k);//remove a moto
                  if(k>l){
                    moto.remove(l);//remove a moto
                  }else{
                    moto.remove(l-1);//remove a moto
                  }
                  l--;
                  k--;
                }
              }
            }
          }
          if(cax==camx&&cay==camy){//verifica se tem um caminhao no mesmo lugar do carro
            carro.remove(j);//remove o carro
            j--;
          }
        }
      }
      
    }
  }
}