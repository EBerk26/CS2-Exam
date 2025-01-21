import java.util.ArrayList;

public class SurvivorLeader {
    private String transmission = "q2xf1t8r5w3t tm9c5i8l900d5n7heto 3g5t6hgw44y5e7bhty605rh8t5 85ml95ak2k5r7qw5ksp295e5t7p45 o5i3n 6z5n205 9soe5o8hhg5lygtt5dq7th 5 gf34s9o 35j7j5o45k99hg5kyqqcjg5mkpl20z5o629sle5k20sk5k9c5 gh73h qxp25vi8t5i3f2v1q 9x7z6t5l8r9j3o4v5l3l1w 9y5a4d6f7x2c9l5g h8s45ek6";
    Shelter[] shelters = new Shelter[40];
    public static void main(String[] args) {
        SurvivorLeader survivorLeaderObject = new SurvivorLeader();
    }
    public SurvivorLeader() {
        System.out.println("Goodbye World! Good luck surviving the apocalypse!");
        for(int x =0;x<shelters.length;x++){
            shelters[x] = new Shelter((int)(100*Math.random()+1),(int)(1001*Math.random()));
        }
        displayShelters();
        System.out.println("It is "+checkSupplies()+" that two shelters have the same number of supplies.");
        System.out.println("Incoming Secret Message! The message reads: "+decipher(transmission));
        System.out.println("***************************************************************************");
        newDefense();
        displayShelters();
        System.out.println("It is "+checkDefense()+" that two shelters have the same defense level.");
    }
    void displayShelters(){
        for(Shelter s: shelters){
            s.printInfo();
        }
    }
    boolean checkSupplies(){
        boolean[] booleanArray = new boolean[1002];
        for(Shelter s: shelters){
            if(booleanArray[s.getNumberOfSupplies()]){
                return true;
            } else{
                booleanArray[s.getNumberOfSupplies()] = true;
            }
        }
        return  false;
    }
    String decipher(String hiddenMessage){
        String notDecipheredYet = hiddenMessage;
        String decoded = "";
        while(notDecipheredYet.contains("5")){
            decoded+=notDecipheredYet.charAt(notDecipheredYet.indexOf("5")+1);
            notDecipheredYet = notDecipheredYet.substring(notDecipheredYet.indexOf("5")+1);
        }
        return decoded;
    }
    void newDefense(){
        //this would probably be easier with arraylists because it's easier to take stuff out but I don't know how to use those.
        int[] availableDefenseNumbers = new int[100];
        int indexOfUsedDefenseNumber;
        for(int x =1;x<=100;x++){
            availableDefenseNumbers[x-1] = x; //indexes are one less than the number they contain because java counts arrays starting at 0
        }
        for(Shelter s: shelters){
            indexOfUsedDefenseNumber = (int)(availableDefenseNumbers.length*Math.random()); //pick a random integer from the array
            s.setDefenseLevel(availableDefenseNumbers[indexOfUsedDefenseNumber]);
            int[] temp = new int[availableDefenseNumbers.length-1];
            for(int x =0;x<indexOfUsedDefenseNumber;x++){
                temp[x] = availableDefenseNumbers[x]; //copy everything over up to the one you just used
            }
            for(int x = indexOfUsedDefenseNumber;x<availableDefenseNumbers.length-1;x++){
                temp[x] = availableDefenseNumbers[x+1]; //copy everything over after the one you just used
            }
            availableDefenseNumbers = new int[temp.length];
            for(int x=0;x<temp.length;x++){
                availableDefenseNumbers[x] = temp[x]; //copy everything back
            }
        }
    }
    boolean checkDefense(){
        boolean[] booleanArray = new boolean[102];
        for(Shelter s: shelters){
            if(booleanArray[s.getDefenseLevel()]){
                return true;
            } else{
                booleanArray[s.getDefenseLevel()] = true;
            }
        }
        return false;
    }
}
class Shelter {
    private int defenseLevel;
    private  int numberOfSupplies;

    void printInfo(){
        System.out.println("Defense Level: "+defenseLevel+". Supplies count: "+numberOfSupplies);
    }

    public Shelter(int defenseLevel, int numberOfSupplies) {
        this.defenseLevel = defenseLevel;
        this.numberOfSupplies = numberOfSupplies;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getNumberOfSupplies() {
        return numberOfSupplies;
    }

    public void setNumberOfSupplies(int numberOfSupplies) {
        this.numberOfSupplies = numberOfSupplies;
    }
}