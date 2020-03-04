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
package org.l2s.gameserver.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.l2s.gameserver.model.StatsSet;
import org.l2s.gameserver.model.conditions.ICondition;
import org.l2s.gameserver.scripting.ScriptEngineManager;

/**
 * @author Sdw
 */
public class ConditionHandler
{
	private final Map<String, Function<StatsSet, ICondition>> _conditionHandlerFactories = new HashMap<>();
	
	public void registerHandler(String name, Function<StatsSet, ICondition> handlerFactory)
	{
		_conditionHandlerFactories.put(name, handlerFactory);
	}
	
	public Function<StatsSet, ICondition> getHandlerFactory(String name)
	{
		return _conditionHandlerFactories.get(name);
	}
	
	public int size()
	{
		return _conditionHandlerFactories.size();
	}
	
	public void executeScript()
	{
		try
		{
			ScriptEngineManager.getInstance().executeScript(ScriptEngineManager.CONDITION_HANDLER_FILE);
		}
		catch (Exception e)
		{
			throw new Error("Problems while running ConditionMasterHandler", e);
		}
	}
	
	private static final class SingletonHolder
	{
		protected static final ConditionHandler INSTANCE = new ConditionHandler();
	}
	
	public static ConditionHandler getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
}
