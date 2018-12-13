package ma.homwork;

//import java.util.Comparator;

public class GradeData implements Comparable<GradeData> {
  private Subject kor;
  private Subject eng;
  private Subject mat;
  private Subject tam1;
  private Subject tam2;
  private int total;
  private int total2;
  private float avg;
  
  private String name;
  
  public GradeData(){ //생성자 초기화
      name=new String();
      kor = new Subject();
      eng = new Subject();
      mat = new Subject();
      tam1 = new Subject();
      tam2 = new Subject();
      name = new String();
      total = 0;
      total2 = 0;
      avg = 0;
      
  }


  public int getKor() {
      return this.kor.getSco();
  }

  public void setKor(int kor) {
      this.kor.setSco(kor);
  }

  public int getEng() {
      return this.eng.getSco();
  }

  public void setEng(int eng) {
      this.eng.setSco(eng);
  }

  public int getMat() {
      return this.mat.getSco();
  }

  public void setMat(int mat) {
      this.mat.setSco(mat);
  }

  public int gettam1() {
      return this.tam1.getSco();
  }

  public void settam1(int tam1) {
      this.tam1.setSco(tam1);
  }
  
  public int gettam2() {
      return this.tam2.getSco();
  }

  public void settam2(int tam2) {
      this.tam2.setSco(tam2);
  }

  
  public int get3Total() {
      total = getEng()+getKor()+getMat();
      return total;
  }
  
  public int get5Total() {
      total2 = getEng()+getKor()+getMat()+gettam1()+gettam2();
      return total2;
  }


  public float getAvg() {
      return this.avg = total /3.f;
  }
  
  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String toString() {
      return  ("이름 : "+" "+ getName()+" "+ " 국어 :"
              +" "+getKor()+" "+" 영어 :"+" "+getEng()+" "+" 수학 :"+" "+getMat()+" "
              +" , 국영수총점 :"
              +" "+get3Total()+" " +" , 국영수평균 : "+" "+getAvg())+ " , 국영수탐 총점 :"+ get5Total();                                                                               
                          
  }

  
  public int compareTo(GradeData o1) {
      if(this.getAvg()>o1.getAvg()) { return 1;
      }
      else if(getAvg()==o1.getAvg()) {
      return 0;
      }
      else{
          return -1;
      }
  }
}
