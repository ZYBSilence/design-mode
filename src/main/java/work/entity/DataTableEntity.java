package work.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/22 13:11
 */
public class DataTableEntity extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = 1764706991772348892L;

    @ExcelProperty(value = "LogIndex", index = 0)
    private String a;
    @ExcelProperty(value = "MEActFOCons", index = 1)
    private String b;
    @ExcelProperty(value = "DGActFOCons", index = 2)
    private String c;
    @ExcelProperty(value = "BlrActFOCons", index = 3)
    private String d;
    @ExcelProperty(value = "MEActMGOCons", index = 4)
    private String e;
    @ExcelProperty(value = "DGActMGOCons", index = 5)
    private String f;
    @ExcelProperty(value = "DG1Power", index = 6)
    private String g;
    @ExcelProperty(value = "DG2Power", index = 7)
    private String h;
    @ExcelProperty(value = "DG3Power", index = 8)
    private String i;
    @ExcelProperty(value = "MESFOC_kw", index = 9)
    private String j;

    @ExcelProperty(value = "MESFOC_nmile", index = 10)
    private String k;
    @ExcelProperty(value = "MEShaftPow", index = 11)
    private String l;
    @ExcelProperty(value = "ShipSpdToWater", index = 12)
    private String m;
    @ExcelProperty(value = "ShipHeel", index = 13)
    private String n;
    @ExcelProperty(value = "ShipTrim", index = 14)
    private String o;
    @ExcelProperty(value = "WindSpd", index = 15)
    private String p;
    @ExcelProperty(value = "WindDir", index = 16)
    private String q;
    @ExcelProperty(value = "ShipDraughtBow", index = 17)
    private String r;
    @ExcelProperty(value = "ShipDraughtAstern", index = 18)
    private String s;
    @ExcelProperty(value = "ShipDraughtMidLft", index = 19)
    private String t;
    @ExcelProperty(value = "ShipDraughtMidRgt", index = 20)
    private String u;

    public DataTableEntity() {
    }

    public DataTableEntity(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p;
        this.q = q;
        this.r = r;
        this.s = s;
        this.t = t;
        this.u = u;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "DataTableEntity{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", h='" + h + '\'' +
                ", i='" + i + '\'' +
                ", j='" + j + '\'' +
                ", k='" + k + '\'' +
                ", l='" + l + '\'' +
                ", m='" + m + '\'' +
                ", n='" + n + '\'' +
                ", o='" + o + '\'' +
                ", p='" + p + '\'' +
                ", q='" + q + '\'' +
                ", r='" + r + '\'' +
                ", s='" + s + '\'' +
                ", t='" + t + '\'' +
                ", u='" + u + '\'' +
                '}';
    }
}
