package me.zwoosks.blockbattle.api.events;

import me.zwoosks.blockbattle.api.BlockBattle;
import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerLeaveQueueEvent extends PlayerEvent {

    private static final HandlerList handlerList = new HandlerList();
    private final BlockBattle plugin;

    public PlayerLeaveQueueEvent(BlockBattle plugin, Player player) {
        super(player);
        Validate.notNull(plugin, "The plugin can't be null!");
        Validate.notNull(player, "The player can't be null!");
        this.plugin = plugin;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public String toString() {
        return "PlayerLeaveQueueEvent{" +
                "plugin=" + plugin +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayerLeaveQueueEvent)) return false;
        PlayerLeaveQueueEvent evt = (PlayerLeaveQueueEvent) obj;
        if (!player.equals(evt.player)) return false;
        if (!plugin.equals(evt.plugin)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = plugin.hashCode();
        result = 31 * result + player.hashCode();
        return result;
    }

}
