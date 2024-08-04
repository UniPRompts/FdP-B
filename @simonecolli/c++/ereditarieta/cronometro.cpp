#include <iostream>
using namespace std;

class Cronometro{
    private:
        int minuti;
        int secondi;

        void convertSeconds(){
            while(secondi >= 60){
                minuti++;
                secondi -= 60;
            }
        }
    public:
        Cronometro(){
            minuti = 0;
            secondi = 0;
        }
        void addSeconds(int s){
            secondi += s;
            convertSeconds();
        }
        void stampa(ostream& dest) const{
            dest<<minuti<<":"<<secondi;
        }
};
