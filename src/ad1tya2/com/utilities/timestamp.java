package ad1tya2.com.utilities;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class timestamp {
    public static Integer main() {
            SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmm");
            Date date = new Date();
            Integer x = parseInt(formatter.format(date));
        return (x);
     }

}
