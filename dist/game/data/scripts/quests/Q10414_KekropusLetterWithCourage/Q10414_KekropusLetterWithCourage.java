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
package quests.Q10414_KekropusLetterWithCourage;

import org.l2s.gameserver.model.Location;
import org.l2s.gameserver.model.actor.Creature;
import org.l2s.gameserver.model.actor.Npc;
import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.model.quest.QuestState;
import org.l2s.gameserver.network.NpcStringId;
import org.l2s.gameserver.network.serverpackets.ExShowScreenMessage;

import quests.LetterQuest;

/**
 * Kekropus' Letter: With Courage (10414)
 * @author St3eT
 */
public class Q10414_KekropusLetterWithCourage extends LetterQuest
{
	// NPCs
	private static final int ANDREI = 31292;
	private static final int JANITT = 33851;
	private static final int INVISIBLE_NPC = 19543;
	// Items
	private static final int SOE_WALL_OF_ARGOS = 37032; // Scroll of Escape: Wall of Argos
	private static final int SOE_TOWN_OF_GODDARD = 37119; // Scroll of Escape: Town of Goddard
	// Location
	private static final Location TELEPORT_LOC = new Location(147491, -56633, -2776);
	// Misc
	private static final int MIN_LEVEL = 70;
	private static final int MAX_LEVEL = 75;
	
	public Q10414_KekropusLetterWithCourage()
	{
		super(10414);
		addTalkId(ANDREI, JANITT);
		addSeeCreatureId(INVISIBLE_NPC);
		
		setIsErtheiaQuest(false);
		setLevel(MIN_LEVEL, MAX_LEVEL);
		setStartQuestSound("Npcdialog1.kekrops_quest_8");
		setStartLocation(SOE_TOWN_OF_GODDARD, TELEPORT_LOC);
		registerQuestItems(SOE_TOWN_OF_GODDARD, SOE_WALL_OF_ARGOS);
	}
	
	@Override
	public String onAdvEvent(String event, Npc npc, PlayerInstance player)
	{
		final QuestState qs = getQuestState(player, false);
		if (qs == null)
		{
			return null;
		}
		
		String htmltext = null;
		switch (event)
		{
			case "31292-02.html":
			{
				htmltext = event;
				break;
			}
			case "31292-03.html":
			{
				if (qs.isCond(2))
				{
					takeItems(player, SOE_TOWN_OF_GODDARD, -1);
					giveItems(player, SOE_WALL_OF_ARGOS, 1);
					qs.setCond(3, true);
					htmltext = event;
				}
				break;
			}
			case "33851-02.html":
			{
				if (qs.isCond(3))
				{
					qs.exitQuest(false, true);
					giveStoryQuestReward(npc, player);
					if (player.getLevel() >= MIN_LEVEL)
					{
						addExpAndSp(player, 1088640, 261);
					}
					showOnScreenMsg(player, NpcStringId.GROW_STRONGER_HERE_UNTIL_YOU_RECEIVE_THE_NEXT_LETTER_FROM_KEKROPUS_AT_LV_76, ExShowScreenMessage.TOP_CENTER, 6000);
					htmltext = event;
				}
				break;
			}
		}
		return htmltext;
	}
	
	@Override
	public String onTalk(Npc npc, PlayerInstance player)
	{
		String htmltext = getNoQuestMsg(player);
		final QuestState qs = getQuestState(player, false);
		
		if (qs == null)
		{
			return htmltext;
		}
		
		if (qs.isStarted())
		{
			if ((npc.getId() == ANDREI) && qs.isCond(2))
			{
				htmltext = "31292-01.html";
			}
			else if (qs.isCond(3))
			{
				htmltext = npc.getId() == ANDREI ? "31292-04.html" : "33851-01.html";
			}
		}
		return htmltext;
	}
	
	@Override
	public String onSeeCreature(Npc npc, Creature creature, boolean isSummon)
	{
		if (creature.isPlayer())
		{
			final PlayerInstance player = creature.getActingPlayer();
			final QuestState qs = getQuestState(player, false);
			
			if ((qs != null) && qs.isCond(3))
			{
				showOnScreenMsg(player, NpcStringId.WALL_OF_ARGOS_IS_A_GOOD_HUNTING_ZONE_FOR_LV_70_OR_ABOVE, ExShowScreenMessage.TOP_CENTER, 6000);
			}
		}
		return super.onSeeCreature(npc, creature, isSummon);
	}
	
	@Override
	public boolean canShowTutorialMark(PlayerInstance player)
	{
		return !player.isMageClass();
	}
}