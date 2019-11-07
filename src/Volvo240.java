import java.awt.*;

/**
 * The car model that can be seen here:
 * https://www.google.com/search?q=volvo+240&sxsrf=ACYBGNQRAMPnL5kgIZusbpzeHPTgxRLQ8w:1573133572414&source=lnms&tbm=
 * isch&sa=X&ved=0ahUKEwiCgJKem9jlAhXhMewKHXmnCl8Q_AUIEigB&biw=1536&bih=722
 * represented as a Java class
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }
    
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}