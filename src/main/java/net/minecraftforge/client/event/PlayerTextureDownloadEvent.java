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
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Event called when a player skin is requested to be downloaded. Use this to
 * change the actual {@link ResourceLocation} or {@link ITextureObject} a
 * texture will use. If the location is not already loaded, the texture object
 * will be loaded to the texture manager.
 */
public class PlayerTextureDownloadEvent extends Event
{
    private final MinecraftProfileTexture profileTexture;
    private final Type textureType;
    @Nullable
    private final SkinAvailableCallback callback;

    @Nullable
    private ResourceLocation location;
    @Nullable
    private Supplier<ITextureObject> textureSupplier;

    public PlayerTextureDownloadEvent(final MinecraftProfileTexture profileTexture, Type textureType, SkinAvailableCallback callback)
    {
        this.profileTexture = profileTexture;
        this.textureType = textureType;
        this.callback = callback;
    }

    public MinecraftProfileTexture getProfileTexture()
    {
        return profileTexture;
    }

    public Type getTextureType()
    {
        return textureType;
    }

    @Nullable
    public SkinAvailableCallback getCallback()
    {
        return callback;
    }

    /**
     * Sets the location to be used. This cancels the event. If the location is
     * not loaded, it is done so using {@code textureSupplier}
     *
     * @param textureLocation The new resource location
     * @param textureSupplier
     */
    public void loadTexture(ResourceLocation textureLocation, Supplier<ITextureObject> textureSupplier)
    {
        this.location = Objects.requireNonNull(textureLocation);
        this.textureSupplier = Objects.requireNonNull(textureSupplier);
        setCanceled(true);
    }

    @Nullable
    public ResourceLocation getLocation()
    {
        return location;
    }

    @Nullable
    public Supplier<ITextureObject> getTextureSupplier()
    {
        return textureSupplier;
    }
}
