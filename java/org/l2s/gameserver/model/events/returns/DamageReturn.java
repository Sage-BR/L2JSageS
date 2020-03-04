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
package org.l2s.gameserver.model.events.returns;

/**
 * @author Sdw
 */
public class DamageReturn extends TerminateReturn
{
	private final double _damage;
	
	public DamageReturn(boolean terminate, boolean override, boolean abort, double damage)
	{
		super(terminate, override, abort);
		_damage = damage;
	}
	
	public double getDamage()
	{
		return _damage;
	}
}
