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

import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraftforge.eventbus.api.Event;

/**
 * This event called from {@link ImageBufferDownload}. It can be used to modify
 * or change the skin of a player as they are loaded.
 */
public class PlayerTextureProcessEvent extends Event
{
    private NativeImage image;
    private final boolean is32;

    public PlayerTextureProcessEvent(NativeImage image, boolean is32)
    {
        this.image = image;
        this.is32 = is32;
    }

    public NativeImage getImage()
    {
        return image;
    }

    public void setImage(NativeImage image)
    {
        this.image = image;
    }

    /**
     * Returns true if the texture is the old skin format with a size of 64x32.
     *
     * @return true if original height is 32px.
     */
    public boolean is32()
    {
        return is32;
    }
}
