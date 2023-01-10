import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String mentesNeve;
        String toltesNeve;
        //default inicializalt peldany
        int korszam=1;
        Pug p1 = new Pug();
        p1.setPenz(1500);
        p1.setEgeszseg(62.0);
        p1.setEnergia(62.0);
        p1.setJollakottsag(62.0);
        p1.setRendetlenseg(62.0);
        p1.setKedv(62.0);
        p1.setMajAllapot (0);

        String kezdes="";
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("♦ ♦ ♦ Üdvözöllek a Pug-a-gotchiban! ♦ ♦ ♦");
        System.out.println();
        System.out.println("Üdv, itt a régi barátod, PugChamp professzor! Én leszek a segítőd a kutyusnevelésben!");
        System.out.println ("Kiskedvenced egy korábbi kísérlet során bionukleáris tömegpusztító fegyverré vált.");
        System.out.println ("Ha baj vagy szomorúság éri, instabillá válik és maga körül mindent megsemmisít 100 kilométeres sugarú körben!");
        System.out.println ("A kísérlet során több nemzetközi biztonsági szerv felfigyelt a különös tevékenységeinkre, a kutyaház pedig kitörlődött a tér-idő kontinuumból.");
        System.out.println ("A cél, hogy összegyűjts hűséges társad segítségével 10 000 Ft-ot a titkos projekt folytatására, hogy hatástalaníthassuk a fegyvert.");
        System.out.println ("(Meg persze egy új kutyaházra...)");
        System.out.println ("VIGYÁZZ! Ha kedvenced egészsége vagy kedve 0%-ra csökken, mindannyiunknak annyi!");
        System.out.println();
        System.out.println("♦ Ha egy korábbi mentésed szeretnéd folytatni, írd be, hogy LOAD");
        System.out.println("♦ Új játék indításához kérlek írd be, hogy START");
        System.out.println("♦ A játékból való kilépéshez kérlek írd be, hogy QUIT");
        System.out.println ();
        String indulas;
        while(!(kezdes.equals ("START") || kezdes.equals ("LOAD") || kezdes.equals ("QUIT"))){
            System.out.println ("Kérlek, csak a felsorolt parancsokat használd!");
            kezdes = sc.nextLine();
        }
    while (true){
        if(kezdes.equals("QUIT")) {
            System.out.println("Köszönöm, hogy játszottál!");
            return;
        }
        if(kezdes.equals("LOAD")){
            File mentesekMappaja = new File("./mentesek/");
            File[] tartalom = mentesekMappaja.listFiles();
            if(tartalom==null){

            }else if(tartalom.length==0){
                System.out.println("Sajnálom, de a mentések mappa nem tartalmaz mentéseket!");
                System.out.println();
                System.out.println("Új játék indításához kérlek írd be, hogy START");
                System.out.println("A játékból való kilépéshez kérlek írd be, hogy QUIT");
                System.out.println ();
                while(!(kezdes.equals ("START") || kezdes.equals ("QUIT"))){
                    System.out.println ("Kérlek, csak a felsorolt parancsokat használd!");
                    kezdes = sc.nextLine();
                }
                continue;

            }else {
            System.out.println("Az alábbi mentéseket találtam. Írd be a megnyitni kívánt mentés nevét a .txt nélkül!");
            File eleresiUt = new File("./mentesek/");
            File[] fajlok = eleresiUt.listFiles((dir, name) -> name.endsWith(".txt"));
                if (fajlok != null) {
                    for(File file: fajlok){
                        System.out.println(file.getName());
                    }
                }
                toltesNeve=sc.nextLine();
            if(toltesNeve.contains(".txt")){
                System.err.println("Kérlek, hogy a fájlkiterjesztést mellőzve írd be a megnyitni kívánt mentés nevét!");
                continue;
            }
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("./mentesek/"+toltesNeve+".txt"));
                p1.setTulajNev(br.readLine());
                p1.setNev(br.readLine());
                korszam = Integer.parseInt(br.readLine());
                p1.setPenz(Integer.parseInt(br.readLine()));
                p1.setEgeszseg(Double.parseDouble(br.readLine()));
                p1.setEnergia(Double.parseDouble(br.readLine()));
                p1.setKedv(Double.parseDouble(br.readLine()));
                p1.setJollakottsag(Double.parseDouble(br.readLine()));
                p1.setRendetlenseg(Double.parseDouble(br.readLine()));
                p1.setMajAllapot (Integer.parseInt(br.readLine ()));
                br.close();
                System.out.println("Sikeres betöltés!");
                System.out.println("Üdv újra itt, "+p1.getTulajNev()+", "+p1.getNev()+"!");
            } catch (IOException e) {
                System.err.println("Oops! Hiba történt a mentésed beolvasásakor! Valid mentésnevet adj meg!");
                continue;
            }
            }
                break;
        }
        indulas="";
        System.out.println("Üdvözöllek a játékban! Mi is volt a kutyusod neve?");
        boolean helyesNev=false;
        while(!helyesNev){
            p1.setNev(sc.nextLine());
            if(!p1.getNev ().matches ("[a-záéíóúöüőűA-ZÁÉÍÓÚÖÜŐŰ\\s]+")){
                System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj kedvencednek!");
            }else if(p1.getNev ().length ()<1 || p1.getNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj kedvencednek!");
            } else{
                helyesNev=true;
            }
        }
        System.out.println("A kutyusod neve: "+p1.getNev());
        System.out.println("Ha véletlen te is törlődnél az ismert világból, azért add meg a neved, hogy megemlékezhessünk rólad!");
        boolean helyesTulajNev=false;
        while(!helyesTulajNev){
            p1.setTulajNev (sc.nextLine());
            if(!p1.getTulajNev ().matches ("[a-záéíóúöüőűA-ZÁÉÍÓÚÖÜŐŰ\\s]+")){
                System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj magadnak!");
            }else if(p1.getTulajNev ().length ()<1 || p1.getTulajNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj magadnak!");
            } else{
                helyesTulajNev=true;
            }
        }
        System.out.println("A gazdi neve: "+p1.getTulajNev());
        System.out.println("**************************************************************************************");
        System.out.println("A kutyusod adatai: ");
        System.out.println("Neve: "+p1.getNev());
        System.out.println("Tulajdonosának neve: "+p1.getTulajNev());
        System.out.println("Vagyonotok: "+p1.getPenz()+" Ft (Default)");
        System.out.println("A kutyusod egészsége: "+p1.getEgeszseg()+"% (Default)");
        System.out.println("A kutyusod energiája: "+p1.getEnergia()+"% (Default)");
        System.out.println("A kutyusod kedve: "+p1.getKedv()+"% (Default)");
        System.out.println("A kutyusod jóllakottsága: "+p1.getJollakottsag()+"% (Default)");
        System.out.println("A kutyusod rendetlensége: "+p1.getRendetlenseg()+"% (Default)");
        System.out.println("**************************************************************************************");
        System.out.println("Amennyiben elégedett vagy a beírt adatokkal, írd be, hogy GO");
        System.out.println("Ellenkező esetben írd be, hogy RE");
        while(!(indulas.equals("RE"))){
            indulas=sc.nextLine();

        if(indulas.equals("RE")){
            continue;
        }
        if(indulas.equals("GO")){
            break;
        }
        System.err.println("Helyes parancsokat használj!");
        }
        if(indulas.equals("GO")){
            break;
        }
    }

        String utasitas;
        //Kajak

        Kaja jutiFali = new Kaja(10,4);
        Kaja szarazTap = new Kaja(20,8);
        Kaja csont = new Kaja(23,10);
        Kaja haziKoszt = new Kaja(15,6);
        Kaja viz = new Kaja(7,3);
        Kaja konzerves = new Kaja(30,13);
        EnergyDrink kutyaEnergyDrink = new EnergyDrink(20,20, 15);

        //Eletcsomagok
        Eletcsomag kicsi = new Eletcsomag(6, 5);
        Eletcsomag nagy = new Eletcsomag(10, 15);
        Eletcsomag allatorvos = new Eletcsomag(25, 100);
        Eletcsomag maxiItal = new Eletcsomag(100, 100);


       //JATEKMENET
        System.out.println("🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕 JÁTÉK INDUL 🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕");
        while(korszam<100 || p1.getPenz()<=10000 || p1.getMajAllapot ()<10 || p1.getEgeszseg ()>0.0 || p1.getKedv ()>0.0){
            System.out.println("🐕 "+korszam+". kör 🐕");
            if(p1.getPenz()>=10000){
                break;
            }
            if(p1.getMajAllapot ()>10){
                break;
            }
            if(p1.getEgeszseg ()==0.0){
                break;
            }
            if(p1.getKedv ()==0.0){
                break;
            }
            if(korszam>100){
                break;
            }
            if(!p1.isTisztasag ()){
            System.out.println("A kutyusodat piszkos lett az előző kör alatt! Először meg kell fürdetned! Ehhez írd be: bath");
            }else{
                if(p1.getEnergia()<10.0){
                    System.out.println("$: "+p1.getPenz()+" Ft, ♥: "+(int)p1.getEgeszseg()+"%, ⚡: "+(int)p1.getEnergia()+"%, ☺: "
                            +(int)p1.getKedv()+"%, ♨: "+(int)p1.getJollakottsag()+"%, ⚠: "+(int)p1.getRendetlenseg()+"%");
                    System.out.println();
                    System.out.println("! Kutyusod elfáradt ebben a körben. Etesd meg vagy fektesd le aludni, utóbbival új kört kezdve.");
                    System.out.println();
                    System.out.println("○ Részletes státuszlekéréshez és jelmagyarázathoz írd be: stat");
                    System.out.println("○ Az élelmek megtekintéséhez írd be: eat");
                    System.out.println("Élelemparancsok: jutifali, szaraztap, csont, hazikoszt, viz, konzerv, energydrink");
                    System.out.println();
                    System.out.println("♦ Főparancsok: Következő kör: SLEEP - Játék mentése: SAVE - Mentés betöltése: LOAD - Új játék kezdése: NEW - Kilépés mentés nélkül: QUIT");

                }else{
                    System.out.println("$: "+p1.getPenz()+" Ft, ♥: "+(int)p1.getEgeszseg()+"%, ⚡: "+(int)p1.getEnergia()+"%, ☺: "
                            +(int)p1.getKedv()+"%, ♨: "+(int)p1.getJollakottsag()+"%, ⚠: "+(int)p1.getRendetlenseg()+"%");
                    System.out.println();
                    System.out.println("○ Részletes státuszlekéréshez és jelmagyarázathoz írd be: stat");
                    System.out.println("○ A kutyusod által a körben elvégezhető tevékenységek listájáért írd be: wtd");
                    System.out.println("○ Az élelmek megtekintéséhez írd be: eat");
                    System.out.println("○ Az életcsomagok megtekintéséhez írd be: heal");
                    System.out.println();
                    System.out.println("> Tevékenységparancsok - Játékok: seta, labda, iskola, park | Munkák: ujsag, rex, orzes");
                    System.out.println("> Élelemparancsok: jutifali, szaraztap, csont, hazikoszt, viz, konzerv, energydrink");
                    System.out.println("> Életcsomagok parancsai: kishk, nagyhk, allatorvos, maxital");
                    System.out.println();
                    System.out.println("♦ Főparancsok: Következő kör: SLEEP - Játék mentése: SAVE - Mentés betöltése: LOAD - Új játék kezdése: NEW - Kilépés mentés nélkül: QUIT");
                }

            }

            utasitas=sc.nextLine();

            if(utasitas.equals("bath")){
                p1.furdetes();
                System.out.println("Kutyusod mostantól csillog és villog!");
            }
            if(utasitas.equals("QUIT") && !p1.isTisztasag ()){
                System.out.println("! Legalább fürdesd meg azt a szerencsétlen kutyát, mielőtt magára hagyod!");
                continue;
            }
           // cheatkód teszteléshez
            if(utasitas.equals ("cheatpenz")){
             p1.setPenz (9999);
          }
          if(utasitas.equals ("cheatkor")){
               korszam=99;
           }
            if(utasitas.equals ("cheategeszseg")){
                p1.setEgeszseg (1.0);
            }
            if(utasitas.equals ("cheatkedv")){
                p1.setKedv (1.0);
            }
            //utasitasellenorzes
            if (!(utasitas.equals("stat") || utasitas.equals("wtd") || utasitas.equals("QUIT") || utasitas.equals("bath") ||
                    utasitas.equals("seta") || utasitas.equals("labda") || utasitas.equals("iskola") ||
                    utasitas.equals("park") || utasitas.equals("ujsag") || utasitas.equals("rex") ||
                    utasitas.equals("orzes")|| utasitas.equals("eat") || utasitas.equals("jutifali")
                    || utasitas.equals("szaraztap") || utasitas.equals("csont") || utasitas.equals("hazikoszt")
                    || utasitas.equals("viz") || utasitas.equals("konzerv") || utasitas.equals("energydrink")
                    || utasitas.equals("kishk") || utasitas.equals("nagyhk") || utasitas.equals("allatorvos")
                    || utasitas.equals("maxital")|| utasitas.equals("SAVE")|| utasitas.equals("LOAD")
                    || utasitas.equals("SLEEP") || utasitas.equals("heal")|| utasitas.equals("NEW"))){

                System.err.println("Kérlek helyes utasításokat adj meg!");
            }
            if(utasitas.equals("wtd") || utasitas.equals("bath") ||
                    utasitas.equals("seta") || utasitas.equals("labda") || utasitas.equals("iskola") ||
                    utasitas.equals("park") || utasitas.equals("ujsag") || utasitas.equals("rex") ||
                    utasitas.equals("orzes")  || utasitas.equals("heal")
                    || utasitas.equals("kishk") || utasitas.equals("nagyhk") || utasitas.equals("allatorvos")
                    || utasitas.equals("maxital")){
                if(p1.getEnergia ()<10.0){
                    System.out.println (p1.getNev ()+" túl fáradt, csupán arra van energiája, hogy egyen, vagy aludjon.");
                    continue;
                }
            }

            if(utasitas.equals("stat") && p1.isTisztasag ()){
                System.out.println("**************************************STÁTUSZ**************************************");
                System.out.println("A kutyusod információi: ");
                System.out.println("Neve: "+p1.getNev() + ", gazdájának neve: "+p1.getTulajNev());
                System.out.println("$ - Vagyon: "+p1.getPenz()+" Ft.");
                System.out.println("♥ - Egészség: "+(int)p1.getEgeszseg()+"%, ⚡ - Energia: "+(int)p1.getEnergia()+"%, ☺ - Kedv: "+(int)p1.getKedv()+"%, ♨ - Jóllakottság: "+(int)p1.getJollakottsag()+"%, ⚠ - Rendetlenség: "+(int)p1.getRendetlenseg()+"%.");
                System.out.println("**************************************/STÁTUSZ**************************************");
            }

            if(utasitas.equals("wtd") && p1.getRendetlenseg()<40.0 && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("**************************************TEVÉKENYSÉGEK**************************************");
                System.out.println("Mivel kedvenced elég fegyelmezett, az alábbi tevékenységek közül választhatsz: ");
                System.out.println("JÁTÉKOK");
                System.out.println("seta - Sétáltatás - Ingyenes esti séta a kertvárosban. -10% energia, +4% egészség, +4% jókedv");
                System.out.println("labda - Labdás játék - Ingyenes, fárasztó, viszont jókedvet teremtő szórakozás az udvarban. -18% energia, -0-9% egészség, -5% rendetlenség, +6% jókedv");
                System.out.println("iskola - Kutyaiskola - Jelképes összegért színvonalas kutyaképzés, melytől a rendetlen kutyák is vigyázzba állnak! -10 Ft, -20% energia, +5% egészség, -50% rendetlenség");
                System.out.println("park - Játék a parkban - Ingyenes szórakozás, melynek keretein belül a helyi parkban játékosan képezzük a kedvencünket. -10% energia, +10% egészség, -10% rendetlenség, +5% jókedv");
                System.out.println("MUNKÁK");
                System.out.println("ujsag - Újságkihordás - Átlagosan fizető munka, bár nem is értem, hogy fér egy mopsz szájába újság. +50 Ft, -10% energia, -4% egészség, -2% jókedv");
                System.out.println("rex - Rendőri segítség - Mivel kutyusod szaglása páratlan lett a kísérlet során, a rendőrök szívesen igénybe vennék drogakcióik során. Egész jól fizet. +100 Ft, -25% energia, -0-15% egészség, -10% jókedv");
                System.out.println("orzes - Házőrzés - "+p1.getNev()+" rendkívül megbízható, emiatt szívesen fogadják fel házőrzésre ismerőseid. Vegyes a jutalom, de a befektetett energia is. +30-200 Ft, -8-30% energia, -10-20% egészség, -14% jókedv");
                System.out.println("**************************************/TEVÉKENYSÉGEK**************************************");

            }
            if(utasitas.equals("wtd") && p1.getRendetlenseg()>40.0 && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("**************************************TEVÉKENYSÉGEK**************************************");
                System.out.println("Mivel kedvenced eléggé fegyelmezetlen, csupán az alábbi tevékenységek közül választhatsz: ");
                System.out.println("JÁTÉKOK");
                System.out.println("seta - Sétáltatás - Ingyenes esti séta a kertvárosban. -10% energia, +4% egészség, +4% jókedv");
                System.out.println("labda - Labdás játék - Ingyenes, fárasztó, viszont jókedvet teremtő szórakozás az udvarban. -18% energia, -0-9% egészség, -5% rendetlenség, +6% jókedv");
                System.out.println("iskola - Kutyaiskola - Jelképes összegért színvonalas kutyaképzés, melytől a rendetlen kutyák is vigyázzba állnak! -10 Ft, -20% energia, +5% egészség, -50% rendetlenség");
                System.out.println("park - Játék a parkban - Ingyenes szórakozás, melynek keretein belül a helyi parkban játékosan képezzük a kedvencünket. -10% energia, +10% egészség, -10% rendetlenség, +5% jókedv");
                System.out.println("**************************************/TEVÉKENYSÉGEK**************************************");
            }
            if(utasitas.equals("eat") && p1.isTisztasag ()){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ÉTELEK/ITALOK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("jutifali - Jutalomfalatka - Ár: "+jutiFali.getAr()+" Ft, Következmények: +"+jutiFali.getTaplalas()+"% jóllakottság, +3% jókedv");
                System.out.println("szaraztap - Száraz kutyatáp - Ár: "+szarazTap.getAr()+" Ft, Következmények: +"+szarazTap.getTaplalas()+"% jóllakottság, -3% jókedv");
                System.out.println("csont - Csont - Ár: "+csont.getAr()+" Ft, Következmények: +"+csont.getTaplalas()+"% jóllakottság, +5% jókedv");
                System.out.println("hazikoszt - Házikoszt - Ár: "+haziKoszt.getAr()+" Ft, Következmények: +"+haziKoszt.getTaplalas()+"% jóllakottság, -1% jókedv");
                System.out.println("viz - Víz - Ár: "+viz.getAr()+" Ft, Következmények: +"+viz.getTaplalas()+"% jóllakottság, +1% jókedv");
                System.out.println("konzerv - Konzerv kutyaeledel - Ár: "+konzerves.getAr()+" Ft, Következmények: +"+konzerves.getTaplalas()+"% jóllakottság, -10% jókedv");
                System.out.println("energydrink - Kutya energiaital - Ár: "+kutyaEnergyDrink.getAr()+" Ft, Következmények: +"+kutyaEnergyDrink.getTaplalas()+"% jóllakottság, +"+kutyaEnergyDrink.getBoost()+"% energia, túlitatáskor -8% jókedv");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/ÉTELEK/ITALOK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            if(utasitas.equals("heal") && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘ÉLETCSOMAGOK˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘");
                System.out.println("kishk - Kisméretű életcsomag - Ár: "+kicsi.getArszabas()+" Ft, Következmények: +"+kicsi.getHealeles()+"% egészség");
                System.out.println("nagyhk - Nagyméretű életcsomag - Ár: "+nagy.getArszabas()+" Ft, Következmények: +"+nagy.getHealeles()+"% egészség");
                System.out.println("allatorvos - Állatorvosi vizsgálat - Ár: "+allatorvos.getArszabas()+" Ft, Következmények: "+allatorvos.getHealeles()+"% egészség");
                System.out.println("maxital - Maximalizáló életelixír - Ár: "+maxiItal.getArszabas()+" Ft, Következmények: "+maxiItal.getHealeles()+"%-ra állítja minden tulajdonságát kedvencünknek (óvatosan, a rendetlenséget is!)");
                System.out.println("˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘/ÉLETCSOMAGOK˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘");
            }
    //jatekok es munkak
            double energia1;
            double energia2;
            double egeszseg1;
            double egeszseg2;
            double rendetlenseg1;
            double rendetlenseg2;
            double kedv1;
            double kedv2;
            int befizetett1;
            int befizetett2;
            int profit1;
            int profit2;
            if(utasitas.equals("seta") && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                kedv1=p1.getKedv ();
                p1.setaltatas();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                kedv2=p1.getKedv ();
                double energia = energia1-energia2;
                double egeszseg = egeszseg2-egeszseg1;
                double kedv = kedv2-kedv1;
                System.out.println(p1.getNev()+" nagyon élvezte a sétáltatást! -"+(int)energia+"% energia, +"+(int)egeszseg+"% egészség, +"+(int)kedv+"% jókedv");
            }
            if(utasitas.equals("labda") && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                rendetlenseg1 = p1.getRendetlenseg();
                kedv1=p1.getKedv ();
                p1.labdaJatek();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                rendetlenseg2 = p1.getRendetlenseg();
                kedv2=p1.getKedv ();
                double energia = energia1-energia2;
                double egeszseg = egeszseg2-egeszseg1;
                double rendetlenseg = rendetlenseg1-rendetlenseg2;
                double kedv = kedv2-kedv1;
                System.out.println(p1.getNev()+" nagyon szeret veled labdázni, "+p1.getTulajNev()+"! -"+(int)energia+"% energia, +"+(int)egeszseg+"% egészség, -"+(int)rendetlenseg+"% rendetlenség, +"+(int)kedv+"% jókedv");
            }
            if(utasitas.equals("iskola") && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                rendetlenseg1 = p1.getRendetlenseg();
                befizetett1 = p1.getPenz();
                p1.kutyaIskola();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                rendetlenseg2 = p1.getRendetlenseg();
                befizetett2 = p1.getPenz();
                double energia = energia1-energia2;
                double egeszseg = egeszseg2-egeszseg1;
                double rendetlenseg = rendetlenseg1-rendetlenseg2;
                int befizetett = befizetett1-befizetett2;
                System.out.println("A kutyaiskola ugyan fárasztó "+p1.getNev()+" számára, mégis sikeresen vette az akadályokat. -"+befizetett+" Ft, -"+(int)energia+"% energia, +"+(int)egeszseg+"% egészség, -"+(int)rendetlenseg+"% rendetlenség");
            }
            if(utasitas.equals("park") && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                rendetlenseg1 = p1.getRendetlenseg();
                kedv1=p1.getKedv ();
                p1.jatekParkban();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                rendetlenseg2 = p1.getRendetlenseg();
                kedv2=p1.getKedv ();
                double energia = energia1-energia2;
                double egeszseg = egeszseg2-egeszseg1;
                double rendetlenseg = rendetlenseg1-rendetlenseg2;
                double kedv = kedv2-kedv1;
                System.out.println("A park szabadsága lehetővé teszi, hogy "+p1.getNev()+" kitombolhassa magát. +"+(int)energia+"% energia, +"+(int)egeszseg+"% egészség, -"+(int)rendetlenseg+"% rendetlenség, +"+(int)kedv+"% jókedv");
            }
            //*************
            if(utasitas.equals("ujsag") && p1.getRendetlenseg()<40.0 && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                profit1=p1.getPenz();
                kedv1=p1.getKedv ();
                p1.ujsagKihordas();
                profit2=p1.getPenz();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                kedv2=p1.getKedv ();
                int profit=profit2-profit1;
                double energia = energia1-energia2;
                double egeszseg = egeszseg1-egeszseg2;
                double kedv = kedv1-kedv2;
                if(p1.getEgeszseg ()<=0.0 || p1.getKedv ()<=0.0){
                    System.out.println (p1.getNev ()+" újságkihordás közben nem figyelt a felé sebesen közeledő H3-as Hummerre...");
                }else{
                    System.out.println("Ugyan "+p1.getNev()+" mopsz méretű szájába nem sok vaskos újság fér, megtanult a hátán lévő táskából újságokat dobálni! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egészség, -"+(int)kedv+"% jókedv");
                }
            }
            if(utasitas.equals("ujsag") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced túl szófogadatlan ahhoz, hogy munkát vállaljon!");
            }
            if(utasitas.equals("rex") && p1.getRendetlenseg()<40.0 && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                profit1=p1.getPenz();
                kedv1=p1.getKedv ();
                p1.rendoriSegitseg();
                profit2=p1.getPenz();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                kedv2=p1.getKedv ();
                int profit=profit2-profit1;
                double energia = energia1-energia2;
                double egeszseg = egeszseg1-egeszseg2;
                double kedv = kedv1-kedv2;
                if(p1.getEgeszseg ()<=0.0 || p1.getKedv ()<=0.0){
                    System.out.println ("Azt hiszem, ez volt "+p1.getNev ()+" utolsó bevetése...");
                }else{
                    System.out.println("Annak ellenére, hogy "+p1.getNev()+" elég kicsi, a szimata kiváló, emiatt könnyen kiszagolta a kokaint! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egészség, -"+(int)kedv+"% jókedv");
                }
            }
            if(utasitas.equals("rex") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced túl szófogadatlan ahhoz, hogy munkát vállaljon!");
            }
            if(utasitas.equals("orzes") && p1.getRendetlenseg()<40.0 && p1.getEnergia()>10 && p1.isTisztasag ()){
                energia1 = p1.getEnergia();
                egeszseg1 = p1.getEgeszseg();
                profit1=p1.getPenz();
                kedv1=p1.getKedv ();
                p1.hazOrzes();
                profit2=p1.getPenz();
                energia2 = p1.getEnergia();
                egeszseg2 = p1.getEgeszseg();
                kedv2=p1.getKedv ();
                int profit=profit2-profit1;
                double energia = energia1-energia2;
                double egeszseg = egeszseg1-egeszseg2;
                double kedv = kedv1-kedv2;
                if(p1.getEgeszseg ()<=0.0 || p1.getKedv ()<=0.0){
                    System.out.println (p1.getNev ()+" a házőrzés során pórul járt...");
                }else{
                    System.out.println("Hiába, nem méret kérdése a hangerő! "+p1.getNev()+" olyan hangosan ugatta meg a betörőket, hogy azt is otthagyták, amit magukkal vittek! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egészség, -"+(int)kedv+"% jókedv");
                }
            }
            if(utasitas.equals("orzes") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced túl szófogadatlan ahhoz, hogy munkát vállaljon!");
            }
    //kajalas
            if(utasitas.equals("jutifali") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ jutiFali.getTaplalas());
                p1.setPenz(p1.getPenz()- jutiFali.getAr());
                p1.setKedv (p1.getKedv ()+3.0);
                System.out.println(p1.getNev()+": Hmmm... fincsi! -"+jutiFali.getAr()+" Ft, +"+jutiFali.getTaplalas()+"% jóllakottság, +3% jókedv");
            }
            if(utasitas.equals("szaraztap") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ szarazTap.getTaplalas());
                p1.setPenz(p1.getPenz()- szarazTap.getAr());
                p1.setKedv (p1.getKedv ()-3.0);
                System.out.println(p1.getNev()+": Átlagos zaba egy átlagos napon... legalább a nap besüt az ablakon! -"+szarazTap.getAr()+" Ft, +"+szarazTap.getTaplalas()+"% jóllakottság, -2% jókedv");
            }
            if(utasitas.equals("csont") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ csont.getTaplalas());
                p1.setPenz(p1.getPenz()- csont.getAr());
                p1.setKedv (p1.getKedv ()+5.0);
                System.out.println(p1.getNev()+": Ettől igazán alfának érzem magam! -"+csont.getAr()+" Ft, +"+csont.getTaplalas()+"% jóllakottság, +5% jókedv");
            }
            if(utasitas.equals("hazikoszt") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ haziKoszt.getTaplalas());
                p1.setPenz(p1.getPenz()- haziKoszt.getAr());
                p1.setKedv (p1.getKedv ()-1.0);
                System.out.println(p1.getNev()+": Csóró... de legalább valamit én is kapok! -"+haziKoszt.getAr()+" Ft, +"+haziKoszt.getTaplalas()+"% jóllakottság, -1% jókedv");
            }
            if(utasitas.equals("viz") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ viz.getTaplalas());
                p1.setPenz(p1.getPenz()- viz.getAr());
                p1.setKedv (p1.getKedv ()+1.0);
                System.out.println(p1.getNev()+": Ennek a víznek ma különösen finom íze van! -"+viz.getAr()+" Ft, +"+viz.getTaplalas()+"% jóllakottság, +1% jókedv");
            }
            if(utasitas.equals("konzerv") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ konzerves.getTaplalas());
                p1.setPenz(p1.getPenz()- konzerves.getAr());
                p1.setKedv (p1.getKedv ()-10.0);
                System.out.println(p1.getNev()+": Nem tudtam, hogy nukleáris háborúra készülünk... -"+konzerves.getAr()+" Ft, +"+konzerves.getTaplalas()+"% jóllakottság, -10% jókedv");
            }
            if(utasitas.equals("energydrink") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ kutyaEnergyDrink.getTaplalas());
                p1.setEnergia(p1.getEnergia()+ kutyaEnergyDrink.getBoost());
                p1.setPenz(p1.getPenz()- kutyaEnergyDrink.getAr());
                p1.setMajAllapot (p1.getMajAllapot ()+1);
                if(p1.getMajAllapot ()>3){
                    p1.setKedv (p1.getKedv ()-8.0);
                    System.out.println (p1.getNev()+":Annyira nem érzem már jól magam ettől, "+p1.getTulajNev ()+"... -"+kutyaEnergyDrink.getAr()+" Ft, +"+kutyaEnergyDrink.getTaplalas()+"% jóllakottság, +"+kutyaEnergyDrink.getBoost()+"% energia, -8% jókedv");
                }else{
                    System.out.println(p1.getNev()+": Csak a májam meg ne bánja! -"+kutyaEnergyDrink.getAr()+" Ft, +"+kutyaEnergyDrink.getTaplalas()+"% jóllakottság, +"+kutyaEnergyDrink.getBoost()+"% energia");
                }
            }
    //eletcsomagok
            if(utasitas.equals("kishk") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(p1.getEgeszseg()+ kicsi.getHealeles());
                p1.setPenz(p1.getPenz()- kicsi.getArszabas());
                System.out.println("-"+kicsi.getArszabas()+" Ft, +"+kicsi.getHealeles()+"% egészség");
            }
            if(utasitas.equals("nagyhk") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(p1.getEgeszseg()+ nagy.getHealeles());
                p1.setPenz(p1.getPenz()- nagy.getArszabas());
                System.out.println("-"+nagy.getArszabas()+" Ft, +"+nagy.getHealeles()+"% egészség");
            }
            if(utasitas.equals("allatorvos") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                double szuri = 10.0;
                int maj = 300;
                p1.setEgeszseg(allatorvos.getHealeles());
                p1.setPenz(p1.getPenz()- allatorvos.getArszabas());
                p1.setKedv(p1.getKedv()-szuri);
                if(p1.getMajAllapot ()>3){
                    p1.setMajAllapot (0);
                    p1.setPenz (p1.getPenz ()-maj);
                    System.out.println("Kedvenced a szuri mellett átesett egy feláras májátültetésen is. -"+(maj+allatorvos.getArszabas ())+" Ft, -"+(int)szuri+"% kedv, +"+nagy.getHealeles()+"% egészség");
                }else{
                    System.out.println("Kedvenced kapott egy szurit, aminek nem annyira örült. -"+nagy.getArszabas()+" Ft, -"+szuri+"% kedv, +"+nagy.getHealeles()+"% egészség");
                }

            }
            if(utasitas.equals("maxital") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(maxiItal.getHealeles());
                p1.setEnergia(maxiItal.getHealeles());
                p1.setJollakottsag(maxiItal.getHealeles());
                p1.setKedv(maxiItal.getHealeles());
                p1.setRendetlenseg(maxiItal.getHealeles());
                p1.setPenz(p1.getPenz()- maxiItal.getArszabas());
                System.out.println(p1.getNev()+" benyakalta az egész elixírt, amitől nagyon virgonc lett, minden tekintetben! -"+maxiItal.getArszabas()+" Ft, minden tulajdonság "+maxiItal.getHealeles()+"%-ra töltve.");
            }

            //mentes
            if(utasitas.equals("SAVE") && p1.isTisztasag ()){
                boolean helyesMentes = false;
                mentesNeve="";
                System.out.println("Kérlek írd be, hogy mi legyen a mentésed neve! (max. 12 karakter!)");
               while(!helyesMentes){
                   mentesNeve=sc.nextLine ();
                   if(!mentesNeve.matches ("[a-záéíóúöüőűA-ZÁÉÍÓÚÖÜŐŰ]+")){
                       System.err.println ("Kérlek, a mentésed a magyar ABC betűiből álljon, szóközt ne tartalmazzon és maximum 12 karakter hosszúságú legyen!");
                   }else if(mentesNeve.length ()<1 || mentesNeve.length ()>12){
                    System.err.println ("Kérlek, a mentésed a magyar ABC betűiből álljon, szóközt ne tartalmazzon és maximum 12 karakter hosszúságú legyen!");
                } else{
                       helyesMentes=true;
                   }
               }
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("./mentesek/"+mentesNeve+".txt"));
                    bw.write(""+p1.getTulajNev());
                    bw.newLine();
                    bw.write(""+p1.getNev());
                    bw.newLine();
                    bw.write(""+korszam);
                    bw.newLine();
                    bw.write(""+p1.getPenz());
                    bw.newLine();
                    bw.write(""+p1.getEgeszseg());
                    bw.newLine();
                    bw.write(""+p1.getEnergia());
                    bw.newLine();
                    bw.write(""+p1.getKedv());
                    bw.newLine();
                    bw.write(""+p1.getJollakottsag());
                    bw.newLine();
                    bw.write(""+p1.getRendetlenseg());
                    bw.newLine ();
                    bw.write (""+p1.getMajAllapot ());

                    bw.close();

                } catch (IOException e) {
                    System.err.println("Oops! Hiba történt a játék mentésekor!");
                    continue;
                }
                System.out.println("Játék sikeresen elmentve!");
                continue;
            }

    //kor vege
            if(utasitas.equals("SLEEP") && p1.isTisztasag ()){
                korszam++;
                double maxEngyPlus = 50.0;
                double minEngyPlus = 30.0;
                int ennyivelNoAlvastolAzEnergia = (int) Math.floor(Math.random()*(maxEngyPlus-minEngyPlus+1)+minEngyPlus);
                p1.setEnergia(p1.getEnergia()+ennyivelNoAlvastolAzEnergia);
                p1.setJollakottsag(p1.getJollakottsag()-8.0);
                p1.setEgeszseg(p1.getEgeszseg()-5.0);
                if(korszam<100 && p1.getEgeszseg ()>0.0 && p1.getKedv ()>0.0){
                    System.out.println("Egy új nap virrad, "+p1.getNev()+" pedig kipihenten, de éhesen kel fel (ja, és egy nappal öregebben is). +"+ennyivelNoAlvastolAzEnergia+"% energia, -8% jóllakottság, -5% egészség");
                }
                if((p1.getMajAllapot () > 3 && p1.getEgeszseg ()>0.0) || (p1.getEgeszseg () < 30.0 && p1.getEgeszseg ()>0.0) && korszam<100){
                    System.out.println ("Lehet, kicsit jobban oda kéne figyelned "+p1.getNev ()+" egészségére... el kellene vinni egy állatorvoshoz...");
                }
                Random tisztasag = new Random();
                int slotMachine = 100;
                int dontoErtek = tisztasag.nextInt(slotMachine);
                p1.setTisztasag(dontoErtek >= 40);
                continue;
            }
            if(utasitas.equals("QUIT")){
                System.out.println("Köszönöm, hogy játszottál!");
                break;
            }
            if(utasitas.equals("LOAD") && p1.isTisztasag ()){
                    System.out.println("Üdv a mentéseknél!");
                    File mentesekMappaja = new File("./mentesek/");
                    File[] tartalom = mentesekMappaja.listFiles();
                    if(tartalom==null){

                    }else if(tartalom.length==0){
                        System.out.println("Sajnálom, de a mentések mappa nem tartalmaz mentéseket!");
                        System.out.println();
                        System.out.println("A megkezdett játékod folytatásához írd be, hogy CONTINUE");
                        System.out.println("A játékból való kilépéshez kérlek írd be, hogy QUIT");
                        utasitas=sc.nextLine();
                        while(!(utasitas.equals ("CONTINUE") || utasitas.equals ("QUIT"))){
                            System.err.println ("Kérlek, csupán az alábbi parancsokat használd!");
                            System.out.println("A megkezdett játékod folytatásához írd be, hogy CONTINUE");
                            System.out.println("A játékból való kilépéshez kérlek írd be, hogy QUIT");
                            utasitas=sc.nextLine();
                        }
                        if(utasitas.equals ("QUIT")){
                            System.out.println("Köszönöm, hogy játszottál!");
                            break;
                        }
                        continue;
                    }else {
                        System.out.println("Az alábbi mentéseket találtam. Írd be a megnyitni kívánt mentés nevét a .txt nélkül!");
                        File eleresiUt = new File("./mentesek/");
                        File[] fajlok = eleresiUt.listFiles((dir, name) -> name.endsWith(".txt"));
                        Set<String> mentesNevek= new HashSet<>();
                        if (fajlok != null) {
                            for(File file: fajlok){
                                System.out.println(file.getName());
                                mentesNevek.add (file.getName ());
                            }
                        }
                        toltesNeve=sc.nextLine();
                        while(!mentesNevek.contains (toltesNeve+".txt")){
                            System.err.println("Valid mentésnevet adj meg, kiterjesztés nélkül!");
                            System.err.flush();
                            toltesNeve=sc.nextLine ();
                        }
                        BufferedReader br;
                        try {
                            br = new BufferedReader(new FileReader("./mentesek/"+toltesNeve+".txt"));
                            p1.setTulajNev(br.readLine());
                            p1.setNev(br.readLine());
                            korszam = Integer.parseInt(br.readLine());
                            p1.setPenz(Integer.parseInt(br.readLine()));
                            p1.setEgeszseg(Double.parseDouble(br.readLine()));
                            p1.setEnergia(Double.parseDouble(br.readLine()));
                            p1.setKedv(Double.parseDouble(br.readLine()));
                            p1.setJollakottsag(Double.parseDouble(br.readLine()));
                            p1.setRendetlenseg(Double.parseDouble(br.readLine()));
                            p1.setMajAllapot (Integer.parseInt(br.readLine ()));
                            br.close();
                            System.out.println("Sikeres betöltés!");
                            System.out.println("Üdv újra itt, "+p1.getTulajNev()+", "+p1.getNev()+"!");
                        } catch (IOException e) {
                            System.err.println("Oops! Hiba történt a mentésed beolvasásakor!");
                            continue;
                        }
                    }
                    continue;

            }
            if(utasitas.equals("NEW")){
                while(true){
                System.out.println("Üdvözöllek újra a karakterkészítésnél! Kérlek írd le, mi legyen a nem magárahagyott, de ugyan úgy nukleáris töltésű kutyusod neve!");
                    boolean helyesNev=false;
                    while(!helyesNev){
                        p1.setNev(sc.nextLine());
                        if(!p1.getNev ().matches ("[a-záéíóúöüőűA-ZÁÉÍÓÚÖÜŐŰ\\s]+")){
                            System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj kedvencednek!");
                        }else if(p1.getNev ().length ()<1 || p1.getNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                            System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj kedvencednek!");
                        } else{
                            helyesNev=true;
                        }
                    }
                System.out.println("A kutyusod új neve: "+p1.getNev());
                System.out.println("Kérlek írd le újra a saját neved! (Gazdi neve)");
                    boolean helyesTulajNev=false;
                    while(!helyesTulajNev){
                        p1.setTulajNev (sc.nextLine());
                        if(!p1.getTulajNev ().matches ("[a-záéíóúöüőűA-ZÁÉÍÓÚÖÜŐŰ\\s]+")){
                            System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj új inkognitódnak!");
                        }else if(p1.getTulajNev ().length ()<1 || p1.getTulajNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                            System.err.println ("Kérlek egy maximum 12 karakterből álló, csak a magyar ABC betűiből álló nevet adj új inkognitódnak!");
                        } else{
                            helyesTulajNev=true;
                        }
                    }
                korszam=1;
                p1.setPenz(1500);
                p1.setEgeszseg(62.0);
                p1.setEnergia(62.0);
                p1.setJollakottsag(62.0);
                p1.setRendetlenseg(62.0);
                p1.setKedv(62.0);
                p1.setMajAllapot (0);
                System.out.println("A gazdi új neve: "+p1.getTulajNev());
                System.out.println("**************************************************************************************");
                System.out.println("A kutyusod új adatai: ");
                System.out.println("Neve: "+p1.getNev());
                System.out.println("Tulajdonosának neve: "+p1.getTulajNev());
                System.out.println("Vagyonotok: "+p1.getPenz()+" Ft (Default)");
                System.out.println("A kutyusod egészsége: "+p1.getEgeszseg()+"% (Default)");
                System.out.println("A kutyusod energiája: "+p1.getEnergia()+"% (Default)");
                System.out.println("A kutyusod kedve: "+p1.getKedv()+"% (Default)");
                System.out.println("A kutyusod jóllakottsága: "+p1.getJollakottsag()+"% (Default)");
                System.out.println("A kutyusod rendetlensége: "+p1.getRendetlenseg()+"% (Default)");
                System.out.println("**************************************************************************************");
                System.out.println("Amennyiben elégedett vagy a beírt adatokkal, írd be, hogy GO");
                System.out.println("Ellenkező esetben írd be, hogy RE");

                    indulas=sc.nextLine();

                    if(indulas.equals("GO")){
                        break;
                    }
                    if(!indulas.equals ("RE"))
                    System.err.println("Helyes parancsokat használj!");
                }
                System.out.println("🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕 JÁTÉK INDUL 🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕🐕");
            }
        }
        if(korszam<100 && p1.getPenz()>=10000 && p1.getEgeszseg ()>0.0 && p1.getKedv ()>0.0 && p1.getMajAllapot ()<10){
            System.out.println("Gratulálok! Te, "+p1.getTulajNev()+" és hűséges társad, "+p1.getNev()+" megnyertétek a játékot! Kemény munkátokkal összegyűjtöttétek a további kutatáshoz és a kutyaházhoz szükséges vagyont!");
            System.out.println ("A világ köszönettel tartozik hősies küzdelmetekért! Ígérjük, nem adjuk tovább a technológiát fegyverneppereknek és egyéb veszélyes alakoknak!");
        }
        if(korszam>100 && p1.getEgeszseg ()>0.0 && p1.getKedv ()>0.0 && p1.getMajAllapot ()<10){
            System.out.println("Sajnáljuk, de a játék számotokra véget ért, "+p1.getTulajNev()+" és "+p1.getNev()+"! Meghaladtátok a maximum számú kört, de nem értétek el a kutatások folytatásához szükséges összeget. Nekünk annyi.");
            System.out.println ("GAME OVER");
        }
        if(p1.getMajAllapot ()>=10 && p1.getKedv ()>0.0 && p1.getEgeszseg ()>0.0){
            System.out.println ("Jajj ne... "+p1.getNev ()+" túl sok energiaitalt ivott, és annyira májkárosult lett, hogy elpusztult! Nekünk a...");
            System.out.println ("GAME OVER");
        }
        if(p1.getPenz ()<10000 && p1.getKedv ()<=0.0 && p1.getEgeszseg ()>0.0){
            System.out.println (p1.getNev ()+" annyira bedepizett, hogy úgy döntött, ennek a világnak pusztulnia kell. Eljött a vég. *BUMM*");
            System.out.println ("GAME OVER");
        }
        if(p1.getPenz ()<10000 && p1.getEgeszseg ()<=0.0){
            System.out.println (p1.getTulajNev ()+"... egyetlen dolgod volt, mégpedig az, hogy életben tartsd kedvenced! Miattad mind megha...");
            System.out.println ("GAME OVER");
        }
    }

}
