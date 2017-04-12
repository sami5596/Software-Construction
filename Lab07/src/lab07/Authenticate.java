package lab07;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFORMATION")
public class Authenticate {
    @Id 
    @Column(name = "userid")
    String userId;
    @Column(name = "scheme")
    String scheme;
    @Column(name = "timeTaken")
    double timeTaken;
    @Column(name = "state")
    String state;
    @Column(name = "t1")
    double t1;
    @Column(name = "s1")
    String s1;
    @Column(name = "t2")
    double t2;
    @Column(name = "s2")
    String s2;
    @Column(name = "t3")
    double t3;
    @Column(name = "s3")
    String s3;
    @Column(name = "t4")
    double t4;
    @Column(name = "s4")
    String s4;
    @Column(name = "t5")
    double t5;
    @Column(name = "s5")
    String s5;
    @Column(name = "t6")
    double t6;
    @Column(name = "s6")
    String s6;
    @Column(name = "t7")
    double t7;
    @Column(name = "s7")
    String s7;

    public Authenticate(String userId, String scheme, double timeTaken, String state, double t1, String s1, double t2, String s2, double t3, String s3, double t4, String s4, double t5, String s5, double t6, String s6, double t7, String s7) {
        this.userId = userId;
        this.scheme = scheme;
        this.timeTaken = timeTaken;
        this.state = state;
        this.t1 = t1;
        this.s1 = s1;
        this.t2 = t2;
        this.s2 = s2;
        this.t3 = t3;
        this.s3 = s3;
        this.t4 = t4;
        this.s4 = s4;
        this.t5 = t5;
        this.s5 = s5;
        this.t6 = t6;
        this.s6 = s6;
        this.t7 = t7;
        this.s7 = s7;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getT1() {
        return t1;
    }

    public void setT1(double t1) {
        this.t1 = t1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public double getT2() {
        return t2;
    }

    public void setT2(double t2) {
        this.t2 = t2;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public double getT3() {
        return t3;
    }

    public void setT3(double t3) {
        this.t3 = t3;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public double getT4() {
        return t4;
    }

    public void setT4(double t4) {
        this.t4 = t4;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public double getT5() {
        return t5;
    }

    public void setT5(double t5) {
        this.t5 = t5;
    }

    public String getS5() {
        return s5;
    }

    public void setS5(String s5) {
        this.s5 = s5;
    }

    public double getT6() {
        return t6;
    }

    public void setT6(double t6) {
        this.t6 = t6;
    }

    public String getS6() {
        return s6;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }

    public double getT7() {
        return t7;
    }

    public void setT7(double t7) {
        this.t7 = t7;
    }

    public String getS7() {
        return s7;
    }

    public void setS7(String s7) {
        this.s7 = s7;
    }

}
