import java.util.ArrayList;

public class PremiumMember extends Member{

    private double fee;
    private static double Family_FEE = 80;
    private ArrayList<String> family = new ArrayList<String>();

    public PremiumMember(String email,String password, double fee){
        super(email,password);
        this.fee = fee;
    }


    public boolean addFamily(String username){
        if(family.size()<2){
            family.add(username);
            System.out.println(username+" is added successfully");
            return true;
        }
        System.out.println("user: "+username+" cannot be added, the Family user is reached the limit");
        return false;
    }

    public boolean removeFamily(String username) {
        for (int i=0;i<family.size();i++) {
            if (family.get(i).equals(username)) {
                family.remove(i);
                System.out.println(username+" is removed successfully");
                return true;
            }
        }
        System.out.println(username+" does not exists cannot be removed");
        return false;
    }

    public double getMonthlyBill(){

        return fee + Family_FEE;
    }

    @Override
    public void printMemberInfo() {
        System.out.println("----PREMIUM MEMBER----");
        System.out.println("Member fee: "+fee);
        super.printMemberInfo();
        System.out.println("---------------------");
        System.out.println("List of Family");
        for (int i=0;i<family.size();i++){
            System.out.println(family.get(i));
        }

    }
}
