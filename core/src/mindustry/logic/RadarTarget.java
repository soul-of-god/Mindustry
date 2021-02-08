package mindustry.logic;

import mindustry.game.*;
import mindustry.gen.*;

public enum RadarTarget{
    任何((team, other) -> true),
    敌人((team, other) -> team != other.team),
    队友((team, other) -> team == other.team),
    玩家((team, other) -> other.isPlayer()),
    攻击((pos, other) -> other.canShoot()),
    飞行((team, other) -> other.isFlying()),
    BOSS((team, other) -> other.isBoss()),
    地面((team, other) -> other.isGrounded());

    public final RadarTargetFunc func;

    public static final RadarTarget[] all = values();

    RadarTarget(RadarTargetFunc func){
        this.func = func;
    }

    public interface RadarTargetFunc{
        boolean get(Team team, Unit other);
    }
}
