// Creare innanzitutto la classe Barattolo che serve per rappresentare dei barattoli caratterizzandoli col volume e
// la quantità di contenuto effettivamente presente nei barattoli, scrivere anche i metodi necessari.
// Successivamente realizzare la classe saliera, che rappresenta i barattoli adibiti a contenere e dosare il sale,
// ogni saliera ha un tot numero di buchini da ognuno dei quali quando viene capovolta esce una quantità unitaria di sale.
// Create le classi si realizzi un main per testarle.
// Si proceda con due realizzazioni distinte delle classi, la prima volta senza usare protected, la seconda usando protected.

#include <iostream>

using namespace std;

class Barattolo{
    protected:
        int volumeTot;
        int volumeOccupato;

    public:
        Barattolo(int volumeTot, int volumeOccupato){
            if(volumeOccupato > volumeTot)
                throw string("Overflow");
            this->volumeTot = volumeTot;
            this->volumeOccupato = volumeOccupato;
        }
        void stampa(ostream& dest) const{
            dest<<volumeOccupato<<"/"<<volumeTot;
        }
};

class Saliera : public Barattolo{
    private:
        int nBuchi;
        int portata;

    public:
        Saliera(int volumeTot, int volumeOccupato, int b, int p) : Barattolo(volumeTot, volumeOccupato){
            nBuchi = b;
            portata = p;
        }
        void usa(int volte){
            for(int i = 0; i < volte;  i++){
                if(volumeOccupato <= 0)
                    throw "Underflow";
                volumeOccupato -= (nBuchi * portata);
            }
                
        }
        void stampa(ostream& dest) const{
            Barattolo::stampa(dest);
            dest<<" "<<nBuchi<<"("<<portata<<")";
        }
};

int main(){

    Barattolo b(1000, 900);
    Saliera s(1000, 900, 10, 2);
    
    b.stampa(cout);
    cout<<"\n";
    s.stampa(cout);
    cout<<"\n";
    s.usa(5);
    cout<<"\n";
    s.stampa(cout);

}