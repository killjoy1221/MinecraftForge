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

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class PlayerTextureDownloadEvent extends Event
{
    private final MinecraftProfileTexture profileTexture;
    private final Type textureType;

    @Nullable
    private ResourceLocation location;

    public PlayerTextureDownloadEvent(final MinecraftProfileTexture profileTexture, final Type textureType)
    {
        this.profileTexture = profileTexture;
        this.textureType = textureType;
    }

    public MinecraftProfileTexture getProfileTexture()
    {
        return profileTexture;
    }

    public Type getTextureType()
    {
        return textureType;
    }

    /**
     * Sets the location to be used. This cancels the event.
     *
     * @param textureLocation The new resource location
     */
    public void setLocation(ResourceLocation textureLocation)
    {
        this.location = textureLocation;
        setCanceled(true);
    }

    @Nullable
    public ResourceLocation getLocation()
    {
        return location;
    }
}
