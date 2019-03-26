/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.event;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

import java.util.Map;

/**
 * An event for changing the {@link MinecraftProfileTexture} associated with a
 * {@link GameProfile}.
 *
 * This is fired async for players and sync for skulls and the player menu, so
 * it is best to stay away from the main thread.
 */
@Cancelable
public abstract class PlayerTextureLoadEvent extends Event
{
    private final GameProfile profile;
    private final Map<Type, MinecraftProfileTexture> profileMap;

    private PlayerTextureLoadEvent(GameProfile profile, Map<Type, MinecraftProfileTexture> profileMap)
    {
        this.profile = profile;
        this.profileMap = profileMap;
    }

    public GameProfile getProfile()
    {
        return profile;
    }

    public Map<Type, MinecraftProfileTexture> getProfileMap()
    {
        return profileMap;
    }

    public static class Pre extends PlayerTextureLoadEvent
    {
        public Pre(GameProfile profile,Map<Type, MinecraftProfileTexture> profileMap)
        {
            super(profile, profileMap);
        }
    }

    public static class Post extends PlayerTextureLoadEvent
    {
        public Post(GameProfile profile,Map<Type, MinecraftProfileTexture> profileMap)
        {
            super(profile, profileMap);
        }
    }
}
