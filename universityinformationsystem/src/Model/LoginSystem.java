/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import universityinformationsystem.DBSystem;
import universityinformationsystem.LoginInfo;
import universityinformationsystem.ProjectHelper;


/**
 *
 * @author pk-dohyeon
 */
public class LoginSystem extends DBSystem{
    private LoginInfo li;
    public LoginInfo updatepw(String id, String pw, String newpw){
        li = new LoginInfo();
        ResultSet rs;
        try {
            rs = st.executeQuery("select id, pw from USER where id = "+ProjectHelper.addQuotationStr(id));
            if(!rs.next()){
                System.out.println("존재하지않는 아이디입니다.");
                li.state = 5;
                return li;
            }
            else if (!pw.equals(rs.getString("pw")))
            { 
                System.out.println("비밀번호를 다시 확인 해주세요.");
                li.state = 6;
                return li;
            }
            
            else
            { 
                String sql = "update USER set pw = " + ProjectHelper.addQuotationStr(newpw) +" where id = " + ProjectHelper.addQuotationStr(id);
                st.executeUpdate(sql);
                     li.state =7;
            return li;
                    }
        }catch (SQLException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            li.state =0;
            return li;
        }
        
    }
    public LoginInfo login(String id, String pw){
        li = new LoginInfo();
        ResultSet rs;
        try {
            rs = st.executeQuery("select id, pw from USER where id = "+ProjectHelper.addQuotationStr(id));
            if(!rs.next()){
                System.out.println("존재하지않는 아이디입니다.");
                li.state = 5;
                return li;
            }
            else if (!pw.equals(rs.getString("pw")))
            { 
                System.out.println("비밀번호를 다시 확인 해주세요.");
                li.state = 6;
                return li;
            }
            else{
                li.id = rs.getNString("id");
                if(li.id.matches("G.*")){
                    li.state = 2;
                    return li;
                }
                else if(li.id.matches("H.*")){
                    li.state = 1;
                    return li;
                }
                else if(li.id.matches("S.*")){
                    li.state = 3;
                    return li;
                }
                else if(li.id.matches("P.*")){
                    li.state = 4;
                    return li;
                }
                else 
                    li.state = 0;
                    return li;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            li.state =0;
            return li;
        }
    }
}
