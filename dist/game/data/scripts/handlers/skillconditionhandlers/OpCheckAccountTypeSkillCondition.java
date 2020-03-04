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
package handlers.skillconditionhandlers;

import org.l2s.gameserver.model.StatsSet;
import org.l2s.gameserver.model.WorldObject;
import org.l2s.gameserver.model.actor.Creature;
import org.l2s.gameserver.model.skills.ISkillCondition;
import org.l2s.gameserver.model.skills.Skill;

/**
 * @author
 */
public class OpCheckAccountTypeSkillCondition implements ISkillCondition
{
	public OpCheckAccountTypeSkillCondition(StatsSet params)
	{
		
	}
	
	@Override
	public boolean canUse(Creature caster, Skill skill, WorldObject target)
	{
		return false;
	}
}