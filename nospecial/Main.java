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
        System.out.println(". . . Udvozollek a Pug-a-gotchiban! . . .");
        System.out.println();
        System.out.println("Udv, itt a regi baratod, PugChamp professzor! En leszek a segitod a kutyusnevelesben!");
        System.out.println ("Kiskedvenced egy korabbi kiserlet soran bionuklearis tomegpusztito fegyverre valt.");
        System.out.println ("Ha baj vagy szomorusag eri, instabilla valik es maga korul mindent megsemmisit 100 kilometeres sugaru korben!");
        System.out.println ("A kiserlet soran tobb nemzetkozi biztonsagi szerv felfigyelt a kulonos tevekenysegeinkre, a kutyahaz pedig kitorlodott a ter-ido kontinuumbol.");
        System.out.println ("A cel, hogy osszegyujts huseges tarsad segitsegevel 10 000 Ft-ot a titkos projekt folytatasara, hogy hatastalanithassuk a fegyvert.");
        System.out.println ("(Meg persze egy uj kutyahazra...)");
        System.out.println ("VIGYAZZ! Ha kedvenced egeszsege vagy kedve 0%-ra csokken, mindannyiunknak annyi!");
        System.out.println();
        System.out.println("- Ha egy korabbi mentesed szeretned folytatni, ird be, hogy LOAD");
        System.out.println("- Uj jatek inditasahoz kerlek ird be, hogy START");
        System.out.println("- A jatekbol valo kilepeshez kerlek ird be, hogy QUIT");
        System.out.println ();
        String indulas;
        while(!(kezdes.equals ("START") || kezdes.equals ("LOAD") || kezdes.equals ("QUIT"))){
            System.out.println ("Kerlek, csak a felsorolt parancsokat hasznald!");
            kezdes = sc.nextLine();
        }
    while (true){
        if(kezdes.equals("QUIT")) {
            System.out.println("Koszonom, hogy jatszottal!");
            return;
        }
        if(kezdes.equals("LOAD")){
            File mentesekMappaja = new File("./mentesek/");
            File[] tartalom = mentesekMappaja.listFiles();
            if(tartalom==null){

            }else if(tartalom.length==0){
                System.out.println("Sajnalom, de a mentesek mappa nem tartalmaz menteseket!");
                System.out.println();
                System.out.println("Uj jatek inditasahoz kerlek ird be, hogy START");
                System.out.println("A jatekbol valo kilepeshez kerlek ird be, hogy QUIT");
                System.out.println ();
                while(!(kezdes.equals ("START") || kezdes.equals ("QUIT"))){
                    System.out.println ("Kerlek, csak a felsorolt parancsokat hasznald!");
                    kezdes = sc.nextLine();
                }
                continue;

            }else {
            System.out.println("Az alabbi menteseket talaltam. Ird be a megnyitni kivant mentes nevet a .txt nelkul!");
            File eleresiUt = new File("./mentesek/");
            System.out.println (mentesekMappaja.getAbsolutePath ());
            System.out.println (eleresiUt.getAbsolutePath ());
            File[] fajlok = eleresiUt.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
                if (fajlok != null) {
                    for(File file: fajlok){
                        System.out.println(file.getName());
                    }
                }
                toltesNeve=sc.nextLine();
            if(toltesNeve.contains(".txt")){
                System.err.println("Kerlek, hogy a fajlkiterjesztest mellozve ird be a megnyitni kivant mentes nevet!");
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
                System.out.println("Sikeres betoltes!");
                System.out.println("Udv ujra itt, "+p1.getTulajNev()+", "+p1.getNev()+"!");
            } catch (IOException e) {
                System.err.println("Oops! Hiba tortent a mentesed beolvasasakor! Valid mentesnevet adj meg!");
                continue;
            }
            }
                break;
        }
        indulas="";
        System.out.println("Udvozollek a jatekban! Mi is volt a kutyusod neve?");
        boolean helyesNev=false;
        while(!helyesNev){
            p1.setNev(sc.nextLine());
            if(!p1.getNev ().matches ("[a-zA-Z\\s]+")){
                System.err.println ("Kerlek egy maximum 12 karakterbol allo ekezetek nelkuli nevet adj kedvencednek!");
            }else if(p1.getNev ().length ()<1 || p1.getNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                System.err.println ("Kerlek egy maximum 12 karakterbol allo ekezetek nelkuli nevet adj kedvencednek!");
            } else{
                helyesNev=true;
            }
        }
        System.out.println("A kutyusod neve: "+p1.getNev());
        System.out.println("Ha veletlen te is torlodnel az ismert vilagbol, azert add meg a neved, hogy megemlekezhessunk rolad!");
        boolean helyesTulajNev=false;
        while(!helyesTulajNev){
            p1.setTulajNev (sc.nextLine());
            if(!p1.getTulajNev ().matches ("[a-zA-Z\\s]+")){
                System.err.println ("Kerlek egy maximum 12 karakterbol allo ekezetek nelkuli nevet adj magadnak!");
            }else if(p1.getTulajNev ().length ()<1 || p1.getTulajNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                System.err.println ("Kerlek egy maximum 12 karakterbol allo ekezetek nelkuli nevet adj magadnak!");
            } else{
                helyesTulajNev=true;
            }
        }
        System.out.println("A gazdi neve: "+p1.getTulajNev());
        System.out.println("**************************************************************************************");
        System.out.println("A kutyusod adatai: ");
        System.out.println("Neve: "+p1.getNev());
        System.out.println("Tulajdonosanak neve: "+p1.getTulajNev());
        System.out.println("Vagyonotok: "+p1.getPenz()+" Ft (Default)");
        System.out.println("A kutyusod egeszsege: "+p1.getEgeszseg()+"% (Default)");
        System.out.println("A kutyusod energiaja: "+p1.getEnergia()+"% (Default)");
        System.out.println("A kutyusod kedve: "+p1.getKedv()+"% (Default)");
        System.out.println("A kutyusod jollakottsaga: "+p1.getJollakottsag()+"% (Default)");
        System.out.println("A kutyusod rendetlensege: "+p1.getRendetlenseg()+"% (Default)");
        System.out.println("**************************************************************************************");
        System.out.println("Amennyiben elegedett vagy a beirt adatokkal, ird be, hogy GO");
        System.out.println("Ellenkezo esetben ird be, hogy RE");
        while(!(indulas.equals("RE"))){
            indulas=sc.nextLine();

        if(indulas.equals("RE")){
            continue;
        }
        if(indulas.equals("GO")){
            break;
        }
        System.err.println("Helyes parancsokat hasznalj!");
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
        System.out.println("........... JATEK INDUL! ...........");
        while(korszam<100 || p1.getPenz()<=10000 || p1.getMajAllapot ()<10 || p1.getEgeszseg ()>0.0 || p1.getKedv ()>0.0){
            System.out.println("__________ "+korszam+". kor __________");
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
            System.out.println("A kutyusodat piszkos lett az elozo kor alatt! Eloszor meg kell furdetned! Ehhez ird be: bath");
            }else{
                if(p1.getEnergia()<10.0){
                    System.out.println("Vagyon: "+p1.getPenz()+" Ft, Egeszseg: "+(int)p1.getEgeszseg()+"%, Energia: "+(int)p1.getEnergia()+"%, Kedv: "
                            +(int)p1.getKedv()+"%, Jollakottsag: "+(int)p1.getJollakottsag()+"%, Rendetlenseg: "+(int)p1.getRendetlenseg()+"%");
                    System.out.println();
                    System.out.println("! Kutyusod elfaradt ebben a korben. Etesd meg vagy fektesd le aludni, utobbival uj kort kezdve !");
                    System.out.println();
                    System.out.println("- Reszletes statuszlekereshez es jelmagyarazathoz ird be: stat");
                    System.out.println("- Az elelmek megtekintesehez ird be: eat");
                    System.out.println("Elelemparancsok: jutifali, szaraztap, csont, hazikoszt, viz, konzerv, energydrink");
                    System.out.println();
                    System.out.println("- Foparancsok: Kovetkezo kor: SLEEP - Jatek mentese: SAVE - Mentes betoltese: LOAD - Uj jatek kezdese: NEW - Kilepes mentes nelkul: QUIT");

                }else{
                    System.out.println("Vagyon: "+p1.getPenz()+" Ft, Egeszseg: "+(int)p1.getEgeszseg()+"%, Energia: "+(int)p1.getEnergia()+"%, Kedv: "
                            +(int)p1.getKedv()+"%, Jollakottsag: "+(int)p1.getJollakottsag()+"%, Rendetlenseg: "+(int)p1.getRendetlenseg()+"%");
                    System.out.println();
                    System.out.println("- Reszletes statuszlekereshez es jelmagyarazathoz ird be: stat");
                    System.out.println("- A kutyusod altal a korben elvegezheto tevekenysegek listajaert ird be: wtd");
                    System.out.println("- Az elelmek megtekintesehez ird be: eat");
                    System.out.println("- Az eletcsomagok megtekintesehez ird be: heal");
                    System.out.println();
                    System.out.println("- Tevekenysegparancsok - Jatekok: seta, labda, iskola, park | Munkak: ujsag, rex, orzes");
                    System.out.println("- Elelemparancsok: jutifali, szaraztap, csont, hazikoszt, viz, konzerv, energydrink");
                    System.out.println("- Eletcsomagok parancsai: kishk, nagyhk, allatorvos, maxital");
                    System.out.println();
                    System.out.println("- Foparancsok: Kovetkezo kor: SLEEP - Jatek mentese: SAVE - Mentes betoltese: LOAD - Uj jatek kezdese: NEW - Kilepes mentes nelkul: QUIT");
                }

            }

            utasitas=sc.nextLine();

            if(utasitas.equals("bath")){
                p1.furdetes();
                System.out.println("Kutyusod mostantol csillog es villog!");
            }
            if(utasitas.equals("QUIT") && !p1.isTisztasag ()){
                System.out.println("! Legalabb furdesd meg azt a szerencsetlen kutyat, mielott magara hagyod !");
                continue;
            }
           // cheatkód teszteléshez
//            if(utasitas.equals ("cheatpenz")){
//             p1.setPenz (9999);
//          }
//          if(utasitas.equals ("cheatkor")){
//               korszam=99;
//           }
//            if(utasitas.equals ("cheategeszseg")){
//                p1.setEgeszseg (1.0);
//            }
//            if(utasitas.equals ("cheatkedv")){
//                p1.setKedv (1.0);
//            }
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

                System.err.println("Kerlek helyes utasitasokat adj meg!");
            }
            if(utasitas.equals("wtd") || utasitas.equals("bath") ||
                    utasitas.equals("seta") || utasitas.equals("labda") || utasitas.equals("iskola") ||
                    utasitas.equals("park") || utasitas.equals("ujsag") || utasitas.equals("rex") ||
                    utasitas.equals("orzes")  || utasitas.equals("heal")
                    || utasitas.equals("kishk") || utasitas.equals("nagyhk") || utasitas.equals("allatorvos")
                    || utasitas.equals("maxital")){
                if(p1.getEnergia ()<10.0){
                    System.out.println (p1.getNev ()+" tul faradt, csupan arra van energiaja, hogy egyen, vagy aludjon.");
                    continue;
                }
            }

            if(utasitas.equals("stat") && p1.isTisztasag ()){
                System.out.println("**************************************STATUSZ**************************************");
                System.out.println("A kutyusod informacioi: ");
                System.out.println("Neve: "+p1.getNev() + ", gazdajanak neve: "+p1.getTulajNev());
                System.out.println(" - Vagyon: "+p1.getPenz()+" Ft.");
                System.out.println("- Egeszseg: "+(int)p1.getEgeszseg()+"%, - Energia: "+(int)p1.getEnergia()+"%, - Kedv: "+(int)p1.getKedv()+"%, - Jóllakottság: "+(int)p1.getJollakottsag()+"%, - Rendetlenség: "+(int)p1.getRendetlenseg()+"%.");
                System.out.println("**************************************/STATUSZ**************************************");
            }

            if(utasitas.equals("wtd") && p1.getRendetlenseg()<40.0 && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("**************************************TEVEKENYSEGEK**************************************");
                System.out.println("Mivel kedvenced eleg fegyelmezett, az alabbi tevekenysegek kozul valaszthatsz: ");
                System.out.println("JATEKOK");
                System.out.println("seta - Setaltatas - Ingyenes esti seta a kertvarosban. -10% energia, +4% egeszseg, +4% jokedv");
                System.out.println("labda - Labdas jatek - Ingyenes, faraszto, viszont jokedvet teremto szorakozas az udvarban. -18% energia, -0-9% egeszseg, -5% rendetlenseg, +6% jokedv");
                System.out.println("iskola - Kutyaiskola - Jelkepes osszegert szinvonalas kutyakepzes, melytol a rendetlen kutyak is vigyazzba allnak! -10 Ft, -20% energia, +5% egeszseg, -50% rendetlenseg");
                System.out.println("park - Jatek a parkban - Ingyenes szorakozas, melynek keretein belul a helyi parkban jatekosan kepezzuk a kedvencunket. -10% energia, +10% egeszseg, -10% rendetlenseg, +5% jokedv");
                System.out.println("MUNKAK");
                System.out.println("ujsag - Ujsagkihordas - Atlagosan fizeto munka, bar nem is ertem, hogy fer egy mopsz szajaba ujsag. +50 Ft, -10% energia, -4% egeszseg, -2% jokedv");
                System.out.println("rex - Rendori segitseg - Mivel kutyusod szaglasa paratlan lett a kiserlet soran, a rendorok szivesen igenybe vennek drogakcioik soran. Egesz jol fizet. +100 Ft, -25% energia, -0-15% egeszseg, -10% jokedv");
                System.out.println("orzes - Hazorzes - "+p1.getNev()+" rendkivul megbizhato, emiatt szivesen fogadjak fel hazorzesre ismeroseid. Vegyes a jutalom, de a befektetett energia is. +30-200 Ft, -8-30% energia, -10-20% egeszseg, -14% jokedv");
                System.out.println("**************************************/TEVEKENYSEGEK**************************************");

            }
            if(utasitas.equals("wtd") && p1.getRendetlenseg()>40.0 && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("**************************************TEVEKENYSEGEK**************************************");
                System.out.println("Mivel kedvenced elegge fegyelmezetlen, csupan az alabbi tevekenysegek kozul valaszthatsz: ");
                System.out.println("JATEKOK");
                System.out.println("seta - Setaltatas - Ingyenes esti seta a kertvarosban. -10% energia, +4% egeszseg, +4% jokedv");
                System.out.println("labda - Labdas jatek - Ingyenes, faraszto, viszont jokedvet teremto szorakozas az udvarban. -18% energia, -0-9% egeszseg, -5% rendetlenseg, +6% jokedv");
                System.out.println("iskola - Kutyaiskola - Jelkepes osszegert szinvonalas kutyakepzes, melytol a rendetlen kutyak is vigyazzba allnak! -10 Ft, -20% energia, +5% egeszseg, -50% rendetlenseg");
                System.out.println("park - Jatek a parkban - Ingyenes szorakozas, melynek keretein belul a helyi parkban jatekosan kepezzuk a kedvencunket. -10% energia, +10% egeszseg, -10% rendetlenseg, +5% jokedv");
                System.out.println("**************************************/TEVEKENYSEGEK**************************************");
            }
            if(utasitas.equals("eat") && p1.isTisztasag ()){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ETELEK/ITALOK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("jutifali - Jutalomfalatka - Ar: "+jutiFali.getAr()+" Ft, Kovetkezmenyek: +"+jutiFali.getTaplalas()+"% jollakottsag, +3% jokedv");
                System.out.println("szaraztap - Szaraz kutyatap - Ar: "+szarazTap.getAr()+" Ft, Kovetkezmenyek: +"+szarazTap.getTaplalas()+"% jollakottsag, -3% jokedv");
                System.out.println("csont - Csont - Ar: "+csont.getAr()+" Ft, Kovetkezmenyek: +"+csont.getTaplalas()+"% jollakottsag, +5% jokedv");
                System.out.println("hazikoszt - Hazikoszt - Ar: "+haziKoszt.getAr()+" Ft, Kovetkezmenyek: +"+haziKoszt.getTaplalas()+"% jollakottsag, -1% jokedv");
                System.out.println("viz - Viz - Ar: "+viz.getAr()+" Ft, Kovetkezmenyek: +"+viz.getTaplalas()+"% jollakottsag, +1% jokedv");
                System.out.println("konzerv - Konzerv kutyaeledel - Ar: "+konzerves.getAr()+" Ft, Kovetkezmenyek: +"+konzerves.getTaplalas()+"% jollakottsag, -10% jokedv");
                System.out.println("energydrink - Kutya energiaital - Ar: "+kutyaEnergyDrink.getAr()+" Ft, Kovetkezmenyek: +"+kutyaEnergyDrink.getTaplalas()+"% jollakottsag, +"+kutyaEnergyDrink.getBoost()+"% energia, tulitataskor -8% jokedv");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/ETELEK/ITALOK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            if(utasitas.equals("heal") && p1.isTisztasag () && p1.getEnergia()>10.0){
                System.out.println("˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘ELETCSOMAGOK˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘");
                System.out.println("kishk - Kismeretu eletcsomag - Ar: "+kicsi.getArszabas()+" Ft, Kovetkezmenyek: +"+kicsi.getHealeles()+"% egeszseg");
                System.out.println("nagyhk - Nagymeretu eletcsomag - Ar: "+nagy.getArszabas()+" Ft, Kovetkezmenyek: +"+nagy.getHealeles()+"% egeszseg");
                System.out.println("allatorvos - Allatorvosi vizsgalat - Ar: "+allatorvos.getArszabas()+" Ft, Kovetkezmenyek: "+allatorvos.getHealeles()+"% egeszseg");
                System.out.println("maxital - Maximalizalo eletelixir - Ar: "+maxiItal.getArszabas()+" Ft, Kovetkezmenyek: "+maxiItal.getHealeles()+"%-ra allitja minden tulajdonsagat kedvencunknek (ovatosan, a rendetlenseget is!)");
                System.out.println("˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘/ELETCSOMAGOK˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘˘");
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
                System.out.println(p1.getNev()+" nagyon elvezte a setaltatast! -"+(int)energia+"% energia, +"+(int)egeszseg+"% egeszseg, +"+(int)kedv+"% jokedv");
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
                System.out.println(p1.getNev()+" nagyon szeret veled labdazni, "+p1.getTulajNev()+"! -"+(int)energia+"% energia, +"+(int)egeszseg+"% egeszseg, -"+(int)rendetlenseg+"% rendetlenseg, +"+(int)kedv+"% jokedv");
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
                System.out.println("A kutyaiskola ugyan faraszto "+p1.getNev()+" szamara, megis sikeresen vette az akadalyokat. -"+befizetett+" Ft, -"+(int)energia+"% energia, +"+(int)egeszseg+"% egeszseg, -"+(int)rendetlenseg+"% rendetlenseg");
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
                System.out.println("A park szabadsaga lehetove teszi, hogy "+p1.getNev()+" kitombolhassa magat. +"+(int)energia+"% energia, +"+(int)egeszseg+"% egeszseg, -"+(int)rendetlenseg+"% rendetlenseg, +"+(int)kedv+"% jokedv");
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
                    System.out.println (p1.getNev ()+" ujsagkihordas kozben nem figyelt a fele sebesen kozeledo H3-as Hummerre...");
                }else{
                    System.out.println("Ugyan "+p1.getNev()+" mopsz meretu szajaba nem sok vaskos ujsag fer, megtanult a hatan levo taskabol ujsagokat dobalni! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egeszseg, -"+(int)kedv+"% jokedv");
                }
            }
            if(utasitas.equals("ujsag") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced tul szofogadatlan ahhoz, hogy munkat vallaljon!");
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
                    System.out.println ("Azt hiszem, ez volt "+p1.getNev ()+" utolso bevetese...");
                }else{
                    System.out.println("Annak ellenere, hogy "+p1.getNev()+" eleg kicsi, a szimata kivalo, emiatt konnyen kiszagolta a kokaint! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egeszseg, -"+(int)kedv+"% jokedv");
                }
            }
            if(utasitas.equals("rex") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced tul szofogadatlan ahhoz, hogy munkat vallaljon!");
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
                    System.out.println (p1.getNev ()+" a hazorzes soran porul jart...");
                }else{
                    System.out.println("Hiaba, nem meret kerdese a hangero! "+p1.getNev()+" olyan hangosan ugatta meg a betoroket, hogy azt is otthagytak, amit magukkal vittek! +"+profit+" Ft, -"+(int)energia+"% energia, -"+(int)egeszseg+"% egeszseg, -"+(int)kedv+"% jokedv");
                }
            }
            if(utasitas.equals("orzes") && p1.getRendetlenseg()>40.0 && p1.getEnergia()>10){
                System.out.println("Kedvenced tul szofogadatlan ahhoz, hogy munkat vallaljon!");
            }
    //kajalas
            if(utasitas.equals("jutifali") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ jutiFali.getTaplalas());
                p1.setPenz(p1.getPenz()- jutiFali.getAr());
                p1.setKedv (p1.getKedv ()+3.0);
                System.out.println(p1.getNev()+": Hmmm... fincsi! -"+jutiFali.getAr()+" Ft, +"+jutiFali.getTaplalas()+"% jollakottsag, +3% jokedv");
            }
            if(utasitas.equals("szaraztap") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ szarazTap.getTaplalas());
                p1.setPenz(p1.getPenz()- szarazTap.getAr());
                p1.setKedv (p1.getKedv ()-3.0);
                System.out.println(p1.getNev()+": Atlagos zaba egy atlagos napon... legalabb a nap besut az ablakon! -"+szarazTap.getAr()+" Ft, +"+szarazTap.getTaplalas()+"% jollakottsag, -2% jokedv");
            }
            if(utasitas.equals("csont") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ csont.getTaplalas());
                p1.setPenz(p1.getPenz()- csont.getAr());
                p1.setKedv (p1.getKedv ()+5.0);
                System.out.println(p1.getNev()+": Ettol igazan alfanak erzem magam! -"+csont.getAr()+" Ft, +"+csont.getTaplalas()+"% jollakottsag, +5% jokedv");
            }
            if(utasitas.equals("hazikoszt") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ haziKoszt.getTaplalas());
                p1.setPenz(p1.getPenz()- haziKoszt.getAr());
                p1.setKedv (p1.getKedv ()-1.0);
                System.out.println(p1.getNev()+": Csoro... de legalabb valamit en is kapok! -"+haziKoszt.getAr()+" Ft, +"+haziKoszt.getTaplalas()+"% jollakottsag, -1% jokedv");
            }
            if(utasitas.equals("viz") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ viz.getTaplalas());
                p1.setPenz(p1.getPenz()- viz.getAr());
                p1.setKedv (p1.getKedv ()+1.0);
                System.out.println(p1.getNev()+": Ennek a viznek ma kulonosen finom ize van! -"+viz.getAr()+" Ft, +"+viz.getTaplalas()+"% jollakottsag, +1% jokedv");
            }
            if(utasitas.equals("konzerv") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ konzerves.getTaplalas());
                p1.setPenz(p1.getPenz()- konzerves.getAr());
                p1.setKedv (p1.getKedv ()-10.0);
                System.out.println(p1.getNev()+": Nem tudtam, hogy nuklearis haborura keszulunk... -"+konzerves.getAr()+" Ft, +"+konzerves.getTaplalas()+"% jollakottsag, -10% jokedv");
            }
            if(utasitas.equals("energydrink") && p1.isTisztasag ()){
                p1.setJollakottsag(p1.getJollakottsag()+ kutyaEnergyDrink.getTaplalas());
                p1.setEnergia(p1.getEnergia()+ kutyaEnergyDrink.getBoost());
                p1.setPenz(p1.getPenz()- kutyaEnergyDrink.getAr());
                p1.setMajAllapot (p1.getMajAllapot ()+1);
                if(p1.getMajAllapot ()>3){
                    p1.setKedv (p1.getKedv ()-8.0);
                    System.out.println (p1.getNev()+":Annyira nem erzem mar jol magam ettol, "+p1.getTulajNev ()+"... -"+kutyaEnergyDrink.getAr()+" Ft, +"+kutyaEnergyDrink.getTaplalas()+"% jollakottsag, +"+kutyaEnergyDrink.getBoost()+"% energia, -8% jokedv");
                }else{
                    System.out.println(p1.getNev()+": Csak a majam meg ne banja! -"+kutyaEnergyDrink.getAr()+" Ft, +"+kutyaEnergyDrink.getTaplalas()+"% jollakottsag, +"+kutyaEnergyDrink.getBoost()+"% energia");
                }
            }
    //eletcsomagok
            if(utasitas.equals("kishk") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(p1.getEgeszseg()+ kicsi.getHealeles());
                p1.setPenz(p1.getPenz()- kicsi.getArszabas());
                System.out.println("-"+kicsi.getArszabas()+" Ft, +"+kicsi.getHealeles()+"% egeszseg");
            }
            if(utasitas.equals("nagyhk") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(p1.getEgeszseg()+ nagy.getHealeles());
                p1.setPenz(p1.getPenz()- nagy.getArszabas());
                System.out.println("-"+nagy.getArszabas()+" Ft, +"+nagy.getHealeles()+"% egeszseg");
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
                    System.out.println("Kedvenced a szuri mellett atesett egy felaras majatultetesen is. -"+(maj+allatorvos.getArszabas ())+" Ft, -"+(int)szuri+"% jokedv, +"+nagy.getHealeles()+"% egeszseg");
                }else{
                    System.out.println("Kedvenced kapott egy szurit, aminek nem annyira orult. -"+nagy.getArszabas()+" Ft, -"+szuri+"% jokedv, +"+nagy.getHealeles()+"% egeszseg");
                }

            }
            if(utasitas.equals("maxital") && p1.getEnergia()>10.0 && p1.isTisztasag ()){
                p1.setEgeszseg(maxiItal.getHealeles());
                p1.setEnergia(maxiItal.getHealeles());
                p1.setJollakottsag(maxiItal.getHealeles());
                p1.setKedv(maxiItal.getHealeles());
                p1.setRendetlenseg(maxiItal.getHealeles());
                p1.setPenz(p1.getPenz()- maxiItal.getArszabas());
                System.out.println(p1.getNev()+" benyakalta az egesz elixirt, amitol nagyon virgonc lett, minden tekintetben! -"+maxiItal.getArszabas()+" Ft, minden tulajdonsag "+maxiItal.getHealeles()+"%-ra toltve.");
            }

            //mentes
            if(utasitas.equals("SAVE") && p1.isTisztasag ()){
                boolean helyesMentes = false;
                mentesNeve="";
                System.out.println("Kerlek ird be, hogy mi legyen a mentesed neve! (max. 12 karakter!)");
               while(!helyesMentes){
                   mentesNeve=sc.nextLine ();
                   if(!mentesNeve.matches ("[a-zA-Z]+")){
                       System.err.println ("Kerlek, a mentesed ekezeteket es szokozt ne tartalmazzon, es maximum 12 karakter hosszusagu legyen!");
                   }else if(mentesNeve.length ()<1 || mentesNeve.length ()>12){
                    System.err.println ("Kerlek, a mentesed ekezeteket es szokozt ne tartalmazzon, es maximum 12 karakter hosszusagu legyen!");
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
                    System.err.println("Oops! Hiba tortent a jatek mentesekor!");
                    continue;
                }
                System.out.println("Jatek sikeresen elmentve!");
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
                    System.out.println("Egy uj nap virrad, "+p1.getNev()+" pedig kipihenten, de ehesen kel fel (ja, es egy nappal oregebben is). +"+ennyivelNoAlvastolAzEnergia+"% energia, -8% jollakottsag, -5% egeszseg");
                }
                if((p1.getMajAllapot () > 3 && p1.getEgeszseg ()>0.0) || (p1.getEgeszseg () < 30.0 && p1.getEgeszseg ()>0.0) && korszam<100){
                    System.out.println ("Lehet, kicsit jobban oda kene figyelned "+p1.getNev ()+" egeszsegere... el kellene vinni egy allatorvoshoz...");
                }
                Random tisztasag = new Random();
                int slotMachine = 100;
                int dontoErtek = tisztasag.nextInt(slotMachine);
                p1.setTisztasag(dontoErtek >= 40);
                continue;
            }
            if(utasitas.equals("QUIT")){
                System.out.println("Koszonom, hogy jatszottal!");
                break;
            }
            if(utasitas.equals("LOAD") && p1.isTisztasag ()){
                    System.out.println("Udv a menteseknel!");
                    File mentesekMappaja = new File("./mentesek/");
                    File[] tartalom = mentesekMappaja.listFiles();
                    if(tartalom==null){

                    }else if(tartalom.length==0){
                        System.out.println("Sajnalom, de a mentesek mappa nem tartalmaz menteseket!");
                        System.out.println();
                        System.out.println("A megkezdett jatekod folytatasahoz ird be, hogy CONTINUE");
                        System.out.println("A jatekbol valo kilepeshez kerlek ird be, hogy QUIT");
                        utasitas=sc.nextLine();
                        while(!(utasitas.equals ("CONTINUE") || utasitas.equals ("QUIT"))){
                            System.err.println ("Kerlek, csupan az alabbi parancsokat hasznald!");
                            System.out.println("A megkezdett jatekod folytatasahoz ird be, hogy CONTINUE");
                            System.out.println("A jatekbol valo kilepeshez kerlek ird be, hogy QUIT");
                            utasitas=sc.nextLine();
                        }
                        if(utasitas.equals ("QUIT")){
                            System.out.println("Koszonom, hogy jatszottal!");
                            break;
                        }
                        continue;
                    }else {
                        System.out.println("Az alabbi menteseket talaltam. Ird be a megnyitni kivant mentes nevet a .txt nelkul!");
                        File eleresiUt = new File("./mentesek/");
                        File[] fajlok = eleresiUt.listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                return name.endsWith(".txt");
                            }
                        });
                        Set<String> mentesNevek= new HashSet<>();
                        for(File file: fajlok){
                            System.out.println(file.getName());
                            mentesNevek.add (file.getName ());
                        }
                        toltesNeve=sc.nextLine();
                        while(!mentesNevek.contains (toltesNeve+".txt")){
                            System.err.println("Valid mentesnevet adj meg, kiterjesztes nelkul!");
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
                            System.out.println("Sikeres betoltes!");
                            System.out.println("Udv ujra itt, "+p1.getTulajNev()+", "+p1.getNev()+"!");
                        } catch (IOException e) {
                            System.err.println("Oops! Hiba tortent a mentesed beolvasasakor!");
                            continue;
                        }
                    }
                    continue;

            }
            if(utasitas.equals("NEW")){
                while(true){
                System.out.println("Udvozollek ujra a karakterkeszitesnel! Kerlek ird le, mi legyen a nem magarahagyott, de ugyan ugy nuklearis toltesu kutyusod neve!");
                    boolean helyesNev=false;
                    while(!helyesNev){
                        p1.setNev(sc.nextLine());
                        if(!p1.getNev ().matches ("[a-zA-Z\\s]+")){
                            System.err.println ("Kerlek egy maximum 12 karakterbol allo, ekezetek nelkuli nevet adj kedvencednek!");
                        }else if(p1.getNev ().length ()<1 || p1.getNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                            System.err.println ("Kerlek egy maximum 12 karakterbol allo, ekezetek nelkuli nevet adj kedvencednek!");
                        } else{
                            helyesNev=true;
                        }
                    }
                System.out.println("A kutyusod uj neve: "+p1.getNev());
                System.out.println("Kerlek ird le ujra a sajat neved! (Gazdi neve)");
                    boolean helyesTulajNev=false;
                    while(!helyesTulajNev){
                        p1.setTulajNev (sc.nextLine());
                        if(!p1.getTulajNev ().matches ("[a-zA-Z\\s]+")){
                            System.err.println ("Kerlek egy maximum 12 karakterbol allo, ekezetek nelkuli nevet adj uj inkognitodnak!");
                        }else if(p1.getTulajNev ().length ()<1 || p1.getTulajNev ().length ()>12 || p1.getNev ().equals ("\\s")){
                            System.err.println ("Kerlek egy maximum 12 karakterbol allo, ekezetek nelkuli nevet adj uj inkognitodnak!");
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
                System.out.println("A gazdi uj neve: "+p1.getTulajNev());
                System.out.println("**************************************************************************************");
                System.out.println("A kutyusod uj adatai: ");
                System.out.println("Neve: "+p1.getNev());
                System.out.println("Tulajdonosanak neve: "+p1.getTulajNev());
                System.out.println("Vagyonotok: "+p1.getPenz()+" Ft (Default)");
                System.out.println("A kutyusod egeszsege: "+p1.getEgeszseg()+"% (Default)");
                System.out.println("A kutyusod energiaja: "+p1.getEnergia()+"% (Default)");
                System.out.println("A kutyusod kedve: "+p1.getKedv()+"% (Default)");
                System.out.println("A kutyusod jollakottsaga: "+p1.getJollakottsag()+"% (Default)");
                System.out.println("A kutyusod rendetlensege: "+p1.getRendetlenseg()+"% (Default)");
                System.out.println("**************************************************************************************");
                System.out.println("Amennyiben elegedett vagy a beirt adatokkal, ird be, hogy GO");
                System.out.println("Ellenkezo esetben ird be, hogy RE");

                    indulas=sc.nextLine();

                    if(indulas.equals("GO")){
                        break;
                    }
                    if(!indulas.equals ("RE"))
                    System.err.println("Helyes parancsokat hasznalj!");
                }
                System.out.println("............ JATEK INDUL (ujra) ............");
            }
        }
        if(korszam<100 && p1.getPenz()>=10000 && p1.getEgeszseg ()>0.0 && p1.getKedv ()>0.0 && p1.getMajAllapot ()<10){
            System.out.println("Gratulalok! Te, "+p1.getTulajNev()+" es huseges tarsad, "+p1.getNev()+" megnyertetek a jatekot! Kemeny munkatokkal osszegyujtottetek a tovabbi kutatashoz es a kutyahazhoz szukseges vagyont!");
            System.out.println ("A vilag koszonettel tartozik hosies kuzdelmetekert! Igerjuk, nem adjuk tovabb a technologiat fegyverneppereknek es egyeb veszelyes alakoknak!");
        }
        if(korszam>100 && p1.getEgeszseg ()>0.0 && p1.getKedv ()>0.0 && p1.getMajAllapot ()<10){
            System.out.println("Sajnaljuk, de a jatek szamotokra veget ert, "+p1.getTulajNev()+" es "+p1.getNev()+"! Meghaladtatok a maximum szamu kort, de nem ertetek el a kutatasok folytatasahoz szukseges osszeget. Nekunk annyi.");
            System.out.println ("GAME OVER");
        }
        if(p1.getMajAllapot ()>=10 && p1.getKedv ()>0.0 && p1.getEgeszseg ()>0.0){
            System.out.println ("Jajj ne... "+p1.getNev ()+" tul sok energiaitalt ivott, es annyira majkarosult lett, hogy elpusztult! Nekunk a...");
            System.out.println ("GAME OVER");
        }
        if(p1.getPenz ()<10000 && p1.getKedv ()<=0.0 && p1.getEgeszseg ()>0.0){
            System.out.println (p1.getNev ()+" annyira bedepizett, hogy ugy dontott, ennek a vilagnak pusztulnia kell. Eljott a veg. *BUMM*");
            System.out.println ("GAME OVER");
        }
        if(p1.getPenz ()<10000 && p1.getEgeszseg ()<=0.0){
            System.out.println (p1.getTulajNev ()+"... egyetlen dolgod volt, megpedig az, hogy eletben tartsd kedvenced! Miattad mind megha...");
            System.out.println ("GAME OVER");
        }
    }

}
