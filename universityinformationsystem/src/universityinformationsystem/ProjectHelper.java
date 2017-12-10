/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityinformationsystem;

/**
 *
 * @author pk-dohyeon
 */
public class ProjectHelper {
     public static  String addQuotationStr(String temp){ //문자열에 ''붙임
        String tempStr = "'"+temp+"'";
        return tempStr;
    }
    public static  String makeStudentId(int i,int tabState){ //숫자를 아이디 형식으로 변환 ex) 4->S004
        String temp="S";
        if(tabState == 1){
            temp = "P";
        }
      if(i < 10){
        temp = temp + "00" + i; 
      }else if(i < 100){
        temp = temp + "0" + i;
      }else{
        temp = temp + i;
      }
        return temp;
    }
    public static  String addLikeStr(String temp){ //문자열에 '%%'붙임
        String tempStr = "'%"+temp+"%'";
        return tempStr;
    }
    
}
