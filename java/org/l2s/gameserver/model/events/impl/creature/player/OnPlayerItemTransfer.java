/*
 * This file is part of the L2J SageS project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2s.gameserver.model.events.impl.creature.player;

import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.model.events.EventType;
import org.l2s.gameserver.model.events.impl.IBaseEvent;
import org.l2s.gameserver.model.itemcontainer.ItemContainer;
import org.l2s.gameserver.model.items.instance.ItemInstance;

/**
 * @author UnAfraid
 */
public class OnPlayerItemTransfer implements IBaseEvent
{
	private final PlayerInstance _player;
	private final ItemInstance _item;
	private final ItemContainer _container;
	
	public OnPlayerItemTransfer(PlayerInstance player, ItemInstance item, ItemContainer container)
	{
		_player = player;
		_item = item;
		_container = container;
	}
	
	public PlayerInstance getPlayer()
	{
		return _player;
	}
	
	public ItemInstance getItem()
	{
		return _item;
	}
	
	public ItemContainer getContainer()
	{
		return _container;
	}
	
	@Override
	public EventType getType()
	{
		return EventType.ON_PLAYER_ITEM_TRANSFER;
	}
}