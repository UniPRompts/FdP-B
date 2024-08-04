// Creare una classe cassa che serva a rappresentare la cassa di un negozio;
// ogni cassa conserva una quantità di denaro all’interno che può aumentare nel tempo man mano che i clienti effettuano acquisti,
// la cassa ogni giorno memorizza il numero di acquisti del negozio. A fine giornata si dà alla cassa il comando “chiusura cassa”
// che riporta la quantità di denaro presente in cassa a una quantità iniziale “fondo cassa”, restituendo quando incassato e azzera il numero di acquisti,
// predisponendo la cassa per il suo uso nel giorno successivo. 
// NB: la cassa non mantiene in memoria quanti acquisti sono stati fatti nei giorni precedenti.
// Si creino anche i relativi metodi set e get dove sensato.

#include <iostream>

using namespace std;

class Cassa{
    private:
        float denaro;
        int nAcquisti;
        float fondoCassa;

    public:

        Cassa(float fondo){
            denaro = fondo;
            nAcquisti = 0;
            fondoCassa = fondo;
        }

        void nuovoAcquisto(float p){
            denaro += p;
            nAcquisti++;
        }
        float chiusuraCassa(){
            float tmp = denaro - fondoCassa;
            nAcquisti = 0;
            denaro = fondoCassa;
            return tmp;
        }
        ostream& stampa(ostream& dest) const{
            dest<<"\nFondo cassa: "<<fondoCassa<<"\nNumero acquisti: "<<nAcquisti<<"\nDenaro complessivo: "<<denaro<<"\n";
            return dest;
        }
};


ostream& operator<<(ostream& dest, const Cassa& c){
    return c.stampa(dest);
}

int main(){

    Cassa c(1000);
    
    cout<<c;

    c.nuovoAcquisto(20);
    c.nuovoAcquisto(30);
    c.nuovoAcquisto(30);
    c.nuovoAcquisto(40.50);
    cout<<c.chiusuraCassa();


    return 0;
}
