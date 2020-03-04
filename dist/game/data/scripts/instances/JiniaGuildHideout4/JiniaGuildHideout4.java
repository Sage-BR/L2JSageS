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
package instances.JiniaGuildHideout4;

import org.l2s.gameserver.model.actor.Npc;
import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.model.instancezone.Instance;
import org.l2s.gameserver.model.quest.QuestState;

import instances.AbstractInstance;
import quests.Q10287_StoryOfThoseLeft.Q10287_StoryOfThoseLeft;

/**
 * Jinia Guild Hideout instance zone.
 * @author Adry_85
 */
public class JiniaGuildHideout4 extends AbstractInstance
{
	// NPC
	private static final int RAFFORTY = 32020;
	// Misc
	private static final int TEMPLATE_ID = 146;
	
	public JiniaGuildHideout4()
	{
		super(TEMPLATE_ID);
		addStartNpc(RAFFORTY);
		addTalkId(RAFFORTY);
	}
	
	@Override
	protected void onEnter(PlayerInstance player, Instance instance, boolean firstEnter)
	{
		super.onEnter(player, instance, firstEnter);
		if (firstEnter)
		{
			final QuestState qs = player.getQuestState(Q10287_StoryOfThoseLeft.class.getSimpleName());
			if (qs != null)
			{
				qs.setCond(2, true);
			}
		}
	}
	
	@Override
	public String onTalk(Npc npc, PlayerInstance talker)
	{
		enterInstance(talker, npc, TEMPLATE_ID);
		return super.onTalk(npc, talker);
	}
	
	public static void main(String[] args)
	{
		new JiniaGuildHideout4();
	}
}