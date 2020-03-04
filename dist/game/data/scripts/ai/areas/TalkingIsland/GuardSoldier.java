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
package ai.areas.TalkingIsland;

import org.l2s.gameserver.enums.ChatType;
import org.l2s.gameserver.model.actor.Npc;
import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.network.NpcStringId;

import ai.AbstractNpcAI;

/**
 * Guard Soldier AI.
 * @author Gladicek
 */
public class GuardSoldier extends AbstractNpcAI
{
	// NPCs
	private static final int GUARD_SOLDIER = 33286;
	
	private GuardSoldier()
	{
		addSpawnId(GUARD_SOLDIER);
	}
	
	@Override
	public String onAdvEvent(String event, Npc npc, PlayerInstance player)
	{
		if (event.equals("SPAM_TEXT") && (npc != null))
		{
			npc.broadcastSocialAction(3);
			npc.broadcastSay(ChatType.NPC_GENERAL, NpcStringId.LADY_YOU_MUST_GO_IN, 1000);
			
		}
		else if (event.equals("SOCIAL_ACTION") && (npc != null))
		{
			npc.broadcastSocialAction(2);
		}
		return super.onAdvEvent(event, npc, player);
	}
	
	@Override
	public String onSpawn(Npc npc)
	{
		startQuestTimer("SPAM_TEXT", 12000, npc, null, true);
		startQuestTimer("SOCIAL_ACTION", 15000, npc, null, true);
		return super.onSpawn(npc);
	}
	
	public static void main(String[] args)
	{
		new GuardSoldier();
	}
}