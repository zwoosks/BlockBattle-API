package me.zwoosks.blockbattle.api.events;

import me.zwoosks.blockbattle.api.BlockBattle;
import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MatchPlayerDeathEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final BlockBattle plugin;
    private final int gameId;
    private final Player killedPlayer;

    public MatchPlayerDeathEvent(final BlockBattle plugin, final int gameId, final Player killedPlayer) {
        Validate.notNull(plugin, "The plugin can't be null!");
        Validate.notNull(killedPlayer, "The killed player can't be null!");
        this.plugin = plugin;
        this.gameId = gameId;
        this.killedPlayer = killedPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public BlockBattle getPlugin() {
        return plugin;
    }

    public int getGameId() {
        return gameId;
    }

    public Player getKilledPlayer() {
        return killedPlayer;
    }

    @Override
    public String toString() {
        return "MatchPlayerDeathEvent{" +
                "plugin=" + plugin +
                ", gameId=" + gameId +
                ", killedPlayer=" + killedPlayer +
                "}";
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof MatchPlayerDeathEvent)) return false;
        MatchPlayerDeathEvent evt = (MatchPlayerDeathEvent) obj;
        if(gameId != evt.gameId) return false;
        if(!killedPlayer.equals(evt.killedPlayer)) return false;
        if(!plugin.equals(evt.plugin)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = plugin.hashCode();
        result = 31 * result + gameId;
        result = 31 * result + killedPlayer.hashCode();
        return result;
    }

}
