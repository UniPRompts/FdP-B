#include <iostream>
using namespace std;

class Televisore{
    private:
        bool acceso = false;
        int volume = 50;
        int canale = 0;

        void setCanale(int other){
            canale = other;
        }

        void setVolume(int other){
            volume = other;
        }

    public:
        void pulsanteAccendi(){
            acceso = !acceso;
        }

        void impostaCanale(int canale){
            if(acceso && canale >= 0 && canale < 100)
                setCanale(canale);
            else
                cout << "Canale non esistente o TV spenta\n";
        }

        void canaleSuccessivo(){
            if(acceso && canale < 99)
                setCanale(canale + 1);
            else
                cout << "Canale non esistente o TV spenta\n";
        }

        void canalePrecedente(){
            if(acceso && canale > 1)
                setCanale(canale - 1);
            else
                cout << "Canale non esistente o TV spenta\n";
        }

        void aumentaVolume(){
            if(acceso && volume < 10)
                setVolume(volume + 1);
            else
                cout << "Volume al massimo o TV spenta\n";
        }

        void abbassaVolume(){
            if(acceso && volume > 0)
                setVolume(volume - 1);
            else
                cout << "Volume al minimo o TV spenta\n";
        }

        void silenzia(){
            if(acceso) setVolume(0);
        }

        void stampaTelevisore(){
            cout << "\nAcceso? (1: si, 0: no):  " << acceso << endl;
            cout << "Volume: " << volume << endl;
            cout << "Canale: " << canale << endl << endl;
        }

};

int menu(){
    int x = 0;

    do {
        cout << "0 - Termina programma" << endl;
        cout << "1 - pulsanteAccendi" << endl;
        cout << "2 - impostaCanale" << endl;
        cout << "3 - canaleSuccessivo" << endl;
        cout << "4 - canalePrecedente" << endl;
        cout << "5 - aumentaVolume" << endl;
        cout << "6 - abbassaVolume" << endl;
        cout << "7 - silenzia" << endl;
        cout << "8 - stampaTelevisore" << endl;
        cout << "Scelta: ";
        cin >> x;
    } while (x < 0 || x > 8);

    return x;
}

int main() {

    int scelta = 0;
    Televisore tv;
    do{
        scelta = menu();

        switch (scelta) {
            case 1: tv.pulsanteAccendi();
                break;

            case 2:
                int canale;
                cout << "Inserire canale: ";
                cin >> canale;

                tv.impostaCanale(canale);
                break;

            case 3:
                tv.canaleSuccessivo();
                break;

            case 4:
                tv.canalePrecedente();
                break;

            case 5:
                tv.aumentaVolume();
                break;

            case 6:
                tv.abbassaVolume();
                break;

            case 7:
                tv.silenzia();
                break;

            case 8:
                tv.stampaTelevisore();
                break;
        }
    } while(scelta != 0);

    return 0;
}
