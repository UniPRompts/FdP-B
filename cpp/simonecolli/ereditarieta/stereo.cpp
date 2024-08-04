// Creare una classe Stereo che permette di rappresentare uno stereo che permette di riprodurre un cassetta musicale.
// Lo stereo potrà essere acceso o spento e dovrà permettere di memorizzare se stia riproducendo o no e il minutaggio della riproduzione,
// in particolare ci sarà un metodo stampa() che stamperà lo stato in cui si trova l’istanza dell classe Stereo.
// Creare la classe StereoCD che rappresenta uno stereo che permette di rappresentare uno stereo che può far ascoltare sia una cassetta che un cd,
// la classe dovrà permettere di memorizzare quale dispositivo sia in riproduzione e il tempo di riproduzione; anche questa classe dovrà avere un metodo stampa().

#include <iostream>
#include "./cronometro.cpp"
using namespace std;

class Stereo{

    protected:
        bool stato;
        bool riproduzione;
        Cronometro minutaggio;
    public:

        Stereo(){
            stato = false;
            riproduzione = false;
        }
        void cambiaStato(){
            if(stato)
                stato = false;
            else
                stato = true;
        }
        void riproduci(){
            if(!stato)
                throw string("Stereo spento");
            if(riproduzione)
                riproduzione = false;
            else
                riproduzione = true;
        }

        void passaSecondi(int s){
            if(!riproduzione)
                throw string("Non c'e' nulla in riproduzione");
            minutaggio.addSeconds(s);
        }

        void stampa(ostream& dest) const{
            dest<<"Acceso: "<<stato<<"\nIn riproduzione: "<<riproduzione<<"\nMinutaggio: ";
            minutaggio.stampa(dest);
            dest<<"\n";
        }
};

class StereoCassette : public Stereo{

    private:
        string nomeCassetta;
        bool inserita;

    public:
        StereoCassette() : Stereo(){
            nomeCassetta = "Inserire una cassetta";
            inserita = false;
        }
        StereoCassette(string nome) : Stereo(){
            stato = true;
            nomeCassetta = nome;
            inserita = true;
        }

        void inserisciCassetta(string nome){
            if(inserita)
                throw "E' gia' presente una cassetta all'interno dello stereo";
            if(!stato)
                throw "Stereo spento";
            nomeCassetta = nome;
            inserita = true;
        }
        
        string estraiCassetta(){
            if(!inserita)
                throw "Non e' presente una cassetta all'interno dello stereo";
            if(!stato)
                throw "Stereo spento";
            if(riproduzione)
                riproduzione = false;
            string tmp = nomeCassetta;
            nomeCassetta = "Inserire una cassetta";
            inserita = false;
            return tmp;
        }
        void riproduci(){
            if(!stato)
                throw "Stereo spento";
            if(!inserita)
                throw "Non e' presente una cassetta all'interno dello stereo";
            riproduzione = true;
        }

        void stampa(ostream& dest) const{
            Stereo::stampa(dest);
            dest<<"Nome cassetta: "<<nomeCassetta;
            dest<<"\n";
        }
};
class StereoConCD : public Stereo{
    private:
        string nomeCD;
        bool inserito;

    public:

        StereoConCD() : Stereo(){
            nomeCD = "Inserire un CD";
            inserito = false;
        }
        StereoConCD(string nome) : Stereo(){
            stato = true;
            nomeCD = nome;
            inserito = true;
        }

        void inserisciCD(string nome){
            if(inserito)
                throw "E' gia' presente un CD all'interno dello stereo";
            if(!stato)
                throw "Stereo spento";
            nomeCD = nome;
            inserito = true;
        }
        
        string estraiCD(){
            if(!inserito)
                throw "Non e' presente un CD all'interno dello stereo";
            if(!stato)
                throw "Stereo spento";
            if(riproduzione)
                riproduzione = false;
            string tmp = nomeCD;
            nomeCD = "Inserire un CD";
            inserito = false;
            return tmp;
        }
        void riproduci(){
            if(!stato)
                throw "Stereo spento";
            if(!inserito)
                throw "Non e' presente un CD all'interno dello stereo";
            riproduzione = true;
        }

        void stampa(ostream& dest) const{
            Stereo::stampa(dest);
            dest<<"Nome CD: "<<nomeCD;
            dest<<"\n";
        }
};

int main(){
    Stereo s;
    s.stampa(cout);
    s.cambiaStato();
    s.riproduci();
    s.passaSecondi(120);
    s.stampa(cout);
    StereoCassette sc1;
    sc1.stampa(cout);
    sc1.cambiaStato();
    sc1.inserisciCassetta("Happy");
    sc1.passaSecondi(20);
    
	try{
        sc1.inserisciCassetta("Happy 2");
    }catch(const char* e){
        cout<<e;
    }
    cout<<sc1.estraiCassetta();
    sc1.cambiaStato();
    try{
        cout<<sc1.estraiCassetta();
    }catch(const char* e){
        cout<<e;
    }
    StereoConCD sc2;
    sc2.stampa(cout);
    sc2.cambiaStato();
    sc2.inserisciCD("Happy");
    sc2.passaSecondi(20);
    
    try{
        sc2.inserisciCD("Happy 2");
    }catch(const char* e){
        cout<<e;
        exit(1);   
    }
    cout<<sc2.estraiCD();
    sc2.cambiaStato();
    try{
        cout<<sc2.estraiCD();
    }catch(string& e){
        cout<<e;
    }
    
    return 0;
}
