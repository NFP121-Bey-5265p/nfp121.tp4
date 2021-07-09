package question3;
import java.util.Stack;
import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;


public class PileModele<T> extends  java.util.Observable implements PileI<T> {
    private PileI<T> pile;
    //private Stack<T> stk;
    //private int capacite;
    //private int taille;
    //private T t;
    public PileModele(PileI<T> pile) {
        this.pile = pile;
        //this.stk = new Stack<T>();
        
       // if (taille <= 0)
        //    taille = PileI.CAPACITE_PAR_DEFAUT;
       // this.capacite = taille;
        
    }

    public void empiler(T o) throws PilePleineException {
      if (estPleine()) throw new PilePleineException(o.toString());
       try{
            this.pile.empiler(o);
        }catch(Exception e){
            throw new PilePleineException(e.toString());
        }finally{
            setChanged();
            notifyObservers();
        } 
        //stk.push(o);
        //pile.empiler(o);
        //setChanged();
        //notifyObservers();
        //notify();
    }

    public T depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        //return stk.pop();
        try{
            return this.pile.depiler();
        }catch(Exception e){
            
        }finally{
            setChanged();
            notifyObservers();
        }
        return null;
       
    }

    public T sommet() throws PileVideException {
       if (estVide()) throw new PileVideException();
       // return stk.peek();
        return  this.pile.sommet();
    }

    public int taille() {
        //return this.stk.size();
        return pile.taille();
     }

     public int capacite() {
        //return this.capacite;
         return pile.capacite();
     }

    public boolean estVide() {
        //return stk.empty();
        return pile.estVide();
     }

    public boolean estPleine() {
        //return capacite == stk.size();
        return pile.estPleine();
      }

    public String toString() {
        
        //String s = "[";
        //for (int i = stk.size() - 1; i >= 0; i--) {
         //    try{
          //  s = s + stk.elementAt(i);
          //  if (i > 0)
           //     s = s + ", ";
          // }catch (NullPointerException e) {
            //   s = s + "";
          //  }
      //} 
      //return s + "]";
      return pile.toString();
     }
}
