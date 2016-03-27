/*
 * Copyright (c) 2014-2016, Dries007 & DoubleDoorDevelopment
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.doubledoordev.d3commands.commands;

import net.doubledoordev.d3commands.util.Constants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class CommandSmite extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "smite";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "/smite [player] [radius] [strikes]";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public boolean isUsernameIndex(final String[] args, final int userIndex)
    {
        return userIndex == 0;
    }

    @Override
    public List addTabCompletionOptions(final ICommandSender sender, final String[] args)
    {
        if (args.length == 1) return getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames());
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        EntityPlayerMP target;

        if (args.length == 0) target = getCommandSenderAsPlayer(sender);
        else target = getPlayer(sender, args[0]);

        double x = target.posX;
        double z = target.posZ;

        int rad = 1;
        if (args.length > 1) rad = parseIntWithMin(sender, args[1], 1);

        int stikes = 1;
        if (args.length > 2) stikes = parseIntWithMin(sender, args[2], 1);

        while (stikes -- > 0)
        {
            target.worldObj.addWeatherEffect(new EntityLightningBolt(target.worldObj, x + Constants.RANDOM.nextInt(rad) - rad / 2.0, target.posY, z + Constants.RANDOM.nextInt(rad) - rad / 2.0));
        }
    }
}