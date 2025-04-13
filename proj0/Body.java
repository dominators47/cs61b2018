
import javax.naming.spi.DirStateFactory;

public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

public Body(double xP, double yP, double xV,
              double yV, double m, String img){
                xxPos = xP;
                yyPos = yP;
                xxVel = xV;
                yyVel = yV;
                mass = m;
                imgFileName = img;
              }

public Body(Body b){
    xxPos = b.xxPos;
    yyPos = b.yyPos;
    xxVel = b.xxVel;
    yyVel = b.yyVel;
    mass = b.mass;
    imgFileName = b.imgFileName;
}
public double calcDistance(Body b){
    return Math.sqrt(Math.pow(xxPos-b.xxPos,2) + Math.pow(yyPos-b.yyPos,2));
}
public double calcForceExertedBy(Body b){
    return G*mass*b.mass/Math.pow(calcDistance(b),2);
}
public double calcForceExertedByX(Body b){
    return (G*mass*b.mass/Math.pow(calcDistance(b),2))*(b.xxPos-xxPos)/calcDistance(b);
}
public double calcForceExertedByY(Body b){
    return (G*mass*b.mass/Math.pow(calcDistance(b),2))*(b.yyPos-yyPos)/calcDistance(b);
} 
public double calcNetForceExertedByX(Body[] allBodys){
    double value = 0;
    for(Body b : allBodys){
        if (! b.equals(this)){ 
           value += b.calcForceExertedByX(b);
            }
    }
    return value;
}
public double calcNetForceExertedByY(Body[] allBodys){
    double value = 0;
    for(Body b : allBodys){
        if (! b.equals(this)){ 
           value += b.calcForceExertedByY(b);
            }
    }
    return value;
}
public void update(double dt, double fX, double fY){
    double ax = fX/mass;
    double ay = fY/mass;
    xxVel = xxVel + ax*dt;
    yyVel = yyVel + ay*dt;
    xxPos = xxPos + xxVel*dt;
    yyPos = yyPos + yyVel*dt;

    
}


}