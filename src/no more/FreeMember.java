public class FreeMember extends Member{
    private int FREE_LIMITED_VDOs = 3;
    private int numDownloadVDO;
    FreeMember(String email, String password){
        super(email,password);
    }

    public boolean addVideo(Video vdo){
        if(numDownloadVDO >= FREE_LIMITED_VDOs){
            System.out.println(vdo.toString());
            System.out.println("cannot be download because the number of video is reaching the limit.");
            return false;
        }
        else{
            super.addVideo(vdo);
            numDownloadVDO++;
            return true;
        }
    }

    public boolean removeVideo(Video vdo){
            super.removeVideo(vdo);
            numDownloadVDO--;
            return true;
    }

    public void printMemberInfo(){
        System.out.println("----FREE MEMBER----");
        super.printMemberInfo();
    }

    public int getNumVideo(){
        return numDownloadVDO;
    }
}
