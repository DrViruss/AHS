package com.viruss.ahs.player.injures;

import com.viruss.ahs.player.PlayerPartEntity;

public interface IAbstractInjure {
    int getDuration();
    void setDuration(int dur);
    AbstractInjure.Type getType();
    void setType(AbstractInjure.Type type);
}
