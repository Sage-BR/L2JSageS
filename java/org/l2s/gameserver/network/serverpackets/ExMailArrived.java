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

/**
 * (just a trigger)
 * @author -Wooden-
 */
public class ExMailArrived implements IClientOutgoingPacket
{
	public static final ExMailArrived STATIC_PACKET = new ExMailArrived();
	
	private ExMailArrived()
	{
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_MAIL_ARRIVED.writeId(packet);
		
		return true;
	}
}
