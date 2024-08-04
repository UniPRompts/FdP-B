// Creare una classe Bicicletta che memorizzi per ogni bicicletta: taglia del telaio e la velocità a cui sta andando.
// Creare tutti i metodi opportuni della classe bicicletta, inoltre si creino:
// – void stampaStato() che stampa a schermo lo stato ovvero ad esempio “velocità 10 km/h”
// Nella creazione delle classi si mettano tutti gli attributi private.
// Creare una classe MountainBike, ogni mountain bike è una bicicletta che ha la caratteristica specifica di possedere anche le marce, gestite da due selettori.
// I valori delle marce andranno da 1 a un massimo che potrà variare da selettore a selettore e da bicicletta a bicicletta.
// Creare tutti i metodi opportuni della classe bicicletta, inoltre si creino:- void stampaStato() che stampa a schermo lo stato ovvero ad esempio:
// “velocità 10 km/h – marce selettore1: 2 – marce selettore2: 7”

#include <iostream>
using namespace std;

class Bicicletta{
    protected:
        int taglia;
        int velocita;

    public:
    Bicicletta(int telaio, int velocita){
        this->taglia = telaio;
        this->velocita = velocita;
    }
    void stampaStato(ostream& dest) const{
        dest<<"Taglia telaio: "<<taglia<<", Velocita: "<<velocita;
    }
};

class MountainBike : public Bicicletta{
    private:
        int marcia1;
        int marcia2;
    public:
        MountainBike(int taglia, int velocita, int marcia1, int marcia2) : Bicicletta(taglia, velocita){
            this->marcia1 = marcia1;
            this->marcia2 = marcia2;
        }
        void stampaStato(ostream& dest) const{
            Bicicletta::stampaStato(dest);
            dest<<"\nMarcia 1: "<<marcia1<<" Marcia 2: "<<marcia2;
        }
};


int main(){
    Bicicletta b(3, 100);
    MountainBike m(5, 120, 6, 6);
    b.stampaStato(cout);
    cout<<"\n";
    m.stampaStato(cout);
    return 0;
}
