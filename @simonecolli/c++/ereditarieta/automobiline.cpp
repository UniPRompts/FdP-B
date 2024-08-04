// Creare una classe per rappresentare un’automobilina telecomandata a batteria.
// L’automobilina si potrà muovere nelle quattro direzioni su un tabellone bidimensionale con caselle quadrate,
// la sua posizione sarà memorizzata tramite le due coordinate.
// Ogni automobilina avrà una certa carica della batteria che si consumerà come segue: per ogni casella in cui si muove consumerà l’1% della batteria,
// qualora si muova in un una sola volta di almeno 5 celle consumerà l’1% in meno ogni 5 celle.
// Creare la classe automobilina della polizia, che avrà le stesse caratteristiche delle automobiline normali, ma in più avrà la sirena, che potrà essere azionata.
// Quando sarà azionata la sirena la carica scenderà del 2%.

#include <iostream>
using namespace std;


class Automobilina{

    protected:
        int x;
        int y;
        unsigned int batteria;
		
    public:

        Automobilina(int x, int y, int batteria){
            this->x = x;
            this->y = y;
            this->batteria = batteria;
        }
        void muovi(int mx, int my){
            if(batteria == 0)
            throw string("Batteria scarica");
            x += mx;
            y += my;
            if(mx < 0)
                mx *= -1;
            if(my < 0)
                my *= -1;
            batteria -= (mx - mx/5);
            batteria -= (my - my/5);
        }

        void stampa(ostream& dest) const{
            dest<<"\n("<<x<<", "<<y<<")"<<" "<<batteria<<"%";
        }
};


ostream& operator<<(ostream& dest, const Automobilina& a){
    a.stampa(dest);
    return dest;
}

class AutomobilinaPolizia : public Automobilina{

    private:
        bool s;

    public:

        AutomobilinaPolizia(int x, int y, int batteria) : Automobilina(x, y, batteria){
            this->s = false;
        }

        void sirena(){
            if(s)
                s = false;
            else{
                s = true;
                batteria -= 2;
            }
        }
        void stampa(ostream& dest) const{
            dest<<"\nAutomobilina della polizia: ";
            Automobilina::stampa(dest);
            dest<<" sirena: "<<s;
        }
};
ostream& operator<<(ostream& dest, const AutomobilinaPolizia& a){
    a.stampa(dest);
    return dest;
}

int main(){

    Automobilina a(10, 10, 100);
    cout<<a;

    AutomobilinaPolizia p(20, 20, 100);
    cout<<p;

    a.muovi(-10, -10);
    cout<<a;

    p.muovi(20, 20);
    cout<<p;
    p.sirena();
    cout<<p;

    return 0;
}
