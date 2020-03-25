import java.util.ArrayList;

public class Member {
    private String email;
    private String password;
    private ArrayList<Video> vdoList = new ArrayList<Video>();

    public Member(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean addVideo(Video vdo){
        if(vdo != null){
            vdoList.add(vdo);
            return true;
        }
        return false;
    }

    public boolean removeVideo(Video vdo){
        if(vdo != null){
            vdoList.remove(vdo);
            System.out.println(vdo);
            return true;
        }
        return false;
    }

    public void printMemberInfo(){
        System.out.println("Email: "+email+" pwd: ("+password+")");
        for(int i=0;i<vdoList.size();i++){
            int k=i+1;
            System.out.println("["+k+"] "+vdoList.get(i));
        }
    }
}
