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
package org.l2s.gameserver.network.serverpackets;

import org.l2s.commons.network.PacketWriter;
import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.network.OutgoingPackets;

public class AskJoinPledge implements IClientOutgoingPacket
{
	private final PlayerInstance _requestor;
	private final int _pledgeType;
	private final String _pledgeName;
	
	public AskJoinPledge(PlayerInstance requestor, int pledgeType, String pledgeName)
	{
		_requestor = requestor;
		_pledgeType = pledgeType;
		_pledgeName = pledgeName;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.ASK_JOIN_PLEDGE.writeId(packet);
		packet.writeD(_requestor.getObjectId());
		packet.writeS(_requestor.getName());
		packet.writeS(_pledgeName);
		if (_pledgeType != 0)
		{
			packet.writeD(_pledgeType);
		}
		return true;
	}
}
