/*
 Esercizio – classe Orario
 implementare in c++ una classe di nome Orario che realizza il tipo di dato
 astratto ora del giorno così definito:
 valori:
     - terne <h,m, s>, con hh, mm, s numeri interi e
       0 <= h <= 23 e 0 <= m,s <= 59, che rappresentano,
       rispettivamente, le ore, i minuti e i secondi;

 operazioni su orari:
     - confronto tra due orari: operatore ==(vero se i due orari sono uguali);
     - operatore < (vero se il primo orario precede il secondo);
     - lettura e scrittura (con overloading degli operatori e <<>>) di un orario
       da/su stream nel formato h:m:s;
     - “getter” per gli attributi h, m, s;
        funzioni get_ora(), get_minuti(), get_secondi();
     - funzione di conversione da orario <h,m,s> a equivalente numero di:
       funzione to_second (); ad esempio, se a contiene l’orario <9:42:10 >>,
       a.to_seconds() restituisce 3493034930;
     - somma tra un orario e un dato numero di secondi: operatore ++; ad esempio, se a
       contiene l’orario 9:42:10 >>, a + 5221 restituisce il nuovo orario 11:9:11 >>.

 la classe fornisce anche un costruttore con tre parametri di tipo
 intero che rappresentano rispettivamente ore, minuti e secondi,
 e un costruttore con un parametro di tipo intero che rappresenta l’equivalente in secondi dell’orario.

 n.b. la funzione di lettura e i costruttori devono (obbligatoriamente) controllare che l’orario fornito sia corretto;
 in caso contrario, viene stampato un opportuno messaggio di errore e l’orario viene forzato al valore 0:0: 00.

 note di implementazione.
    - definire una funzione propria privata controlla_orario() che controlla
    la correttezza dell’orario.

 main di prova.
    la classe realizzata deve essere utilizzata dal main di prova messo a disposizione
    su ‘elly’ insieme al testo dell’esercizio (file orario _main.cpp cpp).
    l’esecuzione del main, completato con la classe orarioorario, deve dare i risultati riportati di seguito al main stesso. non è ammesso apportare modifiche al main.
    n.b. e' vietato: usare dichiarazioni friend, usare goto, usare variabili globali non motivate, definire public tutti i campi di una classe, usare ereditarietà a sproposito.
*/

#include <iostream>
using namespace std;

class Orario{
    private:
        int s, m, h;

        bool checkOrario(const int& h, const int& m, const int& s){
            if((h < 0 || h > 24) || (m < 0 || m > 59) || (s < 0 || h > 59))
                return false;
            else
                return true;
        }

    public:
    // ---------------------------------------------    Geter & Setter
        int getHours(){
            return this->h;
        }
        int getMinutes(){
            return this->m;
        }
        int getSeconds(){
            return this->s;
        }
        void setHours(const int& h){
            this->h = h;
        }
        void setMinutes(const int& m){
            this->m = m;
        }
        void setSeconds(const int& s){
            this->s = s;
        }
    // ---------------------------------------------    Costructors
        Orario(const int& h, const int& m, const int& s){
            if(checkOrario(h, m, s)){
                setHours(h);
                setMinutes(m);
                setSeconds(s);
            } else{
                cout << "L'orario non e' nel giusto formato!!\n";
                setHours(0);
                setMinutes(0);
                setSeconds(0);
            }
        }
        Orario(const int& s){
            seconds2Time(s);
        }
        Orario(){
            setHours(0);
            setMinutes(0);
            setSeconds(0);
        }
    // ---------------------------------------------    Function
        void seconds2Time(const int& s){
            int hh = s / 3600;
            setHours(hh);
            int mm = (s - hh * 3600) / 60;
            setMinutes(mm);
            int ss = s - (hh * 3600 + mm * 60);
            setSeconds(ss);
        }
        int time2Seconds(){
            return (getHours() * 3600 + getMinutes() * 60 + getSeconds());
        }
};

// -------------------------------------------------    Overloading
ostream& operator<<(ostream& dest, Orario o){
    if(o.getHours() < 10)
        dest << "0";
    dest << o.getHours() << ":";

    if(o.getMinutes() < 10)
        dest << "0";
    dest << o.getMinutes() << ":";

    if(o.getSeconds() < 10)
        dest << "0";
    dest << o.getSeconds() << "\n";

    return dest;
}
istream& operator>>(istream& sorg, Orario& o){
    int s, m, h;

    do{
        cout << "Inserire l'ora: ";
        sorg >> h;
    } while(h > 24 || h < 0);

    do{
        cout << "Inserire i minuti: ";
        sorg >> m;
    } while(m > 59 || m < 0);

    do{
        cout << "Inserire i secondi: ";
        sorg >> s;
    } while(s > 59 || s < 0);

    o.setHours(h);
    o.setMinutes(m);
    o.setSeconds(s);

    return sorg;
}
bool operator==(Orario o1, Orario o2){
    if(o1.time2Seconds() == o2.time2Seconds())
        return true;
    return false;
}
bool operator<(Orario o1, Orario o2){
    if(o1.time2Seconds() < o2.time2Seconds())
        return true;
    return false;
}
bool operator>(Orario o1, Orario o2){
    if(o1.time2Seconds() > o2.time2Seconds())
        return true;
    return false;
}
Orario operator+(Orario o, const int& s){
    Orario new_o(o.time2Seconds() + s);
    return new_o;
}

int main() {
    Orario o1(1,24,51);
    Orario o2(5091);
    Orario o3(3610);
    Orario o4(72278);

    cout << "o1: " << o1 << "\tSecondi: " << o1.time2Seconds() << endl;
    o1 = o1 + 2465;
    cout << "o1 + 2465: " << o1 << "\tSecondi: " << o1.time2Seconds() << endl;
    cout << "o2: " << o2 << "\tSecondi: " << o2.time2Seconds() << endl;
    cout << "o3: " << o3 << "\tSecondi: " << o3.time2Seconds() << endl;
    cout << "o4: " << o4 << "\tSecondi: " << o4.time2Seconds() << endl;

    cout << endl;

    if(o1 == o2)
        cout << "o1 e o2 sono uguali\n";
    if(o1 > o3)
        cout << "o1 e' maggiore di o3\n";
    if(o3 < o4)
        cout << "o3 e' minore di o4\n";

    cout << endl;

    Orario o5;
    cin >> o5;
    cout << "o5: " << o5 << "\tSecondi: " << o5.time2Seconds() << endl;

    return 0;
}
