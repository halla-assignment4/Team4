package ma.homwork;

public class Subject { //과목의 점수를 받아오는 클래스
    private int sco;
    Subject(){
        
    }
    Subject(int sc){
        this.sco = sc;
    }
    public int getSco() {
        return this.sco;
    }
    public void setSco(int sco) {
        this.sco = sco;
    }
}

