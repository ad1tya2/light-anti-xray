package ad1tya2.com.utilities;

import static org.bukkit.Bukkit.getServer;

public class log{
    public static void console(String msg){
     getServer().getConsoleSender().sendMessage(msg);
}
}
