/*******************************************************************************
 * This file is part of ASkyBlock.
 *
 *     ASkyBlock is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ASkyBlock is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with ASkyBlock.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/

package world.bentobox.warps.event;

import java.util.List;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import world.bentobox.warps.Warp;

/**
 * This event is fired when request is made for a sorted list of warps or when
 * the API updateWarpPanel method is called.
 * A listener to this event can reorder or rewrite the warp list by using setWarps.
 * This new order will then be used in the warp panel.
 * 
 * @author tastybento
 * 
 */
public class WarpListEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private List<UUID> warps;

    /**
     * @param plugin - BSkyBlock plugin objects
     * @param warps
     */
    public WarpListEvent(Warp plugin, List<UUID> warps) {
        this.warps = warps;
    }


    /**
     *The warp list is a collection of player UUID's and the default order is
     * that players with the most recent login will be first.
     * @return the warps
     */
    public List<UUID> getWarps() {
        return warps;
    }

    /**
     * @param warps the warps to set
     */
    public void setWarps(List<UUID> warps) {
        this.warps = warps;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
