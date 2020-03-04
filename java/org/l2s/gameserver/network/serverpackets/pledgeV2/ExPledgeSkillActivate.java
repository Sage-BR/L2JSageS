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
package org.l2s.gameserver.network.serverpackets.pledgeV2;

import org.l2s.commons.network.PacketWriter;
import org.l2s.gameserver.network.OutgoingPackets;
import org.l2s.gameserver.network.serverpackets.IClientOutgoingPacket;

/**
 * @author Mobius
 */
public class ExPledgeSkillActivate implements IClientOutgoingPacket
{
	private final int _specialtyId;
	
	public ExPledgeSkillActivate(int specialtyId)
	{
		_specialtyId = specialtyId;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_PLEDGE_SKILL_ACTIVATE.writeId(packet);
		packet.writeC(_specialtyId);
		return true;
	}
}