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
public enum ErrorCode {
    NOMAL(0,"정상"),
    NORMALERROR(1,"에러"),
    OVERLAPENROLL(2,"중복된 강의는 수강신청이 불가능 합니다."),
    MAXENROLL(3,"최대수강 인원이 가득 찼습니다."),
    CREDITEXCESS(4,"학점이 초과되어 신청할 수 없습니다"),
    ENROLLCLASSSTUDENT(5,"이미 수강하고 있는 학생은 삭제할 수 없습니다"),
    ENROLLCLASSPROFESSOR(6,"개설된 강의를 담당하는 교수는 삭제할 수 없습니다."),
    UPDATEERROR(7,"수정오류");
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
