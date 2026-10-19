package dev.akatriggered.practicebot.bot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class BotAI {
    
    private final PracticeBot bot;
    private BukkitTask task;
    
    public BotAI(PracticeBot bot) {
        this.bot = bot;
    }
    
    public void start() {
        task = Bukkit.getScheduler().runTaskTimer(bot.getOwner().getServer().getPluginManager().getPlugin("G1axCrystalPracticeBot"), 
            this::tick, 0L, 5L);
    }
    
    public void stop() {
        if (task != null) {
            task.cancel();
        }
    }
    
    private void tick() {
        Zombie entity = bot.getEntity();
        if (entity == null || entity.isDead()) {
            return;
        }
        
        Player owner = bot.getOwner();
        if (!owner.isOnline()) {
            bot.remove();
            return;
        }
        
        BotBehaviour behaviour = bot.getBehaviour();
        
        if (behaviour.isAutoTotem()) {
            entity.getEquipment().setItemInMainHand(new ItemStack(Material.TOTEM_OF_UNDYING));
            entity.getEquipment().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING));
        }
        
        if (behaviour.isStandStill()) {
            entity.setAI(false);
            return;
        }
        
        entity.setAI(true);
        
        if (behaviour.isPearlToOwner() && owner.getLocation().getWorld().equals(entity.getLocation().getWorld()) 
            && owner.getLocation().distance(entity.getLocation()) > 10) {
            entity.launchProjectile(org.bukkit.entity.EnderPearl.class, owner.getLocation().subtract(entity.getLocation()).toVector().normalize());
        }
        
        if (behaviour.isAggressive()) {
            entity.setTarget(owner);
        } else if (behaviour.isDefensive()) {
            AttributeInstance maxHealth = owner.getAttribute(Attribute.MAX_HEALTH);
            double max = maxHealth != null ? maxHealth.getValue() : 20.0;
            if (owner.getHealth() < max * 0.5) {
                entity.setTarget(owner);
            }
        }
    }
    
    public void updateBehaviour(BotBehaviour behaviour) {
        
    }
}
