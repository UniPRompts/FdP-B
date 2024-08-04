// Si crei una classe treno, la classe treno sarà caratterizzata dal numero di vagoni; tutti i vagoni possono contenere al massimo lo stesso numero di viaggiatori.
// Creare un treno in cui il numero di vagoni e il numero massimo di viaggiatori per vagone siano scelti dall’utente
// e per 5 volte far chiedere all’utente se salgono o scendono viaggiatori e memorizzare il numero di viaggiatori presenti nel treno.
// Dopo le 5 volte stampare il numero totale di viaggiatori e il numero medio di viaggiatori per vagone.

#include <iostream>
using namespace std;

class Treno{
    private:
        int nVagoni;
        int maxPerVagone;
        int viaggiatoriPresenti;
    public:
        Treno(int nVagoni, int maxPerVagone){
            this->nVagoni = nVagoni;
            this->maxPerVagone = maxPerVagone;
            viaggiatoriPresenti = 0;
        }
        void aggiungiViaggiatori(int n){
            viaggiatoriPresenti += n;
            if(viaggiatoriPresenti > maxPerVagone*nVagoni)
                throw string("Il treno e' pieno");
        }
        void rimuoviViaggiatori(int n){
            viaggiatoriPresenti -= n;

            if(viaggiatoriPresenti <= 0)
                throw string("Il treno e' vuoto");
        }
        
        ostream& operator<<(ostream& dest) const{
            dest<<"\nNumero passeggeri: "<<viaggiatoriPresenti<<"\nMedia passeggeri per vagone: "<<(float)viaggiatoriPresenti/nVagoni;
            return dest;
        }
};

ostream& operator<<(ostream& dest, const Treno& t){
    return t.operator<<(dest);
}

int main(){
    int nCarrozze, nPasseggeri;
    cout<<"Inserisci il numero di carrozze: ";
    cin>>nCarrozze;
    cout<<"Inserisci il numero di passeggeri per carrozza: ";
    cin>>nPasseggeri;
    Treno t(nCarrozze, nPasseggeri);

    for (int i = 0; i < 5; i++){
        cout<<t;
        int scelta;
        cout<<"\nI passeggeri salgono o scendono?\n1)Salgono\n2)Scendono\n";
        cin>>scelta;
        switch(scelta){

        case 1:
            int n;
            cout<<"\nQuanti passeggeri salgono? ";
            cin>>n;
            t.aggiungiViaggiatori(n);
        break;

        case 2:
            int n2;
            cout<<"\nQuanti passeggeri scendono? ";
            cin>>n2;
            t.aggiungiViaggiatori(n2);
        break;
        
        default:
            cout<<"La scelta inserita non e' disponibile";
            i--;
            break;
        }
    }

    return 0;
}
