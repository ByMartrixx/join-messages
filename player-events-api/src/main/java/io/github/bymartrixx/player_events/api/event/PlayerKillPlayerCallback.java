package io.github.bymartrixx.player_events.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public interface PlayerKillPlayerCallback {
    Event<PlayerKillPlayerCallback> EVENT = EventFactory.createArrayBacked(PlayerKillPlayerCallback.class, (listeners) -> (player, killedPlayer) -> {
        for (PlayerKillPlayerCallback listener : listeners) {
            ActionResult result = listener.killPlayer(player, killedPlayer);

            if (result != ActionResult.PASS) {
                return result;
            }
        }

        return ActionResult.PASS;
    });

    ActionResult killPlayer(ServerPlayerEntity player, ServerPlayerEntity killedPlayer);
}
