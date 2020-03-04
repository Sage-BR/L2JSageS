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
import org.l2s.gameserver.network.OutgoingPackets;

public class StopRotation implements IClientOutgoingPacket
{
	private final int _objectId;
	private final int _degree;
	private final int _speed;
	
	public StopRotation(int objectId, int degree, int speed)
	{
		_objectId = objectId;
		_degree = degree;
		_speed = speed;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.FINISH_ROTATING.writeId(packet);
		
		packet.writeD(_objectId);
		packet.writeD(_degree);
		packet.writeD(_speed);
		packet.writeD(0); // ?
		return true;
	}
}
