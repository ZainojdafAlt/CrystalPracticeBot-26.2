package dev.akatriggered.practicebot.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    
    private final ItemStack item;
    
    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }
    
    public ItemBuilder name(String name) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.displayName(legacy("§f" + name));
            item.setItemMeta(meta);
        }
        return this;
    }
    
    public ItemBuilder lore(String... lore) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            List<Component> loreList = Arrays.stream(lore).map(s -> legacy("§7" + s)).toList();
            meta.lore(loreList);
            item.setItemMeta(meta);
        }
        return this;
    }
    
    private static Component legacy(String text) {
        return LegacyComponentSerializer.legacySection().deserialize(text)
                .decoration(TextDecoration.ITALIC, false);
    }

    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }
    
    public ItemStack build() {
        return item;
    }
}
