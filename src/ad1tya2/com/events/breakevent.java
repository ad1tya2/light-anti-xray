package ad1tya2.com.events;

import ad1tya2.com.utilities.log;
import ad1tya2.com.utilities.sqlite;
import ad1tya2.com.utilities.timestamp;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.sql.SQLException;

public class breakevent implements Listener {
    @EventHandler

    public void onbreak(BlockBreakEvent block) throws SQLException {
        if(block.getBlock().getBlockData().getMaterial().name() == "DIAMOND_ORE") {
            String uuid = block.getPlayer().getUniqueId().toString();
            Integer time = timestamp.main();
            Integer lol = sqlite.count(uuid);
            if(lol > 1)
            {
                log.console("Recently mined diamonds");
                return;
            }

            Integer oo = sqlite.intensity(uuid);

            if(oo > 200)
            {
                block.getPlayer().sendMessage(ChatColor.RED+"BRuh really you think you can fool me?");
            }
            else if(oo > 100)
            {
                block.getPlayer().sendMessage(ChatColor.YELLOW+"Think again about your decisions.......");
            }
            int radius = 5;
            final Block blocc = block.getBlock(); //placed block
            Integer iii = 1;
            for (int x = -(radius); x <= radius; x++) {
                for (int y = -(radius); y <= radius; y++) {
                    for (int z = -(radius); z <= radius; z++) {
                        if (blocc.getRelative(x, y, z).getType() == Material.WATER || blocc.getRelative(x, y, z).getType() == Material.LAVA) {
                            iii = 3;
                            log.console("Detected Air space block near....");
                        }
                    }
                }
            }
            sqlite.main("INSERT INTO data VALUES('" + uuid + "', " + time + ", " + iii + ");");

        }

    }

}
