import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Created by yjr on 2016/10/13.
 */
public class Testss {
    public static void main(String[] args) {




        try{
            PrintWriter pr=new PrintWriter("yyu");
            int i=6/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("-----");

    }
}
