import java.util.Random;

public class Pug {

    private double jollakottsag;
    private double egeszseg;
    private double kedv;
    private double energia;
    private double rendetlenseg;
    private String nev;
    private String tulajNev;
    private int penz;
    private boolean tisztasag = true;
    private int majAllapot;

//jatekok
    public void setaltatas(){
        setEnergia(getEnergia()-10.0);
        setEgeszseg(getEgeszseg()+4.0);
        setKedv (getKedv ()+4.0);
    }
    public void labdaJatek(){
        setEnergia(getEnergia()-18.0);
        Random rand = new Random();
        int felsoHatar = 9;
        int ennyivelNoAzElet = rand.nextInt(felsoHatar);
        setEgeszseg(getEgeszseg()+ennyivelNoAzElet);
        setRendetlenseg(getRendetlenseg()-5.0);
        setKedv (getKedv ()+6.0);
    }
    public void kutyaIskola(){
        setPenz(getPenz()-10);
        setEnergia(getEnergia()-20.0);
        setEgeszseg(getEgeszseg()+5.0);
        setRendetlenseg(getRendetlenseg()-50.0);
    }
    public void jatekParkban(){
        setEnergia(getEnergia()-10.0);
        setEgeszseg(getEgeszseg()+10.0);
        setRendetlenseg(getRendetlenseg()-10);
        setKedv (getKedv ()+5.0);
    }

//munkak
    public void ujsagKihordas(){
        setPenz(getPenz()+50);
        setEnergia(getEnergia()-10);
        setEgeszseg(getEgeszseg()-4);
        setKedv (getKedv ()-2.0);
    }
    public void rendoriSegitseg(){
        Random rand = new Random();
        int felsoHatar = 15;
        int ennyivelCsokkenAzElet = rand.nextInt(felsoHatar);
        setPenz(getPenz()+100);
        setEnergia(getEnergia()-25);
        setEgeszseg(getEgeszseg()-ennyivelCsokkenAzElet);
        setKedv (getKedv ()-10.0);
    }
    public void hazOrzes(){
        int minEngy=8;
        int maxEngy=30;
        int ennyivelCsokkenAzEnergia = (int) Math.floor(Math.random()*(maxEngy-minEngy+1)+minEngy);
        int minJovedelem=30;
        int maxJovedelem=200;
        int ennyivelNoAVagyon = (int) Math.floor(Math.random()*(maxJovedelem-minJovedelem+1)+minJovedelem);
        int minElet=10;
        int maxElet=20;
        int ennyivelCsokkenAzEgeszseg = (int) Math.floor(Math.random()*(maxElet-minElet+1)+minElet);
        setPenz(getPenz()+ennyivelNoAVagyon);
        setEnergia(getEnergia()-ennyivelCsokkenAzEnergia);
        setEgeszseg(getEgeszseg()-ennyivelCsokkenAzEgeszseg);
        setKedv (getKedv ()-14.0);
    }
//furdetes
    public void furdetes(){
        setTisztasag(true);
    }



    public double getJollakottsag() {
        if(jollakottsag<0){
            jollakottsag=0;
            return jollakottsag;
        }
        if(jollakottsag>100){
            jollakottsag=100;
            return jollakottsag;
        }
        return jollakottsag;

    }

    public void setJollakottsag(double jollakottsag) {
            this.jollakottsag = jollakottsag;
    }

    public double getEgeszseg() {
        if(egeszseg<0){
            egeszseg=0;
            return egeszseg;
        }
        if(egeszseg>100){
            egeszseg=100;
            return egeszseg;
        }
        return egeszseg;

    }

    public void setEgeszseg(double egeszseg) {
            this.egeszseg = egeszseg;
    }

    public double getKedv() {
        if(kedv<0){
            kedv=0;
            return kedv;
        }
        if(kedv>100){
            kedv=100;
            return kedv;
        }
        return kedv;

    }

    public void setKedv(double kedv) {

        this.kedv = kedv;
    }

    public double getEnergia() {
        if(energia<0){
            energia=0;
            return energia;
        }
        if(energia>100){
            energia=100;
            return energia;
        }
        return energia;
    }

    public void setEnergia(double energia) {
         this.energia = energia;
    }

    public double getRendetlenseg() {
        if(rendetlenseg > 100.0){
            rendetlenseg=100.0;
            return rendetlenseg;
        }
        if(rendetlenseg < 0.0){
            rendetlenseg=0.0;
            return rendetlenseg;
        }
        return rendetlenseg;

    }

    public void setRendetlenseg(double rendetlenseg) {
            this.rendetlenseg = rendetlenseg;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTulajNev() {
        return tulajNev;
    }

    public void setTulajNev(String tulajNev) {
        this.tulajNev = tulajNev;
    }

    public int getPenz() {
        return penz;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public boolean isTisztasag() {
        return tisztasag;
    }

    public void setTisztasag(boolean tisztasag) {
        this.tisztasag = tisztasag;
    }

    public int getMajAllapot() {
        return majAllapot;
    }

    public void setMajAllapot(int majAllapot) {
        this.majAllapot = majAllapot;
    }
}
