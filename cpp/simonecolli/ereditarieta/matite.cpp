// Creare una classe Matita che serve per rappresentare delle matite e memorizzarne la lunghezza.
// Creare una sottoclasse MatitaConGommino che serve per rappresentare delle matite con gommino,
// la classe memorizza le caratteristiche delle matite e il numero cancellature rimaste a disposizione tramite
// il gommino (tali matite partono con 10 possibilità di cancellature).
// Creare le classi e provarle.
#include <iostream>
using namespace std;


class Matita{
    protected:
        int lunghezza;
    
    public:

        Matita(int lunghezza){
            this->lunghezza = lunghezza;
        }
        void stampa(ostream& dest) const{
            dest<<"\nLunghezza: "<<lunghezza;
        }
};

class MatitaConGommino : public Matita{
    private:
        int cancellature;

    public:
        MatitaConGommino(int lunghezza) : Matita(lunghezza){
            this->cancellature = 10;
        }
        MatitaConGommino(int cancellature, int lunghezza) : Matita(lunghezza){
            this->cancellature = cancellature;
        }
        void stampa(ostream& dest)const{
            Matita::stampa(dest);
            dest<<"\nCancellature rimaste: "<<cancellature;
        }
        void cancella(){
            if(cancellature == 0)
                throw string("cancellature terminate");
            cancellature--;
        }
};

ostream& operator<<(ostream& dest, const Matita& m){
    m.stampa(dest);
    return dest;
}
ostream& operator<<(ostream& dest, const MatitaConGommino& m){
    m.stampa(dest);
    return dest;
}

int main(){
    Matita m1(10);
    cout<<m1;
    MatitaConGommino mg(10, 10);
    cout<<mg;
    mg.cancella();
    mg.cancella();
    mg.cancella();
    cout<<mg;
}
