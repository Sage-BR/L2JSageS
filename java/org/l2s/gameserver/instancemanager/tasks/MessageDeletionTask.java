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
package org.l2s.gameserver.instancemanager.tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.l2s.gameserver.instancemanager.MailManager;
import org.l2s.gameserver.model.World;
import org.l2s.gameserver.model.actor.instance.PlayerInstance;
import org.l2s.gameserver.model.entity.Message;
import org.l2s.gameserver.network.SystemMessageId;
import org.l2s.gameserver.network.serverpackets.SystemMessage;

/**
 * Message deletion task.
 * @author xban1x
 */
public class MessageDeletionTask implements Runnable
{
	private static final Logger LOGGER = Logger.getLogger(MessageDeletionTask.class.getName());
	
	final int _msgId;
	
	public MessageDeletionTask(int msgId)
	{
		_msgId = msgId;
	}
	
	@Override
	public void run()
	{
		final Message msg = MailManager.getInstance().getMessage(_msgId);
		if (msg == null)
		{
			return;
		}
		
		if (msg.hasAttachments())
		{
			try
			{
				final PlayerInstance sender = World.getInstance().getPlayer(msg.getSenderId());
				if (sender != null)
				{
					msg.getAttachments().returnToWh(sender.getWarehouse());
					sender.sendPacket(SystemMessageId.THE_MAIL_WAS_RETURNED_DUE_TO_THE_EXCEEDED_WAITING_TIME);
				}
				else
				{
					msg.getAttachments().returnToWh(null);
				}
				
				msg.getAttachments().deleteMe();
				msg.removeAttachments();
				
				final PlayerInstance receiver = World.getInstance().getPlayer(msg.getReceiverId());
				if (receiver != null)
				{
					receiver.sendPacket(new SystemMessage(SystemMessageId.THE_MAIL_WAS_RETURNED_DUE_TO_THE_EXCEEDED_WAITING_TIME));
				}
			}
			catch (Exception e)
			{
				LOGGER.log(Level.WARNING, getClass().getSimpleName() + ": Error returning items:" + e.getMessage(), e);
			}
		}
		MailManager.getInstance().deleteMessageInDb(msg.getId());
	}
}
