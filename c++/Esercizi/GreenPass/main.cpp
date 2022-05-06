#include <iostream>
#include "date.cpp"
#include "persona.cpp"
using namespace std;

class GreenPass {
protected:
    string cf;
    Data dataGenerazione;
public:
    GreenPass(string cf, Data dataGenerazione){
        this->cf = cf;
        this->dataGenerazione = dataGenerazione;
    }

    void stampa(ostream& dest){
        dest << "Data generazione: ";
        dataGenerazione.stampa(dest);
        dest << endl;
        dest << "Codice fiscale: " << cf << endl;
    }

    string getCF(){
        return cf;
    }
};

class GPVaccino : public GreenPass{
private:
    int tipoVaccino;
public:
    const static int ASTRAZENECA = 0;
    const static int PFIZER = 1;
    const static int MODERNA = 2;
    const static int JHONSON = 3;

    GPVaccino(string cf, Data dataGenerazione, int tipoVaccino) : GreenPass(cf, dataGenerazione){
        if(tipoVaccino < ASTRAZENECA || tipoVaccino > JHONSON)
            throw "vaccino non riconosciuto";
        this->tipoVaccino = tipoVaccino;
    }

    void stampa(ostream& dest){
        GreenPass::stampa(dest);
        dest << "Vaccino: ";
        switch (tipoVaccino) {
            case ASTRAZENECA: dest << "Astrazeneca"; break;
            case PFIZER: dest << "Pfizer"; break;
            case MODERNA: dest << "Moderna"; break;
            case JHONSON: dest << "Jhonson"; break;
            default: throw "vaccino non riconosciuto";
        }
        dest << endl;
        dest << endl;
    }
};

class GPTampone : public GreenPass{
private:
    int tipoTampone;
public:
    const static int SIEROLOGICO = 0;
    const static int MOLECOLARE = 1;

    GPTampone(string cf, Data dataGenerazione, int tipoTampone) : GreenPass(cf, dataGenerazione){
        if(tipoTampone < SIEROLOGICO || tipoTampone > MOLECOLARE)
            throw string("vaccino non riconosciuto");
        this->tipoTampone = tipoTampone;
    }

    void stampa(ostream& dest){
        GreenPass::stampa(dest);
        dest << "Tampone: ";
        switch (tipoTampone) {
            case SIEROLOGICO: dest << "sierologico"; break;
            case MOLECOLARE: dest << "molecolare"; break;
            default: throw string("Tampone non riconosciuto");
        }
        dest << endl;
        dest << endl;
    }
};

class GPGrarigione : public GreenPass{
    //n costanti con tipo di varianti da cui sei guarito
    //data guarigione
private:
    int variante;
public:
    const static int ALFA = 0;
    const static int DELTA = 1;
    const static int OMICRON = 2;

    GPGrarigione(string cf, Data dataGenerazione, int variante) : GreenPass(cf, dataGenerazione){
        if(variante < ALFA || variante > OMICRON)
            throw string("Variante non riconosciuta");
        this->variante = variante;
    }

    void stampa(ostream& dest){
        dest << "Data Guarigione: ";
        dataGenerazione.stampa(dest);
        dest << endl;
        dest << "Codice fiscale: " << cf << endl;

        dest << "Variante: ";
        switch (variante) {
            case ALFA: dest << "alfa"; break;
            case DELTA: dest << "delta"; break;
            case OMICRON: dest << "omicron"; break;
            default: throw string("Variante non riconosciuta");
        }
        dest << endl;
        dest << endl;
    }
};

class PersonaConGP : public Persona{
private:
    GreenPass* gp;
public:
    PersonaConGP(string nome,
                 string cognome,
                 string cf) : Persona(nome, cognome, cf){
        this->gp = NULL;
    }

    void addGreenPass(GreenPass gp){
        if(gp.getCF() != cf)
            throw string("Errore - Codici fiscali non uguali");
        this->gp = &gp;
    }

    bool hasGreenPass(){
        return gp != NULL;
    }

    void stampa(ostream& dest){
        Persona::stampa(dest);
        if(hasGreenPass()) {
            dest << "Persona con green pass" << endl;
            gp->stampa(dest);
        }
        else dest << "Persona senza green pass" << endl;

    }
};

int main() {
    GPVaccino gpv("abc123", Data(6, 5, 2022), GPVaccino::ASTRAZENECA);
    gpv.stampa(cout);

    GPTampone gpt("def456", Data(1, 5, 2022), GPTampone::MOLECOLARE);
    gpt.stampa(cout);

    GPGrarigione gpg("ghi789", Data(20, 4, 2022), GPGrarigione::OMICRON);
    gpg.stampa(cout);

    PersonaConGP p("mattia", "merenda", "abc123");
    try{
        p.addGreenPass(gpv);
    } catch(string& e){
        cout << e;
    }


    p.stampa(cout);


    //p.stampa(cout);

    return 0;
}