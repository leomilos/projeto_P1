/**
 * Leonardo Milos Ra:22.117.012-9
 * data 22-04-2018
 */ 
///programa para movimentar carros,caminhoes e motos em um mundo que caso passe em uma fabrica ele se duplica e caso eles se batem o menor e destruido
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    ///cria dos ArrayList
    ArrayList <Carro> carro = new ArrayList<>();
    ArrayList <Moto> moto = new ArrayList<>();
    ArrayList <Caminhao> caminhao = new ArrayList<>();
    ///cria o mundo
    Mundo m= new Mundo();
    ///prenche o mundo
    m.prenche();
    int [][] t=m.getmundo();
    ///variaveis para contador e para simplificar o x e y
    int x,y,i,j,k,l;
    ///adiciona os objetos no ArrayList e define se o objeto naceu na fabrica ou nao
    for( i=0;i<10;i++){ 
      moto.add(new Moto());
      carro.add(new Carro());
      caminhao.add(new Caminhao());
      carro.get(i).CriaCarro();
      moto.get(i).CriaMoto();
      caminhao.get(i).CriaCaminhao();
      if(t[carro.get(i).getx()][carro.get(i).gety()]==2){
        carro.get(i).setf(true);
      }else{
        carro.get(i).setf(false);
      }
      if(t[caminhao.get(i).getx()][caminhao.get(i).gety()]==2){
        caminhao.get(i).setf(true);
      }else{
        caminhao.get(i).setf(false);
      }
      if(t[moto.get(i).getx()][moto.get(i).gety()]==2){
        moto.get(i).setf(true);
      }else{
        moto.get(i).setf(false);
      }
    }
    
    while(true){
      ///prenche novamente o mapa vazio
      m.prenche();
      ///coloca os objetos dentro do mundo
      for(i=0;i<moto.size();i++){
        m.setposicao(moto.get(i).getx(),moto.get(i).gety(),4);
      }
      for(i=0;i<carro.size();i++){
        m.setposicao(carro.get(i).getx(),carro.get(i).gety(),3);
      }
      for(i=0;i<caminhao.size();i++){
         m.setposicao(caminhao.get(i).getx(),caminhao.get(i).gety(),5);
      }
      ///imprime a quantidade de cada automovel existente
      System.out.printf( "Numero de Carros \33[7;33m \33[0m : %d        Numero de Caminhoes \33[7;37m \33[0m : %d        Numero de Moto \33[7;34m \33[0m :%d\n",carro.size(),caminhao.size(),moto.size());
      ///imprime o mundo
      m.imprime();
      ///coloca um time para a repeticao do processo
      try {
                Thread.sleep(333);
            } catch (Exception e) {
                e.printStackTrace();
      }
      ///move a moto e ve se as condicoes da moto
      for(i =0;i<moto.size();i++){
        moto.get(i).mover();
        x=moto.get(i).getx();
        y=moto.get(i).gety();
        ///verifica se a moto passou pela fabrica e cria uma nova caso tenha passado pela fabrica
        if(moto.get(i).getf()==false && t[x][y]==2){
          moto.add(new Moto());
          moto.get(moto.size()-1).CriaMoto();
          moto.get(i).setf(true);
          ///verifica se nao naceu colidindo com nenhum veiculo acima
          if(t[moto.get(moto.size()-1).getx()][moto.get(moto.size()-1).gety()]>2){
            moto.remove(moto.size()-1);
            continue;
          }
          ///verifica se a nova moto naceu na fabrica caso tenha nacido e setada como true caso nao e false
          if(t[moto.get(moto.size()-1).getx()][moto.get(moto.size()-1).gety()]==2){
            moto.get(moto.size()-1).setf(true);
          }else{
            moto.get(moto.size()-1).setf(false);
          }
        }
        ///caso uma moto saia da fabrica e mudado para false o boolean
        if(moto.get(i).getf()==true && t[x][y]!=2){
          moto.get(i).setf(false);
        }
      }
      ///move o carro e verifica aonde ele esta
      for(i =0;i<carro.size();i++){
        carro.get(i).mover();
        x=carro.get(i).getx();
        y=carro.get(i).gety();
        ///checa se o carro entrou em uma fabrica e cria um novo caso entre
        if(carro.get(i).getf()==false && t[x][y]==2){
          carro.add(new Carro());
          carro.get(carro.size()-1).CriaCarro();
          ///verifica se o novo carro naceu ou nao na fabrica
          if(t[carro.get(carro.size()-1).getx()][carro.get(carro.size()-1).gety()]==2){
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
      ///move o caminhaoe verifica aonde ele esta
      for(i=0;i<caminhao.size();i++){
        caminhao.get(i).mover();
        x=caminhao.get(i).getx();
        y=caminhao.get(i).gety();
        //ve se o caminhao entrou em  uma fabrica
        if(caminhao.get(i).getf()==false && t[x][y]==2){
          caminhao.add(new Caminhao());
          caminhao.get(caminhao.size()-1).CriaCaminhao();
          ///verifica se o novo caminha naceu ou nao numa fabrica
          if(t[caminhao.get(caminhao.size()-1).getx()][caminhao.get(caminhao.size()-1).gety()]==2){
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
          ///verifica se tem um caminhao na mesma posicao que este para destruir ambos se tiver
          if(camx==caminhao.get(l).getx()&&camy==caminhao.get(l).gety()){
            if(l==i){
                  continue;
                }
            caminhao.remove(i);
            if(i>l){
              caminhao.remove(l);
            }else{
              caminhao.remove(l-1);
            }
            l--;
            i--;
          }
        }
        ///ve se todos os carros ja foram destruidos
        if(carro.size()==0){
          for(k=0;k<moto.size();k++){
            int mox,moy;
            mox=moto.get(k).getx();
            moy=moto.get(k).gety();
            ///verifica se tem um caminhao na mesma posicao da moto se tiver remove a moto
            if(mox==camx&&moy==camy){
              moto.remove(k);
              k--;
              continue;
            }
            for(l=k+1;l>moto.size();l++){
              ///verifica se tem uma moto no mesmo lugar que esta
              if(mox==moto.get(l).getx()&&moy==moto.get(l).gety()){
                if(l==k){
                  continue;
                }else{
                  moto.remove(k);
                  if(k>l){
                    moto.remove(l);
                  }else{
                    moto.remove(l-1);
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
            ///ve se tem um carro na mesma possicao que ele para destruir ambos se estiver
            if(cax==carro.get(l).getx()&&cay==carro.get(l).gety()){
              if(l==j){
                  continue;
                }
              carro.remove(j);
              if(j>l){
                carro.remove(l);
              }else{
                carro.remove(l-1);
              }
              l--;
              j--;
            }
          }
          for(k=0;k<moto.size();k++){
            int mox,moy;
            mox=moto.get(k).getx();
            moy=moto.get(k).gety();
            ///ve se tem um carro na mesma posicao da moto destroi apenas a moto 
            if(mox==cax&&moy==cay){
              moto.remove(k);
              k--;
              continue;
            }
            ///ve se tem um caminhao na mesma posicao da moto destroi somente a moto
            if(mox==camx&&moy==camy){
              moto.remove(k);
              k--;
              continue;
            }
            for(l=k+1;l>moto.size();l++){
              ///ve se tem duas moto no mesmo lugar destroi ambas se tiver
              if(mox==moto.get(l).getx()&&moy==moto.get(l).gety()){
                if(l==k){
                }else{
                  moto.remove(k);
                  if(k>l){
                    moto.remove(l);
                  }else{
                    moto.remove(l-1);
                  }
                  l--;
                  k--;
                }
              }
            }
          }
          ///verifica se tem um caminhao no mesmo lugar do carro destroi apenas o carro
          if(cax==camx&&cay==camy){
            carro.remove(j);
            j--;
          }
        }
      }
      
    }
  }
}