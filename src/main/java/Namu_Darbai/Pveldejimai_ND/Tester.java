package Namu_Darbai.Pveldejimai_ND;

import Namu_Darbai.Pveldejimai_ND.Module.*;

public class Tester {
    protected static void print(String text){
        System.out.println(text);
    }
    protected static void line(){
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        line();
        TransportoPriemone transportas = new TransportoPriemone();
        print(transportas.spausdinti());
        line();
        Automobilis auto = new Automobilis(4,"Melyna", KuroTipas.Gass,1.98,4);
        print(auto.spausdinti());
        line();
        Sunkvezimis sunkvezimis = new Sunkvezimis(8,"Rudas",KuroTipas.Diesel,3.5,6);
        print(sunkvezimis.spausdinti());
        line();
        Dviratis dviratis = new Dviratis(2,"Baltas",32);
        print(dviratis.spausdinti());
    }
}
