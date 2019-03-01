/**
 * @author Barraguesh
 * @version %I% %G%
 * @since v0.2 alpha
 */
package IconFighters;
import View.Hazard.*;
import View.*;
import Classes.*;
import java.util.concurrent.ThreadLocalRandom;
import BDStuff.*;

/**
 * Ideas:
 *      DB should be created if it isn´t (use SAX) //OPTIONAL
 *      For con variable que, cuando incremente escriba el texto palabra por palabra y cuando acabe el primer jlabel, cree el siguiente
 *      Hacer un FOR que cada vez que se ataca, se muevan los iconos
 *      Reutilizar la ventana para todas las peleas
 *      Meter todas las funciones en el controlador
 *      Dividir la DB en stats de fighters y villanos
 */
public class Controller {
        
        //Views
        static Welcome welcome;
        static Story story;
        static SelectFighter selectfigther;
        static EditStats editstats;
        static HazardFirstFight hazardfirstfight;
        //static HazardSecondFight SF;
        
        //DB
        static StatsDB icondb;
          
        //Fighters
        public static Icon Hazard;
        public static Icon XML;
        public static Icon Folder;
        
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                try {
                    ConsolePrint("Icon Figthers v0.2 alpha\nUnder MIT license");
                    icondb = new StatsDB();
                    icondb.EmptyStatsTable();
                    icondb.LoadDB("Hazard",40,10,90);
                    ConsolePrint("Hazard defaults loaded in DB");
                    icondb.LoadDB("XML", 25, 20, 120);
                    ConsolePrint("XML defaults loaded in DB");
                    icondb.LoadDB("Folder", 40,10,70);
                    ConsolePrint("Folder defaults loaded in DB");
                    WindowWelcome();
                } catch (Exception ex) {
                    ConsolePrint("Exception in Controller main: " + ex.getMessage());
                }
                
        }
        
        public static void WindowWelcome(){
            welcome = new Welcome();
            welcome.setVisible(true);
        }
        
        /**
         * Loads the Story window
         */
        public static void WindowStory(){
            story = new Story();
            story.setVisible(true);
        }
        
        public static void WindowSelectFigther(){
            selectfigther = new SelectFighter();
            selectfigther.setVisible(true);
        }
        
        public static void WindowEditStats(){
            editstats = new EditStats();
            editstats.setVisible(true);
        }
        
        public static void WindowFirstFigth(String figther){
            //Figther selector
            switch (figther){
                case "Hazard":
                    hazardfirstfight = new HazardFirstFight();
                    hazardfirstfight.setVisible(true);
                break;
                case "..":
                    //FF.setVisible(true);
                break;
                case ".":
                    //FF.setVisible(true);
                break;
            }
        }
        
        public static void SecondFight(String figther){
            switch (figther) {
                case "Hazard":
                    //HSF = new HazardSecondFight();
                    //HSF.setVisible(true);
                break;
                case "..":
                    //FF.setVisible(true);
                break;
                case ".":
                    //FF.setVisible(true);
                break;
            }
        }
        
        // <editor-fold defaultstate="collapsed" desc="DB">
        public static void UpdateStatsDB(String name, int attack, int defense, int lifepoints) throws Exception{
            icondb.UpdateStatsDB(name, attack, defense, lifepoints);
        }
        
        public static Icon GetStats(String name)throws Exception{
            return icondb.GetStatsDB(name);
        }
        // </editor-fold>
        
        public static void ConsolePrint(String string){
            System.out.println(string);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public static int CounterAttack(int damagedone){
            int damage = 0;
            switch(damagedone){
                    case 1:
                        damage = ThreadLocalRandom.current().nextInt(0, XMLBorn().getAttack()/4);
                    break;
                    case 2:
                        damage = ThreadLocalRandom.current().nextInt(XMLBorn().getAttack()/4, XMLBorn().getAttack()/2);
                    break;
            }            
            return damage; 
        }
        
        // <editor-fold defaultstate="collapsed" desc="Villains">
        public static Icon XMLBorn(){
            Icon XML = new Icon(30, 5, 100);
            return XML;
        }
        // </editor-fold>
        
        
}
  

