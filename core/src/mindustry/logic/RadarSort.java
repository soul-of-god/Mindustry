package mindustry.logic;

import arc.math.geom.*;
import mindustry.gen.*;

public enum RadarSort{
    距离((pos, other) -> -pos.dst2(other)),
    血量((pos, other) -> other.health()),
    护盾((pos, other) -> other.shield()),
    护甲((pos, other) -> other.armor()),
    最大生命((pos, other) -> other.maxHealth());

    public final RadarSortFunc func;

    public static final RadarSort[] all = values();

    RadarSort(RadarSortFunc func){
        this.func = func;
    }

    public interface RadarSortFunc{
        float get(Position pos, Unit other);
    }
}
